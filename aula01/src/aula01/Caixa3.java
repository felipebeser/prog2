package aula01;

public class Caixa3 extends Funcionario3 implements AcessoInterno{

	@Override
	public boolean verifica(int senha) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	double getBonus() {
		// TODO Auto-generated method stub
		return 0;
	}

}
