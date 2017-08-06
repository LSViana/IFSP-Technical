/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolutador.negocio;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ManipuladorArquivo {

	public static String read(String nome) throws IOException {
		BufferedReader buffread = new BufferedReader(new FileReader(nome));
		String linha = "";
		String conteudo = "";
		while (true) {
			if (linha != null)
				conteudo += linha;
			else
				break;
			linha = buffread.readLine();
		}
		buffread.close();
		return conteudo;
	}

	public static void write(String nome, String texto) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(nome));
		texto = read(nome) + "\n" + texto;
		buffWrite.append(texto);
		buffWrite.close();

	}

	public static boolean isCadastrado(String nome) {
		File file = new File(nome);
		if (file.exists()) 
			return true;
		else
			return false;
	}

}

