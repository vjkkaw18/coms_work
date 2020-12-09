package question1;

public class AverageColumn {

	public static void main(String[] args) {
		
		
		
	}
	
	public static double[] averages(double[][] arr)
	{
		double[] returnArr = new double[arr[0].length];
		
		for (int col = 0; col < arr[0].length; col++)
		{
			// Column
			double average = 0;
			for (int row = 0; row < arr.length; row++)
			{
				// average rows
				average += arr[row][col];
			}
			average  = average / arr.length;
			returnArr[col] = average;
		}
		
//		arr.length // rows 
//		arr[0].length // columns
		return returnArr;
	}

}
