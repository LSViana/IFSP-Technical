package aula1;

public class Carro extends Veiculo {

	private String placa;
	
	public Carro() {
	
		super();
		
		this.placa = "";
		
	}

	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	@Override
	public String toString() {
		return this.getClass() + super.toString() + "[placa=" + placa + "]";
	}
	
}


