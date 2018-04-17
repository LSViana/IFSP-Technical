package aula1;

public class Aviao {
	
	private String fabricante;
	private String modelo;

	public Aviao( String fabricante, String modelo ) {
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
	public boolean equals(Object obj) {
		
		Aviao a1 = (Aviao) obj;
		
		if( this.fabricante.equals( a1.getFabricante() ) && this.modelo.equals( a1.getModelo() ) )
				return true;
		else
			return false;
	}
	
}
