package aula3;

public class Array1 {

	public static void main( String args[]){
				
		Pessoa pessoas[];
		
		pessoas = new Pessoa[5];
		
		pessoas[0] = new Pessoa("Domingos", 22);
		pessoas[1] = new Pessoa("Marcia", 23);
		
		for( int i = 0; i < pessoas.length; i++ )
			System.out.println( pessoas[i] );
				
	}
		
}
