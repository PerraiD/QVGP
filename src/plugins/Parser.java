package plugins;
import java.io.*;

import org.jdom2.*;
import org.jdom2.input.*;

import java.io.FileNotFoundException;

public class Parser {
	
	static org.jdom2.Document document;
	static Element racine;

	public Element lecture(String fichier)throws FileNotFoundException{
	      SAXBuilder sxb = new SAXBuilder();
	      try
	      {
	         //On crée un nouveau document JDOM avec en argument le fichier XML
	         //Le parsing est terminé ;)
	         document = sxb.build(new File(fichier));
	      }
	      catch(Exception e){}

	      //On initialise un nouvel élément racine avec l'élément racine du document.
	      racine = document.getRootElement();
	      return racine;
	}
}