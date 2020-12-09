package question1;

public class IntArrayAdd {

	public static void main(String[] args) {
		int[][] arr = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}};
		print_2D_array(arr);

	}
	
	public static void print_2D_array(int[][] input_array)	{
		for(int i = 0; i < input_array.length; i++) {
			for(int j = 0; j < input_array[0].length; j++) {
				System.out.print(input_array[i][j] + "     ");
			}
		System.out.println();
		}
	}
	
	
	
	
	public static int[][] arrayAdd(int w, int h, int[] arr)
	{
		int[][] twoDimensionArray = new int[w][h];
		int k = 0;
		
		for (int i = 0; i < w; i++)
		{
			for (int j = 0; j < h; j++)
			{
				twoDimensionArray[i][j] = arr[k];
				k++;
			}
		}
		return twoDimensionArray;
	}

}
