package br.com.projeto.implementacao;

import javax.swing.JOptionPane;

import br.com.projeto.excecao.Excecao;
import br.com.projeto.beans.Cargo;
import br.com.projeto.bo.CargoBO;
import br.com.projeto.util.Magic;

public class TesteCargoBO {
	public static void main(String[] args) {
		
		try {
			char resp = Magic.s("Digite:\n<1> Cadastrar\n<2> Consultar\n<3> Excluir").charAt(0);
			
			if(resp == '1') {
				
				System.out.println(CargoBO.novoCargo(new Cargo(
						Magic.s("Nome: "),
						Magic.s("Nível: "),
						Magic.d("Salário: "),
						Magic.i("ID: ")
						)));
				
			}else if(resp == '2') {
				Cargo resultado = CargoBO.pesquisarCargo(Magic.i("ID: "));
				System.out.println(resultado.getNome());
				System.out.println(resultado.getNivel());
				System.out.println(resultado.getSalario());
			}else if(resp == '3') {
				System.out.println(CargoBO.apagarCargo(Magic.i("ID: ")));
			}else {
				JOptionPane.showMessageDialog(null, "Opção inválida");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}

	}
}
