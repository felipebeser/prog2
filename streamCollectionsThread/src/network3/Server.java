package network3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(10000);
		System.out.println("Aguardando conexão..");
		Socket client = server.accept();
		System.out.println("Conexão estabelecida!");
		Scanner sc = new Scanner(client.getInputStream());
		while(sc.hasNextLine()|| sc.nextLine().equals("sair")) {
			System.out.println("Cliente: " + sc.nextLine());
		}
		System.out.println("Saindo..");
		sc.close();
		client.close();
		server.close();
		}

}
