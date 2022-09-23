package aulaexceptions;

import java.io.FileNotFoundException;

public class TesteException2 {
	
	public static void main(String[] args) {
		try {
			new java.io.FileReader("arquivoTeste.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
