package aula2;


public class TesteClone {

	public static void main(String[] args) {
				
		try {
						
			Funcionario original = new Funcionario("bernardo", 10000, 9, 6, 1972 );
			original.setDataAdmissao(1, 1, 2000);
						
			Funcionario copia = original.clone();
			
			System.out.println();
			System.out.println("Original = " + original );
			System.out.println("Original = " + original.hashCode() );
			
			System.out.println("Copia = " + copia);
			System.out.println("Copia = " + copia.hashCode() );
			
			copia.aumentoSalario(50);
			copia.setDataAdmissao(5, 5, 1900);
			
			System.out.println();
			System.out.println("Original = " + original);
			System.out.println("Original = " + original.hashCode() );
			System.out.println("Copia = " + copia);
			System.out.println("Copia = " + copia.hashCode() );
			
		} catch (CloneNotSupportedException e) {
			
			e.printStackTrace();
			
		}
		
				
	}

}


	

