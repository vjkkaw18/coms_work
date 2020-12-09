package cs228hw1.stats;

/**
 * This is a class called the Double Parser that implements the IParser interface. 
 * It parses the parameter given from a string to a double. 
 * @author vancekaw
 */
public class DoubleParser implements IParser<Double>
{

	/**
	 * Given the argument/parameter str, this method tries to parse the string to a double
	 * but if it fails, it will throw a Number format exception. 
	 */
	@Override
	public Double parse(String str) {
		double num;
		
		try
		{
			 num = Double.parseDouble(str);
		}
		
		catch (NumberFormatException e)
		{
			throw new NumberFormatException();
		}
		return num;
	}

}
