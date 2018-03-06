package aula3;

public class Pessoa implements Comparable<Pessoa> {

	private String nome;
	private int idade;
	
	public Pessoa(){
		this.nome = "";
		this.idade = 0;
	}
	public Pessoa( String nome, int idade ){
		this.nome = nome;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String toString(){
		return this.getClass().getName() + "[nome=" + this.nome + ", idade=" + this.idade + "]";
	}
	
	
//	@Override
//	public int hashCode() {
//		return (int) this.nome.codePointBefore(1);
//	}
//		
//	@Override
//	public boolean equals(Object obj) {
//		
//		if (this == obj)
//			return true;
//		
//		if (obj == null)
//			return false;
//		
//		if (getClass() != obj.getClass())
//			return false;
//		
//		Pessoa other = (Pessoa) obj;
//		
//		if (idade != other.idade)
//			return false;
//		
//		if (nome == null) {
//			if (other.nome != null)
//				return false;
//		} else if (!nome.equals(other.nome))
//			return false;
//		
//		return true;
//		
//	}
		
	@Override
	public int compareTo(Pessoa o) {

		return this.nome.compareTo( o.getNome() );
		
	}	
	
}
