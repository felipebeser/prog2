package aula01;

public class TesteAcessoInterno {
	public static void main(String[] args) {
		int senha = 123;
		AcessoInterno f1 = new Gerente3();
		boolean teste = f1.verifica(senha);
	}
}
