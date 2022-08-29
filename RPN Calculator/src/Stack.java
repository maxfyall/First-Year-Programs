import java.util.Scanner;

public class Stack {

//	fields used in class
	private Scanner s = new Scanner(System.in);
	private String problem;
	private String operator;
	private double number1;
	private double number2;
	private double pushNumber;
	private double popNumber;
	boolean condition = false;

	
	protected List user_list = new List();
	Calculations next = new Calculations();

	/**
	 * Method to get input from user and validate it
	 */
	public String[] getUser_input()
	{
		System.out.println(" ");
		System.out.println("Enter your Equation"); // asks user for input
		
		problem = s.nextLine(); // stores user input as a string
		
		String[] split_array = problem.split(","); // splits the user input into an array of strings
		
		int count = 0;
		int i = 0;
		
		
		try // uses try and catch to avoid a crash in the program
		{
			while(count == 0) 
			{
				
				if(split_array[i].equals("+") || split_array[i].equals("-") || split_array[i].equals("*") || split_array[i].equals("/"))
//					checks if the input from the user is valid by checking for operators
				{
					count++;	
				}
				
				i++;	

			}
		
		}
		
		catch(Exception e) // In case of error, message will be displayed and will be returned to input screen
		{
			System.out.println("An Error Occured");
			getUser_input();
		}
		
		if(count == 0) // if no operator is detected then error message will display
		{
			System.out.println("Invalid input, no operator was detected, please input a valid equation");
			getUser_input();
		}
		
		push(split_array); // calls push method
		
		return split_array; // returns array
		
		
	}
	
	/**
	 * Method to push numbers onto the Stack
	 */
	public String push(String[] split_array) 
	{
		int i = 0;
		
		for(i = 0; i < split_array.length; i++) 
		{
			
			if(split_array[i].equals("+") || split_array[i].equals("-") || split_array[i].equals("*") || split_array[i].equals("/"))
//				checks for operators to see when to stop and call pop method to apply the operator
			{
				operator = split_array[i]; // assigns the operator to a field to store it
				pop(); // calls the pop method
			}
			
			else 
			{
				
				pushNumber = Double.parseDouble(split_array[i]); // converts strings in array to doubles
				
				user_list.addToList(pushNumber); // adds converted strings into the stack
				
				if(operator == null & i == 3) // check if no operator after 2 numbers
				{
					System.out.println("Invalid Input, Please re-enter your equation"); // Error message displays if condition is met
					getUser_input();
				}
				
			}	
			
		}
		
		popList(); // calls popList method
	
		condition = user_list.isListempty(condition); // checks if list is empty
		
		if(condition == true)
		{
			displayAnswer(popNumber); // calls display answer method

		}
		
				
		return operator; // returns operator field
		
	
	}
	
	/**
	 * Method to pop data from the stack
	 */
	public double pop() 
	{
		try 
		{
			number1 = user_list.deleteFromStack(number1, number1); // pops first number
			number2 = user_list.deleteFromStack(number2, number2); // pops second number
			
			next.operations(operator, number1, number2, user_list); // calls operations method to carry out sums

		}
		
		catch(Exception e)
		{
			System.out.println("An Error Occured"); // Displays error message if exception occurs
			getUser_input(); // takes user to user input method
		}
		
		return number1 + number2; // returns the two popped numbers


	}
	
	/**
	 * Method to pop the final piece of data from the stack
	 */
	public double popList() 
	{
		try 
		{
			popNumber = user_list.deleteFromStack(popNumber, popNumber); // pops the last piece of data from the stack
		}
		catch(Exception e) 
		{
			System.out.println("An Error Occured"); // displays error message if exception occurs
			getUser_input();
		}
		
		return popNumber; // returns popped number
	}
	
	/**
	 * Method to display the answer of the users problem.
	 */
	public void displayAnswer(double popNumber)
	{
		System.out.println(" ");
		System.out.println("The answer is " + popNumber); // displays the answer which should be last data on stack
		System.out.println(" ");
		System.out.println("Press Enter to Continue"); // displays message for next steps
	}
	
}
