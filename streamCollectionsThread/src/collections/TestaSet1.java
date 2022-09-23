package collections;

import java.util.HashSet;
import java.util.Set;

public class TestaSet1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set objetos = new HashSet();
		objetos.add("objeto1");
		objetos.add("objeto2");
		objetos.add("objeto3");
		System.out.println(objetos);
		System.out.println(objetos.size());
		objetos.add("objeto3");
		System.out.println(objetos);
		System.out.println(objetos.size());
		
		for (Object objeto : objetos) {
			System.out.println(objeto);
		}
	}

}
