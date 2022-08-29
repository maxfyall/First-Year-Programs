package FilesExcersie;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.io.PrintWriter;


public class Files extends Collection {
	
	/**
	 * Initialise fields for class
	 */
	
	private String readInput;
	private String fileName;
	private String encryptFile;
	private String decryptedFile;
	private String user_choice;
	private String decision;
	
	FileReader fileReader;
	BufferedReader bufferedReader;
	FileOutputStream outputStream;
	PrintWriter printWriter;
	
	private String nextLine;
	
	private Scanner s = new Scanner(System.in);
	private boolean found;

	private static final String crypt1 = "cipherabdfgjk";
	private static final String crypt2 = "lmnoqstuvwxyz";
	private static String decryptedString;
	
	/**
	 * Main Method
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		Files run = new Files();
		
//		run.getFilename_read();
//		run.writeFile();
//		run.copyFile();			commented out run methods to prevent from running unnecessary methods
//		run.decipherFile();
//		run.processData();
		
		run.displayMenu();
		
		while(true) {
			
			run.menu();	
		}
	}

	/**
	 * Method to decipher the mystery text file
	 * @param text
	 * @return
	 */
	
	private static String cipherDecipherString(String text)
	{
	    // declare variables we need
	    int i, j;
	    boolean found = false;
	    String temp="" ; // empty String to hold converted text

	    for (i = 0; i < text.length(); i++) // look at every character in text
	    {
	        found = false;
	        if ((j = crypt1.indexOf(text.charAt(i))) > -1) // is char in crypt1?
	        {           
	            found = true; // yes!
	            temp = temp + crypt2.charAt(j); // add the cipher character to temp
	        } 
	        else if ((j = crypt2.indexOf(text.charAt(i))) > -1) // and so on
	        {
	            found = true;
	            temp = temp + crypt1.charAt(j);
	        }

	        if (! found) // to deal with cases where char is NOT in crypt2 or 2
	        {
	            temp = temp + text.charAt(i); // just copy across the character
	        }
	    }
	    decryptedString = temp;
	    return temp;
	}
	
	/**
	 * Method to read in data from details.txt
	 */
	
	public void getFilename_read() {
		
		System.out.println("Enter the name of the file to read from");
		readInput = s.nextLine();
//		asks user for name of file to read from 
		
//		reads in data from file if file exists. Returns error message if no file found
		try {
			
			fileReader = new FileReader(readInput);
			bufferedReader = new BufferedReader(fileReader);
			
			nextLine = bufferedReader.readLine();
			while (nextLine != null)
			{
			   System.out.println(nextLine);
			   nextLine = bufferedReader.readLine();
			   
			}

			bufferedReader.close();

		} 
		
		catch (IOException e) 
		{
			System.out.println("Sorry an error occured");
			getFilename_read();
		}
		
	}
	
	
	/**
	 * Method to write to file
	 */
	
	public void writeFile() {
		
		String[] writeInput = new String[1000];
		int count = 0;
		found = false;
//		declares variables for using in method
			
		do
		{
			System.out.println("PLease Enter something to write to a file");
			writeInput[count] = s.nextLine();
//			asks user to enter a string to write to file, stores in array of strings
			
				if (writeInput[count].equals(""))
				{
				found = true;
				}
				
			count++;	
				
		} while(found == false);
//		checks if user enters a blank string, if so the method ceases and writes the contents of array to file.
			
			count--;
//			take 1 away from counter to prevent "null" from printing to file
			
//			writes contents of string array to file called fileWrite.txt
				try 
				{
					outputStream = new FileOutputStream("fileWrite.txt");
					printWriter = new PrintWriter(outputStream); 
					
					printWriter.println("This is the file I have written to, and here is what i wrote to the file:");
					
					for (int i = 0; i <= count; i++) 
					{
					printWriter.println(writeInput[i] + "");
					
					} 
				}
				
				catch (IOException e) 
				{
					System.out.println("Sorry an error occured");
					writeFile();
				}
				
				finally 
				{
					printWriter.close();
				}
		
	}
	
	/**
	 * Method that copies contents of file and prints it to another file
	 */
	
	public void copyFile() {
		
		System.out.println("Enter the name of the file to read from");
		readInput = s.nextLine();
		
		System.out.println("Enter a filename to write to (Ensure you use .txt at the end)");
		fileName = s.nextLine();
//		asks the user to enter a filename to read from and a filename to write to
		
//		reads in contents from one file, then prints those contents to a different file of the users choice
		try {
			
			fileReader = new FileReader(readInput);
			bufferedReader = new BufferedReader(fileReader);
			
			outputStream = new FileOutputStream(fileName);
			printWriter = new PrintWriter(outputStream);
			
			nextLine = bufferedReader.readLine();
			printWriter.println("This is a copyied file, here is what was copyied:");
			
			while (nextLine != null)
			{
			   System.out.println(nextLine);
			   printWriter.println(nextLine + "");
			   nextLine = bufferedReader.readLine();
			   
			}

			bufferedReader.close();
			printWriter.close();


		} 
		
		catch (IOException e) 
		{
			System.out.println("Sorry an error occured");
			copyFile();
		}
	
	}
	
