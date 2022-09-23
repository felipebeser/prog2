package network;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Janela{
	public static void main(String[] args) {
		Peer peer = new Peer();
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
		               peer.enviar();
		            }
		         }
		      );
	}
}
