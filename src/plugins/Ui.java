package plugins;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import Core.*;

public class Ui {

	private Pq  prod_question; 
		
	public Ui() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, IOException{
	
		prod_question = (Pq) Loader.getInstance().loadObject(Loader.getInstance().getSpecificPlugin("producteurquestion").get(0));
		System.out.println(prod_question.toString());
	}
	
	
	public void  getPlugins(Object o){
		
		
	}
	
	
}
