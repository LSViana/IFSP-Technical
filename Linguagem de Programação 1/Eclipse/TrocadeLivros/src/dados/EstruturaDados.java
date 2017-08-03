package dados;

public class EstruturaDados {
	
	public String titulo;
	public String resumo;
	public String autor;
	public int anopublicacao;
	public String editora;
	public String edicao;
	public int paginas;
	
	public EstruturaDados(){
		
	}
	public EstruturaDados(String titulo, String resumo, String autor, int anopublicacao, String editora, String edicao, int paginas){
		this.titulo = titulo;
		this.resumo = resumo;
		this.autor = autor;
		this.anopublicacao = anopublicacao;
		this.editora = editora;
		this.edicao = edicao;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getResumo(){
		return resumo;
	}
	public void setResumo(String resumo){
		this.resumo = resumo;
	}
	public String getAutor(){
		return autor;
	}
	public void setAutor(String autor){
		this.autor = autor;
	}
	public int getAnoPublicacao(){
		return anopublicacao;
	}
	public void setAnoPublicacao(int anopublicacao){
		this.anopublicacao = anopublicacao;
	}
	public String getEditora(){
		return editora;
	}
	public void setEditora(String editora){
		this.editora = editora;
	}
	public String getEdicao(){
		return edicao;
	}
	public void setEdicao(String edicao){
		this.edicao = edicao;
	}
	public int getPaginas(){
		return 0;
	}
	public void setPaginas(int paginas){
	}

}