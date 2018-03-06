package br.edu.ifsp.labors;

public class Engineer {

	private String name;
	private String crea;
	
	public Engineer(String name, String crea) {
		super();
		this.name = name;
		this.crea = crea;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCrea() {
		return crea;
	}

	public void setCrea(String crea) {
		this.crea = crea;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((crea == null) ? 0 : crea.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Engineer other = (Engineer) obj;
		if (crea == null) {
			if (other.crea != null)
				return false;
		} else if (!crea.equals(other.crea))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Engineer [name=" + name + ", crea=" + crea + "]";
	}
	
}
