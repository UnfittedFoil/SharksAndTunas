/*
Matthew Tam
2/2/18
*/

public class Environment{
	//Row Major
	private final boolean DEBUG = true;  //Debug flag.  Must be manually set.  Enables debug messages to the console.
	
	private int x = 0, y = 0; //Grid size.  Variables are set to 0 by default for consistency.  These values will be re-written when the Environment class is initialized.
	//Note that when entering x and y coordinates into the environmentGrid String matrix array, 
	private String[][] environmentGrid; //The String matrix array that acts as the "board" of the Environment class.  Used to let the Environment class visually represent the grid that the Fish exist in.
	
	public String[][] getEnvironmentGrid() {
		//Returns the literal String matrix array that represents the environment.
		return environmentGrid;
	}
	public String getValue(int x, int y) {
		//Returns the value of the array index [y][x]		
		return environmentGrid[y][x];
	}
	public boolean isValidAddress (int x, int y) {
		//Determines if the x and y indices exist within the String matrix array.  If they do, return true.  Otherwise, return false.
		if(y < 0 || y > (this.y-1) || x < 0 || x > (this.x-1))
			return false;
		return true;
	}
	public void addFish(Fish fish, int x, int y) { 
		//Check if x and y are valid.  Then set the fish object to have the address and put the fish on the board.
		if(isValidAddress(x, y)) {
			fish.x = x;
			fish.y = y;
			environmentGrid[y][x] = fish.getToken();
		}
		else {
			System.out.println("[" + fish.getToken() + "][" + x + "," + y + "] Invalid action: Out of Bounds.");
		}
	}
	public void fillBoard(){
		//Uses nested "for" loops to automatically populate the initialized String matrix array with " " strings to make them blank.
		
		for(int i=0; i < y; i++){
			for(int j=0; j < x; j++ ){
				environmentGrid[i][j] = " ";
			}
		}
	}	
	public void printBoard(){
		//Draws the board so that y values increase upwards and x values increase as you move to the right.  Uses similar code to the "fillBoard()" method, including nested For loops to draw the board.
		
		//This for loop is written this way because when printing the board, the cells of the String matrix array are drawn from top left to bottom right.  That means that the highest y value index of the String matrix array needs to be drawn first.  Instead of starting the index count at 0, it starts at y-1 and ends at 0.
		for(int i=(y-1); i >= 0; i--){
			for(int j=0; j < x; j++ ){
				System.out.print("[" + environmentGrid[i][j] + "]");
			}
		System.out.println();
		}
	}
	public void swapNodes(int x1, int y1, int x2, int y2){
		//Simple swap function that swaps two nodes within the environmentGrid String matrix array.
		String temp;
		temp = environmentGrid[y1][x1];
		environmentGrid[y1][x1] = environmentGrid[y2][x2];
		environmentGrid[y2][x2] = temp;
	}
	public int[] getLocation(String fish) {
		//Returns a 2x1 array that holds the location in the environmentGrid matrix of a specific object, where index 1 = x and index 0 = y.
		//This method is subject to change depending on how many Fish are in the Environment.
		int[] location = new int[2];
		
		for (int i = 0 ; i < y; i++)
		{
			for(int j = 0 ; j < x ; j++)
			{
				if ( environmentGrid[i][j] == fish)
				{
					if(DEBUG) {
						System.out.println(i);
						System.out.println(j);
					}
					location[1] = i; //x value
					location[0] = j; //y value
					break;
				}
			}
		}
		return location;
	}
	public void moveFish(Fish fish, int[] newLoc) {
		//Grabs x and y location from the fish parameter given to the method.  Store these values to be manipulated locally instead of changing the x and y attributes of the fish in case something inside this method doesn't work correctly.
		//The newLoc integer array is an array holding two values (x and y, respectively).  Index 0 should be x and index 1 should be y.
		int oldLocX = fish.x;
		int oldLocY = fish.y;
		//Determines if the new address (the x and y values representing indices in the environmentGrid String matrix array) exist within the environmentGrid String matrix array.  If it does, perform the "swapNodes()" method and "move" the Fish.  If not, randomly move the Fish object to a valid location within environmentGrid.
		if(isValidAddress(newLoc[0], newLoc[1])) {
			swapNodes(oldLocX, oldLocY, newLoc[0], newLoc[1]);
			fish.x = newLoc[0];
			fish.y = newLoc[1];
		} else {
			newLoc = fish.wander();
			moveFish(fish, newLoc);
		}
	}
	//Constructor
	public Environment(int x, int y) {
		//parameters should be entered x first, then y.
		super();
		this.x = x;
		this.y = y;
		this.environmentGrid = new String[this.y][this.x];
		this.fillBoard();
	}
}