package aula4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStream3 {

	public static void main(String args[]) {  
		
		FileInputStream in = null;
		
		FileOutputStream out = null;

		try {
	    
			in = new FileInputStream("input.txt");
			
			out = new FileOutputStream("output.txt");
	         
			int contador;
			
			while ((contador = in.read()) != -1) {
				
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
