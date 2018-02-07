/*
Matthew Tam
2/2/18
*/

public class Environment{
	//Row Major
	private final boolean DEBUG = true;
	
	private int x = 0, y = 0;
	private String[][] environmentGrid;
	
	public String[][] getEnvironmentGrid() {
		return environmentGrid;
	}
	public String getValue(int x, int y) {
		String result = environmentGrid[x][y];
		
		return result;
	}
	public void setEnvironmentGrid(String[][] environmentGrid) {

		this.environmentGrid = environmentGrid;
	}
	public boolean isValidAddress (int x, int y) {
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
			System.out.println("[" + fish.getToken() + "][" + x + "," + y + "] Invalid move: Out of Bounds.");
		}
	}
	public void fillBoard(){
		for(int i=0; i < y; i++){
			for(int j=0; j < x; j++ ){
				environmentGrid[i][j] = " ";
			}
		}
	}	
	public void printBoard(){
		//Draws the board so that y values increase upwards and x values increase as you move to the right.
		
		for(int i=(y-1); i >= 0; i--){
			for(int j=0; j < x; j++ ){
				System.out.print("[" + environmentGrid[i][j] + "]");
			}
		System.out.println();
		}
	}
	public void swapNodes(int x1, int y1, int x2, int y2){
		String temp;
		temp = environmentGrid[y1][x1];
		environmentGrid[y1][x1] = environmentGrid[y2][x2];
		environmentGrid[y2][x2] = temp;
	}
	public int[] getLocation(String fish) {
		//Returns a 2x1 array that holds the location in the environmentGrid matrix of a specific object, where index 1 = x and index 0 = y.
		//This method is subject to change.
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
		int oldLocX = fish.x;
		int oldLocY = fish.y;
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