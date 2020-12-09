package question1;

public class FirstVowel {

	public static void main(String[] args) {
		System.out.println(indexOfVowel("Kwan"));

	}
	
	
	public static int indexOfVowel(String str)
	{
		int index = 0;
		for (int i = 0; i < str.length(); i++)
		{
			if ("aeiouAEIOU".indexOf(str.charAt(i)) >= 0)
			{
				index = i;
				break;
			}
		}
		return index;
	}

}
