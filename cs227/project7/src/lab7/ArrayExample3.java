package lab7;


import java.util.Arrays;
import java.util.Scanner;

public class ArrayExample3
{
  public static void main(String[] args)
  {
    String s = "3 5 7 9 12";
    
    int[] result = readNumbers(s);
    System.out.println(Arrays.toString(result));
    int[] numbers = {-1, -5, 6, -2, 8, 9};
    System.out.println(Arrays.toString(numbers));
  }
  
  public static int[] getPositiveNumbers(int[] numbers)
  {
	  
	  int count = 0;
	  int index = 0;
	  
	  for(int i = 0; i < numbers.length; i++)
	  {
		  if (numbers[i] > 0)
		  {
			  count = count + 1;
			  index += 1;
		  }  
	  }
	  int[] nums = new int[count];
	  
	  
	  
	  
	  return nums;
  }
  
  
  
  
  public static int[] readNumbers(String text)
  {
    Scanner scanner = new Scanner(text);
    int count = 0;
    while (scanner.hasNextInt())
    {
      scanner.nextInt();
      count +=1;
    }
    
    int[] nums = new int[count];
    scanner = new Scanner(text);
    int index = 0;
    while (scanner.hasNextInt())
    {
      int num = scanner.nextInt();
      nums[index] = num;
      index += 1;
    }
    return nums;  
  }
}