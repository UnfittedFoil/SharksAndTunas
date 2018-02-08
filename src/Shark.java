/*
Matthew Tam
Benjamin Martinez
Hiral Shah
Drew de Montagnac
Carl Koenig

2/2/18
*/

public class Shark extends Fish{
	private final boolean DEBUG = true;  //Debug flag.  Must be manually set.  Enables debug messages to the console.
	//Line of Sight: 1 degree of indirection from where the fish currently is.  In other words, the shark checks all adjacent cells.
	
	//Constructor
	public Shark() {
		super("S");
	}
}