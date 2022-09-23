package aula01;

public class TestaContaConstrutor1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContaConstrutor1 cc1 = new ContaConstrutor1("Felipe", "1091238124");
		ContaConstrutor1 cc2 = new ContaConstrutor1("Clayton", "1091238124");
		System.out.println(cc1.cliente.nome);
		System.out.println(cc1.cliente.cpf);
	//	System.out.println("Numero de contas: " + cc1.getContador());
		System.out.println("Numero de contas: " + ContaConstrutor1.showContador());
		
	}
}
