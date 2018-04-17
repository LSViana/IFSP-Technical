package aula3;


public class Aluno extends Pessoa {

	private String prontuario;
	
	public Aluno(){
		super();
		this.prontuario = "";
	}
	
	public Aluno( String nome, int idade, String prontuario ){
		super( nome, idade );		
		this.prontuario = prontuario;
	}

	public String getProntuario() {
		return prontuario;
	}

	public void setProntuario(String prontuario) {
		this.prontuario = prontuario;
	}
	
	public String toString(){
		return super.toString() + "[prontuario=" + this.prontuario + "]";
	}

	@Override
	public int hashCode() {
				
		return super.hashCode();
				
	}

	@Override
	public boolean equals(Object obj) {
				
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
				
		if (getClass() != obj.getClass())
			return false;
		
		if (!super.equals(obj))
			return false;
		
		Aluno other = (Aluno) obj;
					
		if (prontuario == null) {
			if (other.prontuario != null)
				return false;
		} 
		else if (!prontuario.equals(other.prontuario))
			return false;
		
		return true;
	}
	
	
	
}
