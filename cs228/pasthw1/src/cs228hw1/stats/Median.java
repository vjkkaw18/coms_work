package cs228hw1.stats;

import java.util.ArrayList;
import java.util.Collections;


/**
 * A class that extends AbstractStat for implementations StatObject interface for Median
 * Computes the median of the elements in the ArrayList data 
 * @author vancekaw
 * @param <T>
 * The type of data to be used in the calculation. Must be a number of some variety 
 */

public class Median<T extends Number> extends AbstractStat<T> 
{
	
	/**
	 * An empty constructor for this Median class
	 */
	public Median()
	{
		
	}
	
	/**
	 * A constructor for the Median class that takes in an argument/parameter called data
	 * @param data
	 * calls SetData to performs a deep copy from the parameter to the data object. 
	 * An ArrayList of type T called data. Could be a set of given numbers. 
	 */
	public Median(ArrayList<T> data)
	{
		SetData(data);
		super.GetData();
	}

	
	/**
	 * Returns the median of all the numbers in the data object. 
	 * The median is computed differently depending of the number of data is odd or even. 
	 * If the data object is null or contains no elements that a Runtime Exception indicating this 
	 * Colloections.sort is used to arrange the elements in increasing order to get the median
	 */
	@Override
	public ArrayList<Number> GetResult() throws RuntimeException {

		int index = 0;
		double median = 0.0;
		
		ArrayList<Double> temp = new ArrayList<Double>();
		
		for (int i = 0; i < number.size(); i++)
		{
			if (number.get(i) == null)
			{
				
			}
			else
			{
				temp.add(number.get(i).doubleValue());
			}
		}
		
		ArrayList<Number> medianValue = new ArrayList<Number>();
		
		Collections.sort(temp);
		
		if (temp.size() == 0) 
		{
			throw new RuntimeException();
		}
	
		if (temp.size() % 2 == 0) // number of items are even
		{
			index = (temp.size() / 2);
			median = ((Double) temp.get(index) + (Double) temp.get(index - 1)) / 2;
			medianValue.add(median);
		}
		else 					// number of items are odd 
		{
			index = (temp.size() - 1) / 2;
			median = (Double) temp.get(index);
			medianValue.add(median);
		}

		return medianValue;
	}

}