package aula2;


public class TesteHashCode {

	public static void main(String[] args) {
		
		Carro c1 = new Carro("Ford", "XXX-1234");
		
		Carro c2 = new Carro("Fiat", "AAA-5678");
		
		System.out.println("hashcode c1: " + c1.hashCode() );
		
		System.out.println("hashcode c2: " + c2.hashCode() );
		
	}

}
