package aula01;

public class TestaPolimorfismoSalario {

	public static void main(String[] args) {
		
		ControleSalarial controle = new ControleSalarial();
		
		Funcionario f2 = new Funcionario();
		f2.setSalario(1000);
		
		
		controle.setTotalSalarios(f2);
		System.out.println(controle.getTotalSalarios());
		
		Gerente g2 = new Gerente();
		g2.setSalario(10000);
		controle.setTotalSalarios(g2);
		System.out.println(controle.getTotalSalarios());

	}

}
