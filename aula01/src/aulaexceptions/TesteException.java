package aulaexceptions;

public class TesteException {

	public static void main(String[] args) {
		System.out.println("Inicio do main");
		metodo1();
		System.out.println("Fim do main");
	}

	private static void metodo1() {
		// TODO Auto-generated method stub
		System.out.println("metodo1");
		metodo2();
		System.out.println("fim do metodo1");
	}

	private static void metodo2() {
		System.out.println("incio do metodo2");
		int array[];
		array = new int[10];
		try {
			for (int i = 0; i < 20; i++) {
				array[i]=i;
				System.out.println(i);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Exception out of bounds");
		}
		
		System.out.println("fim do metodo2");
	}	

}
