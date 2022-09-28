package WhatsAppJ;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;

public class Server extends Peer implements Runnable{

	@Override
	public void run() {
			try {
				client = server.accept();
				textArea.append("Conectado\n");
				while(true) {

					
					input = new ObjectInputStream(client.getInputStream());
					output = new ObjectOutputStream(client.getOutputStream());
					output.flush();
					
					System.out.println("while");
					while(message!="sair") {
						message = (String) input.readObject();
						textArea.append(name + ": " + message);
						textArea.setCaretPosition(textArea.getText().length());
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
