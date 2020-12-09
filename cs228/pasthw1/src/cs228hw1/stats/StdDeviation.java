package cs228hw1.stats;

import java.util.ArrayList;

/**
 * A class that extends AbstractStat for implementations StatObject 
 * interface for StdDeviation. 
 * Computes the standard deviation of the elements in the ArrayList data
 * @author vancekaw
 * @param <T> 
 * The type of data to be used in the calculation. Must be a number of some variety.
 */
public class StdDeviation<T extends Number> extends AbstractStat<T> 
{
	/**
	 * An empty constructor for this Average class.
	 */
	public StdDeviation()
	{
		
	}
	
	/**
	 * A constructor for the StdDeviation class that takes in an argument/parameter called data 
	 * A constructor that calls in SetData method in the AbstractStat class to perform a deep copy
	 * @param data
	 * An ArrayList of type T called data. Could be a set of given numbers. 
	 */
	public StdDeviation(ArrayList<T> data)
	{
		SetData(data);
		super.GetData();
	}

	/**
	 * Returns the standard deviation of all numbers in the data object. 
	 * If the data object is null or contains no elements that a Runtime Exception indicating this. 
	 * 
	 */
	@Override
	public ArrayList<Number> GetResult() throws RuntimeException {

		double totalNum = 0.0;
		double average = 0.0;
		ArrayList<Number> newData = new ArrayList<Number>(); 
		double tempNum = 0.0;
		double tempNum2 = 0.0;
		double stdDevValue = 0.0;
		double total = 0.0; 
		ArrayList<Number> finalValue = new ArrayList<Number>(); 
	

		if (number.size() == 0) 
		{
			throw new RuntimeException();
		}

		for (int i = 0; i < number.size(); i++)
		{
			if (number.get(i) == null)
			{
				
			}
			
			else
			{
				totalNum += number.get(i).doubleValue();
			}
		}

		average = totalNum / number.size(); 
		
		for (int j = 0; j < number.size(); j++)
		{
			tempNum = number.get(j).doubleValue() - average;
			tempNum2 = tempNum * tempNum;
			newData.add(tempNum2);
			total = total + tempNum2;
		}
		
		
		stdDevValue = Math.sqrt(total/(newData.size() - 1));
		
		finalValue.add(stdDevValue);
		
		return finalValue;
	}

}

