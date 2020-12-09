package edu.iastate.cs228.hw4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;


/**
 * Main method used to output the desired simulation. 
 * Number one key used to prompt standard input. 
 * Number two key used to prompt file input. 
 * Number three key used to exit the simulation.  
 * @author vancekaw
 *
 */
public class InfixPostfix 
{

	/**
	 * Repeatedly evaluates input infix and postfix expressions.  See the project description
	 * for the input description. It constructs a HashMap object for each expression and passes it 
	 * to the created InfixExpression or PostfixExpression object. 
	 *  
	 * @param args
	 * @throws UnassignedVariableException 
	 * @throws ExpressionFormatException 
	 * @throws FileNotFoundException 
	 **/
	public static void main(String[] args) throws ExpressionFormatException, UnassignedVariableException, FileNotFoundException 
	{
		System.out.println("Evaluation of Infix and Postfix Expressions");
		System.out.println("keys: 1 (standard input) 2 (file input) 3 (exit)");
		System.out.println("(Enter 'I' before an infix expression, 'P' before a postfix expression)");
		System.out.println("\n");
		
		boolean condition = true;
		Scanner scanner = new Scanner(System.in);
		int count = 1;
		boolean tempCondition = true;
		
		while(condition == true)
		{
			System.out.print("Trial " + count + ": ");
			int evaluationKey = scanner.nextInt();
			
			if (evaluationKey == 1)
			{
				System.out.print("Expression: ");
				String letter = scanner.next();
				
				if (letter.equals("I"))
				{
					String expression = scanner.nextLine().trim();
					InfixExpression infix = new InfixExpression(expression);
					System.out.println("Infix form: " + infix.toString());
					System.out.println("Postfix form: " + infix.postfixString());
					infix.setVarTable(variableValue(infix.toString()));
					System.out.println("Expression value: " + infix.evaluate());
				}
				
				else if (letter.equals("P"))
				{
					String expression = scanner.nextLine().trim();
					PostfixExpression postfix = new PostfixExpression(expression);
					System.out.println("Postfix form: " + postfix.toString());
					postfix.setVarTable(variableValue(postfix.toString()));
					System.out.println("Expression value: " + postfix.evaluate());
				}
				
				count++;
				System.out.println("\n");
			}
			
			else if (evaluationKey == 2)
			{
				HashMap<Character, Integer> variableTable = new HashMap<Character, Integer>();
				
				System.out.println("Input from a file");
				System.out.print("Enter file name: ");
				
				String fileName = scanner.next();
				System.out.println();
				String srcPath = "src/edu/iastate/cs228/hw4/" + fileName;
				File file = new File (srcPath);
				Scanner fileScanner = new Scanner(file);
				
				
				while(fileScanner.hasNextLine())
				{
					String currentLine = fileScanner.nextLine();
					Scanner currentLineScanner = new Scanner(currentLine);
					
					while (currentLineScanner.hasNext())
					{
						String firstLetter = currentLineScanner.next();
						
						if (firstLetter.equals("I"))
						{
							variableTable = new HashMap<Character, Integer>();
							condition = true;
							String expression = currentLineScanner.nextLine();
							InfixExpression infix = new InfixExpression(expression);
							String infixToString = infix.toString();
							
							System.out.println("Infix form: " + infixToString);
							System.out.println("Postfix form: " + infix.postfixString());
							
							for (int i = 0; i < infixToString.length(); i++)
							{
								char variable = infixToString.charAt(i);
								
								if (Expression.isVariable(variable))
								{
									if (tempCondition == true)
									{
										System.out.println("where ");
									}
									
									String var = fileScanner.next();
									fileScanner.next();
									
									int value = Integer.parseInt(fileScanner.next());
									System.out.println(var + " = " + value);
									
									variableTable.put(variable, value);
									
									tempCondition = false;
								}
							}
							InfixExpression tempInfix = new InfixExpression (expression, variableTable);
							System.out.println("Expression value: " + tempInfix.evaluate());
							System.out.println();
						}
						
						else if (firstLetter.equals("P"))
						{
							tempCondition = true;
							variableTable = new HashMap<Character, Integer>();
							String expression = currentLineScanner.nextLine();
							PostfixExpression postfix = new PostfixExpression(expression);
							String postfixToString = postfix.toString();
							
							System.out.println("Postfix form: " + postfixToString);
							
							for (int i = 0; i < postfixToString.length(); i++)
							{
								char variable = postfixToString.charAt(i);
								
								if (Expression.isVariable(variable))
								{
									if (tempCondition == true)
									{
										System.out.println("where ");
									}
									
									String var = fileScanner.next();
									fileScanner.next();
									
									int value = Integer.parseInt(fileScanner.next());
									System.out.println(var + " = " + value);
									
									variableTable.put(variable, value);
									tempCondition = false;
								}
							}
							PostfixExpression tempPostfix = new PostfixExpression (expression, variableTable);
							System.out.println("Expression value: " + tempPostfix.evaluate());
							System.out.println();
						}
							
					}
//					currentLineScanner.close();
				}
//				fileScanner.close();
				
				
				count++;
				System.out.println("\n");
			}
			
			else if (evaluationKey == 3)
			{
				condition = false;
			}
		}
		scanner.close();
		
	}
	
	public static HashMap<Character, Integer> variableValue(String input) throws UnassignedVariableException
	{
		HashMap<Character, Integer> varTbl = new HashMap<Character, Integer>();
		
		Scanner scan = new Scanner(System.in);
		
		int count = 0;
		
		for (int i = 0; i < input.length(); i++)
		{
			char currentChar = input.charAt(i);

			if (Expression.isVariable(currentChar))
			{
				if (count == 0)
				{
					System.out.println("where");
					System.out.print(currentChar + " = ");
					
					int varValue = scan.nextInt();
					varTbl.put(currentChar, varValue);
				}

				else 
				{
					System.out.print(currentChar + " = ");
					int varValue = scan.nextInt();
					varTbl.put(currentChar, varValue);
				}
				count++;
			}
		}
//		scan.close();

		return varTbl;
	}
	
	// helper methods if needed
}


