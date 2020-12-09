package edu.iastate.cs228.hw1;

import java.io.FileNotFoundException;
import java.util.Scanner; 

/**
 *  
 * @author
 * Vance Kaw
 *
 */

/**
 * 
 * The Wildlife class performs a simulation of a grid plain with
 * squares inhabited by badgers, foxes, rabbits, grass, or none. 
 *
 */
public class Wildlife 
{
	/**
	 * Update the new plain from the old plain in one cycle. 
	 * @param pOld  old plain
	 * @param pNew  new plain
	 */
	public static void updatePlain(Plain pOld, Plain pNew)
	{
		// TODO 
		// 
		// For every life form (i.e., a Living object) in the grid pOld, generate  
		// a Living object in the grid pNew at the corresponding location such that 
		// the former life form changes into the latter life form. 
		// 
		// Employ the method next() of the Living class. 
		
		int width = pOld.getWidth();
		
		for (int row = 0; row < width; row++)
		{
			for (int col = 0; col < width; col++) 
			{	
				pNew.grid[row][col] = pOld.grid[row][col].next(pNew);
			}
		}
	}

	/**
	 * Repeatedly generates plains either randomly or from reading files. 
	 * Over each plain, carries out an input number of cycles of evolution. 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException
	{	
		// TODO 
		// 
		// Generate wildlife simulations repeatedly like shown in the 
		// sample run in the project description. 
		// 
		// 1. Enter 1 to generate a random plain, 2 to read a plain from an input
		//    file, and 3 to end the simulation. (An input file always ends with 
		//    the suffix .txt.)
		// 
		// 2. Print out standard messages as given in the project description. 
		// 
		// 3. For convenience, you may define two plains even and odd as below. 
		//    In an even numbered cycle (starting at zero), generate the plain 
		//    odd from the plain even; in an odd numbered cycle, generate even 
		//    from odd. 
		
		Plain even;   				 // the plain after an even number of cycles 
		Plain odd;                   // the plain after an odd number of cycles
		
		// 4. Print out initial and final plains only.  No intermediate plains should
		//    appear in the standard output.  (When debugging your program, you can 
		//    print intermediate plains.)
		// 
		// 5. You may save some randomly generated plains as your own test cases. 
		// 
		// 6. It is not necessary to handle file input & output exceptions for this 
		//    project. Assume data in an input file to be correctly formated. 
		
		int trialCount = 0; 
		int width = 0; 
		int cycles = 0; 
		boolean state = true; 
		Plain p = new Plain(0);
		
		
		while (state != false)
		{
			trialCount++;
			
			System.out.print("Please choose a number! \n");
			System.out.print("Simulation of Wildlife of the Plain keys: 1 (random plain) 2 (file input) "
					+ "3 (exit) \n");
			
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("Trial " + trialCount + ": ");
			int simKey = scanner.nextInt();
		
			//*******************************************************
			// RANDOM 
			
			if (simKey == 1)
			{
				System.out.print("Random Plain \n");
				
				System.out.print("Enter grid width: ");
				width = scanner.nextInt();
				System.out.print("Enter the number of cycles: ");

				cycles = scanner.nextInt();
				System.out.print("\n \n");
				System.out.print("Initial plain: \n \n");
				p = new Plain(width);
				p.randomInit();
				System.out.print(p.toString() +"\n \n");
				
				even = new Plain(width);
				odd = new Plain(width);
				
				odd = p;
				even = p; 
				
				for (int l = 0; l < cycles; l++)
				{
					if ((l % 2) != 0)
					{
						updatePlain(even, odd);
					}
					
					else 
					{
						updatePlain(odd, even);
					}
				}
				
				if ((cycles % 2) != 0)
				{
					System.out.print("Final plain: \n \n");
					System.out.print(even +"\n \n");
				}
				
				else 
				{
					System.out.print("Final plain: \n \n");
					System.out.print(odd + "\n \n");
				}
			}
			
			
			//*********************************************************
			// READING FROM FILE
			else if (simKey == 2)
			{
				System.out.print("Plain input from a file \n");
				System.out.print("Filename: ");
				String fileName = scanner.next();
				System.out.print("Enter the number of cycles: ");
				cycles = scanner.nextInt();
				
				System.out.print("\n \n");
				String srcPath = "src/edu/iastate/cs228/hw1/" + fileName;
				p = new Plain(srcPath);
				
				System.out.print("Initial plain: \n \n");
				System.out.print(p.toString() + "\n \n");
				
				even = new Plain(srcPath);
				odd = new Plain(srcPath);
				
				for (int l = 0; l < cycles; l++)
				{
					if ((l % 2) != 0)
					{
						updatePlain(even, odd);
					}
					
					else 
					{
						updatePlain(odd, even);
					}
				}
				
				if ((cycles % 2) != 0)
				{
					System.out.print("Final plain: \n \n");
					System.out.print(even +"\n \n");
				}
				
				else 
				{
					System.out.print("Final plain: \n \n");
					System.out.print(odd + "\n \n");
				}
			}
			
			else
			{
				trialCount = 0;
				state = false; 
			}
		}	
	}	
}