import java.util.Iterator;
import java.util.Scanner;

/**
 * Stores a collection of DVDs and provides access to them
 * @author Iain Martin
 * @version 1.0
 */
public class DVDCollection
{
    DVDQueue dvdQueue; // a queue to store DVDs in

    /**
     * Default constructor.
     */
    public DVDCollection()
    {
        // create the DVD queue
        dvdQueue = new DVDQueue();
    }

    /**
     * A main() method to start / launch the DVD collection program
     */
    public static void main(String[] args)
    {
        // create instance of DVD collection object
        DVDCollection dvdCollection = new DVDCollection();

        // call method to display menu and start program running
        dvdCollection.processUserChoices();
    }

    /**
     * Display a menu to the user and get their (validated) choice
     * 
     * @return The user's choice
     */
    private int displayMenu()
    {
    	

        boolean validChoiceProvided = false;
        int userChoice = 0;

        // while loop repeats until a valid choice is received from the user
        while (!validChoiceProvided)
        {
            // display menu
            System.out.println(""); // empty line for formatting purposes
            System.out.println("Please select one of the following choices");
            System.out.println("1. Add a new DVD to the collection.");
            System.out.println("2. Remove a DVD from the collection and display its details.");
            System.out.println("3. Display details of all DVDs in the collection.");
            System.out.println("4. Find a DVD in your collection");
            System.out.println("5. Display the number of DVDs in the collection.");
            System.out.println("6. Exit the program.");

            // get the user's choice
            userChoice = getInt("Enter choice: ");

            // if the choice is valid
            if ((userChoice >= 1) && (userChoice <= 6))
            {
                // record that a valid choice has been received, ends while loop
                validChoiceProvided = true;  
            }
            else
            {
                // display message to user
                System.out.println("Sorry, that is not a valid choice");
            }
        }

        // return the choice provided
        return userChoice;
    }

    /**
     * Process a menu selection made by the user until they decide to exit the program.
     */
    private void processUserChoices()
    {
        boolean exitChoiceSelected = false;
        int userChoice = 0  ;

        // while loop repeats until user selects option to exit
        while (!exitChoiceSelected)
        {
            // display menu of choices to user and get their choice
            userChoice = displayMenu();

            // handle selection made by user
            switch (userChoice)
            {
                case 1:
                    // add a new DVD to the collection
                    // call method to add a new DVD
                    addDVD();
                    break;
                case 2:
                    // remove a DVD from the collection
                    // call method to remove a DVD
                    removeDVD();
                    break;
                case 3:
                    // display details of all DVDs in the collection
                    // call method to display all DVDs
                    displayCollection();
                    break;
                case 4:
                    // check if the DVD collection is empty or not
                    // call method to check if collection is empty
                    findDVD();
                    break;
                case 5:
                    // display the number of DVDs in the collection
                    // call method to display number of items in collection
                    displayNumberOfDVDsInCollection();
                    break;
                case 6: 
                    // exit the program
                    System.out.println("Program exiting, thank you....");
                    exitChoiceSelected = true;
                    break;
                default:
                // unrecognised choice
                break;
            }
        }
    }

    /**
     * Add a DVD to the end of the collection / queue
     */
    private void addDVD()
    {
        // ask the user for the title and lead actor of the DVD
        String title = getString("Please enter the title of the DVD to add to the collection: ");
        String leadActor = getString("Please enter the lead actor of the DVD: ");

        // add the DVD to the collection
        // Option 1: create a new DVD object and add it to the DVD queue
        DVD dvd = new DVD(title, leadActor);
        dvdQueue.addToQueue(dvd);

        // Option 2: call alternative add() method, providing it with the title and lead actor
        // the DVD queue itself creates a DVD object internally and adds it to the queue
        // dvdQueue.addToQueue(title, leadActor);

        // Option 3: improved robustness, check for exceptions that may occur
        /*try
        {
        dvdQueue.addToQueue(title, leadActor);
        }
        catch (Exception e)
        {
        System.out.println("Sorry, an error occurred. Unable to add a new DVD to the collection");
        }*/

    }

    /**
     * Remove a DVD from the beginning of the collection / queue and display its details
     */
    private void removeDVD()
    {
        DVD dvd; // to store the DVD which is removed

        // call method on queue object to remove and return DVD at front of queue
        dvd = dvdQueue.removeFromQueue();

        // if valid DVD retreived
        if (dvd != null)
        {
            // display the DVD details
            System.out.println("The following DVD has been removed from your collection.");
            System.out.println("DVD title: " + dvd.getTitle());        
            System.out.println("Name of lead actor: " + dvd.getLeadActor());
        }
        else
        {
            // no DVD obtained, the collection may be empty
            System.out.println("Failed to remove DVD from your collection. Your collection may be empty.");
        }
    }

    /**
     * Display all items in the collection
     */
    private void displayCollection()
    {
        // if the queue isn't empty
        if (!dvdQueue.isEmpty())
        {
            // get the iterator for the dvd queue
            Iterator<DVD> iterator = dvdQueue.getIterator();

            // while still items in the collection to iterate through
            while (iterator.hasNext())
            {
                // get the next DVD in the queue
                DVD nextDVD = iterator.next();

                // display its details
                System.out.println("Next dvd: '" + nextDVD.getTitle() + "' starring " + nextDVD.getLeadActor());
            }
        }
        else
        {
            System.out.println("Sorry, the collection is empty. No items to display");
        }
    }

    /**
     * Find a DVD in the collection, e.g. based on its title or name of lead actor
     */
    private void findDVD()
    {
        // store the title provided
        String titleToSearchFor = getString("Please enter the title of the DVD to search for: ");

        // iterate through the DVD collection until a matching DVD is found - as below

        // get an iterator for the collection
        Iterator<DVD> iterator = dvdQueue.getIterator();

        // a variable to store the DVD which is found (or not)
        DVD dvdFound = null;

        // while we haven't reached the end of the collection and DVD not found
        while ((iterator.hasNext()) && (dvdFound == null))
        {
            // get the next DVD in the queue
            DVD nextDVD = iterator.next();

            // if the title of this DVD matches the one we are looking for
            if (nextDVD.getTitle().equals(titleToSearchFor))
            {
                // store this as a the DVD found
                dvdFound = nextDVD;
            }
            else
            {
                // do nothing, we will automatically progress to the next item in the collection
            }
        }

        // if a DVD was found
        if (dvdFound != null)
        {
            // display details of DVD found            
            System.out.println("The following DVD was found in your collection.");
            System.out.println("DVD title: " + dvdFound.getTitle());        
            System.out.println("Name of lead actor: " + dvdFound.getLeadActor());
        }
        else
        {
            // inform user that no DVD was found
            System.out.println("Sorry, no DVD with that title was found");
        }
    }

    /**
     * Display the number of DVDs in the collection
     */
    private void displayNumberOfDVDsInCollection()
    {
        System.out.println("You have " + dvdQueue.getLength() + " DVDs in your collection");
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
}
