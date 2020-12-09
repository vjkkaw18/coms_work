package question1;

import java.util.Scanner;

public class PrintLongestWord {

	public static void main(String[] args) {
		String str = "I am a freshman in Computer Engineering";
		System.out.println(longestWord(str)); // expected Engineering

	}
	
	public static String longestWord(String sentence)
	{
		String longestWord = "";
		int sizeOfWord = 0;
		
		Scanner scan = new Scanner(sentence);
		while (scan.hasNext())
		{
			String currentWord = scan.next();
			
			if (currentWord.length() > sizeOfWord)
			{
				sizeOfWord = currentWord.length();
				longestWord = currentWord;
			}
		}
		return longestWord;
	}

}
