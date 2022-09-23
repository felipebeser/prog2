package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Peer{
	
	Socket conexao;
	ObjectInputStream entrada;
	ObjectOutputStream saida;
	String enviada = "";
	String recebida = "";
	Scanner sc = new Scanner(System.in);
	int port = 10000;

	public void receber() {
		try {
			this.recebida = (String) this.entrada.readObject();
			System.out.println("Mensagem recebida: " + this.recebida);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void enviar(){
		try {
			this.saida.flush();
			this.enviada = sc.nextLine();
			this.saida.writeObject(this.enviada);
			this.saida.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
		
}
