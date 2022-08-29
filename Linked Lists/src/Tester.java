
public class Tester 
{
	
	private List myList;
	
	public Tester() 
	{
		myList = new List();
	}
	
	
	public static void main(String[] args) 
	{
		Tester run = new Tester();
		
		run.initialise();
		run.processes();
		
	}
	
	public void initialise() 
	{
		myList.addToList("03124", 25);
		myList.addToList("03125", 75);
	}
	
	public void processes() 
	{
		myList.printList(id, mark);
	}
}
