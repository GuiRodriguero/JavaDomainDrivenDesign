package br.com.projeto.bo;

import java.util.List;

import br.com.projeto.beans.Cargo;
import br.com.projeto.dao.CargoDAO;

public class CargoBO { // trabalha nos póssíveis erros
	
	public static List<Cargo> pesquisar() throws Exception{
		CargoDAO dao = new CargoDAO();
		List<Cargo> resposta = dao.getAll(); //não podemos usar o dao.getAll() no return pois a conexão deve ser fechada antes
		dao.fecharConexao();
		
		return resposta;
	}

	public static String apagarCargo(int id) throws Exception{
		if(id < 1) {
			return "ID inválido";
		}
		
		CargoDAO dao = new CargoDAO();

		dao.delete(id);
		dao.fecharConexao();
		
		return "Apagou";
	}
	
	public static Cargo pesquisarCargo(int id) throws Exception{
		if(id < 1) {
			//throw new RuntimeException("ID inválido");
			return new Cargo();
		}
		
		CargoDAO dao = new CargoDAO();
		Cargo resposta = dao.mostraUm(id);

		return resposta;
	}
	
	
	public static String novoCargo(Cargo cargo) throws Exception{
		//Regra de Negócio
			//id > 0
		if(cargo.getId() < 1) {
			return "ID inválido";
		}
		
		if(cargo.getNome() == null || cargo.getNome().length() < 4) {
			return "Nome inválido do Cargo";
		}
		
		if(cargo.getNivel() == null || cargo.getNivel().length() < 4) {
			return "Nome inválido do Nível";
		}
		
		if(cargo.getSalario() < 1000) {
			return "Salário inválido";
		}
		
		//RF //"Aquilo que faz com que o sistema quebre"
		
		if(cargo.getNome().length() > 60) {
			return "Nome do Cargo muito grande";
		}
		
		if(cargo.getNivel().length() > 20) {
			return "Nome do Nível muito grande";
		}
		
		//Padronização
		cargo.setNome(cargo.getNome().toUpperCase());
		cargo.setNivel(cargo.getNivel().toUpperCase());
		
		
		//é preferível deixar a conexão do BD no final
		CargoDAO dao = new CargoDAO();
		Cargo resposta = dao.mostraUm(cargo.getId());
		
		if (resposta.getId() != 0) { // se um cargo vier preenchido
			dao.fecharConexao();
			return "Este ID já existe";
		}
		
		dao.add(cargo);
		dao.fecharConexao();
		return "ok";
	}

}
