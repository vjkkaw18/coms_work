package question1;



	import java.util.Arrays;

	public class SOLUTIONS {

		public static void main(String[] args) {
			diagonal(6);
			System.out.println(Arrays.toString(averages(new double[][]{{1, 2, 3},{4, 5, 6} ,{7, 8, 9}})));
			int[] arr = new int[]{1, 1, 2, 2, 3, 2, 6, 7, 1, 2, 9};
			collapse(arr);
			System.out.println(prime(123450000));
		}
		
		private static void diagonal(int n) {
			for(int i = n; i > 0; i--) { // Print Each Line
				
				for(int x = 0; x < i-1; x++) { // Print Spaces.
					System.out.print(" ");
				}
				System.out.println("*");
				// 6
				
			}
		}
		
		private static double[] averages(double[][] arr) {
			double[] returnArr = new double[arr[0].length];

			for(int col = 0; col < arr[0].length; col++) {
				// Column
				double average = 0; 
				for(int row = 0; row < arr.length; row++) {
					// Average Rows. 
					average += arr[row][col];
				}
				average = average / arr.length; 
				returnArr[col] = average;
			}
			return returnArr;
			 
		}
		
		// Problem 1o
		private static void collapse(int[] arr) {
			for(int i = 0; i < arr.length; i++) {
				int num = arr[i];
				for(int x = i+1; x < arr.length; x++) {
					if(arr[x] == num) {
						arr[x] = 0; // Remove duplicate. 
					}
				}
			}
			
			int count = 0;
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] != 0) {
					arr[count] = arr[i];
					count++;
				}
			}
			
			while(count < arr.length) {
				arr[count] = 0;
				count++;
			}
		}
		
		// Problem 1n
		private static int prime(int n) {
			// 8 
			int num = n+1;
			boolean complete = true;
			while(complete) {
				
				for(int i = num-1; i > 1; i--) {
					if(num % i == 0) {
						num++;
						// Not a Prime.
						break;
					}
					if(i == 2) { 
						complete = false;
					}
						
				}
				
			}
			return num;
			
		}
		
	}

