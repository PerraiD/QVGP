package Core;

import java.util.ArrayList;


import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Properties;
import java.io.File;
import config.MetaPlugin;
import plugins.*;

public class Loader{
	
			private LinkedList<Object> lPlugins; 
			private ArrayList<MetaPlugin> mPlugins; 
			private static volatile Loader instance = null;
			// TODO : utilisation avec un filtre directement. 
			// private HashMap<String, ArrayList<MetaPlugin>> configMap ;
			
			
private Loader() {
	
		super();
		this.lPlugins =new LinkedList<Object>(); 
		this.mPlugins = new ArrayList<MetaPlugin>();				
}

/**
 * Methode de chargeur de configuration initiale.
 * @param String, configFile le nom du fichier de configuration
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ClassNotFoundException
 * @throws InstantiationException
 * @throws IllegalAccessException
 * @throws NoSuchMethodException
 * @throws SecurityException
 * @throws IllegalArgumentException
 * @throws InvocationTargetException
 */

		
public void loadConfig() throws FileNotFoundException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
	
	//TODO voir une meileur structure pour le fichire de configuration, XML?
	
    
	Properties p = new Properties();
	
	
	for(File f: getMetaPluginsFiles()){
		
		
		p.load(new FileReader(f));
		MetaPlugin mp= new MetaPlugin();
		
		p.toString();	
		for(String k: p.stringPropertyNames()){
			
			if(k.equals("type")){
				//System.out.println(p.getProperty(k));
				mp.setType(p.getProperty(k));
			}else{
				mp.addParams(k, p.getProperty(k));
			}
			
		}
		mPlugins.add(mp);
	}
	
	
	
	 for (int i = 0; i < mPlugins.size(); i++) {
		if(mPlugins.get(i).isFirstLoad()){
			loadObject(mPlugins.get(i));
		}
	 }				
	
 }



public File[] getMetaPluginsFiles(){
	
		String metaFiles = System.getProperty("user.dir")+"/meta/";
		
		File[] subfiles = new File[1000];
		
		File directory = new File(metaFiles);
		if(!directory.exists()){
			System.out.println("Le fichier/répertoire '"+metaFiles+"' n'existe pas");
		}else if(!directory.isDirectory()){
			System.out.println("Le chemin '"+metaFiles+"' correspond à un fichier et non à un répertoire");
		}else{
			subfiles = directory.listFiles();
//			String message = "Le répertoire '"+metaFiles+"' contient "+ subfiles.length+" fichier"+(subfiles.length>1?"s":"");
//			System.out.println(message);
	
		}

	return subfiles;	
}

/**
 *  Methode qui charge dynamiquement les classes/plugins demandées.
 * @param MetaPlugin, mplug le metaplugins à charger.
 * @return Object, l'objet charger.
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ClassNotFoundException
 * @throws InstantiationException
 * @throws IllegalAccessException
 * @throws NoSuchMethodException
 * @throws SecurityException
 * @throws IllegalArgumentException
 * @throws InvocationTargetException
 */
			
public Object loadObject(MetaPlugin mplug) throws FileNotFoundException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		
		//System.out.println("file://"+System.getProperty("user.dir")+"/bin/plugins/");
		
		URL[] plugUrl = new URL[]{new URL("file://"+System.getProperty("user.dir")+"/bin/")};
		URLClassLoader urlC = new URLClassLoader(plugUrl);
		
		
		//charger la classe correspondante au type de pluggin
		// le type du plugins correspond a sa classe a charger.
		Class<?> cl = urlC.loadClass("plugins."+mplug.getProperty("pluginClass"));
	
		Object o = cl.newInstance();
		
		
		return o;
		
	}

/**
 * Methode de filtrage pour obtenir une liste de plugins disponible en fonction d'un type 
 * @param String, type
 * @return {@link ArrayList}
 */


public ArrayList<MetaPlugin> getSpecificPlugin(String type){
	ArrayList<MetaPlugin> lplug= new ArrayList<MetaPlugin>();
	
	for(MetaPlugin mp: this.mPlugins){
		
		if(mp.getType().equals(type)){
			lplug.add(mp);
		}
		
	}
	
	return lplug;
	
}


public ArrayList<MetaPlugin> getPluginFromName(String name){
	ArrayList<MetaPlugin> lplug= new ArrayList<MetaPlugin>();
	
	for(MetaPlugin mp: this.mPlugins){
		
		if(mp.getName().equals(name)){
			lplug.add(mp);
		}
		
	}
	
	return lplug;
	
	
}

public final static Loader getInstance(){
	if(instance==null){
		instance = new Loader();
	}
	
	return instance;
	
}

public LinkedList<Object> getLPlugins() {
	return lPlugins;
}


public void setLplug(LinkedList<Object> lplug) {
	this.lPlugins = lplug;
}


public ArrayList<MetaPlugin> getMPlugins() {
	return mPlugins;
}


public void setMPlugins(ArrayList<MetaPlugin> mPlugins) {
	this.mPlugins= mPlugins;
}




}
