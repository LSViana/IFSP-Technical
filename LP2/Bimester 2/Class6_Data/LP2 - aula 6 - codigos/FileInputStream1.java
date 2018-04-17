package aula4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStream1 {

	public static void main(String[] args) {
		
		InputStream is  = null;
		
		try {
			
			is = new FileInputStream("arquivo.txt");
			
			System.out.println( "tamanho em bytes: " + is.available() );
			
			int valor;
						
	        while ( ( valor = is.read() ) != -1 ) {
	        
	        	System.out.println( (char) valor );
	                  	
	        }

	        is.close();
	        
		} 
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} 
		catch (IOException e) {
			
			e.printStackTrace();
			
		}
		finally {
			
			if( is != null )
				try {
					is.close();
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
			
		}

	}

}
