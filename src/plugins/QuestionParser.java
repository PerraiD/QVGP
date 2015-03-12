package plugins;

import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.jdom2.*;


public class QuestionParser {
	
	private int nbquestion=0;
	private Element racine;
	private List<Element> listQuestion;
	private String theme="";
	
	public QuestionParser(String file) throws FileNotFoundException{
		Parser p=new Parser();
		racine = p.lecture(file);
		listQuestion = racine.getChildren("question");
	    nbquestion = listQuestion.size();
		theme = racine.getAttributeValue("nom");
	}
	
	public Question chercheQuestion()
	{
	   String enonce="";
	   List<String> listReponse = new ArrayList<String>(); 
	   //On crée un Iterator sur notre liste
	   Iterator<Element> i = listQuestion.iterator();
	   Random rand = new Random();
	   int n = rand.nextInt(nbquestion) + 1;
	   int compteur=1;
	   do
	   {
	      //On recrée l'Element courant à chaque tour de boucle afin de
		  //pouvoir utiliser les méthodes propres aux Element comme :
		  //sélectionner un nœud fils, modifier du texte, etc...
		  Element courant = (Element)i.next();
		  if(n==compteur){
			  enonce = courant.getChild("enonce").getChild("nom").getText();
			  List<Element> listRep = courant.getChildren("reponse");
			  Iterator<Element> rep= listRep.iterator();
			  while(rep.hasNext()){
				  Element r=(Element)rep.next();
				  listReponse.add(r.getChild("nom").getText());
			  }
			  compteur = -1;
		  }
		  compteur++;
	   }while(i.hasNext() && (compteur != 0));
	   
	   Question q= new Question(theme, n, enonce, listReponse);
	   return q;
	   
	}

	public int getNbquestion() {
		return nbquestion;
	}

	public void setNbquestion(int nbquestion) {
		this.nbquestion = nbquestion;
	}

	public Element getRacine() {
		return racine;
	}

	public void setRacine(Element racine) {
		this.racine = racine;
	}

	public List<Element> getListQuestion() {
		return listQuestion;
	}

	public void setListQuestion(List<Element> listQuestion) {
		this.listQuestion = listQuestion;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
	
	
}