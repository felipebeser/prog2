package aulalibs;

public class TestaString1 {
	public static void main(String[] args) {
		String a = "Java no Senac";
		String b = "Java no Senac";
		
		if (a.equals(b)) {
			System.out.println("a e b são objetos iguais.");
		}
		else {
			System.out.println("A e b sao objetos diferentes.");
		}
		
		System.out.println(a.compareTo(b));
		System.out.println(a.compareToIgnoreCase(b));
		System.out.println(a.charAt(0));
		System.out.println(a.lastIndexOf(0));
		System.out.println(a.length());
		System.out.println(a.toLowerCase());
		System.out.println(a.toUpperCase());
		System.out.println(a.split(" "));
		System.out.println(a.substring(3));
		System.out.println(a.trim());
		System.out.println(a.isEmpty());
		System.out.println(a.contains(b));
		System.out.println(a.matches(a));
		System.out.println(a.replace('a', 'e'));
		System.out.println(a.replaceAll(b, a));
	}
}
