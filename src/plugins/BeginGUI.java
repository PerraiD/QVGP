package plugins;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Core.Plateforme;
import Interfaces.IGui;

public class BeginGUI extends JFrame implements IGui,ActionListener{
	
	protected JButton bouton;
	protected JButton bouton2; 
	protected JPanel menu;
	protected JPanel finalPanel;
	protected IGui nextUi;
			
 public BeginGUI() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, IOException{
	 
	    this.setTitle("Qui Veut Gagner Des Plugins");
	    this.setSize(250, 100);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    
	    this.bouton  = new JButton("Commencer !");
	    this.bouton2  = new JButton("Quitter :( ");
	    bouton.addActionListener(this);
	    bouton2.addActionListener(this);
	   
	    
	    this.menu = new JPanel();
	    this.menu.setLayout(new BoxLayout(this.menu, BoxLayout.LINE_AXIS));
	    this.menu.add(bouton);
	    this.menu.add(bouton2);
	 
	    this.finalPanel = new JPanel();
	    this.finalPanel.setLayout(new BoxLayout(this.finalPanel, BoxLayout.PAGE_AXIS));
	    
	    this.finalPanel.add(this.menu);
	    
	    this.getContentPane().add(this.finalPanel);
	    this.setVisible(true);
	    
 }  
	    public void actionPerformed(ActionEvent arg0) {
	  	  if(arg0.getSource() == bouton){  
	  		  			try {
						nextUi =  (IGui) Plateforme.getInstance().loadPluginDependencyFrom(this.getClass(),"IGui");
					
						} catch (ClassNotFoundException
								| InstantiationException
								| IllegalAccessException
								| SecurityException
								| IllegalArgumentException
								| IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						nextUi.setVisible(true);		
				
			
			  this.setVisible(false);
	  		  }
	  		  
	  }
	  	 
	  	 
}
