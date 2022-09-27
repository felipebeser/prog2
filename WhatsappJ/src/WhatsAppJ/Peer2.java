package WhatsAppJ;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Peer2 {
	private ServerSocket server = null;
	private Socket client = null;
	private String name = "";
	private String message = "";
	private int port;
	ObjectInputStream input;
	ObjectOutputStream output;
	
	
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
	

	
//	public String receive() { 
//		
//	}


	public ServerSocket getServer() {
		return server;
	}


	public void setServer(ServerSocket server) {
		this.server = server;
	}


	public Socket getClient() {
		return client;
	}


	public void setClient(Socket client) {
		this.client = client;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPort() {
		return port;
	}


	public void setPort(int port) {
		this.port = port;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}



	
	
}
