package aula2;


public class TesteEquals {

	public static void main(String[] args) {
		
		Carro c1 = new Carro("Fiat", "XXX-5555");
		
		Carro c2 = new Carro("Fiat", "XXX-5555");
		
		Carro c3 = new Carro("Ford", "AAA-12345");
		
		Carro c4 = new Carro("WV", "FFF-1122");
		
		if( c1.equals( c2 ) )
			System.out.println("c1 == c2");
		else
			System.out.println("c1 != c2");
		
		if( c2.equals( c3 ) )
			System.out.println("c2 == c3");
		else
			System.out.println("c2 != c3");	
		
		if( c3.equals( c4 ) )
			System.out.println("c3 == c4");
		else
			System.out.println("c3 != c4");	

	}

}
