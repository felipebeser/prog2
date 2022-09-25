package network3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		JFrame frame = new JFrame("Chat");
		frame.setSize(400, 200);

		JTextArea caixaTexto = new JTextArea();
		JTextField mensagem = new JTextField();
		
		frame.add(mensagem,BorderLayout.PAGE_END);
		frame.add(caixaTexto,BorderLayout.CENTER);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		
		Socket client = new Socket("localhost", 10000);
		caixaTexto.append("Cliente Conectado.");
//		Scanner sc = new Scanner(System.in);
		PrintStream ps = new PrintStream(client.getOutputStream());
//		while(sc.hasNextLine() || sc.nextLine() == "sair" ) {
//			ps.println(sc.nextLine());
//		}
		mensagem.addActionListener(
		         new ActionListener() {
		            public void actionPerformed( ActionEvent e ){
		            	ps.println(mensagem);
		            }
		         }
		      );
		System.out.println("Saindo..");
		ps.close();
//		sc.close();
		client.close();
	}

}
