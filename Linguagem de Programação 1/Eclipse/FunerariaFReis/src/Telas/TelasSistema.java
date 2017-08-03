package Telas;

import javax.swing.JOptionPane;

import Dados.EstruturaDados;
public class TelasSistema
{
	private int tipoPacote;  //1=Gold; 2=Platinum 3=Silver 
	private String tipoUrnaFuneraria; //A1-Luxo B1=Basico 
	private float tamanho;  // em metros
    public TelasSistema() {
	   
   }
   public void TelaEntradaDados() 
   {
       int tipoPacote = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe Tipo de Pacote (1; 2 ou 3)" , "Tipo Pacote", JOptionPane.PLAIN_MESSAGE));
       setTipoPacote(tipoPacote);
       
       String tipoUrna =  JOptionPane.showInputDialog(null, "Informe tipo de Urna funerária (A1 ou B1)" , "Tipo de urna Funerária", JOptionPane.PLAIN_MESSAGE);
       setTipoUrnaFuneraria(tipoUrna);
       
        
       float tamanho = Float.parseFloat(JOptionPane.showInputDialog(null, "Informe tamanho " , "tamanho (em Metros)", JOptionPane.PLAIN_MESSAGE));
       setTamanho(tamanho);;
      
    }
   
   
        
   public int getTipoPacote() {
	return tipoPacote;
}
public void setTipoPacote(int tipoPacote) {
	this.tipoPacote = tipoPacote;
}
public String getTipoUrnaFuneraria() {
	return tipoUrnaFuneraria;
}
public void setTipoUrnaFuneraria(String tipoUrnaFuneraria) {
	this.tipoUrnaFuneraria = tipoUrnaFuneraria;
}
public float getTamanho() {
	return tamanho;
}
public void setTamanho(float tamanho) {
	this.tamanho = tamanho;
}

public void mostraTela(EstruturaDados dados)
{
	 	int       tipoPacote = dados.getCodTipoPacote();
	 	String    tipoUrna = dados.getCodtTipoUrnaFuneraria();
	    String    descricaoTipoPacote          = dados.getDescricaoTipoPacote();
        String    descricaoTipoUrnaFuneraria   = dados.getDescricaoTipoUrnaFuneraria();
	    
        float  tamanho                         = dados.getTamanho();
       
       
         String tela    = String.format("Tipo de Pacote: %d - %s \n Tipo de urna Funerária: %s - %s\n Tamanho: %f", tipoPacote, descricaoTipoPacote, tipoUrna, descricaoTipoUrnaFuneraria, tamanho)  ;
         
              
         
        JOptionPane.showMessageDialog(null,tela);
        
    }
    public void avisaReprovacao(String motivo)
    {
        String msgReprovado    = String.format("Sua solicitação foi reprovada\n Motivo: %s", motivo)  ; 
         JOptionPane.showMessageDialog(null,msgReprovado);
    }
    public String obterOpcaoMenu () 
    {
    	String msgEntradaTela    = String.format("***Funerária F.Reis**\n Você deseja Consultar (C) ou Incluir(I) Sair(S)?")  ;	
    	return   JOptionPane.showInputDialog(null, msgEntradaTela , "System xpto", JOptionPane.PLAIN_MESSAGE);
    	
   
    	 
       
    }
	public void msgTela(String msgDescricao) {
		 JOptionPane.showMessageDialog(null,msgDescricao);
		
	}
}