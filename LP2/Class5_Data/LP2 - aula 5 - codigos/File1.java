package aula4;

import java.io.File;
import java.io.IOException;

public class File1 {

	public static void main(String[] args) {
		
		System.out.println("criar arquivo !");
		
		File arquivo = new File("arquivo.txt");
		
		try {
			
			arquivo.createNewFile();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}

	}

}
