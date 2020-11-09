package br.com.projeto.implementacao;

import java.util.List;

import br.com.projeto.beans.Cargo;
import br.com.projeto.bo.CargoBO;
import br.com.projeto.excecao.Excecao;

public class TesteExibirTodosCargos {
	public static void main(String[] args) {
		try {
			List<Cargo> dados = CargoBO.pesquisar();
			
			for(Cargo c : dados) {
				System.out.println("Nome: " + c.getNome());
				System.out.println("N�vel: " + c.getNivel());
				System.out.println("Sal�rio: " + c.getSalario());
				System.out.println("ID: " + c.getId());
				System.out.println("======================================");
			}
		}catch(Exception e) {
			System.out.println(Excecao.tratarExcecao(e));
		}
	}

}
