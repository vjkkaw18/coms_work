package question5;

import java.util.Scanner;

public class Password {

	public static void main(String[] args) {
		System.out.println(getPassword());

	}

	
	public static String getPassword()
	{
		String password_one = "";
		String password_two = "";
		Scanner s = new Scanner (System.in);
		
		do 
		{
			System.out.println("Enter first password");
			password_one = s.next();
			System.out.println("Enter second password");
			password_two = s.next();
		}
		while (!password_one.equals(password_two));
		
		
		return password_one;
		// return password_two;
	}

}
