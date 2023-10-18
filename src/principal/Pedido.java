package principal;

public class Pedido {
    private int id;
    private String descricao;
    private double valor;

    public Pedido(String descricao, double valor) {
		super();
		this.descricao = descricao;
		this.valor = valor;
	}

	// Getters e Setters para os atributos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
