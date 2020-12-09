package kautzLecture;

public class BinarySearchNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public static int binarySearch(int[] arr, int target)
	{
		return binarySearch(arr, target, 0, arr.length-1);
	}

	public static int binarySearch(int[] arr, int target, int start, int end)
	{
		if (end < start)
		{
			return -1;
		}
		
		int mid = (start + end) / 2;
		if (arr[mid] == target)
		{
			return mid;
		}
		
		else if (target < arr[mid])
		{
			return binarySearch(arr, target, start, mid-1);
		}
		
		else 
		{
			return binarySearch(arr, target, mid+1, end);
		}
	}
}
