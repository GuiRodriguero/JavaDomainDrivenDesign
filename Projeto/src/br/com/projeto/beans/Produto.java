package br.com.projeto.beans;

public class Produto {

	private int id;
	private float valorCompra;
	private float valorVenda;
	private int qtde;
	private String descricao;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getValorCompra() {
		return valorCompra;
	}
	public void setValorCompra(float valorCompra) {
		this.valorCompra = valorCompra;
	}
	public float getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(float valorVenda) {
		this.valorVenda = valorVenda;
	}
	public int getQtde() {
		return qtde;
	}
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	public Produto(int id, float valorCompra, float valorVenda, int qtde, String descricao) {
		super();
		this.id = id;
		this.valorCompra = valorCompra;
		this.valorVenda = valorVenda;
		this.qtde = qtde;
		this.descricao = descricao;
	}
	
	
	public Produto() {
		super();

	}
	
	
}
