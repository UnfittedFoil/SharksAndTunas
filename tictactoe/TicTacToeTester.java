package tictactoe;

import java.util.Scanner;

public class TicTacToeTester {

    public static void main(String[] args) {
        String player = "X";
        TicTacToe game = new TicTacToe();
        
        boolean done = false;
        while(!done) {
            System.out.print(game.toString());
            if(player.equals("X")){
            	done = playerMove(game, player);
            	//computerMove(game, player);
            	player = "O";
            }
            else{
            	computerMove(game, player);
            	player = "X";
            }
            
        }
        System.out.println("Game Over");
    }
    public static boolean  playerMove(TicTacToe game, String player){
    	Scanner in = new Scanner(System.in);
    	System.out.print("Row for player " + player + " (-1 to exit): ");
    	int row = in.nextInt();
    
    	if(row < 0) return true;
    	else {
    		System.out.print("Column for player " + player + ": ");
    		int column = in.nextInt();
    		game.set(row, column, player);
    		if(player.equals("X")) player = "O";
    		else player = "X";
    	}
    	return false;
    }
    public static boolean computerMove(TicTacToe game, String player){
    	delay(1000);
    	int[] moveTo = TicTacToeHeuristic.move(game.getBoard());
    	game.set(moveTo[0], moveTo[1], player);
    	System.out.println("\n\n");
    	return true;
    }
    
    public static void delay(int ms){
    	try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}