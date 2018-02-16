import java.lang.Math;
/*
Matthew Tam
Benjamin Martinez
Hiral Shah
Drew de Montagnac
Carl Koenig
David Specht

2/2/18
*/

public class Shark extends Fish{
	private final boolean DEBUG = true;  //Debug flag.  Must be manually set.  Enables debug messages to the console.
	//Line of Sight: 1 degree of indirection from where the fish currently is.  In other words, the shark checks all adjacent cells.
	
public void search(Environment env) {
		
		int searchX = this.getX() - 1;
		int searchY = this.getY() - 1;
		
		//Searches in a square, so only one side is needed, in this case a length.  This variable can be changed to try and accommodate a larger search area but the code as it stands right now will not function properly without the length being exactly 3.
		int searchArea = 3;
		
		for(int i = 0;i < searchArea;i++) {
			for(int j = 0; j < searchArea;j++) {
				if(env.isWithinBounds(searchX, searchY)) {
					if(DEBUG)
						System.out.println("Searching: X:" + searchX + " Y:" + searchY);
					
					if(env.getValue(searchX, searchY) == "T") {
						if(DEBUG)
							System.out.println("FOUND, X:" + searchX + " Y:" + searchY);
						if((Math.abs(this.getX()) - Math.abs(searchX)) == 1) {
							if(DEBUG)
								System.out.println("Eats Tuna");
							break;
						} else {
							int[] moveLoc = {searchX, searchY};
							env.moveFish(this,  moveLoc);
						}
						//x = searchX;
						//y = searchY;
					}
				}
				
				searchY++;
				
			}
			
			searchY = searchY - 3;
			searchX++;
			
		}
		
}
	
	//Constructor
	public Shark() {
		super("S");
	}
}