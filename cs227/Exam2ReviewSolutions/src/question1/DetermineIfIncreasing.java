package question1;

import java.util.ArrayList;

public class DetermineIfIncreasing {

	public static void main(String[] args) {
		ArrayList<Integer> numbers= new ArrayList<>();
		numbers.add(5);
		numbers.add(6);
		numbers.add(7);
		numbers.add(1);
		numbers.add(9);
		System.out.println(isIncreasingOrder(numbers));
		
		

	}
	
	public static boolean isIncreasingOrder(ArrayList<Integer> values)
	{
		boolean isIncreasing = false;
		for (int i = 0; i < values.size() - 1; i++)
		{
			if (values.get(i) < values.get(i+1))
			{
				isIncreasing = true;
			}
			else
			{
				isIncreasing = false;
				break;
			}
		}
		
		
		
		return isIncreasing;
	}

}
