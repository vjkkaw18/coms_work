package lab8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;


public class ArrayExampleNoDuplicate 
{
	public static void main(String args[]) 
	{
		//ArrayList containing duplicates
		List<String> list = (List<String>) Arrays.asList("java" , "c", "pascal", "ada","java", "java", "c++");    
		System.out.println("Original Arraylist: " + list);  
		
		//Convert ArrayList to HashSet
		LinkedHashSet<String> hashlist = new LinkedHashSet<String>(list);   
		//Create Arraylist without duplicate
		List<String> withoutduplicatelist = new ArrayList<String>(hashlist);       
		
		System.out.println("ArrayList after removing duplicates: " + withoutduplicatelist);      
	}
}