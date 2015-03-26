package plugins;

import Interfaces.ICalculPoint;

public class CalculPoint implements ICalculPoint {
	protected int score;
	protected int pointsPlus;
	protected int pointsMoins;
	
	public CalculPoint(){
		score=0;
		//points par défaut
		pointsPlus=10;
		pointsMoins=0;
	}
	public int getScore(){
		return score;
	}
	
	public void isGoodAnswer(boolean t){
		if(t){
			score+=pointsPlus;
		}else{
			score-=pointsMoins;
		}
	}
}
