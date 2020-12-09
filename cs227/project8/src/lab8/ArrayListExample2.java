package lab8;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample2
{
  public static void main(String[] args)
  {
    String s = "3 5 7 9 12";
    
    ArrayList<String> words = new ArrayList<String>();
    words.add("I");
    words.add("am");
    words.add("am");
    words.add("am");
    words.add("Vance");
    words.add("Vance");
    words.add("Kaw");
    System.out.println("Words with Duplicate: " + words);
    
    removeDuplicates(words);
    
    System.out.println(words);    
    
    
    
//    System.out.println(removeDuplicates(words));
    
//    int[] result = readNumbers(s);
//    System.out.println(Arrays.toString(result));
  }
  
  public static void removeDuplicates(ArrayList words)
  {
	  ArrayList<String> noDuplicates = new ArrayList<String>();
	  for (int i = 0; i < words.size(); i++)
	  {
		  String word = (String) words.get(i);

		  if (!noDuplicates.contains(word))
		  {
			  noDuplicates.add(word);
		  }
	  }
	  words.clear();
	  words.addAll(noDuplicates); 
  }
  
  
  
  public static int[] readNumbers(String text)
  {
    Scanner scanner = new Scanner(text);

    ArrayList<Integer> nums = new ArrayList<Integer>();
    
    scanner = new Scanner(text);
    while (scanner.hasNextInt())
    { 
      nums.add(scanner.nextInt());
    }
    
    int[] ret = new int[nums.size()];
    for (int i = 0; i < nums.size(); i += 1)
    {
      ret[i] = nums.get(i);
    }
    return ret;
  }
}