package lab6;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Choice extends Menu
{
	/**
	 * Initialise fields for Choice class
	 */
	private String user_choice;
	
	private int inputGrade;
	
	private int upper;
	private int lower;
	private double squared;
	private double cubed;
	private double root;
	
	private int total;
	private double average;
	private int max;
	private int min;
	
	private Scanner s = new Scanner(System.in);
//	Scanner declare here to allow only one scanner to open
	
	/**
	 * Constructor sets default values for fields in class
	 */
	public Choice() {
		
		squared = 0;
		cubed = 0;
		root = 0;
		upper = 0;
		lower = 0;
		total = 0;
		average = 0;
		max = 0;
	}
	
	/**
	 * Method to navigate the user to the option they choose
	 */
	public void userInput() {
				
		user_choice = s.nextLine();
		
		switch(user_choice)
		{	
		case "1": getGrade(); // takes user to the getGrade method
			break;
		case "2": calculate_upper_lower_bounds(); // takes user to the lower and upper bounds method
			break;
		case "3": statistics(); // takes user to the statistics method
			break;
		case "4": calculateGrade_2(); // Similar to first choice but can only input 3 invalid numbers
			break;
		case "5": s.close(); System.exit(0); // ends the program when the user presses 4 when on the menu
			break;

		//	Displays the menu after the user comes out of the first 3 options		
		default: System.out.println("Please select another option from the menu.");
		displayMenu();
		break;
		}
		
	}
	
	/**
	 * Method to get a percentage from the user, called when user selects option 1
	 */
	public void getGrade() 
	{
		do
		{
				System.out.println("What is your score? (Percentage)"); // asks user for a percentage
				inputGrade = s.nextInt();
				calculateGrade();
				
		} while(inputGrade>100 || inputGrade<0);	
		
	}
	
	/**
	 * Method to calculate a grade from a percentage inputed by the user, called when user selects option 1
	 */
	public void calculateGrade() {
		int counter = 0;
		
		do {
			if (inputGrade>100 || inputGrade < 0) {
				System.out.println("Invalid Percentage"); // input validation, if a user inputs a invalid percentage
				counter++;
			}
			
			// else if statement to determine the grade form the users input 
			else if (inputGrade>69) {
				System.out.println("Grade: A");
			}
			
			else if (inputGrade>59) {
				System.out.println("Grade: B");
			}
			
			else if (inputGrade>49) {
				System.out.println("Grade: C");
			}
			
			else if (inputGrade>39) {
				System.out.println("Grade: D");
			}
			
			else if (inputGrade<38){
				System.out.println("Grade: E");
			}
			
			if(counter>=3) {
				System.out.println("You had too many tries");
				return;
			}
		}while(counter>=3);
	}
	
	/**
	 * Method to calculate upper and lower bounds, called when user selects option 2
	 */
	public void calculate_upper_lower_bounds() 
	{
		
	do {	
		System.out.println("Enter a Number"); // asks user to enter number
		lower = s.nextInt();
		
		System.out.println("Enter another Number bigger than your last number"); 
		// asks user to enter a number that is bigger than the previous number entered
		
		upper = s.nextInt();
		
		if (lower<upper) // input validation in case user inputs invalid numbers
			{
		System.out.println("Value" + "\t" + "Square" + "\t" + "Cube" + "\t" + "Square Root");
		// headings for the display
				
			for(double num = lower; num <= upper; num++) // for loop to repeat the process for how ever large of a number the user inputed
				{
			
				System.out.printf("%.2f \t", num);
				
				squared = Math.pow(num, 2);
				System.out.printf("%.2f \t", squared);
				
				cubed = Math.pow(num, 3);
				System.out.printf("%.2f \t", cubed);
				
				root = Math.sqrt(num);
				System.out.printf("%.2f \t", root);
				// calculates the x^2, x^3 and the square root of x (x being any number)
				
				System.out.println("");
			
				}	
			}
		else 
			{
			System.out.println("Invalid numbers entered. PLease enter Valid numbers");
			// displays if invalid numbers are entered
			}
		
		} while (lower>upper);
	}
	
	/**
	 * Method to calculate the total, average, maximum and minimum of numbers the user inputs(ceases when the user enters -1). 
	 * Called when the user selects option 3
	 */
	public void statistics() 
	{
		
		int[] number;
		number = new int[100]; // creates a 1D array with a limit of 100 values
		int counter = 0; // creates variable counter and sets to 0
		
		while(counter <= 99) // uses while loop to repeat process multiply times
		{
			System.out.println("Enter your number"); // asks user for a number
			number[counter] = s.nextInt();
			if (number[counter] == -1) // condition, if user enters -1 then the display method is called.
			{
				statistics_display();
				return;
			}
			counter++;
		
		
		total = 0; // sets total to 0 to gain the correct total
			
			total = IntStream.of(number).sum(); // calculates total of values entered
			
		average = 0; // sets average to 0 to gain correct average
		
			average = total/counter; // calculates average of the values the user entered
			
		max = number[0]; // sets maximum value to the first value in array
		
		int i;	// declares variable i as integer
		for(i = 0; i <= 99; i++)
				if (number[i] > max) 
				{ // finds the largest value in the lists of values the user inputed
					max = number[i];
				}
			
			
		min = number[0]; // sets minimum value to first value in array list
		i = 0; // sets i to 0
			
				if (number[i] < min) 
				{ // finds the smallest value in the list of numbers the user entered
					min = number[i];
				}
				
		i++;		
			
		}	
		statistics_display(); // calls the display method to display the total, average, max and min fields
	}
	
	/**
	 * Method to display fields from the statistics method
	 */
	public void statistics_display() {
		System.out.println("Total" + "\t" + "Average" + "\t" + "Largest Value" + "\t" + "Smallest Value"); // headings for the display
		System.out.println(total + "\t" + average + "\t" + max + "\t\t" + min + "\n"); // displays the fields in a formated fashion
	}
	
	/**
	 * Method to calculate a grade from a percentage inputed by the user, also can end if -1 is entered,
	 * called when user selects option 1
	 */
	public void calculateGrade_2() {
		
		do
		{
				System.out.println("What is your score? (Percentage)"); // asks user for a percentage
				inputGrade = s.nextInt();
				if (inputGrade == -1) {
					System.out.println("You have chose to return to the menu");
					return;
				}
				calculateGrade();
				
				
				
		} while(inputGrade>100 || inputGrade<0);
		
		
		
	}
	
}
