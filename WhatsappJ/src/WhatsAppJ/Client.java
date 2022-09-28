package WhatsAppJ;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends Peer implements Runnable{
	
	@Override
	public void run(){
		try {
			client = new Socket(ip,port);
			textArea.append("Conectado.");
			
			input = new ObjectInputStream(client.getInputStream());
			output = new ObjectOutputStream(client.getOutputStream());
			output.flush();
			
			while(message!="sair") {
				message = (String) input.readObject();
				textArea.append(name + ": " + message);
				textArea.setCaretPosition(textArea.getText().length());
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
