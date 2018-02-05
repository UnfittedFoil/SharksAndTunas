/*
Matthew Tam
2/2/18
*/

public class Environment{
	//Row Major
	public int x = 0, y = 0;
	
	private final boolean DEBUG = true;
	
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
		for(int i=0; i < x; i++){
			for(int j=0; j < y; j++ ){
				environmentGrid[i][j] = " ";
			}
		}
		environmentGrid[0][0] = "S";
		environmentGrid[3][3] = "T";
	}	
	public void printBoard(){

		for(int i=0; i < x; i++){
			for(int j=0; j < y; j++ ){
				System.out.print("[" + environmentGrid[i][j] + "]");
			}
		System.out.println();
		}
	}
	public void swapNodes(int x1, int y1, int x2, int y2){
		String temp;
		temp = environmentGrid[x1][y1];
		environmentGrid[x1][y1] = environmentGrid[x2][y2];
		environmentGrid[x2][y2] = temp;
	}
	public int[] getLocation(String fish) {
		//
		int[] location = new int[2];
		
		for (int i = 0 ; i < x; i++)
		for(int j = 0 ; j < y ; j++)
		{
			if ( environmentGrid[i][j] == fish)
			{
				if(DEBUG) {
					System.out.println(i);
					System.out.println(j);
				}
				location[0] = i;
				location[1] = j;
				break;
			}
		}
		
		return location;
	}

	//Constructor
	public Environment(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.environmentGrid = new String[this.x][this.y];
		this.fillBoard();
	}
	
	public Environment(String[][] environmentGrid) {
		super();
		this.environmentGrid = environmentGrid;
		this.fillBoard();
	}
}