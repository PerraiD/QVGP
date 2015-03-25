package plugins;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Core.*;
import Interfaces.*;

public class OptionGui extends JFrame implements IGui,ActionListener{
	
	JRadioButton timer = new JRadioButton("Jouer avec un timer");
	JRadioButton joker = new JRadioButton("Jouer avec des jokers");
	JButton boutonGo = new JButton("Démarrer");
	List<String> choixthemes = new ArrayList<String>(); 
	JComboBox<?> theme;
	
 public OptionGui() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, IOException{
	 
	 IProducteurDeQuestion prod_question = (IProducteurDeQuestion) Plateforme.getInstance().loadObject(Plateforme.getInstance().getSpecificPlugin("producteurquestion").get(0));
	 
	 List<String> themes= new ArrayList<String>();
	 themes= prod_question.getThemes(); 
	 int it=0;
	 for(String theme: themes){
		 System.out.println(theme);
		 choixthemes.add(theme);
		 it++;
	 }
	 String[] choixthe = new String[it];
	 for(int i =0; i <it;i++)
	 {
		 choixthe[i] = choixthemes.get(i);
	 }
	 
	 
	 
	 theme = new JComboBox(choixthe); 
	 
	
	 this.setTitle("Qui Veut Gagner Des Plugins");
	    this.setSize(400, 130);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	 
	   //timer.addActionListener(this);
	    //joker.addActionListener(this);
	    boutonGo.addActionListener(this);
	    
	   
	    JPanel Menu = new JPanel();
	    Menu.setLayout(new BoxLayout(Menu, BoxLayout.PAGE_AXIS));
	    Menu.add(theme);
	    Menu.add(timer);
	    Menu.add(joker);
	    Menu.setMaximumSize(Menu.getPreferredSize());
	    
	    JPanel bouton = new JPanel();
	    bouton.setLayout(new BoxLayout(bouton, BoxLayout.LINE_AXIS));
	    bouton.add(boutonGo);
	    
	    
	    JPanel FinalPanel = new JPanel();
	    FinalPanel.setLayout(new BoxLayout(FinalPanel, BoxLayout.PAGE_AXIS));
	    
	    FinalPanel.add(Menu);
	    FinalPanel.add(bouton);
	    
	    this.getContentPane().add(FinalPanel);
	    this.setVisible(true);
	    
 }  
	    public void actionPerformed(ActionEvent arg0) {
	  	  if(arg0.getSource() == boutonGo){
	  		// LOAD CHARGEUR PLUGIN AVEC VARIABLE INSTANCE A LA FIN DU CHARGEMENT
	  		String res = String.valueOf(theme.getSelectedItem());
	  	
	  		 
				try {
					Object[] values = {res};
					IGui gui= (IGui)Plateforme.getInstance().loadPluginDependencyWithParamsFrom(this.getClass(),"IGui",values, String.class);
				
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException | NoSuchMethodException
						| SecurityException | IllegalArgumentException
						| InvocationTargetException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			  this.setVisible(false);
	  		  }
	  		  
	  		  
	  	 
	 
 }
	    }
