
public class Tester
{
	
	/**
	 * Main Method
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
//		creates instance of tester class
		Menu start = new Menu();
		
		
//		calls display menu method
		start.displayMenu();
		
//		creates while loop to loop program until user exits the program on the menu
		while(true) 
		{
			start.menu(); // calls the menu method
		}
		
	}
	
}
