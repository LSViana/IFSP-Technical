package Dados;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 *-------------------------------------------------------------------*
*                  IFSP - Instituto Federal de São Paulo             *
*                    Técnico Integrado em Informática                *  
*                      Projeto Integrado - Turma 231                 *
*--------------------------------------------------------------------*
*                   Autor: Prof MSc. Veríssimo                       *
*                                                                    *
*                    Id da Classe: Arquivo                           *
* Descrição:                                                         *
*    Classe necessária para manipulção de arquivos: leitura/Gravação/*
*    Alteração e Exclusão                                            *
*    note que não criamos os atributos de instância. Estamos a       *
*    passar e receber os dados pela classe "EstruturaDados"          * 
*--------------------------------------------------------------------*/ 
public class Arquivo
{

    public static String Read(String caminho) {                 //Método para recuperar dados do arquivo .txt, gravado anteriromente
        String conteudo = "";
        try {
            FileReader arq = new FileReader(caminho);          //Instancia classe que manipula arquivo (Localiza o arquivo)  
            BufferedReader lerArq = new BufferedReader(arq);   //leitura do arquivo: Se tudo 
            String linha = "";
            try
            {
                linha = lerArq.readLine();                    // Se leitura OK,  transfere o conteúdo da linha do arquivo, para a String "linha" (obedecendo o layout comentado na classe "Principal")
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
  public static boolean Write(String caminho, String texto) {   //Método par gravar arquivo no caminho solicitado
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
    public static EstruturaDados acessaDados () { //método para formatar dados 
         String arq = "C:/Users/verissimo/Desktop/FunerariaFReis.txt";
         String conteudo = Arquivo.Read(arq);
         int  codigoTipoPacote = Integer.parseInt(conteudo.split(";")[0]);
         String codTipoUrna    = conteudo.split(";")[1];
         float tamanho = Float.parseFloat(conteudo.split(";")[2]);
         
         String descricaoPacote   = "";
         String descricaoTipoUrna = "";
         
       //Note: Quando gravamos o arquivo, tínhamos 2 códigos (CodTipoPacot; CodtTipoUrnaFuneraria).
       // Observe que dentro do arquivo não temos descrição,mas nós criamos estas desrição aqui e as 
       //  colocamos na estrutura
         
       //codigoTipoPacote--> 1=Gold; 2=Platinum 3=Silver
         
         switch( codigoTipoPacote )
         {
             case 1:
            	 descricaoPacote = "Gold";
                     break; 
             case 2:
            	 descricaoPacote = "Platinum";
                     break;
             
             case 3:
            	 descricaoPacote = "Silver";
                     break;
             
             default:
            	 descricaoPacote = "**problema no cadstramento**";
         }
       //
       //codTipoUrna-->  //A1-Luxo B1=Basico
         switch( codTipoUrna )
         {
             case "A1":
            	 descricaoTipoUrna = "Luxo";
                     break; 
             case "B1":
            	 descricaoTipoUrna = "Básico";
                     break;
             
             default:
            	 descricaoPacote = "**problema no cadstramento**";
         }
       
         EstruturaDados dados = new EstruturaDados();
         dados.setCodTipoPacote(codigoTipoPacote);
         dados.setCodtTipoUrnaFuneraria(codTipoUrna);
         dados.setDescricaoTipoPacote(descricaoPacote);           //Este não existe no arquivo (Só na tela)
         dados.setDescricaoTipoUrnaFuneraria(descricaoTipoUrna); //Este não existe no arquivo (Só na tela)
         dados.setTamanho(tamanho);
         return dados;  //retorna a estrutura de "EstruturaDados" no objeto "dados"
            
    
    
    }
    
    }