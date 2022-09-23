package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(10000);
			System.out.println("Porta 10000 aberta, aguardando conexão.");

			
			Socket client = server.accept();
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
