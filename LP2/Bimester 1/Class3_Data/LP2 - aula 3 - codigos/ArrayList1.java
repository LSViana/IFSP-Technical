package aula3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArrayList1 {

	public static void main( String args[]){
				
		List pessoas;
		
		pessoas = new ArrayList();
						
		pessoas.add( new Pessoa("Domingos", 22) );
		pessoas.add( new Pessoa("Marcia", 23) );
		
		System.out.println();
		
		for( int i = 0; i < pessoas.size(); i++ )
			System.out.println( pessoas.get(i) );
			
		System.out.println();
		
 		for( Object p: pessoas )
			System.out.println( p );		
		
	}
		
}
