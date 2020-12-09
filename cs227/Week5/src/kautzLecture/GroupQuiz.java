package kautzLecture;

import java.util.Scanner;

public class GroupQuiz {
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("How many burritos? ");
		int howMany = scanner.nextInt();
		
		double totalCost = howMany * 5.00;
		double deliveryFee = Math.max(2.5, howMany *.5);
		if (howMany >= 12)
		{
			deliveryFee = 0.0;
		}
		
		System.out.println(totalCost + deliveryFee);
	
		
		
		
	}
}
