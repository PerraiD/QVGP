package plugins;

import java.util.ArrayList;

public class Question {
	public String question;
	public ArrayList<String> reponses;
	
	public Question(String question, ArrayList<String> reponses) {
		super();
		this.question = question;
		this.reponses = reponses;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public ArrayList<String> getReponses() {
		return reponses;
	}

	public void setReponses(ArrayList<String> reponses) {
		this.reponses = reponses;
	}
	
	
	
}
