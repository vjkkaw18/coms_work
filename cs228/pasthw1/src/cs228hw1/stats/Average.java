package cs228hw1.stats;

import java.util.ArrayList;

/**
 * A class that extends AbstractStat for implementations StatObject 
 * interface for Average. 
 * Computes the average of the elements in the ArrayList data
 * @author vancekaw
 * @param <T> 
 * The type of data to be used in the calculation. Must be a number of some variety.
 */
public class Average<T extends Number> extends AbstractStat<T> 
{

	/**
	 * An empty constructor for this Average class.
	 */
	public Average()
	{
		
	}
	
	/**
	 * A constructor for the Average class that takes in an argument/parameter called data 
	 * @param data
	 * An ArrayList of type T called data. Could be a set of given numbers. 
	 */
	public Average(ArrayList<T> data)
	{
		SetData(data);
		super.GetData();
	}
	
	/**
	 * This method returns the average of all numbers in the data object. 
	 * A new ArrayList is created to match the expected return type of the method. 
	 * First checks to see if there is anything in the ArrayList number. If there's none, 
	 * then a runtime exception is thrown. 
	 * If there are elements inside the ArrayList number, then the necessary operations
	 * are carried out to get the average. 
	 */
	@Override
	public ArrayList<Number> GetResult() throws RuntimeException {

		double totalNum = 0.0;
		double average = 0.0;
		ArrayList<Number> newAverage = new ArrayList<Number>(); 
	

		if (number.size() == 0) 
		{
			throw new RuntimeException();
		}

		for (int i = 0; i < number.size(); i++)
		{
			totalNum += number.get(i).doubleValue();
		}

		average = totalNum / number.size();
		newAverage.add(average);
		return newAverage;
	}

}
