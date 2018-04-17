package aula1;

public class TesteAviao {

	public static void main(String[] args) {
		
		Aviao a1 = new Aviao("airbus","a330");
		Aviao a2 = new Aviao("airbus","a330");
		Aviao a3 = new Aviao("boeing","777-300");
		
		System.out.println("a1.equals(a2): " + a1.equals(a2) ); 
		System.out.println("a2.equals(a1): " + a2.equals(a1) ); 
		System.out.println("a3.equals(a1): " + a3.equals(a1) ); 
		
	}

}



