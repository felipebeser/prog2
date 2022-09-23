package network;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Client extends Peer{
	
	public void connectToServer(int port) throws UnknownHostException, IOException{
		this.conexao = new Socket( "127.0.0.1", port);
		System.out.println("Cliente conectado ao servidor "+ conexao.getInetAddress());
	}
	
	public static void main(String[] args){
		Client client = new Client();
		
		try {
			client.connectToServer(client.port);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JFrame frame = new JFrame("Chat");
		frame.setSize(400, 200);

		JTextArea caixaTexto = new JTextArea();
		JTextField mensagem = new JTextField();
		
		frame.add(mensagem,BorderLayout.PAGE_END);
		frame.add(caixaTexto,BorderLayout.CENTER);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		mensagem.addActionListener(
		         new ActionListener() {
		            public void actionPerformed( ActionEvent e ){
		            	try {
			    			client.entrada = new ObjectInputStream(client.conexao.getInputStream());
		            		client.saida = new ObjectOutputStream(client.conexao.getOutputStream());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		    			
		               client.enviar();
		            }
		         }
		      );
		
		
	}
	
}
