/**
 * Lab 1
 * 
 * @author AC12001 Team
 * @version January 2018
 */
public class List 
{
    private ListNode head;
    
    /**
     * Constructor for objects of class List
     * Create a head
     */
    public List()
    {
        head = null;
    }

     /**
     * Add a new node at the start of a list
     * 
     * @param student Student name or ID
     * @param mark Student mark  
     */
    public void addToList(String student, int mark)
    {
        ListNode  marker;
        ListNode  newOne;
        
        newOne = new ListNode(student, mark);        
        newOne.setNext(head);
        
        head = newOne;
    }
 
    /**
     * Print the list, starting at head
     */
     public void printList()
     {
        ListNode marker;

        if (head == null)
        {
        	System.out.println("The list is empty.");  
        }
        else
        {
	        System.out.println("The list contains:");    
	        for (marker = head; marker != null; marker=marker.getNext())
	        {
	              System.out.println(marker.printInfo());  
	        }
        }
    }

   /**
     * Find a node
     * 
     * @param  student Student to find
     * @return node if found, else null
     */
     public ListNode findInList(String student)
    {
        ListNode marker, foundNode=null;
        
        for (marker = head; marker != null && foundNode == null; marker=marker.getNext())
        {
            if (student.equals(marker.getStudent()))
            {
                foundNode = marker;
            }
        }

         return foundNode;  
    }
}

