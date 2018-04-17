package aula4;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Set1 {

	public static void main(String[] args) {
		
		Set<String> cargos;
		
		cargos = new HashSet<String>();

		cargos.add("Santos");
		cargos.add("São Paulo");
		cargos.add("Palmeiras");
		cargos.add("Corinthias");
		cargos.add("Flamengo");
		cargos.add("Santos"); // repetido!
		
		
		for(String c:cargos)
			System.out.println(c);

//		System.out.println(cargos);
//		
//		System.out.println();
//		
//		//HashSet<Integer> tree = new HashSet<Integer>();
//		TreeSet<Integer> tree = new TreeSet<Integer>(); 
//		
//		tree.add(12); 
//		tree.add(63); 
//		tree.add(34); 
//		tree.add(45); 
//		
//		Iterator<Integer> iterator = tree.iterator(); 
//	
//		while ( iterator.hasNext() ) { 
//			System.out.print(iterator.next() + " "); 
//		}

	
//		
//		System.out.println();
//		System.out.println();
//		
//		Set<String> conjunto = new HashSet<>();
//
//		conjunto.add("java");
//		conjunto.add("linguagem c");
//		conjunto.add("python");
//
//		for (String palavra : conjunto) {
//		  System.out.println(palavra);
//		}

		
	}

}
