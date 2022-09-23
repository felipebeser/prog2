package aula01;

public class Teste {

	public static void main(String[] args) {
		Conta c1 = new Conta();
		c1.setSaldo(0);
		c1.setLimite(20);
		c1.setNumero(001);
//		c1.setNome("Felipe");
		c1.depositar(100);
		c1.sacar(150);
		c1.cliente.nome = "Felipe";
		
		
		System.out.println("Número da conta = " + c1.getNumero());
		System.out.println("Titular = " + c1.cliente.nome);
		System.out.println("Saldo = " + c1.getSaldo());
		System.out.println("Limite = " + c1.getLimite());
	}

}
