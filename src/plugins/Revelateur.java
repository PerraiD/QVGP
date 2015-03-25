package plugins;

import Interfaces.IQuestion;
import Interfaces.IRevelateur;

public class Revelateur implements IRevelateur{

	private IQuestion question;
	private String bonneReponse="";
	
	public Revelateur(IQuestion q){
		question=q;
		bonneReponse=question.getReponses().get(0);
	}
	
	public String getBonneReponse() {
		return bonneReponse;
	}

	public void setBonneReponse(String bonneReponse) {
		this.bonneReponse = bonneReponse;
	}

	public boolean estReponseCorrecte(String r){
		boolean ret=false;
		if(r.equals(bonneReponse)){
			ret=true;
		}
		return ret;
	}
}
