package solutionsToExam1;

import java.util.Random;

public class Problem5{

	public static String createID(String firstName, String lastName)
	{
		Random rand = new Random();
		String ID = "";
		ID = firstName.charAt(0) + ""; 
		ID = ID + lastName; 
		ID = ID + (rand.nextInt(50) + 1);
		

		return ID;

	}


	public static void main(String[] args)
	{
		System.out.println(createID("Vance", "Kaw"));
	}
}
	

