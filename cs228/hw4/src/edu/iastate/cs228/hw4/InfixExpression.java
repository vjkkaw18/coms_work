package edu.iastate.cs228.hw4;

/**
 *  
 * @author
 * Vance Kaw
 *
 */

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * 
 * This class represents an infix expression. It implements infix to postfix conversion using 
 * one stack, and evaluates the converted postfix expression.    
 *
 */

public class InfixExpression extends Expression 
{
	private String infixExpression;   	// the infix expression to convert		
	private boolean postfixReady = false;   // postfix already generated if true
	private int rankTotal = 0;		// Keeps track of the cumulative rank of the infix expression.
	
	private PureStack<Operator> operatorStack; 	  // stack of operators 
	
	private String tempPostString = ""; // a temporary String called tempPostString to store the convertion of infix to postfix expressions. 
	
	
	/**
	 * Constructor stores the input infix string, and initializes the operand stack and 
	 * the hash map.
	 * 
	 * @param st  input infix string. 
	 * @param varTbl  hash map storing all variables in the infix expression and their values. 
	 */
	public InfixExpression (String st, HashMap<Character, Integer> varTbl)
	{
		super(st, varTbl);
		operatorStack = new ArrayBasedStack();
		infixExpression = super.removeExtraSpaces(st);
	}
	

	/**
	 * Constructor supplies a default hash map. 
	 * 
	 * @param s
	 */
	public InfixExpression (String s)
	{
		super(s);
		varTable = new HashMap<Character, Integer>();
		operatorStack = new ArrayBasedStack();
		infixExpression = super.removeExtraSpaces(s);

	}
	

	/**
	 * Outputs the infix expression according to the format in the project description.
	 */
	@Override
	public String toString()
	{
		String newStr = infixExpression.replace("( ", "(").replace(" )", ")");
		return newStr; 
	}
	
	
	/** 
	 * @return equivalent postfix expression, or  
	 * 
	 *         a null string if a call to postfix() inside the body (when postfixReady 
	 * 		   == false) throws an exception.
	 */
	public String postfixString() 
	{
		if(postfixReady == false)
		{
			try 
			{
				postfix();
			}
			
			catch (ExpressionFormatException e)
			{
				return null;
			}
		}
		return postfixExpression; 
	}


	/**
	 * Resets the infix expression. 
	 * 
	 * @param st
	 */
	public void resetInfix (String st)
	{
		infixExpression = st; 
	}


