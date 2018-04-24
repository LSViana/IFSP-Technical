package aula4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class BibliaAnalizer {

	public static int palavras = 0;
	public static int linhas = 0;
	public static int caracteres = 0;
	public static int numeros = 0;
	
	public static int terra = 0;
	
		
	public static void main (String[] args) { 
				
		try {
			
			InputStream is = new FileInputStream("biblia.txt");
			
			InputStreamReader isr = new InputStreamReader(is);
		        
			BufferedReader br = new BufferedReader(isr);
			
			StreamTokenizer st = new StreamTokenizer( br );
			
			while ( st.nextToken() != StreamTokenizer.TT_EOF ) {
				
				switch ( st.ttype ) 
				{
									
					case StreamTokenizer.TT_WORD: 
						palavras++;
						caracteres += st.sval.length(); 						
						if( st.sval.equals("terra"))
							terra++;
						break;
						
					case StreamTokenizer.TT_NUMBER: 
						numeros++;						
						caracteres += new Double( st.nval ).intValue();					
						break;
		
				}
				
			}
		} 
		catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		System.out.println("caracteres: " + caracteres );
		
		System.out.println("palavras: " + palavras );
		
		System.out.println("terra: " + terra );
		
		System.out.println("numero: " + numeros );
		
	}
}
