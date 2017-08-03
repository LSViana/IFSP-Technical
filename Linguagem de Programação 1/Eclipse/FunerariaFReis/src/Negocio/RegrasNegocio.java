package Negocio;

/**
 *-------------------------------------------------------------------*
*                  IFSP - Instituto Federal de S�o Paulo             *
*                    T�cnico Integrado em Inform�tica                *  
*                      Projeto Integrado - Turma 231                 *
*--------------------------------------------------------------------*
*                   Autor: Prof MSc. Ver�ssimo                       *
*                                                                    *
*                    Id da Classe: Regrasnegocio                     *
* Descri��o:                                                         *
*    Classe que conter� as regras de neg�cio, necess�rias ao sistema *
*--------------------------------------------------------------------*/ 
public class RegrasNegocio
{
   public String verificaCodPacote(int codPacote)  //M�todo para validar o pacote: Retorna mensagem se tiver erro
   {
    if (codPacote == 1 || codPacote == 2  ||codPacote ==  3)
        return "";
    else
        return "Codigo de Pacote Invalido";
    }
}
