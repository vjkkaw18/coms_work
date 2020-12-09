package solutionsToExam1;

import java.util.Scanner;

public class Eggs {
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("How many eggs? ");
		int numEggs = input.nextInt();
		
		System.out.print("Do you want brown eggs (yes/no)? ");
		String typeOfEgg = input.next();
		
		int numFlats = 0;
		int numDozens = 0;
		int numHalfDozens = 0;
		
		if (numEggs >= 30)
		{
			numFlats = numFlats + (numEggs / 30);
			numEggs = numEggs % 30;
		}
		
		else if (numEggs > 25)
		{
			numFlats = 1;
		}
		
		
		
		
		
	}

}
