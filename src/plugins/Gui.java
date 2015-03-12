package plugins;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextArea;
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

import Core.Loader;

public class Gui extends JFrame{
	
  private Panneau pan = new Panneau();
  JButton bouton = new JButton("Fichier");
  JButton bouton2 = new JButton("Thème");
  JButton bouton3 = new JButton("Options");
 //JButton boutonGo = new JButton("Go !");
  private JPanel container = new JPanel();

 JLabel points = new JLabel("Points : ");
 private TextArea texte1= new TextArea("Tapez votre premier texte ici",1,1,java.awt.TextArea.SCROLLBARS_NONE);
 
 //producteur de question
 private Pq  prod_question;
 
 
  public Gui() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, IOException{	  
  
	  prod_question = (Pq) Loader.getInstance().loadObject(Loader.getInstance().getSpecificPlugin("producteurquestion").get(0));
	  System.out.println(prod_question.toString());
	  
	  //prod_question.get
	 	  
    this.setTitle("Qui Veut Gagner Des Plugins");
    this.setSize(600, 600);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    //Ajout du bouton à notre content pane

    
  //  container.setBackground(Color.white);
   // container.add(pan, BorderLayout.CENTER);

    
    JPanel Ligne = new JPanel();
    //On définit le layout en lui indiquant qu'il travaillera en ligne
    Ligne.setLayout(new BoxLayout(Ligne, BoxLayout.PAGE_AXIS));
    Ligne.add(pan);
    
    JPanel Menu = new JPanel();
    //On définit le layout en lui indiquant qu'il travaillera en ligne
    Menu.setLayout(new BoxLayout(Menu, BoxLayout.LINE_AXIS));
    Menu.setAlignmentX( JPanel.LEFT_ALIGNMENT );
    Menu.setBorder(BorderFactory.createLineBorder(Color.black));
    Menu.add(bouton);
    Menu.add(bouton2);
    Menu.add(bouton3);
    
    JPanel Points = new JPanel();
    Points.setLayout(new BoxLayout(Points, BoxLayout.PAGE_AXIS));
    Points.setAlignmentX(JPanel.LEFT_ALIGNMENT);
    Points.add(points);
    
    JPanel b6 = new JPanel();
    //On positionne maintenant ces trois lignes en colonne
    b6.setLayout(new BoxLayout(b6, BoxLayout.PAGE_AXIS));
   
    
    b6.add(Menu);
   // b6.add(Ligne);
    b6.add(Points);
    b6.add(new JLabel("tot"));

    points.setHorizontalAlignment(JLabel.CENTER);  
    this.getContentPane().add(b6);
    this.setVisible(true);
	
  }
  }       
