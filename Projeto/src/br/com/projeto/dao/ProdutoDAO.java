package br.com.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.projeto.beans.Cargo;
import br.com.projeto.beans.Produto;
import br.com.projeto.conexao.Conexao;

public class ProdutoDAO {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public ProdutoDAO() throws Exception{
		con =  Conexao.conectar();
	}
	
	public void fecharConexao() throws Exception{

		con.close();
	}
	
	public int add(Produto objeto) throws Exception{

		con = Conexao.conectar();

		stmt = con.prepareStatement("INSERT INTO TB_PRODUTO (NR_ID, VL_COMPRA, VL_VENDA, NR_QUANTIDADE, DS_QUANTIDADE) VALUES (?, ?, ?, ?, ?)");

		stmt.setInt(1, objeto.getId());
		stmt.setFloat(2, objeto.getValorCompra());
		stmt.setFloat(3, objeto.getValorVenda());
		stmt.setInt(4, objeto.getQtde());
		stmt.setString(5, objeto.getDescricao());

		return stmt.executeUpdate();
	}
	
	public int delete(int id) throws Exception{
		Connection con = Conexao.conectar();
		
		PreparedStatement stmt = con.prepareStatement("DELETE FROM TB_PRODUTO WHERE NR_ID=?");
		stmt.setInt(1, id);
		
		return stmt.executeUpdate();
		
	}
	
	public int modifyValorCompraVenda(Float valorCompra, Float valorVenda, int id) throws Exception {
		stmt = con.prepareStatement("UPDATE TB_PRODUTO SET VL_COMPRA=?, VL_VENDA=? WHERE NR_ID=?");
		stmt.setFloat(1, valorCompra);
		stmt.setFloat(2, valorVenda);
		stmt.setInt(3, id);
		
		return stmt.executeUpdate();
	}

	
	public Produto getProduto(String descricao) throws Exception{
		stmt = con.prepareStatement("SELECT * FROM TB_CARGO WHERE DS_PRODUTO=?");
		stmt.setString(1, descricao);
		
		rs = stmt.executeQuery(); //retorna um ResultSet
		
		if(rs.next()) { // next por conta do ponteiro que começa na linha do nome das colunas e precisamos descê-lo
			
			return new Produto(
					rs.getInt("NR_ID"),
					rs.getFloat("VL_COMRPA"),
					rs.getFloat("VL_VENDA"),
					rs.getInt("NR_QUANTIDADE"),
					rs.getString("DS_PRODUTO")
					
					); // retornar um cargo preenchido
		}
		
		return new Produto(); //retorna um cargo vazio
	}
}
