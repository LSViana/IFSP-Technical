package aula2;

import java.util.ArrayList;
import java.util.Scanner;

public class TesteHashcode2 {

	public static void main(String[] args) {
		
		ArrayList<Aviao> avioes = new ArrayList<>();
		
		System.out.println("Cadastro de Aviões");
		
		
		try( Scanner entrada = new Scanner(System.in)){
			
			String continuar = "s";
			
			while( "s".equalsIgnoreCase( continuar )){
				
				System.out.print("fabricante: ");
				String fabricante = entrada.nextLine();
				
				System.out.print("modelo: ");
				String modelo = entrada.nextLine();
				
				Aviao aviao = new Aviao( fabricante, modelo );
				
				if( avioes.contains(aviao) ){
					
					System.out.println("AVISO - O avião não pode ser cadastrado novamente");
					
				}
				else{
					avioes.add(aviao);
					System.out.println("O avião foi cadastrado com sucesso !");
				}
								
				System.out.println("Deseja adicionar outro avião ? (s/n)");
				
				continuar = entrada.nextLine();
				
			}
			
			
		}
		
		avioes.forEach( System.out::println );
		
		System.out.println("Terminou !");

	}

}
