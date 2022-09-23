package thread;

public class TestaThreadMapaBarra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DesenhaMapa dMapa = new DesenhaMapa();
//		dMapa.desenha();
		Thread tMapa = new Thread((Runnable) dMapa);
		tMapa.start();
		
		BarraProgresso bProgr = new BarraProgresso();
//		bProgr.progresso();
		Thread tProgr = new Thread((Runnable) bProgr);
		tProgr.start();
	}

}
