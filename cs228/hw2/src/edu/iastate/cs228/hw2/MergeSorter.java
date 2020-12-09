package edu.iastate.cs228.hw2;

import java.io.FileNotFoundException;
import java.lang.NumberFormatException; 
import java.lang.IllegalArgumentException; 
import java.util.InputMismatchException;

/**
 *  
 * @author
 * Vance Kaw
 */

/**
 * 
 * This class implements the mergesort algorithm.  
 * Sorting algorithm for merge sort found and referred online 
 *
 */

public class MergeSorter extends AbstractSorter
{
	// Other private instance variables if you need ... 
	
	private Point[] helper;
	private int number;
	private int low;
	private int high; 
	private int middle;
	
	/** 
	 * Constructor takes an array of points.  It invokes the superclass constructor, and also 
	 * set the instance variables algorithm in the superclass.
	 *  
	 * @param pts   input array of integers
	 */
	public MergeSorter(Point[] pts) 
	{
		super(pts);
		algorithm = "mergesort";
	}


	/**
	 * Perform mergesort on the array points[] of the parent class AbstractSorter. 
	 * 
	 */
	@Override 
	public void sort()
	{
		number = points.length;
		this.helper = new Point[number];
		mergeSort(0, number - 1);
		
		for (int i = 0; i < helper.length; i++)
		{
			points[i] = helper[i];
		}
		
	}
	
	
	/**
	 * Performing a recursive call of mergeSort to sort particular side of the array
	 * @param low
	 * the first index of the array
	 * @param high
	 * the last index of the array
	 */
	private void mergeSort(int low, int high)
	{
		// check if low is smaller than high, if not then the array is sorted 
		if (low < high)
		{
			// Get the index of the element which is in the middle
			int middle = low + (high - low) / 2;
			
			// sort the left side of the array
			mergeSort(low, middle);
			
			// sort the right side of the array
			mergeSort(middle + 1, high);
			
			// combine them both
			mergeSortRec(points);
			
			this.low = low;
			this.middle = middle;
			this.high = high;
		}
		
		
	}

	
	/**
	 * This is a recursive method that carries out mergesort on an array pts[] of points. One 
	 * way is to make copies of the two halves of pts[], recursively call mergeSort on them, 
	 * and merge the two sorted subarrays into pts[].   
	 * 
	 * @param pts	point array 
	 */
	private void mergeSortRec(Point[] pts)
	{
		// copy both parts into the helper array
		for (int i = low; i <= high; i++)
		{
			helper[i] = pts[i];
		}
		
		int i = low; 
		int j = middle + 1;
		int k = low;
		
		//copy the smallest values from either the left or the right side back to the original array
		while(i <= middle && j <= high)
		{
//			if (helper[i] <= helper[j])
			if ((pointComparator.compare(helper[i], helper[j]) < 1))
			{
				pts[k] = helper[i];
				i++;
			}
			
			else 
			{
				pts[k] = helper[j];
				j++;
			}
			k++;
		}
		
		// copy the rest of the left side of the array into the target array
		while (i <= middle)
		{
			pts[k] = helper[i];
			k++;
			i++;
		}
		// Since we are sorting in-place any leftover elements from the right side are already at the right position. 
	}

	
	// Other private methods in case you need ...

}
