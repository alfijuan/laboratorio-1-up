package empresa;

public class User {
	private String user;
	private String password;
	
	public User (String user, String pass) {
		this.user= user;
		this.password = pass;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
