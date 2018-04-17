package aula3;

import java.util.ArrayList;
import java.util.Collection;

public class ArrayList3 {

	public static void main( String args[]){
		
		Aluno a1 = new Aluno("Maria", 22, "12345");
		
		Aluno a2 = new Aluno("Domingos", 23, "88888");
		
		Aluno a3 = new Aluno("Marcia", 23, "10101");
				
		Collection<Aluno> alunos;
		
		alunos = new ArrayList<Aluno>();
				
		alunos.add( a1 );
		alunos.add( a2 );
		alunos.add( a3 );
		
		for( Aluno a: alunos )
			System.out.println( a );				

		System.out.println();
		
		
	}
	
}
