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
		Random rgen = new Random();
		int randomDirection = Math.abs(rgen.nextInt()%8);
		int [] result = move(randomDirection);
		
		if(DEBUG){
			System.out.println(randomDirection);
			System.out.println("Attempting to move to: " + result[0] + "," + result[1]);
		}
		
		return result;
	}
	
	public int[] move(int parameter) {
		int[] result = {x, y};
		
		switch(parameter) {
			case 0:
				//North
				result[1]++;//y++
				break;
			case 1:
				//North East
				result[0]++;//x++
				result[1]++;//y++
				break;
			case 2:
				//East
				result[0]++;//x++
				break;
			case 3:
				//South East
				result[0]++;//x++
				result[1]--;//y--
				break;
			case 4:
				//South
				result[1]--;//y--
				break;
			case 5:
				//South West
				result[0]--;//x--
				result[1]--;//y--
				break;
			case 6:
				//West
				result[0]--;//x--
				break;
			case 7:
				//North West
				result[0]--;//x--
				result[1]++;//y++
				break;
		}
		return result;
	}
	
	public void lineOfSight(){
		
	}
	
	public Fish(String token){
		super();
		this.token = token;
	}	
}
