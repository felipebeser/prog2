package collections;

import java.util.HashMap;
import java.util.Map;

public class TestaMap {

	public static void main(String[] args) {
		Conta c1 = new Conta();
		c1.depositar(100);
		c1.setNome("Daniel");
		Conta c2 = new Conta();
		c2.depositar(200);
		c2.setNome("Felipe");
		Conta c3 = new Conta();
		c3.depositar(300);
		c3.setNome("Gabriel");
		
		Map<String, Conta> mapaContas = new HashMap<String, Conta>();
		
		mapaContas.put("1", c1);
		mapaContas.put("2", c2);
		mapaContas.put("3", c3);
		
		System.out.println(mapaContas.get("1").getNome());
	} 
}
