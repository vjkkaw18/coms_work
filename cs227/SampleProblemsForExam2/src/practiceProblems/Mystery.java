package practiceProblems;

public class Mystery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * i = 0
	 * temp = b
	 * arr = a, b, c, d
	 */
	public static void mystery(int[] arr)
	{
		for (int i = 0; i < arr.length - 1; i ++)
		{
			int temp = arr[i+1];
			arr[i+1] = arr[0];
			arr[0] = temp;
		}
	}

}
