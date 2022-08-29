import java.util.Scanner;

public class Shop {

	private Scanner a = new Scanner(System.in); // imports scanner the get inputs from keyboard
	Scanner b = new Scanner(System.in); // uses second scanner to avoid errors with differing data types
	
	private Tree userTree = new Tree(); // creates instance of tree class

	/**
	 * Method to get data for adding to tree
	 */
	public void getItemToAdd()
	{
		boolean found = false; // creates boolean
		
		int itemID; // creates integer for storing data
		System.out.println("Enter the item ID: "); // asks user for input
		itemID = a.nextInt(); // gets input from keyboard
		
		String itemName; // creates string for storing data
		System.out.println("Enter the item name: "); // asks for input
		itemName = b.nextLine(); // gets input from keyboard
		
		double itemCost; // creates double for storing data
		System.out.println("Enter the cost of the item: "); // asks user for input
		itemCost = a.nextDouble(); // gets input from keyboard
		
		found = userTree.addToTree(itemID, itemName, itemCost); // stores data returned from method in boolean (passes in values from user)
		
//		validation for duplicate items
		if(found == true) // if method returns true then item is already in tree
		{
			System.out.println("The item you added is already in the tree"); // display message and return user to menu
			System.out.println("Please try again");
		}
		else // if returns false then item is not in list
		{
			System.out.println("Item Added"); // confirm item is added
		}
		
	}
	
	/**
	 * Method for calling the print total cost method
	 */
	public void callPrintTreeCost() 
	{
		userTree.printTotalCost(); // calls the print total tree cost method
	}
	
	/**
	 * Method for calling the print tree method
	 */
	public void callPrintTheTree()
	{
		userTree.printTree(); // calls the print tree method
	}
	
	/**
	 * Method for getting data to find in the tree
	 */
	public void getUserFindItem()
	{
		System.out.println("Please enter the ID of the item:"); // asks user for input
		int findID = a.nextInt(); // creates integer to store input from keyboard
		
		int data = userTree.findItemTree(findID); // stores returned value from method in variable (passes in value to find)
		
		if(findID != data) // if value returned is not equal to value user is looking for
		{
			System.out.println("The item you are looking for is not present (the tree may be empty)"); // display message
			System.out.println("Please try again");
		}
		else // if value is found then
		{
			System.out.println("Item Found!"); //confirm value is found
			userTree.printNode(); //calls print node method to print the node found
		}
	}
	
	/**
	 * Method to get data for deleting an item
	 */
	public void getDeleteItem() 
	{
		int deleteID; // creates variable
		
		System.out.println("Please enter the ID of the item you wish to remove:"); // asks user for input
		deleteID = a.nextInt(); // gets input from keyboard and stores in variable
		
		userTree.deleteNode(deleteID); // calls the delete node method
	}
	
	
}
