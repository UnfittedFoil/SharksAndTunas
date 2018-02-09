/*
Matthew Tam
Benjamin Martinez
Hiral Shah
Drew de Montagnac
Carl Koenig

2/2/18
*/

public class Game{
	private final boolean DEBUG = true;  //Debug flag.  Must be manually set.  Enables debug messages to the console.
	private int players = 0;
	
	public static void main(String[] args){
		//Creating a new environment, or "game board", sized 4x4.
		Environment ocean = new Environment(4, 4, 1, 1);
		
		//Create and add a shark to the environment
		Shark shark = new Shark();
		ocean.addFish(shark, 1, 1);
		
		//Create and add a tuna to the environment.
		Tuna tuna = new Tuna();
		ocean.addFish(tuna, 2, 2);
		
		ocean.printBoard();	

		
		//Lets tuna wander.
		shark.search(ocean);
		ocean.printBoard();
		System.out.println(tuna.getX() + "," + tuna.getY());
	}
}