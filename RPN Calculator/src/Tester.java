
public class Tester extends Stack
{
	
//	instance of menu class
	private Menu test;
	
	/**
	 * Constructor to set test to instance of menu
	 */
	public Tester()
	{
		test = new Menu();
	}
	
	/**
	 * Main Method
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Tester start = new Tester();
		
		start.init(); // runs init method 
		start.processes(); // runs processes method
	}
	
	/**
	 * Method to display the menu
	 */
	public void init() 
	{
		
		test.displayMenu(user_list, condition); // displays menu

	}
	
	/**
	 * Method to run the menu
	 */
	public void processes() 
	{
		
		while(true) 
		{
			
			test.menu(user_list); // runs menu in while loop to continuously run till user exits
			
		}
	}
}
