package io;

//import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LeCharTeclado {
	public static void main(String[] args) {
		System.out.println("Digite uma tecla: ");
		InputStream c = System.in;
		InputStreamReader isr = new InputStreamReader(c);
//		BufferedReader br = new BufferedReader(isr);
		char ch;
		try {
			ch = (char) isr.read();
			System.out.println(ch);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}