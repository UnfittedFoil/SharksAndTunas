package tictactoe;

import java.util.Random;

/*	Move Priority
 * 1 Middle
 * 2 Game Win
 * 3 prevent Game loss
 * 4 Corner(at random)
 * 5 edge(at random)
 */

public class TicTacToeHeuristic {
	
	public static int[] move(String[][] loc){
		
		if((loc[1][1]).equals(" ")){
			int[] move = {1,1};
			return move;
		}
		
		int[] val = checkWin(loc);
		if(val != null){
			return val;
		}
		val = checkCorner(loc);
		if(val != null){
			return val;
		}
		val = checkEdge(loc);
		if(val != null){
			return val;
		}
		System.out.println("No more moves");
		return null;
	}
	
	public static int[] checkWin(String[][] loc){
		/* 3 vectors
		 * 0-1-2	0-3-6
		 * 0-4-8	2-4-6
		 * 1-4-7	3-4-5
		 * 2-5-8	6-7-8
		 */
		int[][] vectors = {{0,1,2},{0,3,6},{0,4,8},{2,4,6},{1,4,7},{3,4,5},{2,5,8},{6,7,8}};
		int empty = 0;
		for(int i=0;i<8;i++){
			int power=0;
			for(int j=0;j<3;j++){
				int x=vectors[i][j]%3;
				int y=vectors[i][j]/3;
				if(loc[x][y].equals("X")){
					power++;
				}
				else if(loc[x][y].equals("O")){
					power--;
				}
				else{
					empty = vectors[i][j];
				}
			}
			if(power == 2||power == -2){
				int[] ret = {empty%3, empty/3};
				return ret;
			}
		}
		return null;
	}
	
	public static int[] checkCorner(String[][] loc){
		//Possible corners are 0, 2, 6, 8
		int[] corners = {0,2,6,8};
		boolean[] validCorners = {false,false,false,false};
		int totalC=0;
		for(int i=0;i<4;i++){
			if(loc[corners[i]%3][corners[i]/3].equals(" ")){
				validCorners[i]=true;
				totalC++;
			}
		}
		if(totalC==0)
			return null;
		Random rgen = new Random();
		for(int i=0;i<4;i++){
			if(validCorners[i]){
				int chance = rgen.nextInt(totalC);
				if(chance==0){
					int[] ret = {corners[i]%3, corners[i]/3};
					return ret;
				}
				totalC--;
			}
		}
		System.out.println("Error in checkEge()");
		return null;
	}
	public static int[] checkEdge(String[][] loc){
		//Possible edges are 1, 3, 5, 7
		int[] edges = {1,3,5,7};
		boolean[] validEdges = {false,false,false,false};
		int totalC=0;
		for(int i=0;i<4;i++){
			if(loc[edges[i]%3][edges[i]/3].equals(" ")){
				validEdges[i]=true;
				totalC++;
			}
		}
		if(totalC==0)
			return null;
		Random rgen = new Random();
		for(int i=0;i<4;i++){
			if(validEdges[i]){
				int chance = rgen.nextInt(totalC);
				if(chance==0){
					int[] ret = {edges[i]%3, edges[i]/3};
					return ret;
				}
				totalC--;
			}
		}
		System.out.println("Error in checkEge()");
		return null;
	}
}
