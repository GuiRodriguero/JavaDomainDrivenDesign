package br.com.projeto.bo;

import br.com.projeto.beans.Cargo;
import br.com.projeto.beans.Colaborador;
import br.com.projeto.dao.ColaboradorDAO;

public class ColaboradorBO {
	
	public static int novo(Colaborador objeto) throws Exception{
		if(objeto.getCpf().length() != 14) {
			return 0;
		}
		
		if(objeto.getId() < 1) {
			return 0;
		}
		
		if(objeto.getCargo() == null) {
			return 0;
		}
		
		if(objeto.getCargo().getId() < 1) {
			return 0;
		}
		
		Cargo resposta = CargoBO.pesquisarCargo(objeto.getCargo().getId()); // usando o outro BO para ver se o cargo informado existe (ELE DEVE EXISTIR)
		if(resposta.getId() == 0) {
			return 0;
		}
		
		//verificar se o colaborador já existe (ELE NÃO PODE SER REPETIDO)
		ColaboradorDAO dao = new ColaboradorDAO();
		dao.abrirConexao();
//		Colaborador resposta2 = dao.mostraUm(objeto.getId());
//		if(resposta2.getId() != 0) {
//			dao.fecharConexao();
//			return 0;
//		}
		
		//RN
		objeto.setNome(objeto.getNome().toUpperCase());
		
		//Cadastrando
		dao.add(objeto);
		dao.fecharConexao();
		return 1;
	}

}
