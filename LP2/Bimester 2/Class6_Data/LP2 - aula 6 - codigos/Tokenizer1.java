package aula4;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class Tokenizer1 {

	public static void main(String[] args) {
		
		StreamTokenizer streamTokenizer = new StreamTokenizer( new StringReader("Santos Santos 1 campeão brasileiro") );

		try {
			
			while(streamTokenizer.nextToken() != StreamTokenizer.TT_EOF ){

				if( streamTokenizer.ttype == StreamTokenizer.TT_WORD ) {
					
					System.out.print( streamTokenizer.sval );
					System.out.print( " - palavra \n" );
					
				} 
				else if( streamTokenizer.ttype == StreamTokenizer.TT_NUMBER ) {
				
					System.out.print( streamTokenizer.nval );
					System.out.print( " - numero \n" );
					
				} 
				else if( streamTokenizer.ttype == StreamTokenizer.TT_EOL ) {
					
					System.out.println();
					
				}

			}
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
