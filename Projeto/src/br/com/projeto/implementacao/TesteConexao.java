package br.com.projeto.implementacao;

import java.sql.Connection;

import br.com.projeto.excecao.Excecao;
import br.com.projeto.conexao.Conexao;

public class TesteConexao {

	public static void main(String[] args) {
		// Iremos testar a conexão aqui para testar cada classe de cada vez ao invés de fazer tudo e caso dê erro não saber o que está errado
		Connection c = null;
		
		try{
			c = new Conexao().conectar();
			System.out.println("Abriu Conexão!");
		}catch(Exception e) {
			System.out.println(Excecao.tratarExcecao(e));
			e.printStackTrace(); // apenas deixara isso no período de desnvolvimento
		}finally {
			try {
				c.close();
				System.out.println("Fechou Conexão!");
			}catch(Exception e) {
				System.out.println(Excecao.tratarExcecao(e));
			}
		}
	}

}
