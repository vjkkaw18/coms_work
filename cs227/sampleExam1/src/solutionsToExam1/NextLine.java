package solutionsToExam1;

public class NextLine
{
	private int i;

	
	public NextLine(int n)
	{
		i = n;
	}

	public int next()
	{
		if (i % 2 == 0)
		{
			i = i / 2;
		}
		else 
		{
			i = i + 1;
		}
		return i;
	}
}