	/**
	 * Method to decipher hidden message in mystery.txt 
	 */
	
	public void decipherFile() 
	{
		System.out.println("Enter the name of the file to decipher");
		encryptFile = s.nextLine();
		
		System.out.println("Enter the name of the decrypted file (Ensure you use .txt at the end)");
		decryptedFile = s.nextLine();
//		asks user to enter name of file to decipher(mystery.txt) and the filename for the deciphered file
		
//		reads in data from file, deciphers the file, then prints the message to a file
		try {
			
			fileReader = new FileReader(encryptFile);
			bufferedReader = new BufferedReader(fileReader);
			
			outputStream = new FileOutputStream(decryptedFile);
			printWriter = new PrintWriter(outputStream);
			
			nextLine = bufferedReader.readLine();
			printWriter.println("This is the decrypted file, here is the decrypted message:");
			
			while (nextLine != null)
			{
				cipherDecipherString(nextLine);
//				user decipher method to decipher the text file
				
			   System.out.println(decryptedString);
			   printWriter.println(decryptedString + "");
			   nextLine = bufferedReader.readLine();
			   
			}
				
			bufferedReader.close();
			printWriter.close();
			System.out.println("");
			System.out.println("Press Enter to Continue");
		} 
		
		catch (IOException e) 
		{
			System.out.println("Sorry an error occured");
			decipherFile();
		}
		
		if(nextLine != null) {
			
			System.out.println("");
			displayMenu();
//			calls menu method to display the menu when decipher method is finished
		}
	
	
	}
	
	/**
	 * Method to calculate average of data from details.txt
	 */
	
	public void processData() 
	{
		
//		declares variables for use in method
	int[] numbers = new int[6];
	int count = 0;
	int x = 0;
	float[] average = new float[6];
		
	
//	reads in data from details.txt into an array of individual strings, converts the numbers in those strings to integers then calculates
//	the average from those numbers for
	try {
			
			fileReader = new FileReader("details.txt");
			bufferedReader = new BufferedReader(fileReader);
			
			outputStream = new FileOutputStream("Processed_Details.txt");
			printWriter = new PrintWriter(outputStream);
			
			nextLine = bufferedReader.readLine();
			printWriter.println("Proceesed Data from details.txt:");

			while (nextLine != null)
			{ 
				
				String[] detailsArray = nextLine.split(" ");
//				uses string.split() to split 
				
				count = 0;
				for(int i = 2; i<=6; i++) 
				{
					numbers[count] = Integer.parseInt(detailsArray[i]);
					count++;
//					reads in numbers from the array of split up strings
				}
				
				average[x] = IntStream.of(numbers).sum()/5;
//				calculates average of array of numbers
				
				System.out.println(detailsArray[1]+", "+detailsArray[0] + " Final Score is " + average[x] + "");
				printWriter.println(detailsArray[1]+", "+detailsArray[0] + " Final Score is " + average[x] + "");
				x++;
//				prints array of averages to file and screen

			   nextLine = bufferedReader.readLine();  
			}
			
			bufferedReader.close();
			printWriter.close();

		} 
		
		catch (IOException e) 
		{
			System.out.println("Sorry an error occured");
			getFilename_read();
		}
	
		finally 
		{
			System.out.println("");
			displayMenu();
//			displays menu after method is finished
		}
		
	}
	
	/**
	 * Method to display a menu for the user to select from when the program is launched
	 */
	
	public void displayMenu() 
	{
		System.out.println("Please enter 1, 2 or 3 to select:");
		System.out.println("1." + "Decipher mystery.txt");
		System.out.println("2." + "Process details.txt");
		System.out.println("3." + "Check if file exists(if so read it in)");
		System.out.println("4." + "Writes a 2D array to a file");
		System.out.println("5." + "Read and Write an Collection of DVDs");
		System.out.println("6." + "Exit");
	}
	
	/**
	 * Method for navigation between methods(decipher a file and process data)
	 */
	public void menu() 
	{
		
		user_choice = s.nextLine();
//		takes choice from user
			
			switch(user_choice)
			{	
			case "1": decipherFile(); // takes user to the decipher file method to decipher the mystery file
				break;
			case "2": processData(); // takes user to process data method where data in details.txt will be processed 
				break;
			case "3": fileExist(); // takes user to the fileExist method where it will check if a file exists within the directory 
				break;
			case "4": twoDarray(); // takes the user to a method that writes a 2D array to a file 
				break;
			case "5": arrayObjects(); // takes the user to a method that writes a collection of DVDs to a file and then reads them back in. 
				break;
			case "6": System.out.println("Program Closed");s.close(); System.exit(0); // ends the program when the user presses 3 when on the menu
				break;
			//	Displays the menu after the user comes out of the first 3 options		
			default: System.out.println("Please select another option from the menu.");
			displayMenu();
			break;	
			
		}
		
	}
	
//	Optional Extras
	
