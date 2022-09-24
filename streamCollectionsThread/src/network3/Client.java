package network3;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket("localhost", 10000);
		System.out.println("Cliente Conectado.");
		Scanner sc = new Scanner(System.in);
		PrintStream ps = new PrintStream(client.getOutputStream());
		while(sc.hasNextLine() || sc.nextLine() == "sair" ) {
			ps.println(sc.nextLine());
		}
		System.out.println("Saindo..");
		ps.close();
		sc.close();
		client.close();
	}

}
