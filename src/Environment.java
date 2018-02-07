/*
Matthew Tam
Benjamin Martinez
2/6/18
*/
import java.util.ArrayList;
import java.util.Random;

public class Environment{
	//Row Major
	private final boolean DEBUG = true;
	
	private int x = 0, y = 0;
	private String[][] environmentGrid;
	
	private ArrayList<Shark> sharks;     //stores all sharks
	private ArrayList<Tuna> tunas;		//stores all tuna
	
	private int numOfSharks;			//num of sharks you want in game
	private int numOfTuna;				//num of tuna....
	
	//Constructor
	public Environment(int x, int y, int numOfSharks, int numOfTuna) {
		//parameters should be entered x first, then y.
		super();
		this.x = x;
		this.y = y;
		this.numOfSharks = numOfSharks;
		this.numOfTuna = numOfTuna;
		
		setSharks(sharks);
		setTunas(tunas);
		
		this.environmentGrid = new String[this.y][this.x];
		this.fillBoard();
	}
	
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
	
	
	public ArrayList<Shark> getSharks() {
		return sharks;
	}

	public void setSharks(ArrayList<Shark> sharks) {      //adds the number of Sharks specified by numOfSharks to ArrayList sharks
		
		sharks = new ArrayList<Shark>();
		
		for(int i = 0; i < numOfSharks; i++)
		{
			Shark shark = new Shark();
			sharks.add(shark);
		}
		
		this.sharks = sharks;
	}

	public ArrayList<Tuna> getTuna() {
		return tunas;
	}

	public void setTunas(ArrayList<Tuna> tunas) {     //adds the number of Tuna specified by numOfSharks to ArrayList tuna
		
		tunas = new ArrayList<Tuna>();
		
		for(int i = 0; i < numOfTuna; i++)
		{
			Tuna tuna = new Tuna();
			tunas.add(tuna);
		}
		
		this.tunas = tunas;
	}

	public void fillBoard(){
		
		for(int i=0; i < y; i++){
			for(int j=0; j < x; j++ ){
				environmentGrid[i][j] = " ";
			}
		}
		
		for(Shark shark : sharks)				//adds a shark to the board for each shark created
		{
			addShark(shark);
		}
		
		for(Tuna tuna : tunas)					//adds a tuna to the board for each tuna created
		{
			addTuna(tuna);
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
	
	public void addShark(Shark shark)					//adds a shark randomly
	{
		Random rand1 = new Random();
		Random rand2 = new Random();
	    int randomX = rand1.nextInt(x - 1);
	    int randomY = rand2.nextInt(y - 1);

	   
		
		if (environmentGrid[randomX][randomY] == " ")
		{
			environmentGrid[randomX][randomY] = shark.getToken();

		}
		else
		{
			addShark(shark);
		}
	}
	
	public void addShark(Shark shark, int x, int y)			//adds a shark manually
	{
		if (!environmentGrid[x][y].isEmpty())
		{
			environmentGrid[x][y] = shark.getToken();
		}
		else
		{
			System.out.println("Location is currently occupied");
		}
	}
	
	public void addTuna(Tuna tuna)				//adds a tuna randomly
	{
		Random rand1 = new Random();
		Random rand2 = new Random();
		int randomX = rand1.nextInt(x - 1);
	    int randomY = rand2.nextInt(y - 1);

	   
		
		if (environmentGrid[randomX][randomY] == " ")
		{
			environmentGrid[randomX][randomY] = tuna.getToken();
			
		}
		else
		{
			addTuna(tuna);
		}
	}
	
	public void addTuna(Tuna tuna, int x, int y)		//adds a tuna manually
	{
		if (!environmentGrid[x - 1][y - 1].isEmpty())
		{
			environmentGrid[x - 1][y - 1] = tuna.getToken();
		}
		else
		{
			System.out.println("Location is currently occupied");
		}
	}
	
	public void updateEnvironment()				// this might be what updates the environment after each turn.. maybe.. idk
	{
		
	}
	
	public void moveFish(Fish fish, int direction)   
	{
		fish.move(direction);
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
	/**
	public void moveFish(Fish fish) {
		int oldLoc[] = getLocation(fish.getToken());
		
	}
	**/
}