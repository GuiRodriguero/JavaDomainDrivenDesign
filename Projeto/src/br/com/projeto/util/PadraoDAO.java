package br.com.projeto.util;

import java.sql.SQLException;
import java.util.List;

public interface PadraoDAO<T> { //generics para receber qualquer objeto, podemos receber Cargo, Colaborador, etc e assim usar essa interface em todos os DAOs

	//todos os DAOs devem ter o fecharConexão
	void fecharConexao() throws SQLException;
	
	int add(T objeto) throws Exception;
	
	T mostraUm(int id) throws Exception;
	
	List<T> getAll() throws Exception;
}
