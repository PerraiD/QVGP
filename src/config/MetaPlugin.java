package config;

import java.util.HashMap;

/*
 * classe d'information sur un plugins. 
 * 
 * 
 */


public class MetaPlugin {
	 	
		private  String type;
		private HashMap<String, String> params;
		
		public MetaPlugin(){
			this.type="";
			this.params= new HashMap<String,String>();
		}
		
		
		public MetaPlugin(String type,HashMap<String, String> params) {
			this.type= type;
			this.params = params;
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
