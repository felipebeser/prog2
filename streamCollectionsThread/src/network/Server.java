package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;

import javax.swing.JFrame;

public class Server extends Peer{
	
	ServerSocket server;
	
	public void openServer(int port) throws IOException{
		this.server = new ServerSocket(port);
		System.out.println("Porta " + port + " aberta, aguardando conexão.");
		this.conexao = this.server.accept();
		System.out.println("Conexão do cliente verificada.");
	}

	
	public static void main(String[] args){
//		JFrame frame = new JFrame("Servidor");
//		frame.setSize(500, 500);
//      frame.setVisible(true);
        
		Server server = new Server();
		
		try {
			server.openServer(server.port);
			
			server.entrada = new ObjectInputStream(server.conexao.getInputStream());
			server.saida = new ObjectOutputStream(server.conexao.getOutputStream());
			
			while(true) {
				server.receber();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
