package question1;

public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int prime(int n)
	{
		
		// n = 8
		int num = n + 1;
	
		boolean complete = true;
		while(complete)
		{ 
			// a loop to check if the number is prime
			for (int i = num - 1; i > 1; i--)
			{
				if (num % i == 0)
				{
					num++;
					//not a prime 
					break;
				}
				if (i == 2) // a prime if greater than one and divisible only by 1
				{
					complete = false;
				}
			}
		}
		return num;
	}

}
