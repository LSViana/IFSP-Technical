package aula4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Map3 {

	private Map< String, Integer > mapa;
	private Scanner scanner;
	
	public Map3(){
		
		mapa = new HashMap< String, Integer >();
		
		scanner = new Scanner( System.in );
		
		criandoMapa();
		
		verMapa();
		
	}	
	
	public void criandoMapa(){
		
		System.out.print("entre com a frase: ");
		
		String input = scanner.nextLine();
		
		StringTokenizer tokenizer = new StringTokenizer( input );
		
		while( tokenizer.hasMoreElements() ){
			
			String palavra = tokenizer.nextToken().toLowerCase();
			
			if( mapa.containsKey( palavra ) ){
				
				int contagem = mapa.get( palavra );
				
				mapa.put( palavra , contagem + 1 );
				
			}
			else {
				
				mapa.put( palavra , 1 );
				
			}
			
		}
		
	}
	
	public void verMapa(){
		
		System.out.println("===================================================");
		
		Set<String> atributos = mapa.keySet();
		
		for( String atributo: atributos )
			System.out.printf("%s\t%s\n", atributo, mapa.get(atributo) );
		
		if( mapa.isEmpty() )
			System.out.println("Tabela esta vazia");
		
		System.out.println("===================================================");
		
	}
	
	public static void main(String[] args) {

		@SuppressWarnings("unused")
		Map3 app = new Map3();
		
	}

}
