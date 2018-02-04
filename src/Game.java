/*
Matthew Tam
2/2/18
*/

public class Game{
	private final boolean DEBUG = true;
	private int players = 0;
	
	public static void main(String[] args){
		Environment ocean = new Environment(4, 4);
		
		ocean.printBoard();
		
		
		Fish f1 = new Fish(0, 0);
		
		for(;;) {
			try {
				f1.wander();
				break;
			} catch(ArrayIndexOutOfBoundsException exception) {
				
			}
		}
		
	}
}