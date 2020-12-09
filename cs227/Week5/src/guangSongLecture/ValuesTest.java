package guangSongLecture;

import java.util.Scanner;

public class ValuesTest {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter two integer values: ");
		
	
		int intValue = in.nextInt();
		int intValue2 = in.nextInt();
		
		int maxValue;
		int minValue;
		if (intValue > intValue2)
		{
			maxValue = intValue;
			minValue = intValue2;
			System.out.println("The maximum value is: " + maxValue);
			System.out.println("The minimum value is: " + minValue);
		}
		else if(intValue == intValue2)
		{
			System.out.println("The two ints are equal");
		}
		else 
		{
			maxValue = intValue2;
			minValue = intValue;
			System.out.println("The maximum value is: " + maxValue);
			System.out.println("The minimum value is: " + minValue);
		}
		
		
		
			
	}
}
