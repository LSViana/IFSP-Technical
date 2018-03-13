package aula2;

import java.util.Date;
import java.util.GregorianCalendar;

public class Funcionario implements Cloneable {
		
	private String nome;
	private double salario;
	private Date dataAdmissao;	
	private Date dataNascimento;
		
	public Funcionario( String n, double s, int dia, int mes, int ano ){
			
		this.nome = n;
		this.salario = s;
		this.dataNascimento = new GregorianCalendar( ano, mes - 1, dia ).getTime();
			
	}
		
	public void setDataAdmissao( int dia, int mes, int ano ){
			
		dataAdmissao = new GregorianCalendar( ano, mes - 1, dia ).getTime();
			
	}
		
	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void aumentoSalario( double percentual ){
			
		double aumento = salario * percentual / 100;
		this.salario = this.salario + aumento;
			
	}
		
	public String toString(){
		return getClass().getName() + "[nome: " + this.nome + ", salario: " + salario + ", data admissao: " + dataAdmissao +"]";
	}
		
	public Funcionario clone() throws CloneNotSupportedException {
					
		Funcionario clonado = (Funcionario) super.clone();
					
		return clonado;
			
	}
	
}
