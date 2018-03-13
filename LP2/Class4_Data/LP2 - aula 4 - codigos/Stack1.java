package aula4;

import java.util.Stack;

public class Stack1 {

	public static void main(String[] args) {
		
		Stack stack = new Stack();

		stack.push("1");
		
		stack.push("2");
		
		stack.push("3");

		//objeto no topo da pilha ("3")
		Object obj = stack.peek();
		
		System.out.println( obj );
		
		System.out.println( );

		stack.pop(); 
		
		obj = stack.peek();
		
		System.out.println( obj );
		
		System.out.println( );
		
		stack.pop(); 
		
		obj = stack.peek();
		
		System.out.println( obj );
		
		System.out.println( );
		
	}

}
