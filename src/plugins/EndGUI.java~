package plugins;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Core.Plateforme;
import Interfaces.IGui;

public class EndGUI extends JFrame implements IGui,ActionListener{

	JButton boutonEnd = new JButton("Terminer");
	JButton boutonRec = new JButton("Recommencer une partie");
	JLabel points = new JLabel();
	IGui nGui;
	public EndGUI(int userScore){
		this.setTitle("Qui Veut Gagner Des Plugins");
	    this.setSize(400, 130);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    
	    JPanel Menu = new JPanel();
	    Menu.setLayout(new BoxLayout(Menu, BoxLayout.PAGE_AXIS));
	    points.setText("Vous avez totalisé : "+userScore+" points");
	    Menu.add(points);
	    Menu.setMaximumSize(Menu.getPreferredSize());
	    
	    JPanel bouton = new JPanel();
	    bouton.setLayout(new BoxLayout(bouton, BoxLayout.LINE_AXIS));
	    boutonRec.addActionListener(this);
	    boutonEnd.addActionListener(this);
	    bouton.add(boutonRec);
	    bouton.add(boutonEnd);
	    
	    
	    JPanel FinalPanel = new JPanel();
	    FinalPanel.setLayout(new BoxLayout(FinalPanel, BoxLayout.PAGE_AXIS));
	    
	    FinalPanel.add(Menu);
	    FinalPanel.add(bouton);
	    
	    this.getContentPane().add(FinalPanel);
	    this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource()==boutonEnd){
			System.exit(EXIT_ON_CLOSE);
		}else if(event.getSource()==boutonRec){
			try{
				nGui =  (IGui) Plateforme.getInstance().loadPluginDependencyFrom(this.getClass(),"IGui");
				
			} catch (ClassNotFoundException
							| InstantiationException
							| IllegalAccessException
							| SecurityException
							| IllegalArgumentException
							| IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
			}
			nGui.setVisible(true);		
			this.setVisible(false);
		}
		
	}

}
