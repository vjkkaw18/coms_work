package GuangSongLecture;

public class Calculator {
	
	private int value1;
	private int value2;
	private int totalValue;
	
	public Calculator(int givenValue1, int givenValue2)
	{
		value1 = givenValue1;
		value2 = givenValue2;
	}
	
	public int add()
	{
		totalValue = value1 + value2;
		return totalValue;
	}
	
	public int subtract()
	{
		totalValue = value1 - value2;
		return totalValue;
	}
	
	public int multiply()
	{
		totalValue = value1 * value2;
		return totalValue;
	}
	
	public int divide()
	{
		totalValue = value1 / value2;
		return totalValue;
	}

}
