package question1;

public class CollapseArray {

	/**
	 * Input: [1,3,3,4]
	 * Output: [1,3,4,0]
	 * 
	 * remove duplicates 
	 * 
	 * [1,3,0,4]
	 * Count:
	 * 
	 * if (arr[i] != 0)
	 * arr[count] = arr[i]
	 * 
	 * [1,3,0,4] 
	 * i=2
	 * count += 1
	 * 
	 * arr[0] = arr[0] 
	 * arr[2] = arr[3]
	 * 
	 * 
	 */
	
	
	public static int[] collapse(int[] arr)
	{
		for (int i = 0; i < arr.length; i++)
		{
			int num = arr[i];
			for (int j = i + 1; j < arr.length; j++)
			{
				if (arr[j] == num)
				{
					arr[j] = 0; // Remove duplicates
				}

			}
		}
		
		int count = 0; 
		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i] != 0)
			{
				arr[count] = arr[i];
				count++;
			}
		}
		
		while (count < arr.length)
		{
			arr[count] = 0;
			count++;
		}
		
		
		return arr;
	}

}
