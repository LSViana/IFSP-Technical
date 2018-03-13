package aula2;

public class Carro implements Cloneable {

	private String modelo;
	private String placa;
	
	public Carro( String modelo, String placa ){
	
		this.modelo = modelo;
		
		this.placa = placa;
		
	}
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public Carro clone() throws CloneNotSupportedException {
		
		Carro clonado = (Carro) super.clone();
						
		return clonado;
		
	}
	
	public boolean equals(Object obj) {

		if (this == obj) 				// comentário 1
			return true;
		
		if (obj == null) 				// comentário 2
			return false;
		
		if (getClass() != obj.getClass()) 	// comentário 3
			return false;
		
		Carro other = (Carro) obj; 		// comentário 4
		
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		
		return true;
		
	}

	@Override
	public String toString() {
		return "Carro [placa=" + placa + "]";
	}
	
}
