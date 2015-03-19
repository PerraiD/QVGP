package plugins;

import plugins.DirectoryReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Core.QuestionParser;
import Interfaces.IProducteurDeQuestion;
import Interfaces.IQuestion;

public class ProducteurDeQuestion implements IProducteurDeQuestion {
	private List<String> themes;
	
	public ProducteurDeQuestion() throws FileNotFoundException{
		themes= new ArrayList<String>();
		DirectoryReader dr=new DirectoryReader();
		File[] listeThemes = dr.listFiles(System.getProperty("user.dir")+"/themes/");
		for(int i=0;i<listeThemes.length;++i){
			QuestionParser qp=new QuestionParser(listeThemes[i].toString());
			themes.add(qp.getTheme());
		}	
	}

	public List<String> getThemes() {
		return themes;
	}

	public void setThemes(List<String> themes) {
		this.themes = themes;
	}
	
	public ArrayList<IQuestion> recupererQuestions(){
		return listeDesQuestions;
	}
}