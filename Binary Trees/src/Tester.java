
public class Tester {

	/**
	 * Main Method
	 * @param args
	 */
	public static void main(String args[]) 
	{
		Menu start = new Menu(); // creates instance of menu class

		start.displayMenu(); // calls the display menu method
		
		while(true) // runs menu in a while loop to constantly run until user exits program
		{
			start.menu(); // calls the menu method
		}
	}
	
}
