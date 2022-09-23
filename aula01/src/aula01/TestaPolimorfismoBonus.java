package aula01;

public class TestaPolimorfismoBonus {

	public static void main(String[] args) {
		
		ControleBonus controle = new ControleBonus();
		
		Funcionario f2 = new Funcionario();
		f2.setSalario(1000);
		
		
		controle.setTotalBonus(f2);
		System.out.println(controle.getTotalBonus());
		
		Gerente g2 = new Gerente();
		g2.setSalario(10000);
		controle.setTotalBonus(g2);
		System.out.println(controle.getTotalBonus());

	}

}
