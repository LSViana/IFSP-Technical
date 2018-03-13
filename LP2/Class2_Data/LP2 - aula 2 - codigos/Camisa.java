package aula2;

public class Camisa {

	private String cor;
	private String numero;
	
	public Camisa(){
		this.cor = "";
		this.numero = "";
	}
	
	public Camisa( String cor, String numero ){
		this.cor = cor;
		this.numero = numero;
	}

	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String toString(){
		return "[cor = " + this.cor + ", numero = " + this.numero + "]";
	}
	
}
