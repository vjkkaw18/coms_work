package question8;

public class Recursion {

	public static void main(String[] args) {
		System.out.println(ways(4));

	}
	
	public static int ways(int n)
	{
		// If tiles are negative, 0 ways
		if(n < 0)
		{
			return 0;
		}

		// If tiles are 0, there's only one way
		else if(n == 0)
		{
			return 1;
		}

		//Sum answers for jumping 1 tile, 2 tiles and 3 tiles
		else 
		{
			return ways(n - 1) + ways(n - 2) + ways(n - 3);
		}
	}

}
