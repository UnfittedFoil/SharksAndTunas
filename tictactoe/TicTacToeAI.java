package tictactoe;

import java.util.Random;

public class TicTacToeAI {
	public int[] FirstMove(){
		int[] ret = new int[2];
		//50% chance middle	35% chance corner 15% chance edge
		Random rgen = new Random();
		int chance = rgen.nextInt(20);
		if(chance<10){
			ret[0]=1;
			ret[1]=1;
			return ret;
		}
		int pos = rgen.nextInt(4);
		if(chance<17){
			switch(pos){
			case 0:
				ret[0] = 0;
				ret[1] = 0;
				break;
			case 1:
				ret[0] = 2;
				ret[1] = 0;
				break;
			case 2:
				ret[0] = 0;
				ret[1] = 2;
				break;
			case 3:
				ret[0] = 2;
				ret[1] = 2;
				break;
			}
			return ret;
		}
		else{
			switch(pos){
			case 0:
				ret[0] = 0;
				ret[1] = 1;
				break;
			case 1:
				ret[0] = 2;
				ret[1] = 1;
				break;
			case 2:
				ret[0] = 1;
				ret[1] = 0;
				break;
			case 3:
				ret[0] = 1;
				ret[1] = 2;
				break;
			}
			return ret;
		}
	}
}
