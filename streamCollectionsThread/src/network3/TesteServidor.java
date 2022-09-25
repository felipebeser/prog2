package network3;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TesteServidor {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket server = new ServerSocket (3500);
		Socket client = server.accept();
		System.out.println("Cliente conectado.");
		
		
		// outputStream
//		Scanner sc = new Scanner(System.in);
//		PrintStream out = new PrintStream(client.getOutputStream());
		
		//inputStream
		Scanner s = new Scanner(client.getInputStream());
		while(s.hasNextLine()) {
			System.out.println(s.nextLine());
		}
	}
}
