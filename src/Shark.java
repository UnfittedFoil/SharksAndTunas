/*
Matthew Tam
Benjamin Martinez
2/2/18
*/

public class Shark extends Fish{
	private final boolean DEBUG = true;
	//Line of Sight: 1 degree of indirection from where the fish currently is.  In other words, the shark checks all adjacent cells.
	
	public Shark(int x, int y) {
		super(x, y, "S");
	}
	
	public Shark()
	{
		super("S");
	}
	
	public void eat()
	{
		
	}
}
