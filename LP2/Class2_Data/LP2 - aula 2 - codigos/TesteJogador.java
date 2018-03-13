package aula2;

public class TesteJogador {

	public static void main(String[] args) {
			
		try {
		
			Jogador j1 = new Jogador("bernardo", "10", "azul");
			
			Jogador j2 = j1.clone();
			
			System.out.println( j1 );
			System.out.println( j2 );

			j2.setCamisa( new Camisa("20", "branco") );
			
			System.out.println( j1 );
			System.out.println( j2 );

		} 
		catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

	}

}
