import java.util.Scanner;

public class Interaction {

	public static void sayHelloFriend(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("PLease Enter your Name");
		String name = s.nextLine();
		System.out.println("Hello " + name);
	
	}

	public static void addingnumbers(String[] args) {
		int num1, num2, total;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a number");
		num1 = s.nextInt();
		
		System.out.println("Enter another number");
		num2 = s.nextInt();
		
		s.close();
		total = num1 + num2;
		System.out.println("The total of those two numbers is " +  total);
	}
}
