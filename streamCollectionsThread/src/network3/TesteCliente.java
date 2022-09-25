package network3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class TesteCliente {
	Socket client;
	public void enviar(String mensagem) {
		//outputStream
				PrintStream out;
				try {
					out = new PrintStream(client.getOutputStream());
					out.println(mensagem);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Sem saida.");
				}
				
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Chat");
		frame.setSize(400, 200);

		JTextArea caixaTexto = new JTextArea();
		JTextField mensagem = new JTextField();
		
		frame.add(mensagem,BorderLayout.PAGE_END);
		frame.add(caixaTexto,BorderLayout.CENTER);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		TesteCliente cliente = new TesteCliente();
		mensagem.addActionListener(
		         new ActionListener() {
		            public void actionPerformed( ActionEvent e ){
		            	
		            	cliente.enviar(mensagem.getSelectedText());
		            }
		         }
		      );
		
		Socket client = new Socket("127.0.0.1", 3500);
		
		
		
		//inputStream
//		Scanner s = new Scanner(client.getInputStream());
		Scanner s = new Scanner(client.getInputStream());
		while(s.hasNextLine()) {
			System.out.println(s.nextLine());
		}
	}
}
