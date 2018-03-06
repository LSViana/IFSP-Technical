package aula3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class ArrayList2 {

	public static void main( String args[]){
				
		List<Pessoa> pessoas;
		
		pessoas = new ArrayList<Pessoa>();
				
		pessoas.add( new Pessoa("Domingos", 22) );
		pessoas.add( new Pessoa("Marcia", 23) );
		
		System.out.println();
		
		for( Pessoa p: pessoas )
			System.out.println( p );
						
	}
		
}
