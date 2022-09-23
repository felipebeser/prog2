package aula01;

public class Gerente3 extends FuncionarioSistema3 implements AcessoInterno{

	
//	int senha;
//	
//	boolean verifica(){
//		return false;
//	}
	
	@Override
	double getBonus() {
		// TODO Auto-generated method stub
		return 0;
	}

@Override
public boolean verifica(int senha) {
	// TODO Auto-generated method stub
	return false;
}

@Override
boolean verifica() {
	// TODO Auto-generated method stub
	return false;
}

}
