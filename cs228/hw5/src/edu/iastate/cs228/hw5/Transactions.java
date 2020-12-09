package edu.iastate.cs228.hw5;


import java.io.FileNotFoundException;
import java.util.Scanner; 

/**
 *  
 * @author Vance Kaw
 *
 */

/**
 * 
 * The Transactions class simulates video transactions at a video store. 
 *
 */
public class Transactions 
{
	
	/**
	 * The main method generates a simulation of rental and return activities.  
	 *  
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException
	{	
		// 
		// 1. Construct a VideoStore object.
		// 2. Simulate transactions as in the example given in Section 4 of the 
		//    the project description. 
		System.out.println("Transactions at a Video Store");
		System.out.println("keys: 1 (rent)      2 (bulk rent)");
		System.out.println("      3 (return)    4 (bulk return)");
		System.out.println("      5 (summary)   6 (exit)");
		
		Scanner scanner = new Scanner(System.in);
		int inputKey = 0;
		boolean condition = true;
		String str = "";
		VideoStore videoStore = new VideoStore("videoList1.txt");
		
		
		while (condition == true)
		{
			System.out.print("Transaction: ");
			inputKey = scanner.nextInt();
			
			// FOR RENT 
			if (inputKey == 1)
			{
				System.out.print("Film to rent: ");
				str = new Scanner(System.in).nextLine();
				try
				{
					videoStore.videoRent(VideoStore.parseFilmName(str), VideoStore.parseNumCopies(str));
				}
				catch (Exception e)
				{
					
				}
			}
			
			// FOR BULK RENT
			else if (inputKey == 2)
			{
				System.out.print("Video file (rent): ");
				str = new Scanner(System.in).nextLine();
				try
				{
					videoStore.bulkRent(str);
				}
				catch (Exception e)
				{
					
				}
			}
			
			// FOR RETURN
			else if (inputKey == 3)
			{
				System.out.print("Film to return: ");
				str = new Scanner(System.in).nextLine();
				try
				{
					videoStore.videoReturn(VideoStore.parseFilmName(str), VideoStore.parseNumCopies(str));
				}
				catch (Exception e)
				{
					
				}
			}
			
			// FOR BULK RETURN
			else if (inputKey == 4)
			{
				System.out.print("Video file (return): ");
				str = new Scanner(System.in).nextLine();
				try
				{
					videoStore.bulkReturn(str);
				}
				catch (Exception e)
				{
					
				}
			}
			
			// FOR THE SUMMARY
			else if (inputKey == 5)
			{
				System.out.println(videoStore.transactionsSummary());
			}
			
			// EXIT SIMULATION
			else if (inputKey == 6)
			{
				condition = false;
			}
			
			System.out.println();
		}
		
	}
}
