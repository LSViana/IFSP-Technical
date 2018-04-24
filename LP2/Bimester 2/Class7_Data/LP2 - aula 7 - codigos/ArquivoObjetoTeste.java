package aula5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

public class ArquivoObjetoTeste {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		Set<Jogador> time = new HashSet<Jogador>();
		
		time.add( new Jogador("Romario", 10, 1966, 1, 29) );
		time.add( new Jogador("Bebeto", 11, 1964, 2, 16) );
		time.add( new Jogador("Tafarel", 1, 1966, 5, 8) );
		
		ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream("time.dat") );
		
		out.writeObject(time);
		
		out.close();
		
		ObjectInputStream in = new ObjectInputStream( new FileInputStream("time.dat") );
		
		HashSet<Jogador> novo = (HashSet<Jogador>) in.readObject();
		
		in.close();
		
		for( Jogador j: novo)
			System.out.println( j );
				
	}

}
