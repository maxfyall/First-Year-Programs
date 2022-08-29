
public class Calculations 
{
	
// fields used in class
	private double answer = 0;

	/**
	 * Method to calculate sums in infix notation after conversion from RPN notation
	 */
	public void operations(String operator, double number1, double number2, List user_list) 
	{
		
		Stack reset = new Stack();
				
		switch(operator) // uses switch statement to account for all possible operators
		{
		case "+": answer = number1 + number2; // addition
			break;
		case "-": answer = number2 - number1; // subtraction
			break;
		case "*": answer = number1 * number2; // multiplication
			break;
		case "/": answer = number2 / number1; // Division
			break;
		default: System.out.println("Please select another option from the menu.");
		reset.getUser_input();

		}
		
		if(answer == Double.POSITIVE_INFINITY) // Condition in case of division by zero
		{
			System.out.println("Division by 0 is not possible, re-enter your equation");
			reset.getUser_input();
		}
				
		user_list.addToList(answer); // pushes answer of equation onto stack
		
		
	}
	
	
}
