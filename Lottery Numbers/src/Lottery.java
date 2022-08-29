import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Lottery 
{

//	creates 2 sets to store numbers from user and random generator
	private Set<Integer> userNums, lotteryNums;
	
//	fields used in class
	private Scanner s = new Scanner(System.in);
	private Scanner x = new Scanner(System.in);
	private String input;
	private int addToSet;
	private int lottery_max;
	private int weeksToRun;
	private long overallWinnings;
	private long winnings;
	private int ticketCost;
	private int NumPlayers;


	/**
	 * Constructor of class
	 */
	public Lottery() 
	{
		
		userNums = new HashSet<Integer>(); // defines set as HashSet
		lotteryNums = new HashSet<Integer>(); // defines set as HashSet
		weeksToRun = 1; // sets default value of weeks to 1
		
	}
	
	/**
	 * Method for acquiring data
	 * @param found
	 */
	public void getNumbers(boolean found) 
	{
//		asks user for a range of numbers
		System.out.println("Please select a range for the lottery numbers");
		System.out.println("e.g. Enter 10 for a range of 1-10");
		System.out.println("Minimum range is 6");

		lottery_max = s.nextInt(); // stores in field
		System.out.println(" ");
		
//		validation for lottery range
		if(lottery_max < 6) // if lottery range is less than six
		{
//			output an error message
			System.out.println("Sorry you input an invalid range");
			System.out.println("Please re-enter a valid range");
			System.out.println(" ");
			getNumbers(found); // ask user the re-enter their range
		}
	
		System.out.println(" ");
		
//		Instructions for the lottery
		System.out.println("Instructions:");
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

		
		System.out.println(" ");
		System.out.println("Enter your Numbers"); // asks user to enters their numbers
		
		input = x.nextLine(); // stores data in a string
		
		String[] split_array = input.split(","); // uses string slip method to split the string into an array
		
		for(int i = 0; i < split_array.length; i++) // adds data to set using for loop
		{
			
			addToSet = Integer.parseInt(split_array[i]); // converts data in array into integer and stores in field
			
			userNums.add(addToSet); // adds data to set
			
		}
		
//		validation for set
		if(userNums.size() > 6 || userNums.size() < 6) // if the size of the set is bigger or less then size
		{
//			output error message
			System.out.println("You have entered an invalid set of numbers");
			System.out.println("Please try again:");
			System.out.println(" ");
			userNums.clear(); // clear data in the set
			getNumbers(found); // return the use to re-enter their numbers
			
		}
		
		else 
		{
			if(found==false) // if option one has been selected
			{
				
				System.out.println(userNums); // display the users numbers

			}
			
		}
		
		if(found == true) // if the user has selected option 2
		{
//			ask the user how many weeks they wish to run the lottery
			System.out.println(" ");
			System.out.println("How many weeks do you wish to run the lottery?");
			
			weeksToRun = s.nextInt(); // store in a variable
		
			for(int i = 0; i < weeksToRun; i++) // uses for loop to run for multiple weeks
			{
				generateLottery(found); // calls generate lottery method
				calculateWinnings(found); // calls calculate winnings method
				lotteryNums.clear(); // clears set
			}
			
		}
		
	}
	
	/**
	 * Method for generating the lottery numbers
	 * @param found
	 */
	public void generateLottery(boolean found) 
	{
		int[] lottery = new int[6]; // creates array of integers
		
		int count = 0; // creates local variable to keep track of array contents
		
		Random rand = new Random(); // creates instance of Random class
				
		while(lotteryNums.size() != 6) // uses while loop to avoid duplicate numbers
		{
			lottery[count] = rand.nextInt(lottery_max) + 1; // generates a number between 1 and max range, then stores in array
			
			lotteryNums.add(lottery[count]); // adds number to lottery number set
			
			count++; // adds one to counter to move to next item in array
			
//			validation for duplicate numbers
			if(lotteryNums.size() != count) // if the size of the set is not equal to variable count (e.g. a duplicate number has been added)
			{
				count--; // take one away from count
			}
			
		}

//		if option 1 has been selected
		if(found == false) 
		{
			System.out.println(lotteryNums); // display the lottery numbers from the set
		}
		
	}
	
	/**
	 * Method to calculate the winnings
	 * @param found
	 */
	public void calculateWinnings(boolean found) 
	{
		
//		creates copy of the set containing the users numbers
		Set<Integer> copy = new HashSet<Integer>(userNums);
		
//		performs set operation (set intersection) with copied set and lottery numbers set
		copy.retainAll(lotteryNums);
		
		if(copy.size() < 3) // if size of copy set is less than 3
		{
			overallWinnings = overallWinnings + 0; // add nothing to total
		}
		
		if(copy.size() == 3) // if size of set is 3
		{
			overallWinnings = overallWinnings + 25; // add 25 to total
		}
		
		if(copy.size() == 4) // if set size is 4
		{
			overallWinnings = overallWinnings + 100; // add 100 to total
		}
		
		if(copy.size() == 5) // if set size is 5
		{
			overallWinnings = overallWinnings + 1000; // add 1000 to total
		}
		
		if(copy.size() == 6) // if set size is 6
		{
			overallWinnings = overallWinnings + 1000000; // add 1000000 to total
		}
		
//		if option 1 has been selected
		if(found == false)
		{
			userNums.clear(); // clear the set userNums
			winnings = overallWinnings; // sets total to variable
			
			if(winnings == 0) // if the user has won nothing
			{
//				output the bad news
				System.out.println("I'm Sorry to say that you have won nothing");
				System.out.println("and have lost £2");
				System.out.println(" ");
				System.out.println("Press Enter to Continue");
//				clear the set lottery numbers for the next use
				lotteryNums.clear();
				winnings = 0; // sets fields to zero to prevent overlaps
				overallWinnings = 0;
			}
			else // if condition isn't true then
			{
//				display results
				System.out.println("You have won £" + winnings + "!");
				System.out.println(" ");
				System.out.println("Press Enter to Continue");
//				clear the set lottery numbers for the next use
				lotteryNums.clear();
				winnings = 0; // sets fields to zero to prevent overlaps
				overallWinnings = 0;
			}
		}

//		clear the set copy for the next use
		copy.clear();
		
		
	}
	
	/**
	 * Method to calculate winnings if option 2 is selected
	 */
	public void calculateTotalWinnings() 
	{
		
		lotteryNums.clear(); // clears lottery numbers set
		
//		works out how much was spent on tickets
		ticketCost = weeksToRun * 2;
		
//		calculates winnings
		winnings = overallWinnings - ticketCost;
		
		if(winnings < 0) // if winnings is less than 0
		{
//			output the bad news
			System.out.println("I'm sorry to say that you have won nothing");
			System.out.println("and have lost £" + ticketCost);
			System.out.println(" ");
			System.out.println("Press Enter to Continue");
		}
		else // if condition isn't true then
		{
//			display the result
			System.out.println("You have won £" + winnings + "!");
			System.out.println(" ");
			System.out.println("Press Enter to Continue");

		}
		
//		set total field to 0 for next use
		overallWinnings = 0;
		
//		clears the userNums set for next use
		userNums.clear();

		
	}
	
	/**
	 * Method to get the number of players for option 3 in menu
	 */
	public void getNumberofPlayers() 
	{
//		asks the user for the number of players
		System.out.println(" ");
		System.out.println("How Many Players are There?");
		
//		stores in field
		NumPlayers = s.nextInt();
	}
	
	/**
	 * Method to run the multiplayer game
	 * @param found
	 */
	public void MultiplayerGame(boolean found) 
	{
//		creates array with limit being the number of players
		long playerWinnings[] = new long[NumPlayers];
			
		generateLottery(found); // calls generate lottery method
				
		for(int i = 0; i < NumPlayers; i++) 
		{
			int count = i;

			getNumbers2(count); // calls getNumbers2 method
					
			calculateWinnings(found); // calls calculate winnings method
			
			calculateMultiWinnings(count, playerWinnings); // calls calculateMultiWinnings method
		}
		
		
		lotteryNums.clear();
	}
	
	/**
	 * Method to get max range of lottery for option 3 in menu
	 */
	public void getLotteryMax() 
	{
//		asks user for max range of lottery
		System.out.println("Please select a range for the lottery numbers");
		System.out.println("e.g. Enter 10 for a range of 1-10");
		System.out.println("Minimum range is 6");

//		stores in field
		lottery_max = s.nextInt();
		System.out.println(" ");
		
//		validation for range
		if(lottery_max < 6) 
		{
			System.out.println("Sorry you input an invalid range");
			System.out.println("Please re-enter a valid range");
			System.out.println(" ");
			getLotteryMax();
		}
	}
	
	/**
	 * Method to get number of weeks to run the lottery for option 3 in the menu
	 */
	public void getWeeksToRun()
	{
//		asks user for how many weeks they want the lottery to run for
		System.out.println("How many weeks do you wish to run the lottery?");
		
//		stores in field
		weeksToRun = s.nextInt();
	}
	
	/**
	 * Improved Method for getting numbers (used for option 3 in menu)
	 */
	public void getNumbers2(int count)
	{
		System.out.println(" ");
		
//		Displays instructions
		System.out.println("Instructions:");
		System.out.println("You are to enter 6 numbers between 1 and the range you selected");
		System.out.println("Caution - No duplicate numbers");
		System.out.println("Numbers must be seperated by ',' as shown below");
		System.out.println("e.g. 1,2,3,4,5,6");
		System.out.println("£2 to play and prizes will be awarded depending on how many of");
		System.out.println("your numbers match the random generated list of numbers");
		System.out.println(" ");
		System.out.println("Note: You have selected the multiplayer option.");
		System.out.println("This means that you will have to input a different set");
		System.out.println("of numbers for each week");

//		asks user to input their numbers
		System.out.println(" ");
		System.out.println("Player " + (count+1));
		System.out.println("Enter your Numbers");
		
//		stores in a string
		input = x.nextLine();
		
//		splits string into an array
		String[] split_array = input.split(",");
		
		for(int i = 0; i < split_array.length; i++) 
		{
			
			addToSet = Integer.parseInt(split_array[i]); // converts data in array into integer
			
			userNums.add(addToSet); // adds to set
			
		}
		
//		validation for userNums set
		if(userNums.size() > 6 || userNums.size() < 6)
		{
			
			System.out.println("You have entered an invalid set of numbers");
			System.out.println("Please try again:");
			System.out.println(" ");
			userNums.clear();
			getNumbers2(count);
//			returns user to re-enter their numbers if the condition is met
			
		}
	
	}
	
	/**
	 * Method to calculate winnings for Multiplayer game
	 * @param count
	 * @param playerWinnings
	 */
	public void calculateMultiWinnings(int count, long[] playerWinnings) 
	{		
		ticketCost = weeksToRun * 2; // works out cost of tickets
				
		int i = count;
		
		playerWinnings[count] = overallWinnings - ticketCost; // works out winnings for player
		
		i++;
		
		userNums.clear(); // clears set for next players numbers to be added
		
		overallWinnings = 0; // sets total to 0 for next player
		winnings = 0; // sets winnings to 0 for next player
		
		if(i == playerWinnings.length) // condition to check if ready to display results
		{
			for(int j = 0; j < playerWinnings.length; j++)
			{
				System.out.println(" ");
				System.out.println("Player " + (j+1) + " won £" + playerWinnings[j]);
//				displays the results

			}
			
			System.out.println("Press Enter to Continue");


		}


	}
	

}
