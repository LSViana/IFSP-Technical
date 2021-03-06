package telas;

import dados.Arquivo;
import dados.EstruturaDados;
import negocio.RegrasNegocio;
import telas.Tela;

public class TLPrincipal {

	public static void main(String[] args) {

		Tela tela = new Tela();
		tela.TelaEntradaDados();
		RegrasNegocio regras = new RegrasNegocio();
		String motivo = Integer.toString(regras.calcularPontuacao(tela.getPontuacao()));
		if(motivo.equals("")) {
			tela.avisaReprovacao(motivo);
		} else {
			String registro =
					tela.getTitulo() + ";" +
					tela.getResumo() +";" +
					tela.getAutor() + ";" +
					tela.getAnoPublicacao() + ";" +
					tela.getEditora() + ";" +
					tela.getEdicao() + ";" +
					tela.getPaginas() + ";";
			System.out.println(registro);
 		}
	}
}