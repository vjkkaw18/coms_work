package guangSongLecture;

import java.util.Scanner;

public class SumDigitsForLargeNumbers {
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter an integer: ");
		String n = in.next();
		int sum = 0;
		for (int i = 0; i < n.length(); i++)
		{
			char c = n.charAt(i);
			//int value = Integer.parseInt(digit + "");
		}
		
		System.out.println("The sum of digits is " + sum);
	}

}