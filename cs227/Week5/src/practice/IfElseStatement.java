package practice;

import java.util.Scanner;

public class IfElseStatement {
	public static void main (String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Floor: ");
		int floor = in.nextInt();
		
		int actualFloor;
		if (floor > 13)
		{
			actualFloor = floor - 1;
		}
		
		else 
		{
			actualFloor = floor;
		}
		
		System.out.println("The elevator will travel to the actual floor " + actualFloor);
		
	}

}
