package GuangSongLecture;

public class calculator2 {
	
	//the name of the instance variable should not be equal to the name of the parameter variable in the constructor!
	private int operand1;
	//private int op1;
	private int operand2;
	//private int op2;
	private double result;
	
	public void setOpperand1(int op1)
	{
		operand1 = op1;
		//this.op1 = op1;
		
		// could also be written as this.op1 = op1; but instance variable has to be op1.
		//  Only write this.op1 = op1; only if instance variable = parameter variable. 
	}

	public void setOpperand2(int op2) 
	{
		operand2 = op2;
		//this.op2 = op2;
	}
	
	public void add()
	{
		result = operand1 + operand2;
	}
	
	public void subtract()
	{
		result = operand1 - operand2;
	}
	
	public void multiply() 
	{
		result = operand1 * operand2;
	}
	
	public void divide()
	{
		result = operand1 / operand2;
	}
	
	public double getResult() 
	{
		return result;
	}
}
