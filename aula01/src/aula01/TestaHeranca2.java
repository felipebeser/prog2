package aula01;

public class TestaHeranca2 {
	public static void main(String[] args) {
		Funcionario f2 = new Funcionario();
		f2.setSalario(1000);
		System.out.println("O salário do funcionário é: " + f2.getSalario());
		System.out.println("O bonus do funcionário é: " + f2.getBonus());
		
		Gerente g2 = new Gerente();
		g2.setSalario(10000);
		System.out.println("O salário do gerente é: " + g2.getSalario());
		System.out.println("O bonus do gerente é: " + g2.getBonus());
		
		

	}
}
