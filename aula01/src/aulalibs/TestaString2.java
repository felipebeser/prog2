package aulalibs;

public class TestaString2 {

	public static void main(String[] args) {
		String a = "Java no Senac";
		String b = "Java no Senac";
		
		
		System.out.println(a.charAt(3));
		a = a.split(" ")[0];
	//	System.out.println(a.split("Java"));
		System.out.println("a depois do split = " + a);
	}
}
