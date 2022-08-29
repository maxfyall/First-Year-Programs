import java.util.Scanner;

public class Shop 
{
	private Scanner s = new Scanner(System.in);
	
	public void displayItems() 
	{
		System.out.println("Our Menu:");
		System.out.println("You are to enter 6 numbers between 1 and the range you selected");
		System.out.println("Caution - No duplicate numbers");
		System.out.println("Numbers must be seperated by ',' as shown below");
		System.out.println("e.g. 1,2,3,4,5,6");
		System.out.println("£2 to play and prizes will be awarded depending on how many of");
		System.out.println("your numbers match the random generated list of numbers");
		System.out.println(" ");
		System.out.println("Note: Selecting to run the lottery for multiple weeks");
		System.out.println("will use the same numbers you select for those weeks.");
		System.out.println("Your total winnings will be added up and shown to you after");
		System.out.println("the draws are finished");
	}
}
