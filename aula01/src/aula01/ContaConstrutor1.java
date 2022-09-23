package aula01;

public class ContaConstrutor1 {
	private static int contador;
	int numero;
	double saldo;
	double limite;
	Cliente cliente = new Cliente();
	
	public ContaConstrutor1(String nome, String cpf){
		System.out.println("Testando um construtor");
		this.cliente.nome = nome;
		this.cliente.cpf = cpf;
		ContaConstrutor1.contador++;
	}
	
	public int getContador() {
		return ContaConstrutor1.contador;
	}
	
	public static int showContador() {
		return ContaConstrutor1.contador;
	}
}
