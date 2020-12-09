package GuangSongLecture;

import java.util.Scanner;

public class GroupQuiz {
	public static void main(String[] args)
	{
		Scanner info = new Scanner(System.in);
//		Scanner info1 = new Scanner(System.in);
//		Scanner info2 = new Scanner(System.in);
//		Scanner info3 = new Scanner(System.in);
//		Scanner info4 = new Scanner(System.in);
		
		
		System.out.print("Please enter you name: ");
		String name = info.nextLine(); 
		// nextLine() reads the whole line
		// while next() reads the first string of character before the space. 
	
		System.out.println("Your name is " + name);
		
		System.out.print("Please enter your height (in feet): ");
		double height = info.nextDouble();
		System.out.print("Please enter you age: ");
		int yearsOld = info.nextInt();
		System.out.println("You are " + height + " and " + yearsOld + " years old.");

		System.out.print("Please enter your zipcode: ");
		int zipCode = info.nextInt();
		System.out.println("Your zipcode is " + zipCode);
	
		
		
	}

}
