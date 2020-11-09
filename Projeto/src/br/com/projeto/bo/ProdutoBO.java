package br.com.projeto.bo;

import br.com.projeto.beans.Cargo;
import br.com.projeto.beans.Produto;
import br.com.projeto.dao.ProdutoDAO;

public class ProdutoBO {

	public static String novoProduto(Produto produto) throws Exception{
		
		if(produto.getId() < 1) {
			return "ID inv�lido";
		}
		if(produto.getDescricao() == null || produto.getDescricao().length() < 4) {
			return "Descri��o inv�lida";
		}
		if(produto.getValorCompra() < 0) {
			return "Valor de Compra inv�lido";
		}
		if(produto.getValorVenda() < 0) {
			return "Valor de Venda inv�lido";
		}
		if(produto.getDescricao().length() > 60) {
			return "Descri��o muito grande!";
		}
		
		produto.setDescricao(produto.getDescricao().toUpperCase());
		
		ProdutoDAO dao = new ProdutoDAO();
		Produto resposta = dao.getProduto(produto.getDescricao());
		
		if (resposta.getId() != 0) {
			dao.fecharConexao();
			return "Este ID j� existe";
		}
		
		dao.add(produto);
		dao.fecharConexao();
		
		return "cadastrado";
	}
	
	public static String apagarProduto(int id) throws Exception{
		if(id < 1) {
			return "ID inv�lido";
		}
		
		ProdutoDAO dao = new ProdutoDAO();

		dao.delete(id);
		dao.fecharConexao();
		return "Apagou";
	}
	
	public static Produto pesquisarProduto(String descricao) throws Exception{
		
		if(descricao == null || descricao.length() < 4) {
			return new Produto();
		}
		
		ProdutoDAO dao = new ProdutoDAO();
		Produto resposta = dao.getProduto(descricao);
		
		
		return new Produto();
	}
}
