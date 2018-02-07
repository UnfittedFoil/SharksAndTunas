/*
Matthew Tam
2/2/18
*/

public class Game{
	private final boolean DEBUG = true;
	private int players = 0;
	
	public static void main(String[] args){
		//Creating a new environment, or "game board", sized 4x4.
		Environment ocean = new Environment(4, 4);
		
		//Create and add a shark to the environment
		Shark shark = new Shark();
		ocean.addFish(shark, 0, 0);
		
		//Create and add a tuna to the environment.
		Tuna tuna = new Tuna();
		ocean.addFish(tuna, 3, 3);
		
		ocean.printBoard();	
		
		//Lets tuna wander.
		ocean.moveFish(tuna);
		System.out.println(tuna.x + "," + tuna.y);
		ocean.printBoard();
	}
}