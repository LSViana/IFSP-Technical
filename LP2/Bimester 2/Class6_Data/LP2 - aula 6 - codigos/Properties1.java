package aula4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class Properties1 {

	private Properties tabela;
	
	public Properties1(){
	
		tabela = new Properties();
		
		tabela.setProperty("fundo", "azul");
		
		tabela.setProperty("largura", "800 pixels");
		
		tabela.setProperty("altura", "600 pixels");
		
		listarProperties();
		
		tabela.setProperty("fundo", "verde");
		
		listarProperties();
		
		salvarProperties();
		
		tabela.clear();
		
		listarProperties();
				
		carregarProperties();
		
		listarProperties();
		
	}
	
	public void listarProperties(){
		
		Set<Object> atributos = tabela.keySet();
		
		for( Object atributo: atributos )
			System.out.printf("%s\t%s\n", atributo, tabela.get(atributo) );
		
		if( tabela.isEmpty() )
			System.out.println("Tabela esta vazia");
		
		System.out.println("===================================================");
				
	}
	
	public void salvarProperties(){
		
		try {
			
			FileOutputStream output = new FileOutputStream("arquivo.properties");
						
			tabela.store(output, "Arquivo de propriedades");
			
			output.close();
			
			System.out.println("Arquivo de propriedades gravado !");
			
			System.out.println("===================================================");
						 
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		}
		catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public void carregarProperties(){
				
		try {
			
			FileInputStream input = new FileInputStream("arquivo.properties");
			
			tabela.load( input );
			
			input.close();
			
			System.out.println("Arquivo de propriedades carregado !");
			
			System.out.println("===================================================");
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
				
	}
	
	@SuppressWarnings("unused")
	public static void main( String args[] ){
		
		Properties1 teste = new Properties1();
		
	}
	
}
