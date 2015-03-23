package Interfaces;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


import plugins.Theme;


public interface IProducteurDeQuestion {
	public ArrayList<IQuestion> listeDesQuestions = new ArrayList<IQuestion>();
	
	public ArrayList<IQuestion> recupererQuestions(String theme) throws FileNotFoundException;
	
	public List<String> getThemes();
}