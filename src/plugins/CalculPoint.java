package plugins;

import Interfaces.ICalculPoint;

public class CalculPoint implements ICalculPoint {
	private int score;
	public CalculPoint(){
		score=0;
	}
	public int getScore(){
		return score;
	}
	
	public void isGoodAnswer(boolean t){
		if(t){
			score+=10;
		}else{
			score-=0;
		}
	}
}
