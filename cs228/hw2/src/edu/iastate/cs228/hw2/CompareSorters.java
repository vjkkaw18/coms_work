package edu.iastate.cs228.hw2;

/**
 *  
 * @author
 * Vance Kaw
 *
 */

/**
 * 
 * This class executes four sorting algorithms: selection sort, insertion sort, mergesort, and
 * quicksort, over randomly generated integers as well integers from a file input. It compares the 
 * execution times of these algorithms on the same input. 
 *
 */

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner; 


public class CompareSorters 
{
	/**
	 * Repeatedly take integer sequences either randomly generated or read from files. 
	 * Use them as coordinates to construct points.  Scan these points with respect to their 
	 * median coordinate point four times, each time using a different sorting algorithm.  
	 * 
	 * @param args
	 **/
	public static void main(String[] args) throws FileNotFoundException
	{		
		// TODO 
		// 
		// Conducts multiple rounds of comparison of four sorting algorithms.  Within each round, 
		// set up scanning as follows: 
		// 
		//    a) If asked to scan random points, calls generateRandomPoints() to initialize an array 
		//       of random points. 
		// 
		//    b) Reassigns to the array scanners[] (declared below) the references to four new 
		//       RotationalPointScanner objects, which are created using four different values  
		//       of the Algorithm type:  SelectionSort, InsertionSort, MergeSort and QuickSort. 
		// 
		// 	
		RotationalPointScanner[] scanners = new RotationalPointScanner[4]; 
		
		// For each input of points, do the following. 
		// 
		//     a) Initialize the array scanners[].  
		//
		//     b) Iterate through the array scanners[], and have every scanner call the scan() and draw() 
		//        methods in the RotationalPointScanner class.  You can visualize the result of each scan.  
		//        (Windows have to be closed manually before rerun.)  
		// 
		//     c) After all four scans are done for the input, print out the statistics table (cf. Section 2). 
		//
		// A sample scenario is given in Section 2 of the project description. 
		
		System.out.println("Performances of Four Sorting Algorithms in Point Scanning keys: "
				+ "1 (random integers) 2 (file input) 3 (exit)");
		Scanner scanner = new Scanner(System.in);
		int trialCount = 1;
		boolean state = true;
		
		
		while(state != false)
		{
			System.out.print("Trial " + trialCount + ": ");
			int trial = scanner.nextInt();
			
			// random
			if (trial == 1)
			{
				System.out.print("Enter number of random points: ");
				int randomPoints = scanner.nextInt();
				System.out.println("algorithm size time (ns)");
				System.out.println("------------------------------------");
				
				Point[] points = CompareSorters.generateRandomPoints(randomPoints, new Random());
				
				scanners[0] = new RotationalPointScanner(points, Algorithm.SelectionSort);
				scanners[1] = new RotationalPointScanner(points, Algorithm.InsertionSort);
				scanners[2] = new RotationalPointScanner(points, Algorithm.MergeSort);
				scanners[3] = new RotationalPointScanner(points, Algorithm.QuickSort);
				
				for (int i = 0; i < scanners.length; i++)
				{
					scanners[i].scan();
					scanners[i].draw();
					
					if (i == 0)
					{
						System.out.println(scanners[i].stats());
						scanners[i].writePointsToFile();
					}
					
					else if (i == 1)
					{
						System.out.println(scanners[i].stats());
						scanners[i].writePointsToFile();
					}
					
					else if (i == 2)
					{
						System.out.println(scanners[i].stats());
						scanners[i].writePointsToFile();
					}
					
					else if (i == 3)
					{
						System.out.println(scanners[i].stats());
						scanners[i].writePointsToFile();
					}				
				}
				System.out.println("------------------------------------");
				
				
				trialCount += 1;
			}
			
			// file input
			else if (trial == 2)
			{
				String fileName = scanner.next();
				
				scanners[0] = new RotationalPointScanner(fileName, Algorithm.SelectionSort);
				scanners[1] = new RotationalPointScanner(fileName, Algorithm.InsertionSort);
				scanners[2] = new RotationalPointScanner(fileName, Algorithm.MergeSort);
				scanners[3] = new RotationalPointScanner(fileName, Algorithm.QuickSort);
				
				for (int i = 0; i < scanners.length; i++)
				{
					scanners[i].scan();
					scanners[i].draw();
					
					if (i == 0)
					{
						System.out.println(scanners[i].stats());
						scanners[i].writePointsToFile();
					}
					
					else if (i == 1)
					{
						System.out.println(scanners[i].stats());
						scanners[i].writePointsToFile();
					}
					
					else if (i == 2)
					{
						System.out.println(scanners[i].stats());
						scanners[i].writePointsToFile();
					}
					
					else if (i == 3)
					{
						System.out.println(scanners[i].stats());
						scanners[i].writePointsToFile();
					}				
				}
				System.out.println("------------------------------------");
				
				
				trialCount += 1;
			}
			
			else
			{
				trialCount = 0;
				state = false; 
			}
			
		}
	}
	
	
	/**
	 * This method generates a given number of random points.
	 * The coordinates of these points are pseudo-random numbers within the range 
	 * [-50,50] � [-50,50]. Please refer to Section 3 on how such points can be generated.
	 * 
	 * Ought to be private. Made public for testing. 
	 * 
	 * @param numPts  	number of points
	 * @param rand      Random object to allow seeding of the random number generator
	 * @throws IllegalArgumentException if numPts < 1
	 */
	public static Point[] generateRandomPoints(int numPts, Random rand) throws IllegalArgumentException
	{	
		if(numPts < 1)
		{
			throw new IllegalArgumentException();
		}
		
		else 
		{
			Point[] pts = new Point[numPts];
			
			for(int i = 0; i < pts.length; i++) 
			{
				pts[i] = new Point(rand.nextInt(101) - 50, rand.nextInt(101) - 50);
			}
			
			return pts;
		}
	}
	
}
