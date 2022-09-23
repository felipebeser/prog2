package usuarios;

public abstract class Usuario implements CRUD{
	private String login;
	private String Senha;
	
	public int logon() {
		return 0;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String senha) {
		Senha = senha;
	}
	
	
}
