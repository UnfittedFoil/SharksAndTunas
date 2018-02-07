import java.util.Random;
import java.lang.Math;
/*
Matthew Tam
2/2/18
*/

public class Fish {
	private final boolean DEBUG = true;
	
	private final String token;
	private boolean living = true;
	public int x = 0,
				y = 0;
	
	public boolean isLiving() {
		return living;
	}
	public void setLiving(boolean living) {
		this.living = living;
	}
	public String getToken() {
		return token;
	}
	public int[] wander() {
		if(DEBUG)
			System.out.println("Begin wander():");
		
		Random rgen = new Random();
		int randomDirection = Math.abs(rgen.nextInt()%8);
		int [] result = move(randomDirection);
		
		if(DEBUG){
			System.out.println("Random Number:" + randomDirection);
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
		
	}
	
	public Fish(String token){
		super();
		this.token = token;
	}	
}
