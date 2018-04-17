package aula2;


public class Usuario {

	private String login;
	
	public Usuario(){
		
		this.login = "";
		
	}
	
	public Usuario( String login ){
		
		this.login = login;
		
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public int hashCode() {
		
		final int prime = 31;
		
		int result = 1;
		
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		
		return result;
	}
	
}
