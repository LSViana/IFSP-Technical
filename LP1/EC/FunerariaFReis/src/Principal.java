import Dados.Arquivo;
import Dados.EstruturaDados;
import Negocio.RegrasNegocio;
import Telas.TelasSistema;

/**
 *-------------------------------------------------------------------*
*                  IFSP - Instituto Federal de S�o Paulo             *
*                    T�cnico Integrado em Inform�tica                *  
*                      Projeto Integrado - Turma 231                 *
*--------------------------------------------------------------------*
*                   Autor: Prof MSc. Ver�ssimo                       *
*                                                                    *
*                    Id da Classe: Principal                         *
* Descri��o:                                                         *
*    Este � um "tutorial" que orienta os alunos a desenvolverem      *
*    programas em linguagem Java, utilizando o paradigma de          *
*    arquitetura em CAMADAS.                                         *
*    Dever�o ser criadas 3 pacotes:                                  *
*           > Tela   - Entradas e saidas                             *                                           
*           > Dados  - Grava��o e leitura (persistencia)             *
*           > Neg�cio- Regras de neg�cio                             *
*    Importante: Esta classe far� o "papel" de controle <Control>    *
*    Cabe frizar que este "Tutorial" tem a miss�o de "iniciar", de   *
*    forma rudimentar, paradigma da arquitetura  MVC (Futuro)        * 
*--------------------------------------------------------------------*
 */
public class Principal

{
	   
    public static void main(String[] args) {
       
    
    	TelasSistema  telas = new TelasSistema();       //cria objeto "telas" par manipula��o da tela (entrada de dados)
    	
    	String opcaoMenu =  "";
    	do {                                           //in�cio da estrutura de controle "do...while"
    		
    	   opcaoMenu =  telas.obterOpcaoMenu();        //retorna do menu a opcao (neste exemplo C=Consulta; I=Inclusao e  S=Saida do programa)        	
    	   if(opcaoMenu.equals("c"))
    	   {
    		   //chamada do m�todo "acessaDados()", de forma estatica para acesso ao arquivo .txt
    		   //nesta chamada devolve um objeto do tipo "EstruturaDados" (com a imagem do arquivo que desejo recuperar)
    		   //ou seja: Neste momento tenho os dados lidos neste objeto
    		   //IMPORTANTE: Observar que os dados foram gravados em outro momento(Opcao =I)
    		   
    		   EstruturaDados dados = Arquivo.acessaDados();  //A classe "EstruturaDados" � a imagem dos dados que necessito mostrar em tela (Consulta)
//    		   
    		   //passa para o m�todo "mostraTela()" os dados, no objeto "dados"
    		   telas.mostraTela(dados);  //l� no m�todo "mostraTela", poderemos acessar aos m�todos que est�o dentro do objeto "dado": N�o � fant�stico???!!!!
    	   } else {
    		   if(opcaoMenu.equals("i"))
    		   {
    			   telas.TelaEntradaDados();       //M�todo para solicitar os dados para o usu�rio. neste momento os atributos da classe receber�o os dados digitados pelo usu�rio (m�todos set...)  
    			   
    			   RegrasNegocio regras = new RegrasNegocio();    //Cria��o do objeto "regras" (onde teremos os m�todos necess�rios para tratar as regras de neg�cio)
    			   
    			   String msgRegra = regras.verificaCodPacote(telas.getTipoPacote()); //Chama m�todo para validar regras (neste nosso exemplo,, colocamos somente 1 regra)
    			   
    			   if (msgRegra.equals("")) 
    			   {
    				   
    				   String registro =    //aqui � montado uma "String" com o formato (layout) do registro a ser gravado. Note que cada campo deve ter um caracter que os separa (em nosso cado o caracter ";" (Ponto e v�rgula)
    						   telas.getTipoPacote()          +   //primeiro campo do layout 
                              ";"                             +   //separador de campo
                              telas.getTipoUrnaFuneraria()    +   // segundo campo do layout
                               ";"                            +   // Separador de campo
                              telas.getTamanho();                 // terceiro campo do layout
                                                                  //coloque quantos forem necess�rios para sua aplica��o
    				                                              // Em nosso exemplo, so estou a gravar 3 campos.
                              String arq = "C:/Users/Verissimo/Desktop/FunerariaFReis.txt";  //IMPORTANTE: Altere este caminho para sua necessidade
                              
                              Arquivo.Write(arq,registro );     //Chamada EST�TICA para grava��o dos dados, passando o nome do arquivo e os dados necess�rios para serem gravados
   			    	 telas.msgTela("**INCLUSAO Efetuada com Sucesso!!!");
    			   }
    			   else {
    			        telas.msgTela(msgRegra);
    			   }
    		   } else {
    			   if (opcaoMenu.equals("s")) {
    				   telas.msgTela("**Obrigado por utilizar o sistema!!!\n Descanse em Paz!!!");
    			   }
    			   else {
    			      telas.msgTela("escolheu INVALIDA");
    			         }
    			  
    		   }
    		  
    	   }
    	   
    } 
    	while (!opcaoMenu.equals("s")) ;  //Fim (sa�da) da estrutura de controle "do...while"
			
			
        	
    }
   
}

