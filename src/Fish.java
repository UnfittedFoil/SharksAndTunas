import java.util.Random;
/*
Matthew Tam
Benjamin Martinez
Hiral Shah
Drew de Montagnac
Carl Koenig

2/2/18
*/

public class Fish {
	
	private final boolean DEBUG = true;  //Debug flag.  Must be manually set.  Enables debug messages to the console.
	
	private final String token; //The string representation of a Fish object within the Environment object.  Preferably one character only, but can technically be more.
	private boolean living = true;
	//This is where the Fish thinks it is.  The fish stores it's own x and y location within the Environment object so that when the Environment object asks for a Fish's location, the Environment object doesn't have to re-find the Fish.
	private int x = 0,
				y = 0;
	
	public boolean getLiving() {
		return living;
	}
	public void setLiving(boolean living) {
		this.living = living;
	}
	public String getToken() {
		return token;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int[] wander() {
		//Uses Java's built-in random number generator to create a random number from 0 to 8.  This number is then fed to the Fish's "move()" method, which accepts inputs 0-8, where each number is mapped to a direction with 0 being "north" and mapping the rest of the compass clockwise until all 8 directions are numbered.  See the "move()" method's comments for a better visual aid explaining how the numbers are mapped to direction.
		if(DEBUG)
			System.out.println("Begin wander():");
		
		Random rgen = new Random();
		int randomDirection = rgen.nextInt(8);
		
		if(DEBUG)
			System.out.println("Random Number:" + randomDirection);
		
		int [] result = move(randomDirection);
		
		if(DEBUG){
			System.out.println("Attempting to move to: " + result[0] + "," + result[1]);
		}
		
		return result;
	}
	public int[] move(int parameter) {
		int[] result = {x, y};
		
		/* Visual Aid for understanding the switch statement in this method:
		 * The "F" represents the Fish and the numbers around the Fish represent the directions that the Fish can go.
		 * The numbers are mapped to the directions in the diagram.
		 *
		 * 7 0 1
		 * 6 F 2
		 * 5 4 3
		 * 
		 */
		
		if(DEBUG)
			System.out.println("Begin move():");
		
		String directionName="";
		
		switch(parameter) {
			case 0:
				//North
				directionName="North";
				result[1]++;//y++
				break;
			case 1:
				//North East
				directionName="North East";
				result[0]++;//x++
				result[1]++;//y++
				break;
			case 2:
				//East
				directionName="East";
				result[0]++;//x++
				break;
			case 3:
				//South East
				directionName="South East";
				result[0]++;//x++
				result[1]--;//y--
				break;
			case 4:
				//South
				directionName="South";
				result[1]--;//y--
				break;
			case 5:
				//South West
				directionName="South West";
				result[0]--;//x--
				result[1]--;//y--
				break;
			case 6:
				//West
				directionName="West";
				result[0]--;//x--
				break;
			case 7:
				//North West
				directionName="North West";
				result[0]--;//x--
				result[1]++;//y++
				break;
		}
		if(DEBUG)
			System.out.println("Moving " + directionName);
		
		return result;
	}
	
	public void lineOfSight(){
		//Line of Sight: 1 degree of indirection from where the fish currently is.  In other words, the shark checks all adjacent cells.
	}
	
	public Fish(String token){
		super();
		this.token = token;
	}	
}
