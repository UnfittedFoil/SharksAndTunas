import java.util.Random;
/*
Matthew Tam
2/2/18
*/

public class Fish {
	private final boolean DEBUG = true;
	
	private boolean living = true;
	private int x,
				y;
	
	public boolean isLiving() {
		return living;
	}
	public void setLiving(boolean living) {
		this.living = living;
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

	public void wander() {
		Random rgen = new Random();
		int randomDirection = rgen.nextInt()%8;
		move(randomDirection);
		if(DEBUG){
			System.out.println(x + "," + y);
		}
		
	}
	
	public void move(int parameter) {
		
		switch(parameter) {
			case 0:
				//North
				y--;
				break;
			case 1:
				//North East
				y--;
				x++;
				break;
			case 2:
				//East
				x++;
				break;
			case 3:
				//South East
				y++;
				x++;
				break;
			case 4:
				//South
				y++;
				break;
			case 5:
				//South West
				y++;
				x--;
				break;
			case 6:
				//West
				x--;
				break;
			case 7:
				//North West
				x--;
				y--;
				break;
		}
	}
	
	public void lineOfSight(){
		
	}
	
	public Fish(int x, int y){
		super();
		this.x = x;
		this.y = y;
	}
}
