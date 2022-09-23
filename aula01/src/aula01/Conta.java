package aula01;

public class Conta {
	private int numero;
//	private String nome;
	private double saldo;
	private double limite;
	Cliente cliente = new Cliente();
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public double getLimite() {
		return limite;
	}
	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	public void sacar(double valor) {
		if(getSaldo() - valor >= getLimite() * (-1))
			setSaldo(getSaldo()-valor);
		else
			System.out.println("Não é possível realizar a operação.");
	}
	
	public void depositar(double valor) {
		setSaldo(getSaldo()+valor);
	}
	
}

