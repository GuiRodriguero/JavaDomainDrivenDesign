package br.com.projeto.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	public static Connection conectar() throws Exception{ //Vai lançar a exceção pra quem chamou ele. Quem chama geralmente é o main, e no main sempre temos try catch
		return DriverManager.getConnection("jdbc:oracle:thin:@xxx", "xxx", "xxx");
	}
	
	//com o static não iremos precisar instanciar ele na memória
}
