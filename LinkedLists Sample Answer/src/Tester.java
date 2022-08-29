import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Write a description of class Tester here.
 * 
 * @author AC12001 Team
 * @version January 2018
 */
public class Tester
{
    private List testlist;
    
    /**
     * Please don't write your test code directly in your main method!
     * Create an instance of your test class and then run various test methods.
     * @param args
     */
    public static void main(String args[])
    {
        Tester test = new Tester();

        test.init();
        test.process();
    }

    /**
     * Write any test initialisation code here
     */
    private void init()
    {
       testlist = new List();
    }

    
    /**
     * Process our tests
     */
    private void process()
    {
    	// We could also write some automated tests here, for example:
    	//runAutomatedTests();
    	
    	
    	// Run our test Menu
    	runTestMenu();
    }
    
    /**
     * Run automatic tests
     */
    private void runAutomatedTests()
    {
    	// Add some nodes and print out the list:
    	testlist.printList();
    	testlist.addToList("20181", 50);
    	testlist.printList();
    	testlist.addToList("20182", 75);
    	testlist.printList();
    	testlist.addToList("20183", 101);
    	testlist.printList();
    }
    

    /**
     * Display a menu, validate the user's input and return the choice they made
     * 
     * @param   none
     * @return  char x, the validated choice made by the user
     */
   private void runTestMenu()
    {
        String choice;
        boolean exit=false;
        
        do
        {
            System.out.println("List test Menu");
            System.out.println("A - add a student");
            System.out.println("F - find a student");
            System.out.println("P - print the list");
            System.out.println("T - run automated tests");
            System.out.println("Q - quit");        
            
            choice=getString("Please make a choice, and press ENTER: ");
        
            switch (choice)
            {
                case "A":
                case "a":
                	add();
                	break;
                case "P":
                case "p":
                	testlist.printList();
                	break;
                case "F":
                case "f":
                	find();
                	break;
                case "T":
                case "t":
                	runAutomatedTests();
                	break;
                case "Q":
                case "q": 
                	System.out.println("Goodbye\n");
                      exit=true;
                        break;
                default: System.out.println("That is not a valid choice, please try again");
                        break;         
            }
        }while (!exit);
    }
   
    
   
    /**
     * Add - user has chosen add, take student code & exam mark, and add to list
     * 
     * @param   none
     * @return  none
     */
    private void add()
    {
        String student;
        boolean valid;
        int mark;
        
        student = getString("Please type in student's ID: ");

        valid=false;

        do
        {
           mark=getInt("Now type in their mark");

            if (mark>100 || mark < 0)
                  System.out.println("Mark must be between 0 and 100, enter mark again please");
            else
                  valid = true;
         } while (!valid);

        testlist.addToList(student, mark);
     }

     /**
     * Find - ask user for a student code & show the mark
     * 
     * @param   none
     * @return  none
     */
    private void find()
    {
        String student;
        ListNode foundNode;
        
        student = getString("Please type in student's ID: ");
        foundNode = testlist.findInList(student);
        
        if (foundNode != null)
            System.out.println("Student got " + foundNode.getMark());
        else
            System.out.println("Student not in the list");     
     }
    
    
    /**
     * Uses Scanner to get a new String from the user
     */
    public String getString(String userPrompt)
    {
    	Scanner s = new Scanner(System.in);
		System.out.print(userPrompt);
		while (!s.hasNext())
		{
			s.next();
			System.out.print(userPrompt);
		}
		
		return s.next();
    }
    
    /**
	 * Uses Scanner to obtain an integer input
	 * Uses Scanner's hasNextInt() method to check that a valid int
	 * has been inputed. One issue is that lines of text with spaces will
	 * result in unneeded prompts but the program does not crash with invalid input
	 * @return Returns the number inputed by the user
	 */
	public int getInt(String userPrompt)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.print(userPrompt);
		while (!s.hasNextInt())
		{
			s.next();
			System.out.print(userPrompt);
		}
		
		int num = s.nextInt();
		return num;
	}
	
	/**
	 * Uses Scanner to obtain an integer input
	 * Catches the exception thrown if a non-integer is entered
	 * by the user then reads and discards the non-integer text
	 * and tries again until a valid int is entered.
	 * @return Returns the number inputed by the user
	 */
	public int getIntException(String userPrompt)
	{
		int num = 0;
		boolean valid = false;
		Scanner s = new Scanner(System.in);
		
		// Loop until we get a valid int input from the user
		do {
			try {
				System.out.print(userPrompt);
				num = s.nextInt();
				valid = true;
			}
			catch (InputMismatchException e)
			{
				// Read and discard the invalid input
				s.next();
				System.out.println("Please enter a valid integer:");
			}
		} while (!valid);
	
		return num;
	}
}
