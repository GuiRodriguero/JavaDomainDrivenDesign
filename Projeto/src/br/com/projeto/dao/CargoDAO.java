package br.com.projeto.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.projeto.beans.Cargo;
import br.com.projeto.conexao.Conexao;

/**
 * Nessa classe manipularemos a tabela TB_CARGO, onde encontramos como chave primária a coluna NR_ID, todas as outras colunas
 * não são obrigatórias
 * Criamos três atributos para armazenar os componentes do JDBC
 * Na versão 2.0 foi incluído o método xpto() para atender tal demanda...
 * @author Guilherme Rodriguero
 * @author Nome do Cara
 * @version 2.0
 * @since 1.0
 * @see br.com.beas.projeto.Cargo
 * @see br.com.projeto.CargoBO
 *
 */

//JAVADOC da classe -> Descrever PK, FK, métodos, etc
//Annotations -> Comandos via JAVADOC
public class CargoDAO {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	/**
	 * Construtor está servindo para estabelecer a conexão com o BD.
	 * @author Guilherme Rodriguero
	 * @version 1.0
	 * @since 1.0
	 * @throws Exception
	 */
	public CargoDAO() throws Exception{

		con =  Conexao.conectar();
	}
	
	/**
	 * Este método encerra a conexão com o Banco de Dados
	 * @author Guiherme Rodriguero
	 * @throws Exception
	 * @version 1.0
	 * @since 1.0
	 */
	public void fecharConexao() throws Exception{

		con.close();
	}
	
	/**
	 * Método para adicionar uma linha na tabela TB_CARGO
	 * A chave primária não é auto incremento nem sequence
	 * A quantidade máxima de caracteres das colunas varchar são:
	 * NM_CARGO = 30 carcteres
	 * NM_NIVEL = 20 caracteres
	 * @param Um objeto do tipo cargo que irá trazer todas as informações a serem inseridas no Banco de Dados
	 * @author Guiherme Rodriguero
	 * @throws Exception
	 * @version 1.0
	 * @since 1.0
	 * @return Quantidade de linhas que foram adicionadas no Banco de Dados.
	 */
	public int add(Cargo objeto) throws Exception{

		con = Conexao.conectar();

		stmt = con.prepareStatement("INSERT INTO TB_CARGO (NR_ID, NM_CARGO, VL_SALARIO, NM_NIVEL) VALUES (?, ?, ?, ?)");

		stmt.setInt(1, objeto.getId());
		stmt.setString(2, objeto.getNome());
		stmt.setDouble(3, objeto.getSalario());
		stmt.setString(4, objeto.getNivel());


		return stmt.executeUpdate();
	}
	
	
	public int delete(int id) throws Exception{
		Connection con = Conexao.conectar();
		
		stmt = con.prepareStatement("DELETE FROM TB_CARGO WHERE NR_ID=?");
		stmt.setInt(1, id);
		
		return stmt.executeUpdate();
		
	}
	
	public int modifySalary(String nome) throws Exception {
		stmt = con.prepareStatement("UPDATE TB_CARGO SET VL_SALARIO=VL_SALARIO*1.1 WHERE NM_CARGO=?");
		stmt.setString(1, nome);
		
		return stmt.executeUpdate();
	}
	
	//O diferencial do sistema sempre está no output
	
	public Cargo mostraUm(int id) throws Exception{ // vai retornar um cargo com base no id
		stmt = con.prepareStatement("SELECT * FROM TB_CARGO WHERE NR_ID=?");
		stmt.setInt(1, id);
		
		rs = stmt.executeQuery(); //retorna um ResultSet
		
		if(rs.next()) { // next por conta do ponteiro que começa na linha do nome das colunas e precisamos descê-lo
			
			return new Cargo(
					
					rs.getString("NM_CARGO"),
					rs.getString("NM_NIVEL"),
					rs.getDouble("VL_SALARIO"),
					rs.getInt("NR_ID")
					
					); // retornar um cargo preenchido
		}
		
		return new Cargo(); //retorna um cargo vazio
	}
	
	public List<Cargo> getAll() throws Exception{
		List<Cargo> lista = new ArrayList<Cargo>();
		stmt = con.prepareStatement("SELECT * FROM TB_CARGO");
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			lista.add(new Cargo(
					rs.getString("NM_CARGO"),
					rs.getString("NM_NIVEL"),
					rs.getDouble("VL_SALARIO"),
					rs.getInt("NR_ID"))
					);
		}
		
		return lista;
	}

}
