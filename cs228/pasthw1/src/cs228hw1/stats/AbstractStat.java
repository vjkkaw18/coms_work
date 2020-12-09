package cs228hw1.stats;

import java.util.ArrayList;


/**
 * A partial implementation of the StatObject interface. A superclass called AbstractStat
 * that implements most of the methods contained in the math classes. 
 * @author vancekaw
 * An AbstractStat class of type T that extends number. 
 * @param <T>
 * The type of data to be used in the calculation. Must be a number of some variety.
 */
public abstract class AbstractStat<T extends Number>  implements StatObject<T>
{

	protected ArrayList<T> number;
	protected String description;
	
	
	@Override
	public void SetDescription(String d) {
		description = d;
	}

	
	@Override
	public String GetDescription() {
		return description;
	}

	@Override
	public void SetData(ArrayList<T> data) {
		
		number = new ArrayList<T>();
		
		for(int i = 0; i < data.size(); i++)
		{
			if (data.get(i) == null)
			{
			}

			else 
			{
				number.add(data.get(i));
			}
		}	
	}

	@Override
	public ArrayList<T> GetData() {
		return number;
	}

}
