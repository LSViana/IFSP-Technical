package aula3;

import java.util.Comparator;

public class ComparadorPessoa implements Comparator<Pessoa> {
	
	@Override
	public int compare( Pessoa arg0, Pessoa arg1 ) {
					
		if( arg0.getIdade() < arg1.getIdade() )
			return -1;
		
		if( arg0.getIdade() > arg1.getIdade() )
			return 1;
		
		return 0;
		
	}
	
}
