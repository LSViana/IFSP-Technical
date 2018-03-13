package aula2;

public class Jogador implements Cloneable {

	private String nome;
	private Camisa camisa;
	
	public Jogador(){
	
		this.nome = "";
		this.camisa = new Camisa();
		
	}
	
	public Jogador( String nome, String numero, String cor){
		
		this.nome = nome;
		this.camisa = new Camisa( numero, cor );
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Camisa getCamisa() {
		return camisa;
	}

	public void setCamisa(Camisa camisa) {
		this.camisa = camisa;
	}
	
	public String toString(){
		return "[nome = " + this.nome + "] " + this.camisa.toString();
	}
	
	public Jogador clone() throws CloneNotSupportedException {
		
		Jogador clonado = (Jogador) super.clone();
						
		return clonado;
		
	}
		
}
