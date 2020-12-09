package question1;

public class GettingAverage {

	public static void main(String[] args) {
		
		double [] numbers = { 5.0, 5.0, 5.0, 5.0};
		System.out.println(Average(numbers)); // expected 5.0

	}
	
	public static double Average(double[] arr)
	{
		double average = 0;
		double sum = 0;
		double count = 0; 
		
		for (int i = 0; i < arr.length; i++)
		{
			sum += arr[i];
			count += 1;
		}
		
		average = sum / count; 
		return average; // OR return sum/ arr.length
	}

}
