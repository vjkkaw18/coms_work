package kautzLecture;

public class Steps {

	public static void main(String[] args) {
		System.out.println(howManyWays(8));

	}
	
	
	/**
	 * How many ways can Jim climb a flight of n steps?
	 * If n = 8, then he can climb {2,2,2,2}, {2,3,3}, {3,2,3}, {3,3,2} => 4 WAYS 
	 */
	
	public static int howManyWays(int n)
	{
		if (n < 2)
		{
			return 0;
		}
		
		else if (n == 2 || n == 3) 
		{
			return 1;
		}
		
		else 
		{
			return howManyWays(n - 2) + howManyWays(n - 3);
		}
	}
	
	

}
