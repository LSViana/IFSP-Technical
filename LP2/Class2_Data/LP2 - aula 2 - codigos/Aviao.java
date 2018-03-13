package aula2;

public class Aviao {

	private String fabricante;
	private String modelo;
	
	public Aviao(String fabricante, String modelo) {
	
		this.fabricante = fabricante;
		this.modelo = modelo;
		
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	@Override
	public String toString() {
		
		return "Aviao [fabricante=" + fabricante + ", modelo=" + modelo + "]";
		
	}

	@Override
	public int hashCode() {
		
		final int prime = 31;
		
		int result = 1;
		
		result = prime * result + ((fabricante == null) ? 0 : fabricante.hashCode());
		
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		
		return result;	
		
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Aviao other = (Aviao) obj;
		
		if (fabricante == null) {
			
			if (other.fabricante != null)
				return false;
		} 
		else if (!fabricante.equals(other.fabricante))
			return false;
		
		if (modelo == null) {
			
			if (other.modelo != null)
				return false;
			
		} 
		else if (!modelo.equals(other.modelo))
			return false;
		
		return true;
		
	}
		
}
