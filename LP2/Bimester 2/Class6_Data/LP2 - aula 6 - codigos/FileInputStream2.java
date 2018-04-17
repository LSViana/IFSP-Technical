package aula4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStream2 {

	public static void main(String[] args) {
		
		try ( InputStream is = new FileInputStream("arquivo.txt") ){
			
			System.out.println( "tamanho em bytes: " + is.available() );
			
			int valor;
						
	        while ( ( valor = is.read() ) != -1 ) {
	        
	        	System.out.println( (char) valor );
	                  	
	        }
	        
		} 
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} 
		catch (IOException e) {
			
			e.printStackTrace();
			
		}
		

	}

}
