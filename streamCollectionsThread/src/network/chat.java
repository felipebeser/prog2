package network;

import java.io.IOException;

import javax.swing.JFrame;

public class chat {

	public static void main(String[] args) {
		Server server = new Server();
		Client client = new Client();
		
		try {
			server.openServer(server.port);
			client.connectToServer(client.port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	
	}
		
//		try {
//			Socket server = new Socket("127.0.0.1",10000);
//			System.out.println("Conectado ao servidor "+ server.getInetAddress());
//			
//			while(true) {
//				Scanner sc = new Scanner(System.in);
//				String mensagem = "";
//				String resposta = "";
//				ObjectInputStream entrada = new ObjectInputStream(server.getInputStream());
//				resposta = (String) entrada.readObject();
//				System.out.println("Mensagem do servidor " + resposta);
//				ObjectOutputStream saida = new ObjectOutputStream(server.getOutputStream());
//				saida.writeObject(sc.nextLine());
//				if(mensagem == "exit") server.close();
//				sc.close();
//			}
//			
//			try {
//				Server server = new Server();
//				server.conexao = new ServerSocket(10000);
//				System.out.println("Porta 10000 aberta, aguardando conexão.");
//				Socket client = server.conexao.accept();
//				System.out.println("Cliente conectado.");
//				
//				
//				while(true) {
//					server.saida = new ObjectOutputStream(client.getOutputStream());
//					server.mensagem = server.sc.nextLine();
//					server.saida.writeObject(server.mensagem);
//					
//					server.entrada = new ObjectInputStream(client.getInputStream());
//					server.resposta = server.sc.nextLine();
//					System.out.println("Mensagem do cliente: " + server.mensagem);
//				}
//				
//				
//				
//				
//				
//
////				server.close();
//				
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//
//	}

}
