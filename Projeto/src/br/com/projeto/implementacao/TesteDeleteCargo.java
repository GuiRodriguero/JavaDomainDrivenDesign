package br.com.projeto.implementacao;


import javax.swing.JOptionPane;

import br.com.projeto.excecao.Excecao;
import br.com.projeto.dao.CargoDAO;
import br.com.projeto.util.Magic;

public class TesteDeleteCargo {
	public static void main(String[] args) {
		try {
			
			CargoDAO dao = new CargoDAO();

			
			int apaga = Magic.i(JOptionPane.showInputDialog("Digite o ID que deseja apagar: "));
			
			if(dao.delete(apaga) == 0) {
				System.out.println("Não Apagou");
			}else {
				System.out.println("Apagou");
			}
			dao.fecharConexao();
		}catch(Exception e){
			System.out.println(Excecao.tratarExcecao(e));
		}
	}


}
