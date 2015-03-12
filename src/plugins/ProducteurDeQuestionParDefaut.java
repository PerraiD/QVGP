package plugins;

import java.util.ArrayList;
import java.util.List;


import Core.IProducteurDeQuestion;
import Core.IQuestion;

public class ProducteurDeQuestionParDefaut implements IProducteurDeQuestion {
	private List<String> themes;
	
	public ProducteurDeQuestionParDefaut(){
		ArrayList<String> repQ1=new ArrayList<String>();
		repQ1.add("");
		repQ1.add("540m");
		repQ1.add("54km");
		repQ1.add("3m");
		Question q1=new Question("Geographie",1,"Quelle est la longueur du nil?",repQ1);
		q1.toString();
		listeDesQuestions.add(q1);
	}
	
	public ArrayList<IQuestion> recupererQuestions(){
		return listeDesQuestions;
	}

	@Override
	public List<String> getThemes() {
		 this.themes = new ArrayList<String>();
		themes.add("Geographie");
		return themes;
	}
}