package lab7;

import java.util.Scanner;

public class Arrays 
{
	
	private Scanner s = new Scanner(System.in);
	private int total;
	private float average;
	private float total_2;
	
	int[] number = new int[4];
	
	int[] array = new int[7];

	
	public void testIntegerArray()
	{
	
	for(int i = 0; i <=3; i++) {
		
		System.out.println("PLease enter a number");
		number[i] = s.nextInt();	
	}
		
	for(int counter = 0; counter <=3; counter++) 
	{
		System.out.println(number[counter]);
	}

	
	
	for(int count = 3; count>=0; count--) 
	{
		System.out.println(number[count]);
	}
	
}
	
	public void getAverage() {
		
		int counter = 0;
		
		for(int i = 0; i<=6; i++) {
			
			total = total+array[i];
			counter++;
		}
		
		average = total/counter;
		
		System.out.println("Average:" + average);
	}
	
	public void testStringArray() {
		
		String[] words;
		words = new String[5];
		
		for(int i = 0; i <=4; i++) 
		{
			System.out.println("PLease enter a String");
			words[i] = s.nextLine();
			
		}
		
		for(int counter = 0; counter <=4; counter++ ) 
		{
			System.out.println(words[counter]);
		}
		
	}
	
	public void getTotal() {
		
		for(int i = 0; i <=6; i++) 
		{
			System.out.println("PLease enter a Number");
			array[i] = s.nextInt();
			
		}
		
		for(int counter = 0; counter <=6; counter++) 
		{
			total_2 = total_2+array[counter];
		}
		
		System.out.println("Total:" + total_2);
	}
	
	public void test() {

		
		for(int i = 0; i <=6; i++) 
		{
			System.out.println("PLease enter a Number");
			array[i] = s.nextInt();
			
		}
		
		getAverage();
		getTotal();
		
		
	}
	

}
