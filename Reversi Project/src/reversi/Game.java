package reversi;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Game extends Menu
{
	
	/**
	 * Initialise all fields for the class
	 */
	
	private Scanner s = new Scanner(System.in);
	
	int[] moves = new int[8];
	private int No_Valid_MovesPl1;
	private int No_Valid_MovesPl2;
	
	private String user_choice;
	
	private int x;
	private int y;
	
	private int score_1;
	private int score_2;
	private int total;
	
	private boolean complete = false;
	
	FileReader fileReader;
	BufferedReader bufferedReader;
	FileOutputStream outputStream;
	PrintWriter printWriter;
	private String nextLine;
		

	
	/**
	 * Method to set values of grid for start of game
	 */
	public void setGrid()
	{
		
		int a = 1;
		for(int j = 0; j<8; j++)
		{
			
			numbs[j] = a; // sets numbers for edge of the grid
			a++;

		}
		
		for(int i = 1; i<8; i++)
		{
			
			for(int j = 1; j<8; j++) 
			{
				
//				sets grid tiles to empty
				
				grid[j][i] = 0;
			
	//			sets 4 tiles in the middle for start of reversi game 
			
				if(i==4)
				{
					grid[4][i] = 1;
					grid[5][i] = 2;
				}
				
				if(i==5) 
				{
					grid[4][i] = 2;
					grid[5][i] = 1;
				
				}
			}

			
		}		
	}	
	
	
	/**
	 * Method for menu
	 */
	public void menu() {
		
		user_choice = s.nextLine();
//		takes choice from user
			
			switch(user_choice)
			{	
			case "1": setGrid(); Player_one(); // Starts a new 2 human player game
				break;
			case "2": loadGame(); //  Loads a previously saved game
				break;
			case "3": System.out.println("Program Closed");s.close(); System.exit(0); // ends the program when the user presses 3 when on the menu
				break;
			//	Displays the menu after the user comes out of the first 3 options		
			default: System.out.println("Please select another option from the menu.");
			displayGrid();
			displayMenu();
			break;	
		
			}

	}
	
	/**
	 * Method for First Player's turn
	 */
	public void Player_one()
	{
		
//		while loop to run the game until someone wins
		while(complete = true) 
		{
			
			displayGrid(); // displays the current grid
			
//			displays the player and saving information
			System.out.println(" ");
			System.out.println("Enter 0 to save and exit the game");
			System.out.println("(This will overwrite a previously saved game)");
			System.out.println(" ");
			System.out.println("Player One (X): " + "Score: " + score_1);
			
//			calls the player input method
			PlayerInput();
			
//			validation for attempted save
			if(x == 0) 
			{
				break;
			}
			
//			calls methods to validate and flip pieces if necessary for player 1
			ValidateInput();
			ValidatePlayer1();
			flipPieces_pl1();
			
//			calls method to start second player's turn at end of player one's turn 
			Player_two();
			
//			validation for attempted save
			if(x == 0) 
			{
				break;
			}
		
		}

	
	}
	
	/**
	 * Method for Second Player's turn
	 */
	public void Player_two()
	{
	
		displayGrid(); // displays the current grid
		
//		displays player information
		System.out.println("");
		System.out.println("Player Two (O): " + "Score: " + score_2);
		
//		calls player input method
		PlayerInput();
		
//		validation for attempted save
		if(x == 0) 
		{
			return;
		}
		
//		calls methods to validate and flip pieces if necessary for player 2
		ValidateInput();
		ValidatePlayer2();
		flipPieces_pl2();
		
	}
	
	/**
	 * Method that asks for x point and y point on grid
	 */
	public void PlayerInput() {
	
//		asks user for an x-coordinate
		System.out.println("Enter your x Point");
		x = s.nextInt();
		
//		if 0 is entered then the game saves
		if(x == 0) 
		{
			saveGame();
			System.out.println("Game Saved");
			System.out.println(" ");
			return;
		}
		
//		asks user for a y-coordinate
		System.out.println("Now Enter your y Point");
		y = s.nextInt();
		
//		if 0 is entered then the game saves
		if(y == 0) 
		{
			saveGame();
			System.out.println("Game Saved");
			return;
		}		
		
	}
	
	/**
	 * Validates the two inputs from user
	 */
	public void ValidateInput() 
	{
		
		boolean t = false;
		
		while(t == false) 
		{
			if(x<1 || y<1) 	//	checks if user input is within range of grid

			{
//				displays error message if a coordinate enter is out of range
				System.out.println("Sorry but that move is invalid");
//				takes user back to the player input method to re-enter their coordinates
				PlayerInput();
				
			}
			
			else if(x>8 || y>8) // checks id user input is within range of grid
			{
				
				System.out.println("Sorry but that move is invalid");
				PlayerInput();
				
			}
			
			else // if the coordinates are within range then the while loop ceases and the program moves on
			{
				t = true;
			}
			
		}
			
		
//		creates boolean for checks
		t = false;

		while(t = false) 
		{
//			checks if the grid slot if empty
			if(grid[x][y]==0)
			{
				
				t = true;
				
			}
			
			else // if occupied then an error message is displayed and the user is taken back to re-enter their coordinates
			{
				System.out.println("That move is invalid");
				PlayerInput();
			}
		
		}
		
//		initialise variable for setting moves
		int b = 1;
			
//		Stores all possible moves in a 1D array
		
			moves[0] = grid[x-b][y];
			moves[1] = grid[x-b][y-b];
			moves[2] = grid[x][y-b];
			moves[3] = grid[x+b][y-b];
			moves[4] = grid[x+b][y];
			moves[5] = grid[x+b][y+b];
			moves[6] = grid[x][y+b];
			moves[7] = grid[x-b][y+b];
		
	}
	
	/**
	 * Method to Validate moves from player one
	 */
	public void ValidatePlayer1() 
	{
				
		for(int i = 0; i<7; i++)
		{
//			checks if any of the moves around the user's slot are valid
			if(moves[i] == 2)
			{
//				if it is valid, one is added to valid moves
				No_Valid_MovesPl1++;
			}
			
		}
		
//		if their are no valid moves, e.g if valid moves = 0, then an error message displays and the user is taken back to re-enter their method
		if(No_Valid_MovesPl1 == 0) 
		{
			System.out.println("");
			System.out.println("Invalid Move, Please Re-enter your move");
			Player_one();
		}
	}
	
	/**
	 * Method to Validate moves from player two
	 */
	public void ValidatePlayer2() 
	{
				
		for(int i = 0; i<7; i++) 
		{
//			checks if any of the moves around the user's slot are valid
			if(moves[i] == 1)
			{
//				if it is valid, one is added to valid moves
				No_Valid_MovesPl2++;
			}
			
		}
//		if their are no valid moves, e.g if valid moves = 0, then an error message displays and the user is taken back to re-enter their method
		if(No_Valid_MovesPl2 == 0) 
		{
			System.out.println("");
			System.out.println("Invalid Move, Please Re-enter your move");
			Player_two();
		}
	}
	
	
	/**
	 * Method to flip pieces if the point player 1 has entered is valid 
	 */
	public void flipPieces_pl1()
	{
		
		int b = 1; // initialises local variable
		
//		checks and flips pieces in a diagonal top-left direction
		if(grid[x-b][y-b] == 2) 
		{
			
			int j = y;
			
			for(int count = x; count!=0; count--) 
			{
				if(grid[count][j] == 1) 
				{
					grid[x][y] = 1;
					
					int k = j;
					for(int i = count; i!=x; i++) 
					{
						grid[i][k] = 1;
						k++;
					}
				}
				j--;
				
				if(j==0) 
				{
					break;
				}
			}
		}
		
//		checks and flips pieces in a diagonal top-right direction
		if(grid[x+b][y-b] == 2) 
		{
			int j = y;
			
			for(int count = x; count!=8; count++) 
			{
				if(grid[count][j] == 1) 
				{
					grid[x][y] = 1;
					
					int k = j;
					for(int i = count; i!=x; i--) 
					{
						
						grid[i][k] = 1;
						k++;
					}
				}
				j--;
				
				if(j==0) 
				{
					break;
				}
			}
		}
		
//		checks and flips pieces in a diagonal bottom-right direction 
		if(grid[x+b][y+b] == 2) 
		{
			int j = y;
			
			for(int count = x; count!=8; count++) 
			{
				if(grid[count][j] == 1) 
				{
					grid[x][y] = 1;
					
					int k = j;
					for(int i = count; i!=x; i--) 
					{
						grid[i][k] = 1;
						k--;
					}
				}
				j++;
				
				if(j==8) 
				{
					break;
				}
			}
		}
		
//		checks and flips pieces in a diagonal bottom-left direction 
		if(grid[x-b][y+b] == 2) 
		{
			int j = y;
			
			for(int count = x; count!=0; count--) 
			{
				if(grid[count][j] == 1) 
				{
					grid[x][y] = 1;
					
					int k = j;
					for(int i = count; i!=x; i++) 
					{
						grid[i][k] = 1;
						k--;
					}
				}
				j++;
				
				if(j==8) 
				{
					break;
				}
			}
		}
		
//		checks and flips pieces in a vertical up direction 
		if(grid[x][y-b] == 2) 
		{
			for(int count = y; count!= 0; count--) 
			{
				if(grid[x][count] == 1) 
				{
					grid[x][y] = 1;

					for(int i = count; i!=y; i++) 
					{
						grid[x][i] = 1;
					}
				}
			}
		}
		
//		checks and flips pieces in a vertical down direction 
		if(grid[x][y+b] == 2) 
		{
			for(int count = y; count!=8; count++) 
			{
				if(grid[x][count] == 1) 
				{
					grid[x][y] = 1;

					for(int i = count; i!=y; i--) 
					{
						grid[x][i]= 1;
					}
				}
			}
		}
		
//		checks and flips pieces in a horizontal left direction 
		if(grid[x-b][y] == 2) 
		{
			for(int count = x; count!=0; count--) 
			{
				if(grid[count][y] == 1)
				{
					grid[x][y] = 1;

					for(int i = count; i!=x; i++) 
					{
						grid[i][y] = 1;
					}
				
				}
			}
		}
		
//		checks and flips pieces in a horizontal right direction 
		if(grid[x+b][y] == 2) 
		{
			for(int count = x; count!= 8; count++) 
			{
				if(grid[count][y] == 1) 
				{
					grid[x][y] = 1;

					for(int i = count; i!=x; i--) 
					{
						grid[i][y] = 1;
					}
				}
			}
		}
		
//		if nothing happens then the move is invalid and the user misses their turn
		if(grid[x][y] == 0) 
		{
			System.out.println("The move you entered is invalid");
			System.out.println("Subsequently you have missed your turn");
		}
					
//		calculates score for player 1
		score_1 = 0;

		for(int i = 1; i<9; i++) 
		{
			
			for(int j = 1; j<9; j++) 
			{
				
				if(grid[j][i] == 1) 
				{
					score_1++;
				}			
	
			}
		}
		
//		Calculates score for player 2
		score_2 = 0;

		for(int i = 1; i<9; i++) 
		{
			
			for(int j = 1; j<9; j++) 
			{
				
				if(grid[j][i] == 2) 
				{
					score_2++;
				}			
	
			}
		}
		
//		if a player has no counters left the game ends
		if(score_1 == 0) 
		{
			complete = true;
			System.out.println("Player Two Wins");
		}
		
		if(score_2 == 0) 
		{
			complete = true;
			System.out.println("Player One Wins");
		}
		
		total = 0;
		
//		calculates total score
		total = score_1 + score_2;
		
//		if total score reaches 64, the grid is full and no moves are available
		if(total>64) 
		{
//			stops while loop in player_one running again
			complete = true;
			
//			if player one has highest score then player one wins
			if(score_1 > score_2) 
			{
				System.out.println("Player One Wins");
			}
			
//			if player two has highest score then player two wins
			if(score_2<score_1) 
			{
				System.out.println("Player Two Wins");
			}
		}
		
	}
	
	/**
	 * Method to flip pieces if the point player 2 has entered is valid 
	 */
	public void flipPieces_pl2() 
	{
		
		int a = 1; // initialises local variable
		
//		checks and flips pieces in a diagonal top-left direction
		if(grid[x-a][y-a] == 1) 
		{
			
			int j = y;
			
			for(int count = x; count!=0; count--) 
			{
				if(grid[count][j] == 2) 
				{
					grid[x][y] = 2;
					
					int k = j;
					for(int i = count; i!=x; i++) 
					{
						grid[i][k] = 2;
						k++;
					}
				}
				j--;
				
				if(j==0) 
				{
					break;
				}
			}
		}
		
//		checks and flips pieces in a diagonal top-right direction
		if(grid[x+a][y-a] == 1) 
		{
			int j = y;
			
			for(int count = x; count!=8; count++) 
			{
				if(grid[count][j] == 2) 
				{
					grid[x][y] = 2;
					
					int k = j;
					for(int i = count; i!=x; i--) 
					{
						
						grid[i][k] = 2;
						k++;
					}
				}
				j--;
				
				if(j==0) 
				{
					break;
				}
			}
		}
		
//		checks and flips pieces in a diagonal bottom-right direction
		if(grid[x+a][y+a] == 1) 
		{
			int j = y;
			
			for(int count = x; count!=8; count++) 
			{
				if(grid[count][j] == 2) 
				{
					grid[x][y] = 2;
					
					int k = j;
					for(int i = count; i!=x; i--) 
					{
						grid[i][k] = 2;
						k--;
					}
				}
				j++;
				
				if(j==8) 
				{
					break;
				}
			}
		}
		
//		checks and flips pieces in a diagonal bottom-left direction
		if(grid[x-a][y+a] == 1) 
		{
			int j = y;
			
			for(int count = x; count!=0; count--) 
			{
				if(grid[count][j] == 2) 
				{
					grid[x][y] = 2;
					
					int k = j;
					for(int i = count; i!=x; i++) 
					{
						grid[i][k] = 2;
						k--;
					}
				}
				j++;
				
				if(j==8) 
				{
					break;
				}
			}
		}
		
//		checks and flips pieces in a vertical up direction
		if(grid[x][y+a] == 1) 
		{
			for(int count = y; count!= 8; count++) 
			{
				if(grid[x][count] == 2) 
				{
					grid[x][y] = 2;

					for(int i = count; i!=y; i--) 
					{
						grid[x][i] = 2;
					}
				}
			}
		}
		
//		checks and flips pieces in a vertical down direction
		if(grid[x][y-a] == 1) 
		{
			for(int count = y; count!= 0; count--) 
			{
				if(grid[x][count] == 2) 
				{
					grid[x][y] = 2;

					for(int i = count; i!=y; i++) 
					{
						grid[x][i] = 2;
					}
				}
			}
		}
		
//		checks and flips pieces in a horizontal left direction
		if(grid[x-a][y] == 1)
		{
			for(int count = x; count!=0; count--) 
			{
				if(grid[count][y] == 2) 
				{
					grid[x][y] = 2;

					for(int i = count; i!=x; i++) 
					{
						grid[i][y] = 2;
					}
				}
			}
		}
		
//		checks and flips pieces in a horizontal right direction
		if(grid[x+a][y] == 1) 
		{
			for(int count = x; count!= 8; count++) 
			{
				if(grid[count][y] == 2) 
				{
					grid[x][y] = 2;

					for(int i = count; i!=x; i--) 
					{
						grid[i][y] = 2;
					}
				}
			}
		}
		
//		if nothing happens then the move is invalid and the user misses their turn
		if(grid[x][y] == 0) 
		{
			System.out.println("The move you entered is invalid");
			System.out.println("Subsequently you have missed your turn");
		}
				
//		calculates score for player 2
		score_2 = 0;

		for(int i = 1; i<9; i++) 
		{
			
			for(int j = 1; j<9; j++) 
			{
				
				if(grid[j][i] == 2) 
				{
					score_2++;
				}			
	
			}
		}
		
//		calculates score for player 1
		score_1 = 0;

		for(int i = 1; i<9; i++) 
		{
			
			for(int j = 1; j<9; j++)
			{
				
				if(grid[j][i] == 1) 
				{
					score_1++;
				}			
	
			}
		}
		
//		calculates total score
		total = score_1 + score_2;
		
//		if total score reaches 64, the grid is full and no moves are available
		if(total>64) 
		{
//			stops while loop in player_one running again
			complete = true;
			
//			if player one has highest score then player one wins
			if(score_1 > score_2) 
			{
				System.out.println("Player One Wins");
			}
			
//			if player two has highest score then player two wins
			if(score_2<score_1) 
			{
				System.out.println("Player Two Wins");
			}
		}
	}
	
	/**
	 * Method to save the game on user command
	 */
	public void saveGame() 
	{
		
//		writes 2D array grid to a file called savedGame.txt
		try 
		{
			outputStream = new FileOutputStream("savedGame.txt");
			printWriter = new PrintWriter(outputStream);
			
//			uses for loops to write the playing portion of the 2D array grid to a text file
			for(int i = 1; i <8; i++) 
			{
				for(int j = 1; j<8; j++) 
				{
					printWriter.println(grid[i][j]);
				}
			}
		}
		
//		if error occurs then a message will be displayed
		catch(IOException e)
		{
			System.out.println("An error occured when trying to save the game");
		}
		
//		closes print writer in finally
		finally 
		{
			printWriter.close();
		}

	}
	
	/**
	 * Method to load a previously saved game
	 */
	public void loadGame()
	{
		
//		reads in data from savedGame.txt and stores in the 2D array grid
		try 
		{
			
			fileReader = new FileReader("savedGame.txt");
			bufferedReader = new BufferedReader(fileReader);
						
			nextLine = bufferedReader.readLine();
			
//			uses for loops to read in the data
			for(int i = 1; i<8; i++) 
			{
				for(int j = 1; j<8; j++) 
				{
					grid[i][j] = Integer.parseInt(nextLine); // converts nextLine to int as nextLine is a string
					nextLine = bufferedReader.readLine(); // sets variable to next line of the text file
				}
			}
			
//			closes the fileReader
			fileReader.close();

		}
		
//		if error occurs then a message will be displayed
		catch (IOException e) 
		{
			System.out.println("An error occured when attempting to load a previous save");
		}
		
//		message displays that the load was successful and calls the player_one method to continue the game
		System.out.println("Saved Game loaded");
		Player_one();

	}
	
}
