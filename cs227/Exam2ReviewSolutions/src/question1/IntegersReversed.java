package question1;

public class IntegersReversed {

	public static void main(String[] args) {
		int[] integerArray = {1,2,3,4};
		intReverse(integerArray);
		
		System.out.println(integerArray);

	}

	public static void intReverse(int[] integers)
	{

//		int first = 0;
//		int last = integers.length - 1;
//
//
//		while (first < last)
//		{
//			int temp = integers[first];
//			integers[first] = integers[last];
//			integers[last] = temp;
//
//			first++;
//			last--;
//		}

		for (int i = 0; i < integers.length / 2; i++) {
			int temp = integers[i];
			integers[i] = integers[integers.length - 1];
			integers[integers.length - i] = temp;
		}
	}
	
	public static void reverseArray(int[] arr)
	{
		int[] anotherArray = new int[arr.length]; // 4
		int index = 0;
		
		for (int count = arr.length - 1; count >= 0; count--)
		{
			anotherArray[index] = arr[count];
			index++;
		}
		

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = anotherArray[i];
		}
		
	}

}
