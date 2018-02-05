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
	public void fillBoard(){
		for(int i=0; i < y; i++){
			for(int j=0; j < x; j++ ){
				environmentGrid[i][j] = " ";
			}
		}
		environmentGrid[0][0] = "S";
		environmentGrid[3][3] = "T";
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
		//Returns a 2x1 array that holds the location in the environmentGrid matrix of a specific object, where index 1 = x and index 2 = y.
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
	public void moveFish(Fish fish) {
		int oldLoc[] = getLocation(fish.getToken());
		
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