package entities;

public class Produto {
	private String nome;
	private Double preco;
	private Integer quantidade;
	
	public Produto(String nome, Double preco, Integer quantidade) {
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}
	
	public double total() {
		return preco * quantidade;
	}

}
