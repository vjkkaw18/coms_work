package tutoringSession;

public class mystery {
	
	public static void main(String[] args)
	{
		mystery(5);
	}
	
	public static void mystery(int n)
	{
		if (n <= 0)
		{
			return;
		}
		
		else 
		{
			System.out.println(n);
			
			mystery(n-3);
			mystery(n-2);
		}
	}

}
