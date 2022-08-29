package FilesExcersie;

import java.util.Scanner;

public class DVD {
	/**Initialising fields
	 * 
	 */
		private String title;
		private String director;
		private String runtime;
		private String cost;
		private Scanner s = new Scanner(System.in);

		
	/**	initialising default values in Constructor
	 * 
	 */
		public DVD() 
		{
			title = "";
			director = "";
			runtime = "";
			cost = "";
		}

	/**	get information on film from the user
	 * 
	 * @param args
	 */
		public void getInfo(){
			
			System.out.println("What is the name of your Film?");
			title = s.nextLine();
			
			System.out.println("Who directed the film?");
			director = s.nextLine();
			
			System.out.println("What is the total runtime? (in minutes)");
			runtime = s.nextLine();
			
			System.out.println("How much does the DVD cost?");
			cost = s.nextLine();
		
		}

		/** displays information about the film given by the user
		 * 
		 */
		public void displayValues() {
			
			System.out.println("Title: " + title);
			System.out.println("Director: " + director);
			System.out.println("Run Time: " + runtime);
			System.out.println("Cost of DVD: " + cost);
		}
}
