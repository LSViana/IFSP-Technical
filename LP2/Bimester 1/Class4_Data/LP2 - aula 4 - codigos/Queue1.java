package aula4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;

public class Queue1 {

	public static void main(String[] args) {
				
		Queue queueA = new LinkedList();
	
		queueA.add("element 1");
		queueA.add("element 2");
		queueA.add("element 3");
		
		System.out.println( "Fila: \n" );
		
		//imprimir queueA
		System.out.println( queueA.toString() );
		
		System.out.println();
				
		//imprimir queueA com Iterator
		Iterator iterator = queueA.iterator();

		while( iterator.hasNext() )			
			System.out.print(iterator.next().toString()  + ", ");
		
		System.out.println("\n");
		
		// imprimir queueA for-each
		for(Object object : queueA) 
			System.out.print( object.toString() + ", ");
		
		System.out.println();
		System.out.println();	
		
		Object element = queueA.element();
						
		System.out.println( "elemento atual: " + element.toString() + "\n" );
		
		queueA.remove();
		
		System.out.println( "elemento removido.\n");
		
		element = queueA.element();
		
		System.out.println( "elemento atual: " + element.toString() + "\n" );
		
		queueA.remove();
		
		System.out.println( "elemento removido.\n");
		
		element = queueA.element();
		
		System.out.println( "elemento atual: " + element.toString() + "\n" );
		
		queueA.remove();
		
		System.out.println( "elemento removido.\n");
		
	}

}
