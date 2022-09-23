package collections;

import java.util.ArrayList;
import java.util.List;

public class TestaLista1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> lista1 = new ArrayList<String>();
		lista1.add("Daniel");
		lista1.add("Felipe");
		lista1.add("Gabriel");
		lista1.add("Diogo");
		System.out.println(lista1.contains("Diogo"));
//		System.out.println(lista1.size());
	
		for (String name: lista1) {
			System.out.println(name);
		}
		
		
//		List<Conta> lista2 = new ArrayList<Conta>();
	}
}
