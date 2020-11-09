package br.com.projeto.beans;

public class Cargo {
	
	private String nome;
	private String nivel;
	private double salario;
	private int id;
	private byte teste;
	
	//GETTER E SETTER
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	//CONSTRUTORES
	
	public Cargo(String nome, String nivel, double salario, int id) {
		super();
		this.nome = nome;
		this.nivel = nivel;
		this.salario = salario;
		this.id = id;
	}
	public Cargo() {
		super();
	}
	
	
	

}
