package guangSongLecture;

public class Quiz4 {

	public static void main(String[] args) {
		int maximumValue = max(3,6,5);
		
		System.out.println(maximumValue);
		

	}

	public static int max(int a, int b, int c)
	{
		if (a > b && a > c)
		{
			return a;
		}
		else if (b > a && b > c)
		{
			return b;
		}
		else
		{
			return c;
		}
		
	}
	
	
}
