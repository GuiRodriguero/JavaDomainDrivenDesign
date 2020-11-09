package br.com.projeto.implementacao;

import javax.swing.JOptionPane;

import br.com.projeto.excecao.Excecao;
import br.com.projeto.beans.Produto;
import br.com.projeto.bo.ProdutoBO;
import br.com.projeto.util.Magic;

public class TesteProdutoBO {
	
	public static void main(String[] args) {
		
		String menu[] = {"Sair", "Cadastrar", "Consultar", "Excluir"};
		
		try {
			int escolha = JOptionPane.showOptionDialog(null, "Escolha uma das opções abaixo", "ProduosBO",
	                0, JOptionPane.QUESTION_MESSAGE, null, menu, menu[0]);
			
			if(escolha == 1) {
				System.out.println(ProdutoBO.novoProduto(new Produto(
						Magic.i("ID: "),
						Magic.f("Valor Compra: "),
						Magic.f("Valor Venda: "),
						Magic.i("Quantidade: "),
						Magic.s("Descrição: ")
						)));
			}else if(escolha == 2) {
				Produto resultado = ProdutoBO.pesquisarProduto(Magic.s("Descrição: "));
				System.out.println(resultado.getId());
				System.out.println(resultado.getValorCompra());
				System.out.println(resultado.getValorVenda());
				System.out.println(resultado.getQtde());
				System.out.println(resultado.getDescricao());
			}else if(escolha == 3) {
				System.out.println(ProdutoBO.apagarProduto(Magic.i("ID: ")));
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
	}

}
