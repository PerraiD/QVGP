package plugins;


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.lang.reflect.InvocationTargetException;

import java.net.MalformedURLException;

import java.util.Collections;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Core.Plateforme;
import Interfaces.*;

public class QuestionGUI extends JPanel implements IGui,ActionListener{
	String question = "";
	ButtonGroup RepGroup = new ButtonGroup();
	JRadioButton bouton1;
	JRadioButton bouton2 ;
	JRadioButton bouton3 ;
	JRadioButton bouton4 ;
	String moitquest1;
	String moitquest2;
	String moitquest3;
	IRevelateur revelateur;
	ICalculPoint points;
	Plateforme plateformeInstance;
	
	public QuestionGUI (IQuestion question, ICalculPoint points) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, MalformedURLException{
		
		plateformeInstance = Plateforme.getInstance();
		Object[] q = {question};
		revelateur = (IRevelateur) plateformeInstance.loadPluginDependencyWithParamsFrom(this.getClass(),"IRevelateur",q,IQuestion.class); 
		
		this.points = points;
		this.question = question.getEnonce();
		List<String> reps = question.getReponses();
		Collections.shuffle(reps);
		bouton1 = new JRadioButton(reps.get(0));
		bouton2 = new JRadioButton(reps.get(1));
		bouton3 = new JRadioButton(reps.get(2));
		bouton4 = new JRadioButton(reps.get(3));
		
		RepGroup.add(bouton1);
		RepGroup.add(bouton2);
		RepGroup.add(bouton3);
		RepGroup.add(bouton4);
		
	}
	public void paintComponent(Graphics g){
		bouton1.setSelected(true);
		int TMAX = question.length();
		g.drawString("---QUESTION---",120, 20);
		if (TMAX > 40 && TMAX <90){
			
		moitquest1= question.substring(0,41);
		moitquest2= question.substring(41,TMAX);
		g.drawString(moitquest1,10, 40);
		g.drawString(moitquest2,0, 50);
		}
		else if (TMAX > 90){
			
			moitquest1= question.substring(0,45);
			moitquest2= question.substring(45,85);
			moitquest3= question.substring(85,TMAX);
			g.drawString(moitquest1,10, 40);
			g.drawString(moitquest2,0, 50);
			g.drawString(moitquest3,0, 60);
		}
		else g.drawString(question,10, 40);
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==bouton1){
			
		}
	} 
	
	public void verifierReponse(){
		verifRepByButton(bouton1);
		verifRepByButton(bouton2); 
		verifRepByButton(bouton3); 
		verifRepByButton(bouton4);
	}
	
	public void verifRepByButton(JRadioButton b){
		if(b.isSelected()){
			points.isGoodAnswer(revelateur.estReponseCorrecte(b.getText()));
		}
	}
		    
}               

