import java.util.Random;
/*
Matthew Tam
Benjamin Ma
2/6/18
*/

public class Fish {
	
	private final boolean DEBUG = true;
	private String token = "";
	private boolean living = true;
	
	private int x = 0,
				y = 0;
	
	public Fish(int x, int y, String token){     //used for adding a fish manually ( manually meaning by x,y coords)
		super();
		this.x = x;
		this.y = y;
		this.token = token;
	}
	
	public Fish(String token)		//used for adding a fish randomly
	{
		this.token = token;
	}
	
	
	public boolean isLiving() {
		return living;
	}
	
	public void setLiving(boolean living) {
		this.living = living;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token)
	{
		this.token = token;
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
	}
	
	public void move(int direction) {
		
		switch(direction) {
			case 0:
				//North
				y++;
				break;
			case 1:
				//North East
				y++;
				x++;
				break;
			case 2:
				//East
				x++;
				break;
			case 3:
				//South East
				y--;
				x++;
				break;
			case 4:
				//South
				y--;
				break;
			case 5:
				//South West
				y--;
				x--;
				break;
			case 6:
				//West
				x--;
				break;
			case 7:
				//North West
				x--;
				y++;
				break;
		}
	}
	
	
	
	
}