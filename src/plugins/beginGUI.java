package plugins;



import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class beginGUI extends JFrame implements ActionListener{
	
	JButton bouton = new JButton("Commencer !");
	JButton bouton2 = new JButton("Quitter :(");
	
 public beginGUI(){
	 
	 this.setTitle("Qui Veut Gagner Des Plugins");
	    this.setSize(250, 100);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	 
	    bouton.addActionListener(this);
	    bouton2.addActionListener(this);
	    
	    
	    
	    
	    JPanel Menu = new JPanel();
	    Menu.setLayout(new BoxLayout(Menu, BoxLayout.LINE_AXIS));
	    Menu.add(bouton);
	    Menu.add(bouton2);
	 
	    JPanel FinalPanel = new JPanel();
	    FinalPanel.setLayout(new BoxLayout(FinalPanel, BoxLayout.PAGE_AXIS));
	    
	    FinalPanel.add(Menu);
	    
	    this.getContentPane().add(FinalPanel);
	    this.setVisible(true);
	    
 }  
	    public void actionPerformed(ActionEvent arg0) {
	  	  if(arg0.getSource() == bouton){
	  		
	  		  
	  		 
	  		  try {
				new Gui().setVisible(true);
				
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  this.setVisible(false);
	  		  }
	  		  
	  		  }
	  	 
	  	 
}
