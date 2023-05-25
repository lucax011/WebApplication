package javaWebApplication.Beans;

public class RegisterBean {

	private String nome;
	private String sobrenome;
	private String email;
	private String senha;

	public RegisterBean( String nome, String sobrenome, String email, String senha) {
		
		super();
		
		this.email = email;
		this.nome = nome;
		this.senha = senha;
		this.sobrenome = sobrenome;
		
	}
	
	public String getNome() {

		return nome;

	}

	public void setNome(String nome) {

		this.nome = nome;

	}

	public String getSobrenome() {

		return sobrenome;

	}

	public void setSobreome(String sobrenome) {

		this.sobrenome = sobrenome;

	}

	public String getEmail() {

		return email;

	}

	public void setEmail(String email) {

		this.email = email;

	}

	public String getSenha() {

		return senha;

	}

	public void setSenha(String senha) {

		this.senha = senha;

	}

}
