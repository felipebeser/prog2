package aula01;

public class TestaGerenteFuncionario {
	public static void main(String[] args) {
		Funcionario f1 = new Funcionario();
		f1.setSalario(1000);
		System.out.println("O salário funcionário após bonificação é: " + (f1.getSalario() + f1.getBonus()));
		
		Gerente g1 = new Gerente();
		g1.setSalario(10000);
		System.out.println("O salário do gerente após bonificação é: " + (g1.getSalario() + g1.getBonus()));

	}
}

