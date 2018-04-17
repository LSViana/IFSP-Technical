package aula1;

public class TesteObject {

	public static void main(String[] args) {
		
		Veiculo v1 = new Veiculo();
		
		Carro c1 = new Carro();
		Carro c2 = new Carro();
		
		System.out.println("\nv1.getClass(): " + v1.getClass() );
		System.out.println("\nc1.getClass(): " + c1.getClass() );
		System.out.println("\nc2.getClass(): " + c2.getClass() );
	        
		System.out.println("\nv1.toString: " + v1.toString() );
		System.out.println("\nc1.toString: " + c1.toString() );
		System.out.println("\nc2.toString: " + c2.toString() );
	        	        
		System.out.println("\nc1.equals(c2): " + c1.equals(c2) );
		System.out.println("\nc2.equals(c2): " + c2.equals(c1) );
		
		System.out.println("\nv1.hashcode(): "+ v1.hashCode() );
		System.out.println("\nc1.hashcode(): "+ c1.hashCode() );
		System.out.println("\nc2.hashcode(): "+ c2.hashCode() );

	}

}



