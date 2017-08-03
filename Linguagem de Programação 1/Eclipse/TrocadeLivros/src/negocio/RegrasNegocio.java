package negocio;

public class RegrasNegocio {
	public int pontuacao = 20;
	public int npaginas;
	
	public RegrasNegocio(){
		
	}
	public RegrasNegocio(int pontuacao, int npaginas){
		this.pontuacao = pontuacao;
		this.npaginas = npaginas;
	}

	public int calcularPontuacao(int npaginas) {
		return this.pontuacao += npaginas;
	}
	public boolean fazerTroca(RegrasNegocio livro1, RegrasNegocio livro2){
		if(livro1.getPontuacao() >= livro2.getPontuacao())
			return true;
		else
			return false;
	}
	public int getNpaginas(){
		return npaginas;
	}
	public void setNpaginas(int npaginas){
		this.npaginas = npaginas;
	}
	public int getPontuacao(){
		return pontuacao;
	}
	public void setPontuacao(int pontuacao){
		this.pontuacao = pontuacao;
	}
}
