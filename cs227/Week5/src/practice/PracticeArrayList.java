package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class PracticeArrayList {

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<> ();
		Scanner scan = new Scanner(System.in);

		//store all the inputs from the user to the ArrayList
		for (int i = 0; i < 5; i++)
		{
			al.add(scan.nextInt());
		}

		int j = 0;
		while (j < 5)
		{
			al.add(scan.nextInt());
			j++;
		}
		
		
		//print out all the elements in the ArrayList
		for (int i = 0; i < 5; i++)
		{
			System.out.println(al.get(i) + "");
		}
		
		int k = 0;
		while (k < 5)
		{
			System.out.println(al.get(k) + "");
		}
		
		System.out.println(al.size());

	}

}
