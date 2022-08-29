import java.util.Scanner;

public class Menu {

//	field for storing data
	private String user_choice;
	
//	fields used for class
	private Scanner s = new Scanner(System.in);
	private boolean found = false;
	
//	creates instance of Lottery class for running methods from that class
	Lottery run = new Lottery();
	
	/**
	 * Method for menu
	 */
	public void menu() 
	{
		
		user_choice = s.nextLine();
//		takes choice from user
		
			switch(user_choice)
			{	
			case "1": found = false; run.getNumbers(found); run.generateLottery(found); run.calculateWinnings(found); // Starts the Single Week Lottery
				break;
			case "2": found = true; run.getNumbers(found); run.calculateTotalWinnings(); // Starts a multiple week lottery
				break;
			case "3": found = true; run.getNumberofPlayers(); run.getLotteryMax(); run.MultiplayerGame(found); // Starts a multiplayer lottery
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
		System.out.println("1." + "Start Single Lottery Draw");
		System.out.println("2." + "Start Weekly Lottery Draw");
		System.out.println("3." + "Start Multiplayer Lottery Draw");
		System.out.println("4." + "Exit");
		
	}
	
}
