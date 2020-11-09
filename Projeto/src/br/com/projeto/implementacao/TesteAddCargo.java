package br.com.projeto.implementacao;

import javax.swing.JOptionPane;

import br.com.projeto.excecao.Excecao;
import br.com.projeto.beans.Cargo;
import br.com.projeto.dao.CargoDAO;
import br.com.projeto.util.Magic;

public class TesteAddCargo {
	public static void main(String[] args){
		
		try {
			CargoDAO dao = new CargoDAO();
			Cargo cargo = new Cargo();
			
			cargo.setId(Magic.i("ID"));
			cargo.setNivel(Magic.s("Nível").toUpperCase());
			cargo.setNome(Magic.s("Nome").toUpperCase());
			cargo.setSalario(Magic.d("Salario"));
			
			if(dao.add(cargo) == 0) {
				System.out.println("Não Gravou");
			}else {
				System.out.println("Gravado");
			}
			
			dao.fecharConexao();
		}catch(Exception e) {
			System.out.println(Excecao.tratarExcecao(e));
		}

	}
}
