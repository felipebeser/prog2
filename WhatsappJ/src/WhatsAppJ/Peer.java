package WhatsAppJ;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Peer extends JFrame {
	ServerSocket server;
	Socket client;
	String name = "";
	String message = "";
	int port = 10000;
	String ip = "127.0.0.1";
	ObjectInputStream input;
	ObjectOutputStream output;
	private JPanel contentPane;
	private JTextField textName;
	private JTextField messageField;
	private JTextArea textArea;
	private JButton btnHost;
	private JButton btnConnect;
	private JLabel labelName;


	/**
	 * Launch the application.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	  public static void main( String args[] ) throws ClassNotFoundException, IOException{
	      Peer app = new Peer();
	      System.out.println("teste");
	      app.addWindowListener(
	         new WindowAdapter() {
	            public void windowClosing( WindowEvent e ){
	               System.exit( 0 );
	            }
	         }
	      );

	      app.runApp();
	   }

	/**
	 * Create the frame.
	 */
	public Peer() {
		setTitle("WhatsAppJ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		labelName = new JLabel("Name"); // label name
		labelName.setBounds(68, 103, 46, 14);
		contentPane.add(labelName);
		
		textName = new JTextField(); 			//text name
		textName.setBounds(140, 100, 128, 20);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textArea = new JTextArea();
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
		
		btnHost = new JButton("Host");
		btnHost.setBounds(103, 203, 89, 23);
		contentPane.add(btnHost);
		
		btnConnect = new JButton("Connect");
		btnConnect.setBounds(214, 203, 128, 23);
		contentPane.add(btnConnect);
		
		btnHost.addActionListener(new ActionListener() {          //host
			public void actionPerformed(ActionEvent e) {
				host(port);
			}
		});
		
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connect(ip, port);
			}
		});
		
		
		messageField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendData(e.getActionCommand());
			}
		});	
	}
	
	public ServerSocket host(int port){
		try {
			this.server = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.server;
	}
	
	public Socket accept() {
		try {
			this.client = this.server.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.client;
	}
	
	public Socket connect (String ip, int port) {
		try {
			this.client = new Socket(ip,port);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.client;
	}
	

	
	public void runApp() throws IOException, ClassNotFoundException {
			textArea.setVisible(true);
			messageField.setVisible(true);
			textName.setVisible(false);
			btnHost.setVisible(false);
			btnConnect.setVisible(false);
			labelName.setVisible(false);
			messageField.requestFocus();
//			peer.setServer(peer.host(port));
			server = new ServerSocket(port);
			textArea.append("Aguardando conex�o na porta " + server.getInetAddress() + "\n");
			client = server.accept();
			textArea.append( "Conex�o estabelecida de: " + client.getInetAddress().getHostName() + "\n");
//				
			input = new ObjectInputStream(client.getInputStream());
			output = new ObjectOutputStream(client.getOutputStream());
			output.flush();
				
				
				while(message!="sair") {
					message = (String) input.readObject();
					textArea.append(message + "\n");
				}
			
			
			
			String recebida = null;

			Scanner sc = null;
			try {
				sc = new Scanner(client.getInputStream());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
//			ObjectInputStream ois = new ObjectInputStream(peer.getClient().getInputStream());
			while(sc.hasNextLine()) {
				textArea.append(sc.nextLine());
			}
			sc.close();
//			recebida = (String) ois.readObject();
//			
			
			
//			try {
//				peer.setClient(peer.getServer().accept());
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			
			try {
				client = connect(ip, port);
				textArea.setVisible(true);
				messageField.setVisible(true);
				textName.setVisible(false);
				btnHost.setVisible(false);
				btnConnect.setVisible(false);
				labelName.setVisible(false);
				textArea.append("Conectado \n");
				messageField.requestFocus();
				input = new ObjectInputStream(client.getInputStream());
				output = new ObjectOutputStream(client.getOutputStream());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
	
	   private void sendData( String s ){
		      try {
		         message = s;
		         output.writeObject( "CLIENT>>> " + s );
		         output.flush();
		         textArea.append( "\nCLIENT>>>" + s );
		      }catch ( IOException cnfex ) {
		         textArea.append("\nError writing object" );
		      }
		   }
}
