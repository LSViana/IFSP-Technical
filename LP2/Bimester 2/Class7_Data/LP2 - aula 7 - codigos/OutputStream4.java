package aula4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class OutputStream4 {

	public static void main(String args[]) {
		 
		FileReader in = null;
	      
		FileWriter out = null;

		try {
	         
			in = new FileReader("input.txt");
			out = new FileWriter("output.txt");
	    	  
			int contador;
	    	  
			while ( (contador = in.read()) != -1) {
	    		  
				out.write(contador);
	    		  
			}
	         
			in.close();
	    	  
			out.close();	    	  
	    	  
		} 
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} 
		catch (IOException e) {
			
			e.printStackTrace();
			
		}
	      
	}

}
