/*
Matthew Tam
2/2/18
*/

public class Environment{
	//Row Major
	public int x = 4, y = 4;
	
	private final boolean DEBUG = true;
	
	private String[][] environmentGrid = new String[x][y];
	
	public String[][] getEnvironmentGrid() {
		return environmentGrid;
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

		for(int i=0; i < 4; i++){
			for(int j=0; j < 4; j++ ){
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
	
	//Constructor
	public Environment(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.fillBoard();
	}
	
	public Environment(String[][] environmentGrid) {
		super();
		this.environmentGrid = environmentGrid;
		this.fillBoard();
	}
}