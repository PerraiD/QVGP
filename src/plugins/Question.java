package plugins;

import java.util.List;

import Interfaces.IQuestion;

public class Question implements IQuestion{

	private String theme;
	private int numero;
	private String enonce;
	private List<String> reponses;
	
	public Question(String theme, int numero, String enonce, List<String> reponses) {
		super();
		this.theme = theme;
		this.numero = numero;
		this.enonce = enonce;
		this.reponses = reponses;
	}
	
	public String getTheme() {
		return theme;
	}
	
	public void setTheme(String theme) {
		this.theme = theme;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getEnonce() {
		return enonce;
	}
	
	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}
	
	public List<String> getReponses() {
		return reponses;
	}
	
	public void setReponses(List<String> reponses) {
		this.reponses = reponses;
	}

	@Override
	public String toString() {
		return "Question [theme=" + theme + ", numero=" + numero + ", enonce="
				+ enonce + ", reponses=" + reponses + "]";
	}


}