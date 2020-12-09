package question1;

public class IsPermutation {

	public static void main(String[] args) {
		int[] array = {1 ,2, 3, 4, 5};
		System.out.println(isPermutation(array)); // expected true;

	}
	
	public static boolean isPermutation(int[] arr)
	{
		boolean permutation = true;
		
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = i + 1; j < arr.length; j++)
			{
				if (arr[i] == arr[j])
				{
					permutation = false;
				}
			}
		}
		return permutation;
	}

}