	/**
	 * Converts infix expression to an equivalent postfix string stored at postfixExpression.
	 * If postfixReady == false, the method scans the infixExpression, and does the following
	 * (for algorithm details refer to the relevant PowerPoint slides): 
	 * 
	 *     1. Skips a whitespace character.
	 *     2. Writes a scanned operand to postfixExpression. 
	 *     3. When an operator is scanned, generates an operator object.  In case the operator is 
	 *        determined to be a unary minus, store the char '~' in the generated operator object.
	 *     4. If the scanned operator has a higher input precedence than the stack precedence of 
	 *        the top operator on the operatorStack, push it onto the stack.   
	 *     5. Otherwise, first calls outputHigherOrEqual() before pushing the scanned operator 
	 *        onto the stack. No push if the scanned operator is ). 
     *     6. Keeps track of the cumulative rank of the infix expression. 
     *     
     *  During the conversion, catches errors in the infixExpression by throwing 
     *  ExpressionFormatException with one of the following messages:
     *  
     *      /- "Operator expected" if the cumulative rank goes above 1;
     *      -- "Operand expected" if the rank goes below 0; 
     *      -- "Missing '('" if scanning a �)� results in popping the stack empty with no '(';
     *      -- "Missing ')'" if a '(' is left unmatched on the stack at the end of the scan; 
     *      /- "Invalid character" if a scanned char is neither a digit nor an operator; 
     *   
     *  If an error is not one of the above types, throw the exception with a message you define.
     *      
     *  Sets postfixReady to true.  
	 */
	public void postfix() throws ExpressionFormatException
	{	
		int parenthesis = 0;
		
		if (postfixReady == false)
		{
			Scanner scanner = new Scanner(infixExpression);
			tempPostString = "";
			
			while (scanner.hasNext())
			{
				String str = scanner.next();
				char firstChar = str.charAt(0);
				boolean unary = false;
				
				if (firstChar == '(')
				{
					unary = true;
				}
				
				else 
				{
					unary = false;
				}
				
				if(isInt(str))
				{
					if (tempPostString.length() == 0)
					{
						tempPostString += str;
						rankTotal++;
					}
					
					else 
					{
						tempPostString += " " + str;
						rankTotal++;
					}
					continue;
				}
				
				else if (isOperator(firstChar))
				{
					Operator op = new Operator(firstChar);
					
					// first condition for unary
					if (operatorStack.isEmpty() && firstChar == '-')
					{
						if (tempPostString.length() == 0)
						{
							op = new Operator('~');
							op.operator = '~';
							operatorStack.push(op);
							rankTotal += 0;
						}
						
						else 
						{
							operatorStack.push(op);
							
							if ((firstChar == '+') || (firstChar == '-') || (firstChar == '*') 
									|| (firstChar == '/') || (firstChar == '%') || (firstChar == '^'))
							{
								rankTotal -= 1;
							}
							
							else if((firstChar == '(') || (firstChar == ')'))
							{
								rankTotal += 0;
							}
						}
						
						
						if (rankTotal > 1)
						{
							throw new ExpressionFormatException("Operator Expected");
						}
					}
					
					// second condition for unary
					else if (!operatorStack.isEmpty() && ((operatorStack.peek().getOp() == '-') || 
							(operatorStack.peek().getOp() == '+')) && (firstChar == '-'))
					{
						op = new Operator('~');
						op.operator = '~';
						operatorStack.push(op);
						rankTotal += 0;
					}
					
					// third condition for unary
					else if (!operatorStack.isEmpty() && (unary == true) && (firstChar == '-'))
					{
						op = new Operator('~');
						op.operator = '~';
						operatorStack.push(op);
						rankTotal += 0;
					}
					
					else if (operatorStack.isEmpty())
					{
						operatorStack.push(op);
						
						if ((firstChar == '+') || (firstChar == '-') || (firstChar == '*') 
								|| (firstChar == '/') || (firstChar == '%') || (firstChar == '^'))
						{
							rankTotal -= 1;
						}
						
						else if((firstChar == '(') || (firstChar == ')'))
						{
							rankTotal += 0;
						}
					}
					
					else if (operatorStack.peek().compareTo(op) < 0 && firstChar != ')')
					{
						operatorStack.push(op);
						
						if ((firstChar == '+') || (firstChar == '-') || (firstChar == '*') 
								|| (firstChar == '/') || (firstChar == '%') || (firstChar == '^'))
						{
							rankTotal -= 1;
						}
						
						else if((firstChar == '(') || (firstChar == ')'))
						{
							rankTotal += 0;
						}
					}
					
					else 
					{
						try 
						{
							outputHigherOrEqual(op);
						}

						catch (NoSuchElementException e)
						{
							throw new ExpressionFormatException("Missing '('");
						}
					}
					
					if (firstChar == '(')
					{
						parenthesis += 1;
					}
					
					else if (firstChar == ')')
					{
						parenthesis -= 1;
					}
					
					if (rankTotal > 1)
					{
						throw new ExpressionFormatException("Operator expected");
					}
					
					if (rankTotal < 0)
					{
						throw new ExpressionFormatException("Operand expected");
					}
				}
				
				else if (isVariable(firstChar)) 
				{
					if (tempPostString.length() == 0)
					{
						tempPostString += str;
						rankTotal++;
					}
					
					else 
					{
						tempPostString += " " + str;
						rankTotal++;
					}
					
					if (rankTotal > 1)
					{
						throw new ExpressionFormatException("Operator expected");
					}
				}
				
				else 
				{
					throw new ExpressionFormatException("Invalid Character");
				}
			}
		}
		
		while (!operatorStack.isEmpty())
		{
			Operator topStack = operatorStack.pop();
			
			if (topStack.getOp() != '(')
			{
				tempPostString += " " + topStack.getOp();
			}
		}
		
		if (parenthesis > 0)
		{
			throw new ExpressionFormatException("Missing ')'");
		}
		
		if (parenthesis < 0)
		{
			throw new ExpressionFormatException("Missing '('");
		}
		
		if (rankTotal > 1)
		{
			throw new ExpressionFormatException("Operator expected");
		}
		
		if (rankTotal <= 0)
		{
			throw new ExpressionFormatException("Operand expected");
		}
		
		postfixExpression = tempPostString;
		postfixReady = true;
	}
	
	
	/**
	 * This function first calls postfix() to convert infixExpression into postfixExpression. Then 
	 * it creates a PostfixExpression object and calls its evaluate() method (which may throw  
	 * an exception).  It also passes any exception thrown by the evaluate() method of the 
	 * PostfixExpression object upward the chain. 
	 * 
	 * @return value of the infix expression 
	 * @throws ExpressionFormatException, UnassignedVariableException
	 */
	public int evaluate() throws ExpressionFormatException, UnassignedVariableException  
    {
		postfix();
		PostfixExpression postfix = new PostfixExpression(postfixExpression, varTable);
		
		int value = postfix.evaluate();
		
		return value;  
    }


	/**
	 * Pops the operator stack and output as long as the operator on the top of the stack has a 
	 * stack precedence greater than or equal to the input precedence of the current operator op.  
	 * Writes the popped operators to the string postfixExpression.  
	 * 
	 * If op is a ')', and the top of the stack is a '(', also pops '(' from the stack but does 
	 * not write it to postfixExpression. 
	 * 
	 * @param op  current operator
	 */
	private void outputHigherOrEqual(Operator op)
	{
		while(!operatorStack.isEmpty() && operatorStack.peek().compareTo(op) >= 0)
		{
			Operator topStack = operatorStack.peek();
			operatorStack.pop();
			tempPostString += " " + topStack.getOp();
		}
		
		if (op.getOp() == ')' && operatorStack.peek().getOp() == '(')
		{
			operatorStack.pop();
		}
		
		if (op.getOp() != ')')
		{
			operatorStack.push(op);
			rankTotal -= 1;
		}
	}

	// other helper methods if needed
}
