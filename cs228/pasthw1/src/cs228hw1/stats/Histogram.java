package cs228hw1.stats;

import java.util.ArrayList;

/**
 * A class called the Historgram that extends AbstratStat for implementations StatObject
 * interface for Historgram
 * @author vancekaw
 * @param <T>
 * The type of data to be used in the calculation. Must be a number of some variety. 
 */
public class Histogram<T extends Number> extends AbstractStat<T> 
{
	
	
	private double minRange = Integer.MIN_VALUE;
	private double maxRange = Integer.MAX_VALUE;
	private int numBins = 10;

	/**
	 * An empty constructor for this Historgram class. 
	 */
	public Histogram()
	{
		
	}
	
	/**
	 * A constructor for the Histogram class that takes in an argument/parameter called data 
	 * that performs a deep copy from the parameter to the data object. 
	 * @param data
	 * An ArrayList of type T called data. Could be a set of given numbers. 
	 */
	public Histogram(ArrayList<T> data)
	{
		SetData(data);
		super.GetData();
	}

	/**
	 * Returns an ArrayList parameter that performs a deep copy from the parameter to the data object
	 * The value ranges of the bins are set via other methods. 
	 * A runtime exception is thrown if the histogram is not valid for any reason. 
	 * A histogram can be valid for zero data elements, but is invalid if the MinRange is greater 
	 * than the MaxRange 
	 */
	@Override
	public ArrayList<Number> GetResult() throws RuntimeException {
		
		double interval = (Math.abs(maxRange) - Math.abs(minRange)) / numBins;
		
		ArrayList<Number> doubleVal = new ArrayList<Number>(numBins); 

		if (number.size() == 0) 
		{
			throw new RuntimeException();
		}
		
		double[] tempArr = new double[numBins];
		
		for (int i = 0; i < number.size(); i++)
		{	
			if (number.get(i) == null)
			{

			}

			else 
			{
				double currentNum = number.get(i).doubleValue();
				
				if (currentNum < minRange || currentNum >= maxRange)
				{

				}

				else
				{
					for(int j = 1; j < numBins; j++)
					{
						if(currentNum == minRange)
						{
							tempArr[j-1] += 1;
							break;
						}

						else if (currentNum > minRange 
								&& currentNum < minRange + (interval * j))
						{
							tempArr[j-1] += 1;
							break;
						}

						else if (currentNum > minRange + (interval * j) 
								&& currentNum < minRange + (interval * (j+1)))
						{
							tempArr[j] += 1;
							break;
						}
					}
				}
			}


		}
		for (int k = 0; k < numBins; k++)
		{
			int temp = (int) tempArr[k];
			doubleVal.add(temp);
		}

		return doubleVal;
	}
	
	/**
	 * A method that sets the number of equal size bins in the histogram
	 * If this method is not called then the default value is 10
	 * @param givenBins
	 * The given number of bins
	 */
	public void SetNumberBins(int givenBins)
	{
		numBins = givenBins;
	}
	
	/**
	 * A method that returns the current number of bins 
	 * @return
	 */
	public double GetNumberBins()
	{
		return numBins;
	}
	
	/**
	 * A method that sets the highest value at which data is included in the highest bin. 
	 * Data that is greater or equal than this value is not placed in any bins if GetResult is called
	 * The default is positive infinity. 
	 * @param givenMaxTemp
	 * given maximum temperature
	 */
	public void SetMaxRange(T givenMaxTemp)
	{
		maxRange = givenMaxTemp.doubleValue();
	}
	/**
	 * Returns the current MaxRange value
	 */
	
	public double getMaxRange()
	{
		return maxRange;
	}
	
	/**
	 * A method that sets the lowest value at which data is included in the lowest bin
	 * Data that is less than this value is not placed if any bin if Get Result is called. 
	 * The default is negative infinity. 
	 * @param givenMinTemp
	 * given minimum temperature
	 */
	public void SetMinRange(T givenMinTemp)
	{
		minRange = givenMinTemp.doubleValue();
	}
	
	/**
	 * returns the minimum range value
	 * @return
	 */
	public double GetMinRange()
	{
		return minRange;
	}
	
}
