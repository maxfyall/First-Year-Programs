
public class TreeNode {
    // fields to store the data being held in this list node
    private int id;
    private String Name;
    private double cost;
    private TreeNode right;
    private TreeNode left;

    /**
     * Default constructor. Initialise fields to default values
     */
    public TreeNode()
    {
        // set id to default / empty values 
        id = 0;
        Name = " ";
        cost = 0;
        right = null;
        left = null;
    }

    /**
     * Alternative constructor.
     *
     */
    public TreeNode(int id, String Name, double cost)
    {
        // set fields to values provided
        this.id = id;
        this.Name = Name;
        this.cost = cost;
        right = null;
        left = null;
    }

    /**
     * Get the id contained in this list node
     * 
     */
    public int getid()
    {
        return id;
    }

    
    /**
	 * @return the itemName
	 */
	public String getName() 
	{
		return Name;
	}

	/**
	 * @return the cost
	 */
	public double getCost() 
	{
		return cost;
	}

	/**
	 * @return the right
	 */
	public TreeNode getRight() 
	{
		return right;
	}

	/**
	 * @return the left
	 */
	public TreeNode getLeft() 
	{
		return left;
	}

	/**
	 * sets value of object reference right
	 * @param node
	 */
    public void setRight(TreeNode node)
    {
    	right = node;
    }
    
    /**
     * sets value of object reference left
     * @param node
     */
    public void setLeft(TreeNode node) 
    {
    	left = node;
    }
   
}
