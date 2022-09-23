package io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LeArquivo {
	public static void main(String[] args) throws IOException {
//		System.out.println("Digite uma frase: ");
		InputStream c =  new FileInputStream("teste.txt");
		InputStreamReader isr = new InputStreamReader(c);
		BufferedReader br = new BufferedReader(isr);
//		char ch;
		String s ="";
		s = br.readLine();
		try {
			while (s != null) {
				System.out.println(s);
				s = br.readLine();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}