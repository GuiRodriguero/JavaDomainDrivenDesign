package br.com.projeto.util; //pacote com metodos static para facilitar a vida

import javax.swing.JOptionPane;

public class Magic {

	//muito usado em classes sem atributos
	
	//Se a classe tiver atributos e o método não tiver relação com os atributos da classe, ele pode ser estático
	
	//métodos static -> Não precisam ser instanciados para serem chamados
	
	public static String s(String msg) {//facilitar o JOptionPane
		return JOptionPane.showInputDialog(msg).toUpperCase();
	}
	
	public static int i(String msg){//quando for int
		return Integer.parseInt(s(msg));
	}
	
	public static double d(String msg) {
		return Double.parseDouble(s(msg));
	}
	
	public static float f(String msg) {
		return Float.parseFloat(s(msg));
	}
}
