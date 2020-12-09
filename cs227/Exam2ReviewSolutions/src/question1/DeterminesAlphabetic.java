package question1;

public class DeterminesAlphabetic {

	public static void main(String[] args) {
		String string = "Hello, world!";
		System.out.println(stringIsAlphabetic(string));

	}
	
	public static String stringIsAlphabetic(String str)
	{
		String newStr = "";
		
		for (int i = 0; i < str.length(); i++)
		{
			char currentChar = str.charAt(i);
			
			if (Character.isAlphabetic(currentChar))
			{
				newStr += currentChar;
			}
			
			else 
			{
				newStr += "#";
			}
			
		}
		return newStr;
	}
	

}
