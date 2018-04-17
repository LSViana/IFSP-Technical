package aula4;

import java.io.File;
import java.io.IOException;

public class File2 {

	public static void main(String[] args) {
		
		File novo  = new File("novo.txt");
		
		if ( novo.exists() ) { 
			
			System.out.println("novo.txt já existe.");
			
		} 
		else {
						
			try {
				
				novo.createNewFile(); 
				
				System.out.println("novo.txt foi criado");
				
			}
	        catch (IOException ex) {
	        	
	        	System.out.println("Tratamento da Exception" );
	        	
	        }
			
		}
		
		File diretorio  = new File("JavaIO");
		
		diretorio.mkdir(); 
	    
		if ( diretorio.isDirectory() ) { 
			
			System.out.println("novo diretorio foi criado.");
			
			System.out.println( diretorio.getAbsolutePath() );
			
		}

	}

}
