/*
Matthew Tam
2/2/18
*/

public class Shark extends Fish{
	private final boolean DEBUG = true;
	//Line of Sight: 1 degree of indirection from where the fish currently is.  In other words, the shark checks all adjacent cells.
	
	public Shark() {
		super("S");
	}
}