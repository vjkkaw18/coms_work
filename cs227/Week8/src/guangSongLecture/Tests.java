package guangSongLecture;

import java.util.Scanner;

public class Tests {

	public static void main(String[] args) {
		 String text = "2,4,6,8";
		 String text2 = "-2,5,12,19,26";
		 String text3 = "2,4,7";
		 String text4 = "1,2,23skidoo";

		 
		 Scanner scan = new Scanner(text4).useDelimiter(",");
			
			boolean answer = false;
			
			int firstNum = scan.nextInt();
			int secondNum = scan.nextInt();
			int numDifference = secondNum - firstNum; 
			
			while(scan.hasNextInt())
			{
				firstNum = secondNum;
				secondNum = scan.nextInt();
				if(numDifference == secondNum - firstNum)
				{
					answer = true;
				}
				else 
				{
					answer = false;
				}
					
		
			}
			
			
				
			
			System.out.println(answer);
			System.out.println(firstNum);
			System.out.println(secondNum);
	}

}
