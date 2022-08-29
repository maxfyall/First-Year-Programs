import java.util.Scanner;

public class Menu {

//	field for storing data
	private String user_choice;

	Scanner s = new Scanner(System.in); // Imports scanner to take input from keyboard
	
	Shop run = new Shop(); // creates instance of Shop class

	/**
	 * Method for menu
	 */
	public void menu() {

		user_choice = s.nextLine();
//		takes choice from user

		switch (user_choice) 
		{
		case "1": run.getItemToAdd(); // runs the add item method in shop class
			break;
		case "2": run.getDeleteItem(); // runs the delete item method in shop class
			break;
		case "3": run.callPrintTheTree(); // runs the print tree method in the shop class
			break;
		case "4": run.getUserFindItem(); // runs the find item method in shop class
			break;
		case "5": run.callPrintTreeCost(); // runs the print cost of tree method in shop class
			break;
		case "6":
			System.out.println("Program Closed");
			s.close();
			System.exit(0); // ends the program when the user presses 6 when on the menu
			break;
		// Displays the menu after the user finishes a method or if user inputs an invalid option in menu
		default:
			System.out.println("Please select another option from the menu.");
			displayMenu();
			break;

		}

	}

	/**
	 * Method to display the status of the list, the instruction for the calculator
	 * and the menu instructions
	 */
	public void displayMenu() {

//		displays options for menu
		System.out.println("Welcome To The Shop:");
		System.out.println(" ");
		System.out.println("Enter a number to to select an option:");
		System.out.println("1." + "Add an item");
		System.out.println("2." + "Remove an item");
		System.out.println("3." + "Print all items in numerical order of ID number");
		System.out.println("4." + "Find and item");
		System.out.println("5." + "Calculates total cost of all items currently in the tree");
		System.out.println("6." + "Exit");

	}
}
