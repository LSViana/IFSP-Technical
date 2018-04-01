package aula4;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Map2 {

	public static void main(String[] args) {
		
		Map<Integer, String> mapaNomes = new HashMap<Integer, String>(); 
		
		mapaNomes.put( 1, "Romario" );
		mapaNomes.put( 2, "Ronaldo" );
		mapaNomes.put( 3, "Bebeto" );
		
		Set<Integer> chave = mapaNomes.keySet();
		
		for(Integer x: chave)
			System.out.println( x + " - " + mapaNomes.get(x) );


	}

}
