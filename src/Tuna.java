/*
Matthew Tam
2/2/18
*/

public class Tuna extends Fish{
	private final boolean DEBUG = true;
	//Line of Sight: 1 degree of indirection from where the fish currently is.  In other words, the shark checks all adjacent cells.
	
	public Tuna(int x, int y) {
		super(x, y, "T");
	}	
}