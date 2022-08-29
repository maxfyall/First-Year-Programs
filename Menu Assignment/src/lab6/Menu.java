package lab6;

public class Menu 
{

	/** 
	 * Initialising fields for Menu class
	 */
	private String choice_1;
	private String choice_2;
	private String choice_3;
	private String choice_4;
	private String choice_5;
	
	/** 
	 * String values set for the menu inside a constructor
	 */
	public Menu() {
		
		choice_1 = "Calculate Student Grade";
		choice_2 = "Calculate Upper and Lower Bounds";
		choice_3 = "Multiple Number Calculations";
		choice_4 = "Calculate Grade V2";
		choice_5 = "Quit";
	}
	
	
	/**
	 * Method to display the menu
	 */
	public void displayMenu() {
		
		System.out.println("Please enter 1, 2, 3, 4 or 5 to select:");
		System.out.println("1." + choice_1);
		System.out.println("2." + choice_2);
		System.out.println("3." + choice_3);
		System.out.println("4." + choice_4);
		System.out.println("5." + choice_5);
		
	}
	
	/**
	 * Main Method
	 * @param args
	 */
	public static void main(String[] args) {
		
		Choice run = new Choice();
		Menu runtime = new Menu();
		
		runtime.displayMenu();
		
		while(true) 
		{
			run.userInput();	
		}
	
	}
		
}
