package br.com.projeto.implementacao;

import br.com.projeto.beans.Cargo;
import br.com.projeto.beans.Colaborador;
import br.com.projeto.bo.ColaboradorBO;
import br.com.projeto.excecao.Excecao;

public class TesteColaboradorBO {
	
	public static void main(String[] args) {
		try {
			
			Colaborador objeto = new Colaborador();
			objeto.setAdmissao("18/10/2020");
			objeto.setCpf("555.036.098-00");
			objeto.setNome("Teste");
			objeto.setId(12);
			objeto.setCargo(new Cargo(null, null, 0, 554));
			
			System.out.println(ColaboradorBO.novo(objeto));
		
		}catch(Exception e) {
			e.printStackTrace();
			Excecao.tratarExcecao(e);
		}
	}

}
