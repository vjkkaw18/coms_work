package question1;

public class LettersAppear {

	public static void main(String[] args) {
		System.out.println(determineLetter("Engineeriingg")); // true
		System.out.println(determineLetter("Hello")); // true

	}
	
	public static boolean determineLetter(String str)
	{
		boolean character = false;
		int count = 0;
		for (int i = 0; i < str.length(); i++)
		{
			for (int j = i + 1; j < str.length(); j++)
			{
				if(str.charAt(i) == str.charAt(j))
				{
					count += 1;
					if (count >= 1)
					{
						character = true; 
						break;
					}
				}
			}
		}
		return character; 
	}
}
