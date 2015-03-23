package config;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * classe d'information sur un plugins. 
 * 
 * 
 */
public class MetaPlugin {
	 	
		private  String type;
		private HashMap<String, String> params;
		private ArrayList<String> dependencies; 
		
		public MetaPlugin(){
			this.type="";
			this.params= new HashMap<String,String>();
			this.dependencies = new ArrayList<String>();
			
		}
			
		
		public MetaPlugin(String type,HashMap<String, String> params) {
			this.type= type;
			this.params = params;
		}

		public void loadDependencies(){
			String depend = this.getProperty("dependencies"); 
			if(depend != null){
			  if(depend.contains(",")){
				  String[] tmpDep= depend.split(",");  
				  for(String dep:tmpDep){
						dependencies.add(dep);
				  }
			  }else{
				  dependencies.add(depend);
				  
			  }
			}else{
				dependencies.add(""); // on ajoute une entrée null pour indiquée qu'il y na pas de dépendances.
			}
				
		}
		
		
		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public HashMap<String, String> getParams() {
			return params;
		}

		public void setParams(HashMap<String, String> params) {
			this.params = params;
		}
		
		
		public void addParams(String key, String value){
			
			this.params.put(key, value);
		}
		
		
		public ArrayList<String> getDependencies() {
			return dependencies;
		}

		public void setDependencies(ArrayList<String> dependencies) {
			this.dependencies = dependencies;
		}

		public boolean isFirstLoad(){
			
			return params.get("firstLoad").equals("yes");
					
		}
		
		//ajout de filtre sur les propriétés.
		
		public String getProperty(String prop){
			return this.getParams().get(prop);
		}
		
		
		public String getName(){
			return params.get("pluginName");
		}
		 
		public String toString(){
			
			return  this.type + params.toString();			
			
		}
		
		
}
