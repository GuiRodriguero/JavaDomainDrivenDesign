package br.com.projeto.implementacao;

import javax.swing.JOptionPane;

import br.com.projeto.excecao.Excecao;
import br.com.projeto.dao.CargoDAO;
import br.com.projeto.util.Magic;

public class TesteAtualizarCargo {
	public static void main(String[] args) {
		try {
			CargoDAO dao = new CargoDAO(); // QUando ele chama o construtor, a conexão com o banco já é criada pelas alterações que fizemos
			
			String nome = Magic.s("Digite o cargo").toUpperCase();
			System.out.println(dao.modifySalary(nome) + " salário(s) foi(am) modificado(s)");
			
			
			dao.fecharConexao(); //Sempre fechar a conexão
		}catch(Exception e) {
			//e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
	}
}
