package telas;

import javax.swing.JOptionPane;
import dados.EstruturaDados;

public class Sistema {
	public String titulo;
	public String resumo;
	public String autor;
	public int anopublicacao;
	public String editora;
	public String edicao;
	public int paginas;

	public Sistema() {
	}

	public void TelaEntradaDados() {
		int anopublicacao = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o ano de publica��o",
				"Ano de publica��o", JOptionPane.PLAIN_MESSAGE));
		setAnoPublicacao(anopublicacao);
		int paginas = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o n�mero de p�ginas",
				"N�mero de p�ginas", JOptionPane.PLAIN_MESSAGE));
		setPaginas(paginas);

		String titulo = JOptionPane.showInputDialog(null, "Informe o t�tulo do livro)", "T�tulo do livro",
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
		String edicao = JOptionPane.showInputDialog(null, "Informe a edi��o do livro)", "Edi��o do livro",
				JOptionPane.PLAIN_MESSAGE);
		setEdicao(edicao);

	}

	public void setAnoPublicacao(int anopublicacao) {
		this.anopublicacao = anopublicacao;
	}
	public void setPaginas(int paginas) {
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public void setEdicao(String edicao) {
		this.edicao = edicao;
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
				"T�tulo do livro: %d - %s\n Resumo do livro: %s - %s\n Autor do livro: %s - %s\n Editora do livro: %s - %s\n Edi��o do livro: %s - %s\n Ano de publica��o: %d - %s\n N�mero de p�ginas: %d - %s",
				titulo, resumo, autor, editora, edicao, anopublicacao, paginas);

		JOptionPane.showMessageDialog(null, tela);
	}
	public void avisaReprovacao(String motivo) {
        String msgReprovado    = String.format("Seu livro n�o pode ser cadastrado\n Motivo: %s", motivo)  ; 
         JOptionPane.showMessageDialog(null,msgReprovado);
    }
	public void msgTela(String msgDescricao) {
		JOptionPane.showMessageDialog(null, msgDescricao);

	}

}