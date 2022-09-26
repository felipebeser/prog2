package WhatsAppJ;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class janela extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField messageField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					janela frame = new janela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public janela() {
		Peer peer = new Peer();
		int port = 10000;
		String ip = "127.0.0.1";
		
		setTitle("WhatsAppJ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelName = new JLabel("Name"); // label name
		labelName.setBounds(68, 103, 46, 14);
		contentPane.add(labelName);
		
		textName = new JTextField(); 			//text name
		textName.setBounds(140, 100, 128, 20);
		contentPane.add(textName);
		textName.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setVisible(false);
		textArea.setFocusable(rootPaneCheckingEnabled);
//		textArea.append("textArea");
		textArea.setBounds(0, 0, 434, 192);
		contentPane.add(textArea);
		
		messageField = new JTextField();
		messageField.setVisible(false);
		messageField.setBounds(48, 203, 319, 47);
		contentPane.add(messageField);
		messageField.setColumns(10);
		
		JButton btnHost = new JButton("Host");
		btnHost.setBounds(103, 203, 89, 23);
		contentPane.add(btnHost);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.setBounds(214, 203, 128, 23);
		contentPane.add(btnConnect);
		
		btnHost.addActionListener(new ActionListener() {          //host
			public void actionPerformed(ActionEvent e) {
				textArea.setVisible(true);
				messageField.setVisible(true);
				textName.setVisible(false);
				btnHost.setVisible(false);
				btnConnect.setVisible(false);
				labelName.setVisible(false);
				messageField.requestFocus();
//				peer.setServer(peer.host(port));
				try {
					peer.setServer(new ServerSocket(port));
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				textArea.append("Aguardando conexão na porta " + peer.getServer().getInetAddress() + "\n");
				peer.setClient(peer.accept());
//				textArea.append( "Conexão estabelecida de: " + peer.getClient().getInetAddress().getHostName() + "\n");
//				
//				String recebida = null;
//				do {
//					try {
//	//					Scanner sc = new Scanner(peer.getClient().getInputStream());
//						ObjectInputStream ois = new ObjectInputStream(peer.getClient().getInputStream());
//						recebida = (String) ois.readObject();
//						
//						textArea.append(recebida);
//					} catch (IOException | ClassNotFoundException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//				} while (!recebida.equals("sair"));
//				
				
				
//				try {
//					peer.setClient(peer.getServer().accept());
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
			}
		});
	
	
		
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				peer.setClient(peer.connect(ip, port));
				textArea.setVisible(true);
				messageField.setVisible(true);
				textName.setVisible(false);
				btnHost.setVisible(false);
				btnConnect.setVisible(false);
				labelName.setVisible(false);
				textArea.append("Conectado \n");
				messageField.requestFocus();
			
			}
		});
		
		
		messageField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String enviada = messageField.getSelectedText();
				try {
					PrintStream out = new PrintStream(peer.getClient().getOutputStream());
					out.println(enviada);
					
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				
//				textArea.append(messageField.getText());
			}
		});
		
		
		
	}
}
