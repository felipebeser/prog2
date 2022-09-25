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

public class Server {

	public static void main(String[] args) throws IOException {
		JFrame frame = new JFrame("Chat");
		frame.setSize(400, 200);

		JTextArea caixaTexto = new JTextArea();
		JTextField mensagem = new JTextField();
		mensagem.setEnabled(false);
		frame.add(mensagem,BorderLayout.PAGE_END);
		frame.add(caixaTexto,BorderLayout.CENTER);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		
		ServerSocket server = new ServerSocket(10000);
		caixaTexto.append("Aguardando conexão..");
		Socket client = server.accept();
		caixaTexto.append("Conexão estabelecida!");
		
		mensagem.setEnabled(true);
		mensagem.addActionListener(
		         new ActionListener() {
		            public void actionPerformed( ActionEvent e ){
		            	Scanner sc = new Scanner(mensagem.getSelectedText());
		        		try {
							PrintStream ps = new PrintStream(client.getOutputStream());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		        		while(sc.hasNextLine() || sc.nextLine().equals("sair")) {
		        			System.out.println("Cliente: " + sc.nextLine());
		        		}
		        		sc.close();
		            }
		         }
		      );
		
		System.out.println("Saindo..");
		client.close();
		server.close();
		}
}
