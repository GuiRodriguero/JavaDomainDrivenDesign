package br.com.projeto.beans;

public class Pessoa { 
	//Dado numérico: Tudo aquilo que pode ser usado em uma expressão matemática
	//O dado numérico também possui muito mais performance pois existem apenas 13 dados numéricos (de 0 a 9 . , e -) e alfanumérico existem bem mais, o que dificulta a busca
	//Ex: O ID não é utilizado para fazer conta, porém é um dado sensível e importante para o relacionamento para as tabelas, além do seu desempenho ser essencial para o programa
	//Quando um dado, mesmo que não efetue conta, for de extrema importância, o int mostra-se eficaz
	
	private String telefone;
	private String email;
	
    public void setAll(String fone, String email) {
        this.telefone = fone;
        this.email = email;
    }
   
    public String getAll() {
        return telefone + "\n" + email;
    }
    
    
	//GETTER E SETTER
	
	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	
	//CONSTRUTORES

	public Pessoa(String telefone, String email) {
		super();
		this.telefone = telefone;
		this.email = email;
	}


	public Pessoa() {
		super();
	}
	
	
	
}
