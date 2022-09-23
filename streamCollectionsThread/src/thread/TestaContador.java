package thread;

public class TestaContador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contador c1 = new Contador();
		c1.setCont(1);
		Thread t1 = new Thread(c1);
		t1.start();
		
		Contador c2 = new Contador();
		c2.setCont(2);
		Thread t2 = new Thread(c2);
		t2.start();
		
		Contador c4 = new Contador();
		c4.setCont(4);
		Thread t4 = new Thread(c4);
		t4.start();
		
		Contador c3 = new Contador();
		c3.setCont(3);
		Thread t3 = new Thread(c3);
		t3.start();
		
		
	}

}
