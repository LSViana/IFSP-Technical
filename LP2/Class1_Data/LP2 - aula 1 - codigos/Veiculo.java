package aula1;

public class Veiculo {

	private String modelo;
	
	public Veiculo() {
		
		this.modelo = "";
	}

	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "[modelo=" + modelo + "]";
	}
		
}





