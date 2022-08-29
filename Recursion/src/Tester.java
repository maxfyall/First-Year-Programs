
public class Tester 
{
	/**
	 * Main Method
	 * @param args
	 */
	public static void main(String[] args) 
	{
//		creates instance of menu class
		Menu run = new Menu();
		
//		calls display menu method
		run.displayMenu();
		
//		uses while loop to continuously run menu
		while(true) 
		{
			run.menu(); // calls menu method
		}
	}
	
}
