package aula4;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class OutputStream2 {

	public static void main(String[] args) {
						         
		try {
		
			Scanner s = new Scanner(System.in);
			
			PrintStream ps = new PrintStream("arquivo.txt");
		
			while (s.hasNextLine()) {
	        
				ps.println( s.nextLine() );
				
	        }
			
			ps.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		}
        
        
        
	}

}
