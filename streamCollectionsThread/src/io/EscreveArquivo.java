package io;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class EscreveArquivo {
	public static void main(String[] args) throws IOException{
		OutputStream c =  new FileOutputStream("escrita.txt");
		OutputStreamWriter isr = new OutputStreamWriter(c);
		try (BufferedWriter br = new BufferedWriter(isr)){
			br.write("Testando a escrita.");
			br.close();
		} catch (Exception exception) {
			// TODO: handle exception
		} finally {
			isr.close();
			c.close();
		}
	}
}