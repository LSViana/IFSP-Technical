package aula5;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class Jogador implements Serializable {

	private String nome;
	private Integer numero;
	private Date nascimento;
	
	public Jogador(){
		
		this.nome = "";
		this.numero = 0;
		this.nascimento = new Date();
		
	}
	
	public Jogador( String nome, Integer numero, int ano, int mes, int dia ){
		
		this.nome = nome;
		
		this.numero = numero;
		
		GregorianCalendar calendario = new GregorianCalendar( ano, mes - 1, dia );
		
		this.nascimento = calendario.getTime();
		
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	@Override
	public String toString() {
		return "Jogador [nome=" + nome + ", numero=" + numero + ", nascimento=" + nascimento + "]";
	}
	
	

}
