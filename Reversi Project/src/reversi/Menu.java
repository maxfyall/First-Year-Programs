package reversi;

public class Menu
{
	
	int[][] grid = new int[12][12]; //	2D array set to 10 to allow specific points to not cause errors

	int[] numbs = new int[8]; // 1D array to store numbers around edge of grid

	
	/**
	 * Displays grid at start of game and when menu is displayed
	 */
	public void displayGrid() 
	{

		System.out.print("  ");

		
		for(int i = 0; i<8; i++)
		{
			System.out.print(numbs[i]+ " "); // displays numbers around the edge of the grid
			
		}
		
		System.out.println(" ");
		
		int a = 1;


		for(int i = 0; i<8; i++) // for loop to display the grid
		{
			
			System.out.print(numbs[i]+" ");

			for(int j = 1; j<9; j++) {
				
				if(grid[j][a] == 1)
				{
					System.out.print("X"+" "); // displays an X every time there is a one in the 2D array grid
				}
				
				else if(grid[j][a] == 2) 
				{
					System.out.print("O"+ " "); // displays an O every time there is a two in the 2d array grid
				}
				else {
					System.out.print("." +" "); // displays a # every time there is anything bar a one and two
				}			
	
			}
			a++;
			System.out.println(" ");
		}

	}
		
	
	/**
	 * Displays menu
	 */
	public void displayMenu() 
	{
		System.out.println("");
		System.out.println("Please enter a number to to select an option:");
		System.out.println("1." + "Play New Game (2 player)");
		System.out.println("2." + "Load Game");
		System.out.println("3." + "Exit");
	}
	
	/**
	 * Main Method
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		Game run = new Game();
		Menu runtime = new Menu();
		
		
		run.setGrid(); // runs the set grid method  
		run.displayGrid(); // runs the display grid method
		runtime.displayMenu(); // runs the display menu method
		
		while(true) {
			
			run.menu(); // runs the menu method in a while loop to run forever until user quits 
			
		}	
	}
}
