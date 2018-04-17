package aula4;

import java.util.Enumeration;
import java.util.Properties;

public class Properties2 {

	public static void main(String[] args) {
		
		Properties propriedades = System.getProperties();
	    
		Enumeration<?> e = propriedades.propertyNames();

	    while ( e.hasMoreElements() ) {
	      
	    	String chave = (String) e.nextElement();
	    	
	    	System.out.println( chave + " -- " + propriedades.getProperty(chave) );
	    	
	    }
	    
	}

}




