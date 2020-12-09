package question1;

public class ColumnWithMaxSum {

	public static void main(String[] args) {
		int[][] intArray= { {1,1,1}, {2,2,2}, {3,3,3}, {2,2,2}};
		System.out.println(columnMaxSum(intArray));

	}
	
	public static int columnMaxSum(int[][] integers)
	{
		int column = 0;
		int sum = 0;
		int max = 0;
		
		for (int row = 0; row < integers.length; row++) // row
		{
			for (int cols = 0; cols < integers[0].length; cols++) // column
			{
				sum = sum + integers[row][cols];
			}
			
			if (sum > max)
			{
				max = sum;
				column = row;
			}
			sum = 0;
			
		}
		
		
		
		return column;
	}
	
//	public static int columnMaxSum(int[][] a)
//	{
//		int[] sums = new int[a[0].length];
//		for (int i = 0; i < a.length;i++)
//		{
//			for (int j = 0; j < a.length; j++)
//			{
//				sums[j] = sums[j] + a[i][j];
//			}
//		}
//		
//		int inx = 0;
//		for (int i = 0; i < sums.length; i++)
//		{
//			
//		}
//		
//	}

}
