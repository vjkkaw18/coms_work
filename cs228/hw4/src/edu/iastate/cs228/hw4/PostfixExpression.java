package edu.iastate.cs228.hw4;

/**
 *  
 * @author
 * Vance Kaw
 *
 */

/**
 * 
 * This class evaluates a postfix expression using one stack.    
 *
 */

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner; 

public class PostfixExpression extends Expression 
{
	private int leftOperand;            // left operand for the current evaluation step             
	private int rightOperand;           // right operand (or the only operand in the case of 
	                                    // a unary minus) for the current evaluation step	

	private PureStack<Integer> operandStack;  // stack of operands
	

	/**
	 * Constructor stores the input postfix string and initializes the operand stack.
	 * 
	 * @param st      input postfix string. 
	 * @param varTbl  hash map that stores variables from the postfix string and their values.
	 */
	public PostfixExpression (String st, HashMap<Character, Integer> varTbl)
	{
		super(st, varTbl);
		operandStack = new ArrayBasedStack();
	}
	
	
	/**
	 * Constructor supplies a default hash map. 
	 * 
	 * @param s
	 */
	public PostfixExpression (String s)
	{
		super(s);
		operandStack = new ArrayBasedStack();
	}

	
	/**
	 * Outputs the postfix expression according to the format in the project description.
	 */
	@Override 
	public String toString()
	{
		String newStr = postfixExpression.replace("( ", "(").replace(" )", ")");
		
		return newStr;
	}
	

	/**
	 * Resets the postfix expression. 
	 * @param st
	 */
	public void resetPostfix (String st)
	{
		postfixExpression = st; 
	}


	/**
     * Scan the postfixExpression and carry out the following:  
     * 
     *    1. Whenever an integer is encountered, push it onto operandStack.
     *    2. Whenever a binary (unary) operator is encountered, invoke it on the two (one) elements popped from  
     *       operandStack,  and push the result back onto the stack.  
     *    3. On encountering a character that is not a digit, an operator, or a blank space, stop 
     *       the evaluation. 
     *       
     * @return value of the postfix expression 
     * @throws ExpressionFormatException with one of the messages below: 
     *  
     *           -- "Invalid character" if encountering a character that is not a digit, an operator
     *              or a whitespace (blank, tab); 
     *           --	"Too many operands" if operandStack is non-empty at the end of evaluation; 
     *           -- "Too many operators" if getOperands() throws NoSuchElementException; 
     *           -- "Divide by zero" if division or modulo is the current operation and rightOperand == 0;
     *           -- "0^0" if the current operation is "^" and leftOperand == 0 and rightOperand == 0;
     *           -- self-defined message if the error is not one of the above.
     *           
     *         UnassignedVariableException if the operand as a variable does not have a value stored
     *            in the hash map.  In this case, the exception is thrown with the message
     *            
     *           -- "Variable <name> was not assigned a value", where <name> is the name of the variable.  
     *           
     */
	public int evaluate() throws ExpressionFormatException, UnassignedVariableException
    {
		Scanner scanner = new Scanner(postfixExpression);
		while(scanner.hasNext())
		{
			String str = scanner.next();
			
			if (isInt(str)) // an integer is encountered, push onto operandStack.
			{
				int integer = Integer.parseInt(str);
				operandStack.push(integer);
				continue;
			}
			
			else if (str.length() > 1)
			{
				throw new ExpressionFormatException("Should only be one character!");
			}
			
			char firstChar = str.charAt(0);
			
			if (isOperator(firstChar))
			{
				try
				{
					getOperands(firstChar);
				}
				
				catch (NoSuchElementException e)
				{
					throw new ExpressionFormatException("Too many operators");
				}
				
				int value = compute(firstChar);
				operandStack.push(value);
			}
			
			else if (isVariable(firstChar))
			{
				if (varTable.get(firstChar) == null)
				{
					throw new UnassignedVariableException("Variable " + firstChar + " was not assigned a value");
				}
				
				else 
				{
					operandStack.push(varTable.get(firstChar));
				}
			}
			
			else 
			{
				throw new ExpressionFormatException("Invalid character");
			}
		}
		
		int finalValue = operandStack.pop();
		
		if(!operandStack.isEmpty())
		{
			throw new ExpressionFormatException("Too many operands");
		}
		
		scanner.close();
		
		return finalValue;  
    }
	

	/**
	 * For unary operator, pops the right operand from operandStack, and assign it to rightOperand. 
	 * The stack must have at least one entry. Otherwise, throws NoSuchElementException.
	 * For binary operator, pops the right and left operands from operandStack, and assign them to rightOperand 
	 * and leftOperand, respectively. The stack must have at least two entries. Otherwise, throws NoSuchElementException. 
	 * @param op
	 * 			char operator for checking if it is binary or unary operator.
	 */
	private void getOperands(char op) throws NoSuchElementException 
	{
		// TODO 
		if (op == '~')
		{
			if (operandStack.size() < 1)
			{
				throw new NoSuchElementException();
			}
			
			rightOperand = operandStack.pop();
		}
		
		else 
		{
			if (operandStack.size() < 2)
			{
				throw new NoSuchElementException();
			}
			
			rightOperand = operandStack.pop();
			leftOperand = operandStack.pop();
		}
	}


	/**
	 * Computes "leftOperand op rightOprand" or "op rightOperand" if a unary operator. 
	 * 
	 * @param op operator that acts on leftOperand and rightOperand. 
	 * @return
	 */
	private int compute(char op) throws ExpressionFormatException
	{
		int value = 0;
		
		if (op == '~')
		{
			value = -1 * rightOperand;
		}
		
		if (op == '+')
		{
			value = leftOperand + rightOperand;
		}
		
		if (op == '-')
		{
			value = leftOperand - rightOperand;
		}
		
		if (op == '*')
		{
			value = leftOperand * rightOperand;
		}
		
		if (op == '/')
		{
			if (rightOperand == 0)
			{
				throw new ExpressionFormatException("Divide by zero");
			}
			
			value = leftOperand / rightOperand;
		}
		
		if (op == '%')
		{
			value = leftOperand % rightOperand;
		}
		
		if (op == '^')
		{
			if (leftOperand == 0 && rightOperand == 0)
			{
				throw new ExpressionFormatException("0^0");
			}
			
			double tempOperand1 = (double) leftOperand;
			double tempOperand2 = (double) rightOperand;
			
			value = (int) Math.pow(tempOperand1, tempOperand2);
		}
	
		return value;
	}
}
