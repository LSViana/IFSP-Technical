package dados;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class Arquivo
{

    public static String Read(String caminho) {
        String conteudo = "";
        try {
            FileReader arq = new FileReader(caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";
            try
            {
                linha = lerArq.readLine();
                while (linha!=null) {
                    conteudo += linha+"\n";
                    linha = lerArq.readLine();
                }
                arq.close();
                return conteudo;
            } catch (IOException ex) {
                System.out.println( "Erro: nao foi possivel ler o arquivo");
                return "";
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Erro: Arquivo não encontrado");
            return "";
        }  
        
    }
  public static boolean Write(String caminho, String texto) {
      try {
          FileWriter arq = new FileWriter(caminho);
          PrintWriter gravaArq = new PrintWriter(arq);
          gravaArq.println(texto);
          gravaArq.close();    
          return true;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public static EstruturaDados acessaDados () {
         String arq = "Teste.txt";
         String conteudo = Arquivo.Read(arq);
         String c1 = conteudo.split(";")[0];
         String c2 = conteudo.split(";")[1];
         String c3 = conteudo.split(";")[2];
         int c4 = Integer.parseInt(conteudo.split(";")[4]);
         String c5 = conteudo.split(";")[5];
         //int c6 = Integer.parseInt(conteudo.split(";")[5]);
         String  c6 = conteudo.split(";")[6];
         int c7 = Integer.parseInt(conteudo.split(";")[7]);
         
         EstruturaDados dados = new EstruturaDados();
         
         dados.setTitulo(c1);
         dados.setResumo(c2);
         dados.setAutor(c3);
         dados.setAnoPublicacao(c4);
         dados.setEditora(c5);
         dados.setEdicao(c6);
         dados.setPaginas(c7);
         return dados;
            
    
    
    }
}