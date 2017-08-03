package Dados;

/**
 *-------------------------------------------------------------------*
*                  IFSP - Instituto Federal de São Paulo             *
*                    Técnico Integrado em Informática                *  
*                      Projeto Integrado - Turma 231                 *
*--------------------------------------------------------------------*
*                   Autor: Prof MSc. Veríssimo                       *
*                                                                    *
*                    Id da Classe: EstruturaDados                    *
* Descrição:                                                         *
*    Classe necessária para proporcionar a navegação dos dados entre * 
*    as classes "Tela" e "Arquivo"                                   *
*--------------------------------------------------------------------*/ 
public class  EstruturaDados
{
  private String  descricaoTipoPacote;
  private String  codtTipoUrnaFuneraria; //A1-Luxo B1=Basico 
  private String  descricaoTipoUrnaFuneraria;  //  
  private float tamanho;  // em metros
  private int     codTipoPacote;  //1=Gold; 2=Platinum 3=Silver
 
  public int getCodTipoPacote() {
	return codTipoPacote;
}
public void setCodTipoPacote(int codTipoPacote) {
	this.codTipoPacote = codTipoPacote;
}
public String getDescricaoTipoPacote() {
	return descricaoTipoPacote;
}
public void setDescricaoTipoPacote(String descricaoTipoPacote) {
	this.descricaoTipoPacote = descricaoTipoPacote;
}
public String getCodtTipoUrnaFuneraria() {
	return codtTipoUrnaFuneraria;
}
public void setCodtTipoUrnaFuneraria(String codtTipoUrnaFuneraria) {
	this.codtTipoUrnaFuneraria = codtTipoUrnaFuneraria;
}
public String getDescricaoTipoUrnaFuneraria() {
	return descricaoTipoUrnaFuneraria;
}
public void setDescricaoTipoUrnaFuneraria(String descricaoTipoUrnaFuneraria) {
	this.descricaoTipoUrnaFuneraria = descricaoTipoUrnaFuneraria;
}
public float getTamanho() {
	return tamanho;
}
public void setTamanho(float tamanho) {
	this.tamanho = tamanho;
}

}