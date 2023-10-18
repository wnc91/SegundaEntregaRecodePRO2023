package principal;

public class Cliente {
	
	private String cpf;
	private String email;
	private int id = 0;
	private String nome;
	private String endereco;
	private String telefone;
	
	public Cliente() {
	}
	
	public Cliente(String cpf, String email, String nome, String endereco, String telefone) {
		super();
		this.cpf = cpf;
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
