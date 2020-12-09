package cs228hw1.stats;

import java.util.ArrayList;

/**
 * A class that extends AbstractStat for implementations StatObject interface for Maximum
 * Returns the maximum of the elements in the ArrayList data. 
 * @author vancekaw
 * @param <T>
 * The type of data to be used in the calculation. Must be a number of some variety. 
 */
public class Maximum<T extends Number> extends AbstractStat<T> 
{
	/**
	 * An empty constructor for this Average class.
	 */
	public Maximum()
	{
		
	}
	
	/**
	 * A constructor for the Maximum class that takes in an argument/parameter called data
	 * Passes the data and calls the method in the AbstractClass called SetData
	 * A constructor with an appropriate ArrayList parameter that performs a deep copy
	 * from the parameter to the data object. 
	 * @param data
	 * An ArrayList of type T called data. Could be a set of given numbers.
	 */
	public Maximum(ArrayList<T> data)
	{
		SetData(data);
		super.GetData();
	}

	/**
	 * This method returns the maximum of all numbers in the data object.
	 * A new ArrayList is created to match the expected return type of the method. 
	 * First checks to see if there is anything in the ArrayList number. 
	 * If it sees a null in the data object, it will just skip or proceed as normal. 
	 * If the data object is null or contains no elements that a Runtime Exception 
	 * indicating this. 
	 */
	@Override
	public ArrayList<Number> GetResult() throws RuntimeException {

		long maximum = number.get(0).longValue();
		int index = 0; 
		ArrayList<Number> maxValue = new ArrayList<Number>();

		for (int i = 1; i < number.size(); i++)
		{
			if (number.get(i) == null)
			{

			}
			
			else 
			{
				long currentNum = number.get(i).longValue();
				if (currentNum > maximum)
				{
					maximum = currentNum;
					index = i;
				}
				
				else if(currentNum == maximum)
				{
					
				}
			}
		}
		maxValue.add(number.get(index));
		
		return maxValue;
	}

}