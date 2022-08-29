import java.util.Scanner;

public class Menu extends Stack
{
	
//	field for storing data
	private String user_choice;
	
	private Stack run = new Stack();
	private Scanner a = new Scanner(System.in);
	
	/**
	 * Method for menu
	 */
	public void menu(List user_list) 
	{
		
		
		user_choice = a.nextLine();
//		takes choice from user
			
			switch(user_choice)
			{	
			case "1": run.getUser_input(); // Starts the RPN Calculator
				break;
			case "2": System.out.println("Program Closed");a.close(); System.exit(0); // ends the program when the user presses 3 when on the menu
				break;
			//	Displays the menu after the user comes out of the first 3 options		
			default: System.out.println("Please select another option from the menu.");
			displayMenu(user_list, condition);
			break;	
		
			}

	}
	
	/**
	 * Method to display the status of the list, the instruction for the calculator and the menu instructions
	 */
	public void displayMenu(List user_list, boolean condition)
	{
				
		System.out.println(" ");
		user_list.isListempty(condition); // checks if list is empty and displays status
		
		
//		displays instructions for calculator and menu
		System.out.println(" ");
		System.out.println("Instructions:");
		System.out.println("This Calculator only takes equations in Postfix notation");
		System.out.println("Numbers must be seperated by ',' as shown below");
		System.out.println("Valid Operators: '+' '-' '*' '/': ");
		System.out.println("e.g. 3,5,*,6,4,+,2,*,+");
		System.out.println(" ");
		System.out.println("Please enter a number to to select an option:");
		System.out.println("1." + "Start RPN Calculator");
		System.out.println("2." + "Exit");
		
	}
}
