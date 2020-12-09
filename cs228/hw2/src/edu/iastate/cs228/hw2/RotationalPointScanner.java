package edu.iastate.cs228.hw2;

import java.io.File;

/**
 * 
 * @author
 * Vance Kaw
 *
 */

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * 
 * This class sorts all the points in an array by polar angle with respect to a reference point whose x and y 
 * coordinates are respectively the medians of the x and y coordinates of the original points. 
 * 
 * It records the employed sorting algorithm as well as the sorting time for comparison. 
 *
 */
public class RotationalPointScanner  
{
	private Point[] points; 
	
	private Point medianCoordinatePoint;  // point whose x and y coordinates are respectively the medians of 
	                                      // the x coordinates and y coordinates of those points in the array points[].
	private Algorithm sortingAlgorithm;    
	
	protected String outputFileName;   // "select.txt", "insert.txt", "merge.txt", or "quick.txt"
	
	protected long scanTime; 	       // execution time in nanoseconds. 
	
	/**
	 * This constructor accepts an array of points and one of the four sorting algorithms as input. Copy 
	 * the points into the array points[]. Set outputFileName. 
	 * 
	 * @param  pts  input array of points 
	 * @throws IllegalArgumentException if pts == null or pts.length == 0.
	 */
	public RotationalPointScanner(Point[] pts, Algorithm algo) throws IllegalArgumentException
	{	
		if (pts == null || pts.length == 0)
		{
			throw new IllegalArgumentException();
		}
		
		else 
		{
			points = new Point[pts.length];

			for (int i = 0; i < pts.length; i++)
			{
				points[i] = pts[i];

			}
			
			sortingAlgorithm = algo;
			
			if (sortingAlgorithm == Algorithm.SelectionSort)
			{
				outputFileName = "select.txt";
			}
			
			else if (sortingAlgorithm == Algorithm.InsertionSort)
			{
				outputFileName = "insert.txt";
			}
			
			else if (sortingAlgorithm == Algorithm.MergeSort)
			{
				outputFileName = "merge.txt";
			}
			
			else if (sortingAlgorithm == Algorithm.QuickSort)
			{
				outputFileName = "quick.txt";
			}
		}
	}

	
	/**
	 * This constructor reads points from a file. Set outputFileName. 
	 * 
	 * @param  inputFileName
	 * @throws FileNotFoundException 
	 * @throws InputMismatchException   if the input file contains an odd number of integers
	 */
	protected RotationalPointScanner(String inputFileName, Algorithm algo) throws FileNotFoundException, InputMismatchException
	{
		try 
		{
			File file = new File(inputFileName);
			Scanner scanner = new Scanner(file);
			Point point = new Point();
			
			ArrayList<String> arrList = new ArrayList<String>();
		
			while (scanner.hasNextLine())
			{
				arrList.add(scanner.nextLine());
			}
			scanner.close();
			
			Scanner scan = new Scanner(file);
			ArrayList<Integer> newArr = new ArrayList<Integer>();
			
			int arrSize = arrList.size();
			for (int i = 0; i < arrSize; i++)
			{
				scan = new Scanner(arrList.get(i));
				
				while (scan.hasNextInt())
				{
					newArr.add(scan.nextInt());
				}
			}
			
			if ((newArr.size() % 2) != 0)
			{
				scan.close();
				throw new InputMismatchException();
			}
			
			else 
			{
				points = new Point[newArr.size() / 2];
				for (int j = 0, k = 0; j < newArr.size(); j+=2, k++)
				{
					Point p2 = new Point(newArr.get(j), newArr.get(j+1));
					
					if (j == 0)
					{
						point = p2;
					}
					
					else if (point.compareTo(p2) > 0)
					{
						point = p2;
					}
					
					points[k] = p2;
				}
				scan.close();
			}

			sortingAlgorithm = algo;
			
			if (sortingAlgorithm == Algorithm.SelectionSort)
			{
				outputFileName = "select.txt";
			}
			
			else if (sortingAlgorithm == Algorithm.InsertionSort)
			{
				outputFileName = "insert.txt";
			}
			
			else if (sortingAlgorithm == Algorithm.MergeSort)
			{
				outputFileName = "merge.txt";
			}
			
			else if (sortingAlgorithm == Algorithm.QuickSort)
			{
				outputFileName = "quick.txt";
			}
		}
		
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	
	/**
	 * Carry out three rounds of sorting using the algorithm designated by sortingAlgorithm as follows:  
	 *    
	 *     a) Sort points[] by the x-coordinate to get the median x-coordinate. 
	 *     b) Sort points[] again by the y-coordinate to get the median y-coordinate.
	 *     c) Construct medianCoordinatePoint using the obtained median x- and y-coordinates. 
	 *     d) Sort points[] again by the polar angle with respect to medianCoordinatePoint.
	 *  
	 * Based on the value of sortingAlgorithm, create an object of SelectionSorter, InsertionSorter, MergeSorter,
	 * or QuickSorter to carry out sorting. Copy the sorting result back onto the array points[] by calling 
	 * the method getPoints() in AbstractSorter. 
	 *      
	 * @param algo
	 * @return
	 */
	public void scan()
	{  
		AbstractSorter aSorter; 
		
		// create an object to be referenced by aSorter according to sortingAlgorithm. for each of the three 
		// rounds of sorting, have aSorter do the following: 
		// 
		//     a) call setComparator() with an argument 0, 1, or 2. in case it is 2, must have made 
		//        the call setReferencePoint(medianCoordinatePoint) already. 
		//
		//     b) call sort(). 		
		// 
		// sum up the times spent on the three sorting rounds and set the instance variable scanTime. 
		
		
		if (sortingAlgorithm == Algorithm.InsertionSort)
		{
			aSorter = new InsertionSorter(points);
			
			long startTime = 0;
			long endTime = 0;
			long tempScanTime = 0;
			
			aSorter.setComparator(0);
			startTime = System.nanoTime();
			aSorter.sort();
			endTime = System.nanoTime();
			tempScanTime += (endTime - startTime);
			
			aSorter.setComparator(1);
			startTime = System.nanoTime();
			aSorter.sort();
			endTime = System.nanoTime();
			tempScanTime += (endTime - startTime);	
			
			medianCoordinatePoint = aSorter.getMedian();
			aSorter.setReferencePoint(medianCoordinatePoint);
			aSorter.setComparator(2);
			startTime = System.nanoTime();
			aSorter.sort();
			endTime = System.nanoTime();
			tempScanTime += (endTime - startTime);
			
			scanTime = tempScanTime;
			aSorter.getPoints(points);
		}
		
		else if (sortingAlgorithm == Algorithm.SelectionSort)
		{
			aSorter = new SelectionSorter(points);

			long startTime = 0;
			long endTime = 0;
			long tempScanTime = 0;
			
			aSorter.setComparator(0);
			startTime = System.nanoTime();
			aSorter.sort();
			endTime = System.nanoTime();
			tempScanTime += (endTime - startTime);
			
			aSorter.setComparator(1);
			startTime = System.nanoTime();
			aSorter.sort();
			endTime = System.nanoTime();
			tempScanTime += (endTime - startTime);	
			
			medianCoordinatePoint = aSorter.getMedian();
			aSorter.setReferencePoint(medianCoordinatePoint);
			aSorter.setComparator(2);
			startTime = System.nanoTime();
			aSorter.sort();
			endTime = System.nanoTime();
			tempScanTime += (endTime - startTime);
			
			scanTime = tempScanTime;
			aSorter.getPoints(points);
		}
		
		else if (sortingAlgorithm == Algorithm.QuickSort)
		{
			aSorter = new QuickSorter(points);

			long startTime = 0;
			long endTime = 0;
			long tempScanTime = 0;
			
			aSorter.setComparator(0);
			startTime = System.nanoTime();
			aSorter.sort();
			endTime = System.nanoTime();
			tempScanTime += (endTime - startTime);
			
			aSorter.setComparator(1);
			startTime = System.nanoTime();
			aSorter.sort();
			endTime = System.nanoTime();
			tempScanTime += (endTime - startTime);	
			
			medianCoordinatePoint = aSorter.getMedian();
			aSorter.setReferencePoint(medianCoordinatePoint);
			aSorter.setComparator(2);
			startTime = System.nanoTime();
			aSorter.sort();
			endTime = System.nanoTime();
			tempScanTime += (endTime - startTime);
			
			scanTime = tempScanTime;
			aSorter.getPoints(points);
		}
		
		else if (sortingAlgorithm == Algorithm.MergeSort)
		{
			aSorter = new MergeSorter(points);

			long startTime = 0;
			long endTime = 0;
			long tempScanTime = 0;

			
			aSorter.setComparator(0);
			startTime = System.nanoTime();
			aSorter.sort();
			endTime = System.nanoTime();
			tempScanTime += (endTime - startTime);
			
			aSorter.setComparator(1);
			startTime = System.nanoTime();
			aSorter.sort();
			endTime = System.nanoTime();
			tempScanTime += (endTime - startTime);	
			
			medianCoordinatePoint = aSorter.getMedian();
			aSorter.setReferencePoint(medianCoordinatePoint);
			aSorter.setComparator(2);
			startTime = System.nanoTime();
			aSorter.sort();
			endTime = System.nanoTime();
			tempScanTime += (endTime - startTime);
			
			scanTime = tempScanTime;
			aSorter.getPoints(points);
		}
	}
	
	
	/**
	 * Outputs performance statistics in the format: 
	 * 
	 * <sorting algorithm> <size>  <time>
	 * 
	 * For instance, 
	 * 
	 * selection sort   1000	  9200867
	 * 
	 * Use the spacing in the sample run in Section 2 of the project description. 
	 */
	public String stats()
	{
		
		String output = sortingAlgorithm + " " + points.length + "  " + scanTime; 
		
		return output;
	}
	
	
	/**
	 * Write points[] after a call to scan().  When printed, the points will appear 
	 * in order of polar angle with respect to medianCoordinatePoint with every point occupying a separate 
	 * line.  The x and y coordinates of the point are displayed on the same line with exactly one blank space 
	 * in between. 
	 */
	@Override
	public String toString()
	{
		
		
		String orderedPoints = "";
		
		for (int i = 0; i < points.length; i++)
		{
			orderedPoints += String.format("%d %d\n", points[i].getX(), points[i].getY());
		}
		return orderedPoints; 
	}

	
	/**
	 *  
	 * This method, called after scanning, writes point data into a file by outputFileName. The format 
	 * of data in the file is the same as printed out from toString().  The file can help you verify 
	 * the full correctness of a sorting result and debug the underlying algorithm. 
	 * 
	 * @throws FileNotFoundException
	 */
	public void writePointsToFile() throws FileNotFoundException
	{
		try 
		{
			File file = new File(outputFileName);
			PrintWriter pw = new PrintWriter(file);
			String str = this.toString();
			pw.write(str);
			pw.close();
		}
		
		catch (FileNotFoundException e)
		{
			return;
		}
	}	

	
	/**
	 * This method is called after each scan for visually check whether the result is correct.  You  
	 * just need to generate a list of points and a list of segments, depending on the value of 
	 * sortByAngle, as detailed in Section 4.1. Then create a Plot object to call the method myFrame().  
	 */
	public void draw()
	{		
		int numSegs = 0;  // number of segments to draw 
		numSegs = points.length * 2;

		// Based on Section 4.1, generate the line segments to draw for display of the sorting result.
		// Assign their number to numSegs, and store them in segments[] in the order. 
		Segment[] segments = new Segment[numSegs]; 

		ArrayList<Point> p1 = new ArrayList<Point>();


		for(int i = 0; i < points.length; i++) 
		{ 
			if(!p1.contains(points[i])) 
			{
				p1.add(points[i]);
			}
		}

		int count = 0;
		for(int i = 0; i < p1.size() - 1; i++) 
		{

			if(!p1.get(i).equals(p1.get(i+1))) 
			{
				segments[i] = new Segment(p1.get(i),p1.get(i+1));
				count++;
			}

		}

		if(!points[0].equals(points[points.length - 1])) 
		{
			segments[count++] = new Segment(points[0], points[points.length - 1]); 
		}
		for(int i = 0; i < p1.size(); i++) {
			segments[count++] = new Segment(this.medianCoordinatePoint, p1.get(i));
		}


		Segment[] segsCopy = new Segment[count];
		for(int i = 0; i < segsCopy.length; i++) {
			segsCopy[i] = segments[i];
		}
		segments = segsCopy;



		String sort = null; 

		switch(sortingAlgorithm)
		{
		case SelectionSort: 
			sort = "Selection Sort"; 
			break; 
		case InsertionSort: 
			sort = "Insertion Sort"; 
			break; 
		case MergeSort: 
			sort = "Mergesort"; 
			break; 
		case QuickSort: 
			sort = "Quicksort"; 
			break; 
		default: 
			break; 		
		}

		System.out.println(Arrays.deepToString(points));
		System.out.println(p1);
		System.out.println(Arrays.deepToString(segments));
		System.out.println(segments.length);

		// The following statement creates a window to display the sorting result.
		Plot.myFrame(points, segments, sort);
	
		
	}
		
}
