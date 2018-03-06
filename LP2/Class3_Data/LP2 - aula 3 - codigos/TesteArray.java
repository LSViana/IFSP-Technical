package aula3;

import java.util.Arrays;

public class TesteArray {

	public static void main(String[] args) {
		
		Pessoa[] pessoas = new Pessoa[3];
		
		Pessoa p1 = new Pessoa("mirela", 50);
		
		Pessoa p2 = new Pessoa("marcia", 10);
		
		Pessoa p3 = new Pessoa("bernardo", 40);
		
		pessoas[0] = p1;
		
		pessoas[1] = p2;
		
		pessoas[2] = p3;
		
		for( Pessoa p: pessoas)
			System.out.println(p);
		
		System.out.println();
		
		Arrays.sort(pessoas);
		
		for( Pessoa p: pessoas)
			System.out.println(p);
		
		System.out.println();
		
		Arrays.sort( pessoas, new ComparadorPessoa() );
				
		for( Pessoa p: pessoas)
			System.out.println(p);
		
	}

}
