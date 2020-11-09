package br.com.projeto.implementacao;

import java.sql.Connection;

import br.com.projeto.excecao.Excecao;
import br.com.projeto.conexao.Conexao;

public class TesteConexao {

	public static void main(String[] args) {
		// Iremos testar a conex�o aqui para testar cada classe de cada vez ao inv�s de fazer tudo e caso d� erro n�o saber o que est� errado
		Connection c = null;
		
		try{
			c = new Conexao().conectar();
			System.out.println("Abriu Conex�o!");
		}catch(Exception e) {
			System.out.println(Excecao.tratarExcecao(e));
			e.printStackTrace(); // apenas deixara isso no per�odo de desnvolvimento
		}finally {
			try {
				c.close();
				System.out.println("Fechou Conex�o!");
			}catch(Exception e) {
				System.out.println(Excecao.tratarExcecao(e));
			}
		}
	}

}
