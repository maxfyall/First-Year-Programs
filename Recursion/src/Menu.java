import java.util.Scanner;

public class Menu {

//	field for storing data
	private String user_choice;
	
//	fields used for class
	private Scanner s = new Scanner(System.in);
	
	
	/**
	 * Method for menu
	 */
	public void menu() 
	{
		
		user_choice = s.nextLine();
//		takes choice from user
		
			switch(user_choice)
			{	
			case "1": 
				break;
			case "2":
				break;
			case "3":
				break;
			case "4": System.out.println("Program Closed");s.close();System.exit(0); 
			// ends the program when the user presses 3 when on the menu
				break;	
			default: System.out.println(" ");
			displayMenu();
			break;	
		
			}
		
	}
	
	/**
	 * Method to display the menu instructions
	 */
	public void displayMenu()
	{
//		displays menu options
		System.out.println("Please enter a number to select an option:");
		System.out.println("1." + "Option 1:");
		System.out.println("2." + "Option 2:");
		System.out.println("3." + "Option 3:");
		System.out.println("4." + "Exit");
		
	}
	
}
