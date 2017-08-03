package Negocio;

/**
 *-------------------------------------------------------------------*
*                  IFSP - Instituto Federal de São Paulo             *
*                    Técnico Integrado em Informática                *  
*                      Projeto Integrado - Turma 231                 *
*--------------------------------------------------------------------*
*                   Autor: Prof MSc. Veríssimo                       *
*                                                                    *
*                    Id da Classe: Regrasnegocio                     *
* Descrição:                                                         *
*    Classe que conterá as regras de negócio, necessárias ao sistema *
*--------------------------------------------------------------------*/ 
public class RegrasNegocio
{
   public String verificaCodPacote(int codPacote)  //Método para validar o pacote: Retorna mensagem se tiver erro
   {
    if (codPacote == 1 || codPacote == 2  ||codPacote ==  3)
        return "";
    else
        return "Codigo de Pacote Invalido";
    }
}
