package plugins;

import java.util.ArrayList;

public class Theme {
	
		private ArrayList<Question> qList;
		private String name;
	
		
		public Theme(ArrayList<Question> qList, String name) {
			
			this.qList = qList;
			this.name = name;
		}
		
		public void addQuestion(Question q){
			qList.add(q);
		}
		
		public void removeQuestion(Question q){
			qList.remove(q);
		}
		
		public ArrayList<Question> getqList() {
			return qList;
		}
		public void setqList(ArrayList<Question> qList) {
			this.qList = qList;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
}
