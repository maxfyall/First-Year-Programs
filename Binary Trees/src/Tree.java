public class Tree {

//	fields used in class
	private TreeNode root;
	private TreeNode newNode;
	private TreeNode node_to_print;
	private TreeNode node_to_delete;
	private TreeNode track_prev;
	private double total_cost;

	/**
	 * Default constructor. Initialise fields to default values.
	 */
	public Tree() {
		root = null;
	}

	/**
	 * 
	 * @return the root
	 */
	public TreeNode getroot() {
		return root;
	}

	/**
	 * Set the 'root' of the tree to the given node
	 * 
	 */
	public void setroot(TreeNode newRoot) {
		root = newRoot;
	}

	/**
	 * Method to add items into the tree
	 * 
	 * @param id
	 * @param Name
	 * @param cost
	 * @return found
	 */
	public boolean addToTree(int id, String Name, double cost) {
//		initialising fields and variables
		TreeNode current = root; // sets current to root

		TreeNode previous = null; // sets previous to null

		boolean found = false; // creates boolean and sets to false

		newNode = new TreeNode(id, Name, cost); // creates new node and stores values passed in from method in shop
												// class

		total_cost = total_cost + newNode.getCost(); // adds value of field cost to global variable to work out the total cost of the tree

		if (root == null) // if list is empty
		{
			root = newNode; // set new node to the root of the list
			found = false; // set found to false
			return found; // return false
		}

		else // if root is not null
		{
			if (newNode.getid() == findItemTree(0)) // check node isn't already in list already by calling find method
			{
				found = true; // if item is found then set found to true
				return found; // return true
			} 
			else // item is not in the list
			{
				while (current != null) // start while loop, while current is not null
				{
					previous = current; // keeps track of previous node, sets previous to current

					if (newNode.getid() < current.getid()) // if id of newNode is less than the id of the current node
					{
						current = current.getLeft(); // set current to currents left
					} 
					else // if not
					{
						current = current.getRight(); // set current to currents right
					}
				}

//				when loop finishes
				if (newNode.getid() < previous.getid()) // check if id of new node is less than the id of the previous
														// node
				{
					previous.setLeft(newNode); // if so then previous left to the new node (add the node essentially)
				} else // else
				{
					previous.setRight(newNode); // set new node to previous right
				}

				return found = false; // return false
			}
		}
	}
	
	/**
	 * Method to find an item in the tree
	 * @param findID
	 * @return
	 */
	public int findItemTree(int findID) 
	{
		TreeNode findNode;
		findNode = root; // sets findNode to root
		int data = 0; // creates variable

		while (findNode != null) // starts while loop, while findNode is not null 
		{
			data = findNode.getid(); // sets variable to id of findNode

//			method is used to check two things, if a duplicate is in list and to find an item in the list
			if (data == newNode.getid() || data == findID) // if data is equal to either the newNode id or the passed in data
			{
				node_to_print = findNode; // stores node needed for printing in other method
				node_to_delete = findNode; // stores node needed for deleting in other method
				return data; // returns data
			} 
			else // else
			{
				if (findID == 0) // if findID equals 0 (if find method hasn't been called from user find method in shop class)
				{
//					run this code
					if (newNode.getid() < data) // if if from new node id is less than data
					{
						findNode = findNode.getLeft(); // go left
					} 
					else // else
					{
						findNode = findNode.getRight(); // go right
					}
				} 
				else // else
				{
//					run this code
					if (findID < data) // if data passes is less than data 
					{
						track_prev = findNode; // store current as previous

						findNode = findNode.getLeft(); // go left
					} 
					else //else
					{
						track_prev = findNode; // store current as previous

						findNode = findNode.getRight(); // go right
					}
				}
			}
		}

		return 0; // if nothing is found return 0
	}
	
	/**
	 * Method to print the contents of the tree using in-order traversal 
	 */
	public void printTree() 
	{
		System.out.println("All items in the tree currently:"); // prints heading
		TraverseTree(root); // calls traverse tree method
	}

	/**
	 * Method to print the contents of node
	 */
	public void printNode() 
	{
		System.out.println("Item Name: " + node_to_print.getName()); // prints the name of the item
		System.out.println("Item Cost: " + node_to_print.getCost()); // prints the cost of the item
	}

	/**
	 * Method to print the total cost of the tree
	 */
	public void printTotalCost() 
	{
		System.out.println("The total cost of the tree is £" + total_cost); // prints the total cost inside a message
	}

	/**
	 * Recursive method to print out the tree
	 * @param current
	 */
	public void TraverseTree(TreeNode current) 
	{
		if (current != null) // if current is not null
		{
//			checks the left side of the tree
			if (current.getLeft() != null) // if left of current is not null
			{
				TraverseTree(current.getLeft()); // call the method and pass in left of current
//				this will repeat until there are no more nodes on the left side of the tree
			}
//			prints the items
			System.out.println("ID: " + current.getid() + "  " + "Item Name: " + current.getName() + "  " + "Cost: "
					+ current.getCost());

//			checks the right side of the tree
			if (current.getRight() != null) // if right of current is not null
			{
				TraverseTree(current.getRight()); // call the method and pass in right of current
			}
		}
	}

	/**
	 * Method to find the most right node on the left side of the tree (used for delete method)
	 * @return
	 */
	public TreeNode findMostRight() 
	{
		// initialises variables
		TreeNode find = null;
		TreeNode prev2 = null;

		find = node_to_delete.getLeft(); // sets find to left of node to delete

		while (find != null) // starts while loop, while find is not null
		{
			prev2 = track_prev; // store the previous of the previous

			track_prev = find; // stores previous of find

			find = find.getRight(); // sets find to right of find
		}

		find = track_prev; // sets find to previous as find is null when loop finishes
		track_prev = prev2; // sets previous to the previous of find

		return find; // return find
	}
	
	/**
	 * Method to delete a node
	 * @param deleteID
	 */
	public void deleteNode(int deleteID) 
	{
		int info = 0; // creates variable

		info = findItemTree(deleteID); // stores returned data from method in variable

		TreeNode previous = track_prev; // stores data from find method in variables for use in method
		TreeNode current = node_to_delete;

		if (info != deleteID) // if data returned from find method is not equal to the data passed in from the method in shop class
		{
			System.out.println("This item cannot be deleted because it does not exist"); // display error message as item user wants to deletes is not present
			System.out.println("Please try again");
		}
		
		else // else find out which type of delete should take place
		{
			
//			delete a leaf
			if (current.getLeft() == null && current.getRight() == null) // if left and right of node are equal to null
			{
//				run this code
				
				if (previous == null) // checks if previous is null (i.e. node to delete is the root) 
				{
					setroot(null); // set root to null
				} 
				else // if previous is not null then
				{
					if (previous.getLeft() == current) // check if left of previous is equal to current 
					{
						previous.setLeft(null); // set left of previous to null
					}
					else // if left of previous is not equal to current then
					{
						previous.setRight(null); // set right of previous to null
					}
				}
				
//				print the node that was deleted
				System.out.println("Item Removed: ");
				System.out.println(" ");
				System.out.println("Item ID: " + current.getid());
				System.out.println("Item Name: " + current.getName());
				System.out.println("Item Cost: " + current.getCost());
			}

//			delete a node with one node attached on left
			if (current.getRight() == null && current.getLeft() != null) // if right of node is equal to null and left of current is not null then
			{
				if (previous.getLeft() == current) // check if left of previous is equal to current
				{
					previous.setLeft(current.getLeft()); // if so set left of previous to left of current
				} 
				else // if not true
				{
					previous.setRight(current.getLeft()); // set right of previous to left of current
				}

//				print the contents of the deleted node to show what node was deleted
				System.out.println("Item Removed: ");
				System.out.println(" ");
				System.out.println("Item ID: " + current.getid());
				System.out.println("Item Name: " + current.getName());
				System.out.println("Item Cost: " + current.getCost());
			}

//			delete a node with 1 node attached on right
			if (current.getRight() != null && current.getLeft() == null) // if right of node is not null and left of current is equal to null then
			{
				if (previous.getLeft() == current) // check if left of previous is equal to current
				{
					previous.setLeft(current.getRight()); // if so set left of previous to right of current
				} 
				else // otherwise
				{
					previous.setRight(current.getRight()); // set right of previous to right of current
				}
				
//				print contents of deleted node
				System.out.println("Item Removed: ");
				System.out.println(" ");
				System.out.println("Item ID: " + current.getid());
				System.out.println("Item Name: " + current.getName());
				System.out.println("Item Cost: " + current.getCost());
			}

//			deleting a node with 2 nodes attached
			if (current.getRight() != null && current.getLeft() != null) // if right and left of current are not null
			{
				// set variables
				TreeNode previousToDelete = track_prev;
				
				TreeNode replace = findMostRight(); // find the replacement for the deleted node by calling the find most right method

				previous = track_prev;

				// run checks on the replacement node to delete the replacement node from its original place
				if (replace.getLeft() == null && replace.getRight() == null) 
				{
					if (previous.getLeft() == replace) 
					{
						previous.setLeft(null);
					} 
					else 
					{
						previous.setRight(null);
					}
				}

				if (replace.getRight() == null && replace.getLeft() != null) 
				{
					if (previous.getLeft() == replace) 
					{
						previous.setLeft(replace.getLeft());
					} 
					else 
					{
						previous.setRight(replace.getLeft());
					}

				}

				if (current.getRight() != null && current.getLeft() == null) 
				{
					if (previous.getLeft() == current) 
					{
						previous.setLeft(current.getRight());
					} 
					else 
					{
						previous.setRight(current.getRight());
					}
				}
				
//				print the contents of the deleted node
				System.out.println("Item Removed: ");
				System.out.println(" ");
				System.out.println("Item ID: " + current.getid());
				System.out.println("Item Name: " + current.getName());
				System.out.println("Item Cost: " + current.getCost());

//				set the left and right of the replacement node to the left and right of the deleted node
				replace.setLeft(current.getLeft());
				replace.setRight(current.getRight());

				if (previousToDelete == null) // if previous off deleted node is null (deleted node is the root)
				{
					setroot(replace); // replace the root with the replacement node
				} 
				else // otherwise
				{
					previousToDelete.setLeft(replace); // replace the node to delete with the replacement node.
				}
			}

		}

	}

}
