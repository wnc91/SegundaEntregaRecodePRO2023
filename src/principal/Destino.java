package principal;

public class Destino {
    private int id;
    private String nome;
    private String destino;
    private String pais;
    private String estado;
    private String cidade;

    public Destino() {
    }
    
    public Destino(int id, String nome, String destino, String pais, String estado, String cidade) {
        this.nome = nome;
        this.destino = destino;
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
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

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	 @Override
	    public String toString() {
	        return "Destino{" +
	                "id=" + id +
	                ", nome='" + nome + '\'' +
	                ", destino='" + destino + '\'' +
	                ", pais='" + pais + '\'' +
	                ", estado='" + estado + '\'' +
	                ", cidade='" + cidade + '\'' +
	                '}';
	    }
}
