package lab6;

import java.util.Scanner;

public class Loops {

	public static void main(String[] args) {
		System.out.println(Initials("Vance jenrick kwan Kaw"));
		System.out.println(firstVowel("vance"));

	}
	
	public static String Initials(String fullName)
	{
		String oneWord;
		char firstLetter;
		String initialLetters = "";
		
		Scanner scanner = new Scanner(fullName);
		
		while (scanner.hasNext())
		{
			oneWord = scanner.next();
			firstLetter = oneWord.charAt(0);
			initialLetters = initialLetters + firstLetter;
		}
		return initialLetters;
	}
	
	public static int firstVowel(String words)
	{
		for (int i = 0; i < words.length(); i++)
		{
			switch (words.charAt(i)) {
			case 'a':
				return i;
			case 'e':
				return i;
			case 'i':
				return i;
			case 'o':
				return i;
			case 'u':
				return i;
			case 'A':
				return i;
			case 'E':
				return i;
			case 'I':
				return i;
			case 'O':
				return i;
			case 'U':
				return i;
			}
		}
		return -1;
	}

}
