package br.com.projeto.beans;

public class Colaborador extends Pessoa{
	
	private String nome;
	private int id;
	private Cargo cargo;
	private String admissao;
	private String cpf;
	
	
	public void setAll(String fone, String email, String nome, int id, Cargo cargo, String admissao, String cpf) {
        super.setAll(fone, email);
        this.nome = nome;
        this.id = id;
        this.cargo = cargo;
        this.admissao = admissao;
        this.cpf = cpf;
    }
   
    public String getAll() {
        return super.getAll() + "\n" + nome + "\n" + cargo + "\n" + admissao + "\n" + cpf;
       
    }
    
	//GETTER E SETTER
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public String getAdmissao() {
		return admissao;
	}
	public void setAdmissao(String admissao) {
		this.admissao = admissao;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	//CONSTRUTORES
	
	public Colaborador() {
		super();
	}
	public Colaborador(String telefone, String email, String nome, int id, Cargo cargo, String admissao, String cpf) {
		super(telefone, email);
		this.nome = nome;
		this.id = id;
		this.cargo = cargo;
		this.admissao = admissao;
		this.cpf = cpf;
	}
}
