package br.com.projeto.bo;

import java.util.List;

import br.com.projeto.beans.Cargo;
import br.com.projeto.dao.CargoDAO;

public class CargoBO { // trabalha nos p�ss�veis erros
	
	public static List<Cargo> pesquisar() throws Exception{
		CargoDAO dao = new CargoDAO();
		List<Cargo> resposta = dao.getAll(); //n�o podemos usar o dao.getAll() no return pois a conex�o deve ser fechada antes
		dao.fecharConexao();
		
		return resposta;
	}

	public static String apagarCargo(int id) throws Exception{
		if(id < 1) {
			return "ID inv�lido";
		}
		
		CargoDAO dao = new CargoDAO();

		dao.delete(id);
		dao.fecharConexao();
		
		return "Apagou";
	}
	
	public static Cargo pesquisarCargo(int id) throws Exception{
		if(id < 1) {
			//throw new RuntimeException("ID inv�lido");
			return new Cargo();
		}
		
		CargoDAO dao = new CargoDAO();
		Cargo resposta = dao.mostraUm(id);

		return resposta;
	}
	
	
	public static String novoCargo(Cargo cargo) throws Exception{
		//Regra de Neg�cio
			//id > 0
		if(cargo.getId() < 1) {
			return "ID inv�lido";
		}
		
		if(cargo.getNome() == null || cargo.getNome().length() < 4) {
			return "Nome inv�lido do Cargo";
		}
		
		if(cargo.getNivel() == null || cargo.getNivel().length() < 4) {
			return "Nome inv�lido do N�vel";
		}
		
		if(cargo.getSalario() < 1000) {
			return "Sal�rio inv�lido";
		}
		
		//RF //"Aquilo que faz com que o sistema quebre"
		
		if(cargo.getNome().length() > 60) {
			return "Nome do Cargo muito grande";
		}
		
		if(cargo.getNivel().length() > 20) {
			return "Nome do N�vel muito grande";
		}
		
		//Padroniza��o
		cargo.setNome(cargo.getNome().toUpperCase());
		cargo.setNivel(cargo.getNivel().toUpperCase());
		
		
		//� prefer�vel deixar a conex�o do BD no final
		CargoDAO dao = new CargoDAO();
		Cargo resposta = dao.mostraUm(cargo.getId());
		
		if (resposta.getId() != 0) { // se um cargo vier preenchido
			dao.fecharConexao();
			return "Este ID j� existe";
		}
		
		dao.add(cargo);
		dao.fecharConexao();
		return "ok";
	}

}
