package br.com.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.projeto.beans.Cargo;
import br.com.projeto.beans.Colaborador;
import br.com.projeto.conexao.Conexao;
import br.com.projeto.util.PadraoDAO;

public class ColaboradorDAO implements PadraoDAO<Colaborador>{

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public void abrirConexao() throws Exception{

		con =  Conexao.conectar();
	}

	@Override
	public void fecharConexao() throws SQLException{
		con.close();
	}

	@Override
	public int add(Colaborador objeto) throws Exception {
		stmt = con.prepareStatement("INSERT INTO TB_COLABORADOR (NR_ID, NM_COLABORADOR, DT_ADMISSAO, NR_CPF, FK_CARGO) VALUES(?, ?, ?, ?, ?)");
		stmt.setInt(1, objeto.getId());
		stmt.setString(2, objeto.getNome());
		stmt.setString(3, objeto.getAdmissao());
		stmt.setString(4, objeto.getCpf());
		stmt.setInt(5, objeto.getCargo().getId());
		
		return stmt.executeUpdate();
	}

	@Override
	public Colaborador mostraUm(int id) throws Exception {//selecionando tudo da tb_colaborador, que está ligada à tb_cargo
		stmt = con.prepareStatement("SELECT * FROM TB_COLABORADOR INNER JOIN TB_CARGO ON TB_COLABORADOR.FK_CARGO=TB_CARGO.NR_ID WHERE NR_ID = ?");
		
		stmt.setInt(1, id);
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			return new Colaborador(
					null,
					null,
					rs.getString("NM_COLABORADOR"),
					rs.getInt("TB_COLABORADOR.NR_ID"),
					
					new Cargo(
							rs.getString("NM_CARGO"),
							rs.getString("NM_NIVEL"),
							rs.getDouble("VL_SALARIO"),
							rs.getInt("TB_CARGO.NR_ID")
							),
					
					rs.getString("DT_ADMISSAO"),
					rs.getString("NR_CPF")
					);
		}
		return new Colaborador();
	}

	@Override
	public List<Colaborador> getAll() throws Exception {

		return null;
	}
	
}
