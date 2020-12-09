package kautzLecture;

public class RecursionPractice {

	public static void main(String[] args) {
		
		countUp(5);
		
		System.out.println(factorial(5));
		
		System.out.println(isPalindrome("tacocat"));
		
		
		System.out.println(fibonacci(1)); // expected 1
		System.out.println(fibonacci(2)); // expected 1
		System.out.println(fibonacci(3)); // expected 2
		System.out.println(fibonacci(4)); // expected 3
		System.out.println(fibonacci(5)); // expected 5
		System.out.println(fibonacci(6)); // expected 8
		System.out.println(fibonacci(7)); // expected 13
		System.out.println(fibonacci(8)); // expected 21
	}
	
	public static void countUp(int n)
	{
		if (n == 0)
		{
			System.out.println(n);
		}
		
		else 
		{
			int temp = n - 1; 
			countUp(temp);
			System.out.println(n);
		}
	}
	
	public static int factorial(int n)
	{
		if (n == 1)
		{
			return 1;
		}
		
		else 
		{
			return n * factorial(n - 1);
		}
	}
	
	public static boolean isPalindrome(String s)
	{
		int len = s.length();
		if (len <= 1)
		{
			return true;
		}
		
		else 
		{
			char first = s.charAt(0);
			char last = s.charAt(len - 1);
			
			String middle = s.substring(1, len - 1);
			
			return first == last && isPalindrome(middle);
		}
	}
	
	public static int fibonacci(int n)
	{
		if (n == 1 || n == 2)
		{
			return 1;
		}
		
		else 
		{
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

}
