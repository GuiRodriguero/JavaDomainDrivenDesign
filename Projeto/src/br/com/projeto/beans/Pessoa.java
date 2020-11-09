package br.com.projeto.beans;

public class Pessoa { 
	//Dado num�rico: Tudo aquilo que pode ser usado em uma express�o matem�tica
	//O dado num�rico tamb�m possui muito mais performance pois existem apenas 13 dados num�ricos (de 0 a 9 . , e -) e alfanum�rico existem bem mais, o que dificulta a busca
	//Ex: O ID n�o � utilizado para fazer conta, por�m � um dado sens�vel e importante para o relacionamento para as tabelas, al�m do seu desempenho ser essencial para o programa
	//Quando um dado, mesmo que n�o efetue conta, for de extrema import�ncia, o int mostra-se eficaz
	
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
