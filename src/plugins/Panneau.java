package plugins;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
 
public class Panneau extends JPanel { 
  public void paintComponent(Graphics g){
	  
	  this.setBackground(Color.GRAY);
	    //g.drawString("Bienvenue dans l'application Plus long texte commun !", 90, 30);
	    g.drawLine(0, 0, this.getWidth(), 0);
	    
  }               
}
