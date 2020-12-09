package practice;

import java.util.Scanner;

public class IfElseExample {

//	public static void main(String[] args) {
//		
//		Scanner in = new Scanner(System.in);
//		int numApples = in.nextInt();
//		
//		double totalCost = Math.max(numApples, 0) * 5.00;
//		double deliveryFee = totalCost * 0.10;
//		
//		if (numApples >= 10) 
//		{
//			deliveryFee = 0;
//		}
//		
//		System.out.println(totalCost + deliveryFee);
//	
//	}
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter number of apples: ");
		int numApples = in.nextInt();
		System.out.print("Enter number of balls: ");
		int numBalls = in.nextInt();
		int totalCost = 0;
		
		if (numApples == 2 && numBalls == 1) 
		{
			totalCost = 0;
		}
		else if (numApples == 2 && numBalls == 2)
		{
			totalCost = 100;
		}
		
		System.out.println(totalCost);
	
	}


}
