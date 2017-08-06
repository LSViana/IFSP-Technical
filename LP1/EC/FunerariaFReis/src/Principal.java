import Dados.Arquivo;
import Dados.EstruturaDados;
import Negocio.RegrasNegocio;
import Telas.TelasSistema;

/**
 *-------------------------------------------------------------------*
*                  IFSP - Instituto Federal de São Paulo             *
*                    Técnico Integrado em Informática                *  
*                      Projeto Integrado - Turma 231                 *
*--------------------------------------------------------------------*
*                   Autor: Prof MSc. Veríssimo                       *
*                                                                    *
*                    Id da Classe: Principal                         *
* Descrição:                                                         *
*    Este é um "tutorial" que orienta os alunos a desenvolverem      *
*    programas em linguagem Java, utilizando o paradigma de          *
*    arquitetura em CAMADAS.                                         *
*    Deverão ser criadas 3 pacotes:                                  *
*           > Tela   - Entradas e saidas                             *                                           
*           > Dados  - Gravação e leitura (persistencia)             *
*           > Negócio- Regras de negócio                             *
*    Importante: Esta classe fará o "papel" de controle <Control>    *
*    Cabe frizar que este "Tutorial" tem a missão de "iniciar", de   *
*    forma rudimentar, paradigma da arquitetura  MVC (Futuro)        * 
*--------------------------------------------------------------------*
 */
public class Principal

{
	   
    public static void main(String[] args) {
       
    
    	TelasSistema  telas = new TelasSistema();       //cria objeto "telas" par manipulação da tela (entrada de dados)
    	
    	String opcaoMenu =  "";
    	do {                                           //início da estrutura de controle "do...while"
    		
    	   opcaoMenu =  telas.obterOpcaoMenu();        //retorna do menu a opcao (neste exemplo C=Consulta; I=Inclusao e  S=Saida do programa)        	
    	   if(opcaoMenu.equals("c"))
    	   {
    		   //chamada do método "acessaDados()", de forma estatica para acesso ao arquivo .txt
    		   //nesta chamada devolve um objeto do tipo "EstruturaDados" (com a imagem do arquivo que desejo recuperar)
    		   //ou seja: Neste momento tenho os dados lidos neste objeto
    		   //IMPORTANTE: Observar que os dados foram gravados em outro momento(Opcao =I)
    		   
    		   EstruturaDados dados = Arquivo.acessaDados();  //A classe "EstruturaDados" é a imagem dos dados que necessito mostrar em tela (Consulta)
//    		   
    		   //passa para o método "mostraTela()" os dados, no objeto "dados"
    		   telas.mostraTela(dados);  //lá no método "mostraTela", poderemos acessar aos métodos que estão dentro do objeto "dado": Não é fantástico???!!!!
    	   } else {
    		   if(opcaoMenu.equals("i"))
    		   {
    			   telas.TelaEntradaDados();       //Método para solicitar os dados para o usuário. neste momento os atributos da classe receberão os dados digitados pelo usuário (métodos set...)  
    			   
    			   RegrasNegocio regras = new RegrasNegocio();    //Criação do objeto "regras" (onde teremos os métodos necessários para tratar as regras de negócio)
    			   
    			   String msgRegra = regras.verificaCodPacote(telas.getTipoPacote()); //Chama método para validar regras (neste nosso exemplo,, colocamos somente 1 regra)
    			   
    			   if (msgRegra.equals("")) 
    			   {
    				   
    				   String registro =    //aqui é montado uma "String" com o formato (layout) do registro a ser gravado. Note que cada campo deve ter um caracter que os separa (em nosso cado o caracter ";" (Ponto e vírgula)
    						   telas.getTipoPacote()          +   //primeiro campo do layout 
                              ";"                             +   //separador de campo
                              telas.getTipoUrnaFuneraria()    +   // segundo campo do layout
                               ";"                            +   // Separador de campo
                              telas.getTamanho();                 // terceiro campo do layout
                                                                  //coloque quantos forem necessários para sua aplicação
    				                                              // Em nosso exemplo, so estou a gravar 3 campos.
                              String arq = "C:/Users/Verissimo/Desktop/FunerariaFReis.txt";  //IMPORTANTE: Altere este caminho para sua necessidade
                              
                              Arquivo.Write(arq,registro );     //Chamada ESTÁTICA para gravação dos dados, passando o nome do arquivo e os dados necessários para serem gravados
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
    	while (!opcaoMenu.equals("s")) ;  //Fim (saída) da estrutura de controle "do...while"
			
			
        	
    }
   
}