	/**
	 * Optional Extra - Check if file exists
	 */
	
	public void fileExist() 
	{
		System.out.println("Enter the name of the file to read from");
		readInput = s.nextLine();
//		asks user for name of file to read from 
		
		
		try {
			
			fileReader = new FileReader(readInput);
			bufferedReader = new BufferedReader(fileReader);
			
			nextLine = bufferedReader.readLine();
			
			if(nextLine != null) {
//			checks if file is readable, checking if there is anything in the file
				while (nextLine != null)
				{
				   System.out.println(nextLine);
				   nextLine = bufferedReader.readLine();

				}
				
			}
			else {

				System.out.println("The file you entered is unreadable");
				fileExist();
//				if file is unreadable then print error message and enter another filename
				
			}
			
			bufferedReader.close();
			System.out.println("");
			System.out.println("Press Enter to Continue");

		} 
		
		catch (IOException e) 
		{
			System.out.println("An Error Occured, The filename you entered may not exist, please try again");
			fileExist();
		}
	}
	
	/**
	 * Optional Extra - Write a 2D array to a file
	 */
	public void twoDarray() 
	{
		int[][] numbers = new int[3][3];
		
		numbers[0][0] = 12;
		numbers[0][1] = 1;
		numbers[0][2] = 13;
		numbers[1][0] = 234;
		numbers[1][1] = 121;
		numbers[1][2] = 4;
		numbers[2][0] = 9;
		numbers[2][1] = 21;
		numbers[2][2] = 19;
//		set values in 2D array

		try 
		{
			outputStream = new FileOutputStream("arrayWrite.txt");
			printWriter = new PrintWriter(outputStream); 
			
			printWriter.println("This is a 2D array that was written to a file:");
			
			for (int i = 0; i <= 2; i++) 
			{
			printWriter.println(numbers[0][i] + "");
			printWriter.println(numbers[1][i] + "");
			printWriter.println(numbers[2][i] + "");
			System.out.println(numbers[0][i] + "");
			System.out.println(numbers[1][i] + "");
			System.out.println(numbers[2][i] + "");
//			Print values of array to file and to the screen
			} 
			
			printWriter.close();
			System.out.println("");
			System.out.println("This 2D array was wriiten to a file");
			System.out.println("Press Enter to Continue");
		}
		
		catch (IOException e) 
		{
			System.out.println("Sorry an error occured");
			twoDarray();
		}
	}
	
	/**
	 * Method to write and then read a collection of DVDS
	 */
	
	public void arrayObjects() {
		
//		Collection runCollection = new Collection();
//		
//		runCollection.setData();
////		gets info about the DVDS
//		
//		int i = 0;
//		
//		try 
//		{
//			outputStream = new FileOutputStream("DVDs.txt");
//			printWriter = new PrintWriter(outputStream);
//			
//			printWriter.println("DVD Collection:");
//			
//			while (CollectionDVD[i] != null)
//			{
//			   printWriter.println(CollectionDVD[i] + "");
//			   i++;
//			}
//	
//			printWriter.close();
////			Writes to file
//			
//		} 
//		
//		catch (IOException e) 
//		{
//			System.out.println("Sorry an error occured");
//			copyFile();
//		}
//		 
//		System.out.print("Do you wish the read in the DVDs to a Collection? (Y/N)");
//		decision = s.nextLine();
////		asks user if they want to read it in
//		
//		if (decision != "N") 
//		{
//			
//			try {
//				
//				fileReader = new FileReader("DVDs.txt");
//				bufferedReader = new BufferedReader(fileReader);
//				
//				nextLine = bufferedReader.readLine();
//				while (nextLine != null)
//				{
//				   System.out.println(nextLine);
//				   nextLine = bufferedReader.readLine();
//				   
//				}
//	
//				bufferedReader.close();
////				reads in data from file
//			} 
//			
//			catch (IOException e) 
//			{
//				System.out.println("Sorry an error occured");
//			}
//		}
//		
//		else {
//			
//			System.out.println("");
//			System.out.println("You select N, you have been returned to the menu");
//			System.out.println("");
//			displayMenu();
////			returns user to menu of they chose not to read in data
//			
//		}
		
		System.out.println("Sorry this option is not available");
		System.out.println("");
		displayMenu();
		
	}

}
