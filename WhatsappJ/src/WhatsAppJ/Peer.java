package WhatsAppJ;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Peer extends JFrame {
	Host host;
	Connect connect;
	ServerSocket server;
	Socket client;
	String name = "";
	String message = "";
	int port = 10000;
	String ip = "127.0.0.1";
	ObjectInputStream input;
	ObjectOutputStream output;
	protected JPanel contentPane;
	protected JTextField textName;
	protected JTextField messageField;
	protected JTextArea textArea;
	protected JButton btnHost;
	protected JButton btnConnect;
	protected JLabel labelName;


	/**
	 * Launch the application.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Peer frame = new Peer();
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
		textArea.setFocusable(false);
//		textArea.append("textArea");
		textArea.setBounds(0, 0, 434, 192);
		textArea.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
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
		
		
		btnHost.addActionListener(new ActionListener() {          //start host
			public void actionPerformed(ActionEvent e) {
				name = textName.getText();
				textName.setVisible(false);
				labelName.setVisible(false);
				btnHost.setVisible(false);
				btnConnect.setVisible(false);
				textArea.setVisible(true);
				messageField.setVisible(true);
				setTitle("WhatsAppJ Host");
				tHost.start();
			}
		});
		
		btnConnect.addActionListener(new ActionListener() { 	//start client
			public void actionPerformed(ActionEvent e) {
				name = textName.getText();
				textName.setVisible(false);
				labelName.setVisible(false);
				btnHost.setVisible(false);
				btnConnect.setVisible(false);
				textArea.setVisible(true);
				messageField.setVisible(true);
				messageField.setEnabled(false);
				setTitle("WhatsAppJ Client");
				tConnect.start();
			}
		});
		
		
		messageField.addActionListener(new ActionListener() {  //send message
			@Override
			public void actionPerformed(ActionEvent e) {
				sendData(e.getActionCommand());
				messageField.setText("");
			}
		});	
	}

	 Thread tHost = new Thread() {
		 public void run() {
			 try {
					server = new ServerSocket (port);
					textArea.append("Aguardando conexão..");
					client = server.accept();
					output = new ObjectOutputStream(client.getOutputStream());
					input = new ObjectInputStream(client.getInputStream());
					textArea.append("Conectado!");
					messageField.setEnabled(true);
					
					while(message != "sair") {
						try {
							message = (String) input.readObject();
							textArea.append(message);
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
	 };
	 
	 Thread tConnect = new Thread() {
		 public void run() {
			 try {
					client = new Socket (ip, port);
					output = new ObjectOutputStream(client.getOutputStream());
					input = new ObjectInputStream(client.getInputStream());
					textArea.append("Conectado!");
					messageField.setEnabled(true);
					
					while(message != "sair") {
						try {
							message = (String) input.readObject();
							textArea.append(message);
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
	 };

	  private void sendData( String s ){
	      try {
	    	 SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");  
	    	 Date date = new Date();   
	         message = s;
	         output.writeObject( "\n(" + formatter.format(date) + ") " + name + ": " + s );
	         output.flush();
	         textArea.append( "\n" + formatter.format(date) + name + ": " + s );
	      }catch ( IOException cnfex ) {
	         textArea.append("\nError writing object" );
	      }
	   }
}
