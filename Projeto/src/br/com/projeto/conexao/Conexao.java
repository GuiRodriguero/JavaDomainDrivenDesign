package br.com.projeto.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	public static Connection conectar() throws Exception{ //Vai lan�ar a exce��o pra quem chamou ele. Quem chama geralmente � o main, e no main sempre temos try catch
		return DriverManager.getConnection("jdbc:oracle:thin:@xxx", "xxx", "xxx");
	}
	
	//com o static n�o iremos precisar instanciar ele na mem�ria
}
