package question7;

public class Mystery {

	public static void main(String[] args) {
//		mystery(10);
//		mystery(10);
		mystery(-1); // will result to stack overflow because it's an infinite recursion

	}
	public static void mystery(int x)
	{
		if (x == 1)
		{
			System.out.println("pooh");
		}
		
		else if (x % 2 == 0)
		{
			System.out.println(x);
			mystery(x/2);

//			mystery(x/2);
//			System.out.println(x);
		}
		
		else 
		{
			mystery(x - 1);
		}
	}

}
