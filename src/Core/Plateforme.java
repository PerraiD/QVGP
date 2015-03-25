package Core;

import java.util.ArrayList;

import java.util.LinkedList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Properties;
import java.io.File;
import config.MetaPlugin;


public class Plateforme{
	
			private LinkedList<Object> lPlugins; 
			private ArrayList<MetaPlugin> mPlugins; 
			private static volatile Plateforme instance = null;
			private URL[] plugUrl;
			private URLClassLoader urlC;
			
			
private Plateforme() throws MalformedURLException {
	
		super();
		this.lPlugins =new LinkedList<Object>(); 
		this.mPlugins = new ArrayList<MetaPlugin>();	
		this.plugUrl = new URL[]{new URL("file://"+System.getProperty("user.dir")+"/bin/")};
		this.urlC = new URLClassLoader(plugUrl);
}

public final static Plateforme getInstance() throws MalformedURLException{
	if(instance==null){
		instance = new Plateforme();
	}
		
	return instance;
	
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
		mp.loadDependencies(); // on charge la liste de dépendances.
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
						
		//charger la classe correspondante au type de pluggin
		// le type du plugins correspond a sa classe a charger.
		Class<?> cl = urlC.loadClass("plugins."+mplug.getProperty("pluginClass"));
	
		Object o = cl.newInstance();
		// ajout dans la liste des plugins charger de l'objet.
		lPlugins.add(o); // TODO: un controlleur de plugins.
		return o;
		
	}


/**
 * Méthode permettant de récupéré un plugin de dépendance pour la classe et en fonction de l'interface passée en paramètre.
 * @param Class<?>, targetClass
 * @param String, pluginInterface
 * @return Object , le plugin
 */

public Object loadPluginDependencyFrom(Class<?> targetClass, String pluginInterface) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
	 	
	Class<?> interfClass = Class.forName("Interfaces." + pluginInterface);
	
	Object plugToLoad=null;
	MetaPlugin tmpPlug = this.getPluginFromClassName(targetClass.getName());
	
	
	for(String dep : tmpPlug.getDependencies()){
		
		Class<?> pluginClass = urlC.loadClass("plugins."+dep);

		if(interfClass.isAssignableFrom(pluginClass)){
			
			plugToLoad = pluginClass.newInstance();  
	   }
		
	}
	
	return plugToLoad;
}

public Object loadPluginDependencyWithParamsFrom(Class<?> targetClass,String pluginInterface,Object[] values,Class<?> ... param) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
	
	
	Class<?> interfClass = Class.forName("Interfaces." + pluginInterface);
	
	Object plugToLoad=null;
	MetaPlugin tmpPlug = this.getPluginFromClassName(targetClass.getName());
	
	System.out.println(tmpPlug.getDependencies().get(0));
	
	for(String dep : tmpPlug.getDependencies()){
		
		Class<?> pluginClass = urlC.loadClass("plugins."+dep);

		if(interfClass.isAssignableFrom(pluginClass)){
			Constructor<?> pluginConstr = pluginClass.getConstructor(param);
			
			plugToLoad = pluginConstr.newInstance(values);  
	   }
		
	}
	
	return plugToLoad;
	

	
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
/**
 * Methode quiq permet de récupéré les métadonnées d'un plugin en fonction de son nom;
 * @param String, name
 * @return MetaPugin, la classe de métadonnées d'un plugin.
 */

public MetaPlugin getPluginFromName(String name){
	MetaPlugin mPlug= new MetaPlugin();
	
	for(MetaPlugin mp: this.mPlugins){
		
		if(mp.getName().equals(name)){
			mPlug = mp;
		}
		
	}
	
	return mPlug;
	
	
}

public MetaPlugin getPluginFromClassName(String className){
	
	MetaPlugin mPlug= new MetaPlugin();
	 
	// présence en préfix du package de la classe on récupère juste le nom de la classe
	if(className.contains(".")){
		//System.out.println(className);
		String[] tmpS = className.split("\\.");
		className= tmpS[1];
	}
	
	for(MetaPlugin mp: this.mPlugins){
		
		if(mp.getProperty("pluginClass").equals(className)){
			mPlug = mp;
		}
		
	}
	
	return mPlug;
	
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
