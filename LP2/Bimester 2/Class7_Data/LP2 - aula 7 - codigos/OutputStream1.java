package aula4;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class OutputStream1 {

	public static void main(String[] args) {
			
		try {
			
			OutputStream os = new FileOutputStream("saida.txt");
			
			OutputStreamWriter osw = new OutputStreamWriter(os);
	        
	        BufferedWriter bw = new BufferedWriter(osw);

	        bw.write("Santos campeão brasileiro 2017");

	        bw.close();
	        
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		        
	}

}
