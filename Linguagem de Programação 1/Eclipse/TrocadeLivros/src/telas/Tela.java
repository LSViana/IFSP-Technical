package telas;

import javax.swing.JOptionPane;
import dados.EstruturaDados;

public class Tela {
	public String titulo;
	public String resumo;
	public String autor;
	public int anopublicacao;
	public String editora;
	public String edicao;
	public int paginas;
	public int pontuacao;

	public Tela() {
	}
	public Tela(String titulo, String resumo, String autor, int anopublicacao, String editora, String edicao, int paginas){
		this.titulo = titulo;
		this.resumo = resumo;
		this.autor =autor;
		this.anopublicacao = anopublicacao;
		this.editora = editora;
		this.edicao = edicao;
		this.paginas = paginas;
	}

	public void TelaEntradaDados() {
		int anopublicacao = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o ano de publicação",
				"Ano de publicação", JOptionPane.PLAIN_MESSAGE));
		setAnoPublicacao(anopublicacao);
		int paginas = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o número de páginas",
				"Número de páginas", JOptionPane.PLAIN_MESSAGE));
		setPaginas(paginas);

		String titulo = JOptionPane.showInputDialog(null, "Informe o título do livro)", "Título do livro",
				JOptionPane.PLAIN_MESSAGE);
		setTitulo(titulo);
		String resumo = JOptionPane.showInputDialog(null, "Informe o resumo do livro)", "Resumo do livro",
				JOptionPane.PLAIN_MESSAGE);
		setResumo(resumo);
		String autor = JOptionPane.showInputDialog(null, "Informe o(a)(s) autor(a)(es)/(s) do livro)", "Autor do livro",
				JOptionPane.PLAIN_MESSAGE);
		setAutor(autor);
		String editora = JOptionPane.showInputDialog(null, "Informe a editora do livro)", "Editora do livro",
				JOptionPane.PLAIN_MESSAGE);
		setEditora(editora);
		String edicao = JOptionPane.showInputDialog(null, "Informe a edição do livro)", "Edição do livro",
				JOptionPane.PLAIN_MESSAGE);
		setEdicao(edicao);

	}

	public void setAnoPublicacao(int anopublicacao) {
		this.anopublicacao = anopublicacao;
	}
	public int getAnoPublicacao(){
		return anopublicacao;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	public int getPaginas(){
		return paginas;
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
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getAutor(){
		return autor;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getEditora(){
		return editora;
	}
	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}
	public String getEdicao(){
		return edicao;
	}

	public void mostraTela(EstruturaDados dados) {
		int anopublicacao = dados.getAnoPublicacao();
		int paginas = dados.getPaginas();
		String titulo = dados.getTitulo();
		String resumo = dados.getResumo();
		String autor = dados.getAutor();
		String editora = dados.getEditora();
		String edicao = dados.getEdicao();

		String tela = String.format(
				"Título do livro: %d - %s\n Resumo do livro: %s - %s\n Autor do livro: %s - %s\n Editora do livro: %s - %s\n Edição do livro: %s - %s\n Ano de publicação: %d - %s\n Número de páginas: %d - %s",
				titulo, resumo, autor, editora, edicao, anopublicacao, paginas);

		JOptionPane.showMessageDialog(null, tela);
	}
	public void avisaReprovacao(String motivo) {
        String msgReprovado    = String.format("Seu livro não pode ser cadastrado\n Motivo: %s", motivo)  ;
         JOptionPane.showMessageDialog(null,msgReprovado);
    }
	public void msgTela(String msgDescricao) {
		JOptionPane.showMessageDialog(null, msgDescricao);

	}
	public int getPontuacao() {
		return pontuacao;
	}

}