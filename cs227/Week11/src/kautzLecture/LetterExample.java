package kautzLecture;

import java.util.ArrayList;

public class LetterExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static ArrayList<String> findPermutation(String s)
	{
		ArrayList<String> result = new ArrayList<>();
		
		if (s.length() <= 1)
		{
			result.add(s);
		}
		
		else 
		{
			for (int i = 0; i < s.length(); i++)
			{
				char ch = s.charAt(i);
				String rest = s.substring(0,i) + s.substring(i+1);
				ArrayList<String> temp = findPermutation(rest);
				for (String t : temp)
				{
					String perm = "" + ch + t;
					result.addAll(temp);
				}
			}
		}
		return result;
	}

}
