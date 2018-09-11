package beans;

public class Login {
	
	private String login;
	private String password;
	private boolean notFilled;
	private boolean notAuthenticated;
	
	public Login() {
		this("", "");
	}
	
	public Login(String login, String password) {
		super();
		this.login = login;
		this.password = password;
		this.notFilled = false;
		this.notAuthenticated = false;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isNotFilled() {
		return notFilled;
	}
	public void setNotFilled(boolean notFilled) {
		this.notFilled = notFilled;
	}
	public boolean isNotAuthenticated() {
		return notAuthenticated;
	}
	public void setNotAuthenticated(boolean authenticated) {
		this.notAuthenticated = authenticated;
	}

}
