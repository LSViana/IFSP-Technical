package aula4;

import java.io.File;
import java.util.Scanner;

public class File3 {

	public File3(){

		Scanner input = new Scanner( System.in );
		
		System.out.println("Digite o nome de um arquivo ou diretorio: ");
		
		analizarPath( input.nextLine() );
		
		input.close();
				
	}
	
	
	
	public void analizarPath( String path ){
	
		File arquivo = new File(path);
		
		if( arquivo.exists() ){
			
			System.out.printf( "\n%s%s\n%s\n%s\n%s\n%s%s\n%s%s\n%s%s\n%s%s\n",
				 arquivo.getName(), " existe",
				 ( arquivo.isFile() ? "é um arquivo" : "não é um arquivo"),
				 ( arquivo.isDirectory() ? "é um diretorio" : "não é um diretorio"),
				 ( arquivo.isAbsolute() ? "é um caminho absoluto" : "não é um caminho absoluto"),
				 "ultima modificação: ", arquivo.lastModified(),
				 "tamanho: ", arquivo.length(),
				 "path: ", arquivo.getPath(),
				 "path absoluto: ", arquivo.getAbsolutePath()
				 
			);
			
			if( arquivo.isDirectory() ){
				
				String diretorios[] = arquivo.list();
				
				System.out.println( "Contêm os diretorios: " );
				
				for( String d: diretorios )
					System.out.println(d);
				
			}
			
		}
		else {
			
			System.out.printf( "\n%s %s", path, "não existe !" );
			
		}
				
	}
	
	public static void main(String[] args) {
	
		@SuppressWarnings("unused")
		File3 app = new File3();

	}

}
