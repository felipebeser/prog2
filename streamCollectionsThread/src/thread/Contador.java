package thread;

public class Contador implements Runnable{
	
	private int cont;
	
	public void setCont(int cont) {
		this.cont = cont;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i<100;i++) {
			System.out.println("Thread "+cont+", valor "+i);
		}
	}

}
