package br.com.projeto.implementacao;

import javax.swing.JOptionPane;

import br.com.projeto.excecao.Excecao;
import br.com.projeto.dao.CargoDAO;
import br.com.projeto.util.Magic;

public class TesteAtualizarCargo {
	public static void main(String[] args) {
		try {
			CargoDAO dao = new CargoDAO(); // QUando ele chama o construtor, a conex�o com o banco j� � criada pelas altera��es que fizemos
			
			String nome = Magic.s("Digite o cargo").toUpperCase();
			System.out.println(dao.modifySalary(nome) + " sal�rio(s) foi(am) modificado(s)");
			
			
			dao.fecharConexao(); //Sempre fechar a conex�o
		}catch(Exception e) {
			//e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
	}
}
