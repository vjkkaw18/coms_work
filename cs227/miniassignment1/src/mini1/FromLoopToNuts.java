package mini1;

import java.util.Random;
import java.util.Scanner;

public class FromLoopToNuts {

	private FromLoopToNuts()
	{

	}

	public static int countMatches(java.lang.String s, java.lang.String t)
	{
		int matches = 0;
		int i;
		for (i = 0; i < Math.min(s.length(), t.length()); i++)
		{
			if (s.charAt(i) == t.charAt(i))
			{
				matches = matches + 1;
			}
		}

		return matches;
	}

	public static boolean isArithmetic(java.lang.String text)
	{
		Scanner scan = new Scanner(text).useDelimiter(",");

		boolean answer = true;
		if (text.isEmpty())
		{
			answer = true;
			return answer;
		}

		int firstNum = scan.nextInt();
		int secondNum = scan.nextInt();
		int numDifference = secondNum - firstNum; 

		while(scan.hasNext())
		{
			if(scan.hasNext() && !scan.hasNextInt()) {
				answer = false;
				return answer;
			}
			firstNum = secondNum;
			secondNum = scan.nextInt();
			if(numDifference == secondNum - firstNum)
			{
				answer = true;
			}
			else 
			{
				answer = false;
				break;
			}
		}
		return answer;
	}

	public static int countSubstrings(java.lang.String t, java.lang.String s)
	{
		int numSubstrings = 0;
		int indexLast = 0;

		while (indexLast != -1)
		{
			indexLast = s.indexOf(t,indexLast);

			if (indexLast != -1)
			{
				numSubstrings++;
				indexLast += t.length();
			}
		}
		return numSubstrings;
	}

	public static int countSubstringsWithOverlap(java.lang.String t, java.lang.String s)
	{
		int numSubstrings = 0;
		int indexLast = 0;

		while (indexLast != -1)
		{
			indexLast = s.indexOf(t,indexLast);

			if (indexLast != -1)
			{
				numSubstrings++;
				indexLast++;
			}
		}
		return numSubstrings;
	}

	public static boolean differByOneSwap(java.lang.String s, java.lang.String t)
	{
		boolean hasOnePair = false;
		int numPairs = 0;

		for (int i = 0; i < Math.min(s.length() - 1, t.length() - 1); i++)
		{
			if (s.length() == t.length())
			{
				if (s.charAt(i) != t.charAt(i))
				{
					if (s.charAt(i) == t.charAt(i+1) && s.charAt(i+1) == t.charAt(i))
					{
						numPairs = numPairs + 1;		
					}
				}
			}
		}
		if (numPairs == 1)
		{
			hasOnePair = true;
		}
		else if (numPairs > 1)
		{
			hasOnePair = false;
		}
		return hasOnePair;
	}

	public static java.lang.String eliminateRuns(java.lang.String s)
	{
		String runCharacters = "";
		if (s.length() == 0)
		{
			runCharacters = "";
		}
		else 
		{
			char current = s.charAt(0);

			runCharacters = Character.toString(current);
			for (int i = 1; i < s.length(); i++)
			{
				char c = s.charAt(i);
				char d = s.charAt(i-1);
				if (c != d)
				{
					runCharacters = runCharacters + Character.toString(c);
				}
			}
		}
		return runCharacters;
	}

	public static int findEscapeCount(double x, double y, int maxIterations)
	{
		double maximumIterations = maxIterations;
		int numIterations = 0;
		double a = 0;
		double b = 0;
		double currentTotal = 0; 
		double tempA = 0;
		double tempB = 0;

		while (numIterations < maximumIterations && currentTotal <= 4)
		{
			if (numIterations == 0)
			{
				a = x;
				b = y;	
				currentTotal = (a * a) + (b * b);
			}
			else if (numIterations == 1)
			{
				a = x;
				b = y;
				tempA = ((a * a) - (b * b)) + x;
				tempB = 2 * a * b + y;
				a = tempA; 
				b = tempB;
				currentTotal = (a * a) + (b * b);
			}
			else
			{
				tempA = (a * a) - (b * b) + x;
				tempB = 2 * a * b + y;
				a = tempA; 
				b = tempB;
				currentTotal = (a * a) + (b * b);
			}
			numIterations = numIterations + 1;
		}
		return numIterations;
	}

	public static int threeInARow(java.util.Random rand, int bound)
	{
		int second;
		int first = rand.nextInt(bound);
		int countForConsecutives = 0;
		int iterations = 1;

		while (countForConsecutives != 2)
		{
			second = rand.nextInt(bound); 
			iterations++;
			if (first == second)
			{
				countForConsecutives += 1;
			}
			else
			{
				countForConsecutives = 0;
				first = second;
			}
		}
		return iterations;
	}
}
