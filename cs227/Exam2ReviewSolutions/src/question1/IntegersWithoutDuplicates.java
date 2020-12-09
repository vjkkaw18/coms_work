package question1;

import java.util.ArrayList;

public class IntegersWithoutDuplicates {

	public static void main(String[] args) {
		int[] array = { 5, 4, 5, 6, 4, 2};
		array = noDuplicates(array);
//		for (int i=0; i<array.length; i++) {
//			System.out.println(array +" ");
//		}
		System.out.println(array);

	}
	
//	public static int[] noDuplicates(int[] arr)
//	{
//		int size = arr.length;
//		for (int i = 0; i < arr.length; i++)
//		{
//			int num = arr[i];
//			for (int j = i + 1; j < arr.length; j++)
//			{
//				if (arr[j] == num)
//				{
//					arr[j] = 0; // Remove duplicates
//				}
//
//			}
//		}
//		
//		int count = 0; 
//		for (int i = 0; i < arr.length; i++)
//		{
//			if (arr[i] != 0)
//			{
//				arr[count] = arr[i];
//				count++;
//			}
//		}
//		
//		while (count < arr.length)
//		{
//			arr[count] = 0;
//			count++;
//		}
//		for (int i = 0; i < arr.length; i++)
//		{
//			if (arr[i] == 0)
//			{
//				size--;
//			}
//		}
//		int[] b = new int[size];
//		for (int i = 0; i < size; i++) 
//		{
//			b[i]=arr[i];
//		}
//		
//		return b;
//	}
	
	public static int[] noDuplicates(int[] arr)
	{
		ArrayList<Integer> aList = new ArrayList<>();
		for (int value : arr)
		{
			if (!aList.contains(value))
			{
				aList.add(value);
			}
		}
		
		int [] result = new int[aList.size()];
		for(int i = 0; i < result.length; i++)
		{
			result[i] = aList.get(i);
		}
		return result;
	}

}
