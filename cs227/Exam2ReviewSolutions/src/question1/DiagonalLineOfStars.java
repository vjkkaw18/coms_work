package question1;

public class DiagonalLineOfStars {

	public static void main(String[] args) {
		diagonal(6);

	}
	
	private static void diagonal(int n) // n = 6
	{
		for (int i = n; i > 0; i--) // Print each line
		{
			for (int j = 0; j < i - 1; j++)
			{
				System.out.print(" "); // print spaces
			}
			System.out.println("*");
			// 6
			
		}
	}

}
