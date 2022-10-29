package teste;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class TestandoListas
{
	public static void main(String[] args) {
		ArrayList<ArrayList<String>> params = new ArrayList<ArrayList<String>>(3);
		
		ArrayList<String> p0 = new ArrayList<String>();
		p0.add("Teste");
		p0.add("Email");
		
		
		params.add(p0);
		
		for(List<String> list: params) {
			for(String item: list) {
				System.out.println(item);
				System.out.println(list);
			}
		}
		
	}
}
