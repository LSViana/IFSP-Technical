package Dados;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 *-------------------------------------------------------------------*
*                  IFSP - Instituto Federal de S�o Paulo             *
*                    T�cnico Integrado em Inform�tica                *  
*                      Projeto Integrado - Turma 231                 *
*--------------------------------------------------------------------*
*                   Autor: Prof MSc. Ver�ssimo                       *
*                                                                    *
*                    Id da Classe: Arquivo                           *
* Descri��o:                                                         *
*    Classe necess�ria para manipul��o de arquivos: leitura/Grava��o/*
*    Altera��o e Exclus�o                                            *
*    note que n�o criamos os atributos de inst�ncia. Estamos a       *
*    passar e receber os dados pela classe "EstruturaDados"          * 
*--------------------------------------------------------------------*/ 
public class Arquivo
{

    public static String Read(String caminho) {                 //M�todo para recuperar dados do arquivo .txt, gravado anteriromente
        String conteudo = "";
        try {
            FileReader arq = new FileReader(caminho);          //Instancia classe que manipula arquivo (Localiza o arquivo)  
            BufferedReader lerArq = new BufferedReader(arq);   //leitura do arquivo: Se tudo 
            String linha = "";
            try
            {
                linha = lerArq.readLine();                    // Se leitura OK,  transfere o conte�do da linha do arquivo, para a String "linha" (obedecendo o layout comentado na classe "Principal")
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
            System.out.println("Erro: Arquivo n�o encontrado");
            return "";
        }  
        
    }
  public static boolean Write(String caminho, String texto) {   //M�todo par gravar arquivo no caminho solicitado
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
    public static EstruturaDados acessaDados () { //m�todo para formatar dados 
         String arq = "C:/Users/verissimo/Desktop/FunerariaFReis.txt";
         String conteudo = Arquivo.Read(arq);
         int  codigoTipoPacote = Integer.parseInt(conteudo.split(";")[0]);
         String codTipoUrna    = conteudo.split(";")[1];
         float tamanho = Float.parseFloat(conteudo.split(";")[2]);
         
         String descricaoPacote   = "";
         String descricaoTipoUrna = "";
         
       //Note: Quando gravamos o arquivo, t�nhamos 2 c�digos (CodTipoPacot; CodtTipoUrnaFuneraria).
       // Observe que dentro do arquivo n�o temos descri��o,mas n�s criamos estas desri��o aqui e as 
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
            	 descricaoTipoUrna = "B�sico";
                     break;
             
             default:
            	 descricaoPacote = "**problema no cadstramento**";
         }
       
         EstruturaDados dados = new EstruturaDados();
         dados.setCodTipoPacote(codigoTipoPacote);
         dados.setCodtTipoUrnaFuneraria(codTipoUrna);
         dados.setDescricaoTipoPacote(descricaoPacote);           //Este n�o existe no arquivo (S� na tela)
         dados.setDescricaoTipoUrnaFuneraria(descricaoTipoUrna); //Este n�o existe no arquivo (S� na tela)
         dados.setTamanho(tamanho);
         return dados;  //retorna a estrutura de "EstruturaDados" no objeto "dados"
            
    
    
    }
    
    }