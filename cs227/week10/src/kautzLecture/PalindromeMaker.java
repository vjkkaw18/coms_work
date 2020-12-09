package kautzLecture;

public class PalindromeMaker {

	public static void main(String[] args) {
		String result = makePalindrome("abcde");
		System.out.println(result);

	}
	
	public static String makePalindrome(String s)
	{
		if (s.length() <= 1)
		{
			return s;
		}
		
		else 
		{
			char ch = s.charAt(0);
			String rest = s.substring(1);
			String temp = makePalindrome(rest);  // make rest into a palindrome
			String result = "" + ch + temp + ch;
			return result;
		}
		
		
		
		
	}

}
