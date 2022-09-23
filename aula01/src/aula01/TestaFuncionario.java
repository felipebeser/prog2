package aula01;

public class TestaFuncionario {
	public static void main(String[] args) {
		Funcionario f1 = new Funcionario();
		f1.nome = "Clayton";
		f1.salario = 10000;
		f1.status = "ativo";
		System.out.println("Salario "+ f1.nome+": "+f1.salario);
//		f1.bonificacao(100);
		
		System.out.println("Salario com bonus: "+f1.salario);
		System.out.println(f1);
	}
}
