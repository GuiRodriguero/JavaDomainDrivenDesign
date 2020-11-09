package br.com.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.projeto.beans.Cargo;
import br.com.projeto.conexao.Conexao;

public class CargoDAOComentada {
	
	//para n�o ficar instanciando em todos os m�todos igual est� no ANTIGO abaixo
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public CargoDAOComentada() throws Exception{
		//vai fazer isso toda vez que instanciar essa classe, tendo em vista que 
		//toda vez que instanciamos ele iremos abrir a conex�o do bd
		
		//Se tivermos um comando SQL dentro de while por exemplo, ele nao vai ficar abrindo, executando e fechando conex�o
		//Com esse construtor ele vai abrir uma vez s�
		
		con =  Conexao.conectar();
	}
	
	public void fecharConexao() throws Exception{
		//Olhar ANTIGO2 para ver como era feito (c�digo menos limpo)
		con.close();
	}
	
	
	public int add(Cargo objeto) throws Exception{
		//recebendo a conex�o do Driver Manager
		// ANTIGO Connection con = Conexao.conectar(); // Como o m�todo � static, n�o precisamos instanciar
		con = Conexao.conectar();
		
		//recebe a estrutura da conex�o
		//ANTIGO PreparedStatement stmt = con.prepareStatement("INSERT INTO TB_CARGO (NR_ID, NM_CARGO, VL_SALARIO, NM_NIVEL) VALUES (?, ?, ?, ?)");
		stmt = con.prepareStatement("INSERT INTO TB_CARGO (NR_ID, NM_CARGO, VL_SALARIO, NM_NIVEL) VALUES (?, ?, ?, ?)");
		//Usamos o ? para previnir concatenar para previnir SQL Injection
		
		stmt.setInt(1, objeto.getId());
		stmt.setString(2, objeto.getNome());
		stmt.setDouble(3, objeto.getSalario());
		stmt.setString(4, objeto.getNivel());
		
		
		//ANTIGO2 int resposta = stmt.executeUpdate(); //executa e retorna a quantidade de linha, seu retorno � mais confiavel que o execute normal	 
		//ANTIGO2 con.close(); // se n�o fechar, cada vez que executa ele ir� abrir uma conex�o nova e n�o ir� fechar a anterior
		
		return stmt.executeUpdate();
		
		/*
		 * 3 tipos de execute
		 * execute -> Retorna boolean
		 * executeUpdate -> Retorna quantidade de linhas afetadas no banco de dados
		 * executeQuery -> Apenas usado com select, retorna um ResultSet
		 * 
		 * usos de: execute() ou executeUpdate() -> insert, delete ou update
		 */
	}
	
	
	public int delete(int id) throws Exception{
		Connection con = Conexao.conectar();
		
		PreparedStatement stmt = con.prepareStatement("DELETE FROM TB_CARGO WHERE NR_ID=?");
		stmt.setInt(1, id);
		
		return stmt.executeUpdate();
		
	}

}
