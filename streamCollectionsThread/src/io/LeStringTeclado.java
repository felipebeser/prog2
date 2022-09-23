package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LeStringTeclado {
	public static void main(String[] args) {
		System.out.println("Digite uma frase: ");
		InputStream c = System.in;
		InputStreamReader isr = new InputStreamReader(c);
		BufferedReader br = new BufferedReader(isr);
//		char ch;
		String s;
		try {
			s = br.readLine();
			System.out.println(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}