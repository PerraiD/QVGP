package Core;

import java.util.ArrayList;
import java.util.List;

import plugins.Theme;


public interface IProducteurDeQuestion {
	public ArrayList<IQuestion> listeDesQuestions = new ArrayList<IQuestion>();
	
	public ArrayList<IQuestion> recupererQuestions();
	
	public List<String> getThemes();
}