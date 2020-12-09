package edu.iastate.cs228.hw4;


/**
 * Simple Test Cases I created to aid in testing and debugging each and every method. 
 * @author vancekaw
 *
 */
public class SimpleTestCases {

	public static void main(String[] args) throws ExpressionFormatException, UnassignedVariableException {
		
//		System.out.println(Expression.isOperator('c')); // false 
//		System.out.println(Expression.isOperator('+')); // true 
//		
//		System.out.println(Expression.isVariable('G')); // false 
//		System.out.println(Expression.isVariable('g')); // true 
//		
//		String str1 = "  Hello            World      !!!"; 
//		System.out.println(str1); //  Hello            World      !!!
//		System.out.println(Expression.removeExtraSpaces(str1)); //Hello World !!!
//
//		String str2 = "      Hey  there    Joey!!!      "; 
//		System.out.println(str2); //      Hey  there    Joey!!!      
//		System.out.println(Expression.removeExtraSpaces(str2)); //Hey there Joey!!! 
//		
//		System.out.println(Expression.isInt("hello")); // false 
//		System.out.println(Expression.isInt("123HelloWorld")); // false 
//		System.out.println(Expression.isInt("99")); // true 
//		
//		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
//		hashMap.put('x', 4);
//		hashMap.put('y', 2);
//		hashMap.put('z', 5);
//		
//		char c = 'x';
//		
//		if (hashMap.containsKey(c))
//		{
//			int x = (int) hashMap.get(c);
//			System.out.println(x);
//		}
		
		
//		HashMap<Character, Integer> hashMap2 = new HashMap<Character, Integer>();
//		hashMap2.put('x', 4);
//		hashMap2.put('y', 2);
//		hashMap2.put('z', 5);
//		
//		String str = "(x - 15) * 4 / 2 ^ 2";
//		InfixExpression e = new InfixExpression(str, hashMap2);
//		System.out.println(e.postfixExpression);
//		System.out.println(e.varTable);
		
		// FOR POSTFIX EXPRESSIONS
		String str = "2 3 * 5 4 * + 9 -";
		PostfixExpression e = new PostfixExpression(str);
		System.out.println(e.toString()); // 2 3 * 5 4 * + 9 -
		System.out.println(e.evaluate()); // 17
//		
//		String str2 = "2 1 * 3 ~ + ~ 5 *";
//		PostfixExpression f = new PostfixExpression(str2);
//		System.out.println(f.toString()); // 2 1 * 3 ~ + ~ 5 *
//		System.out.println(f.evaluate()); // 5
//		
//		String str3 = "50 6 + 2 3 ^ -";
//		PostfixExpression g = new PostfixExpression(str3);
//		System.out.println(g.toString()); // 50 6 + 2 3 ^ -
//		System.out.println(g.evaluate()); // 48
//		
//		String str4 = "x y + z *";
//		HashMap<Character, Integer> hashMap2 = new HashMap<Character, Integer>();
//		hashMap2.put('x', 21);
//		hashMap2.put('y', 13);
//		hashMap2.put('z', 5);
//		PostfixExpression h = new PostfixExpression(str4, hashMap2);
//		System.out.println(h.toString()); // x y + z *
//		System.out.println(h.evaluate()); // 170
//		
//		String str5 = "8 1 3 + / 6 2 ^ -";
//		PostfixExpression i = new PostfixExpression(str5);
//		System.out.println(i.toString()); // 8 1 3 + / 6 2 ^ -
//		System.out.println(i.evaluate()); // -34
		
		
		
//		// FOR INFIX EXPRESSIONS
//		InfixExpression j = new InfixExpression("- ( 2 * 1 + - 3 ) * 5");
//		System.out.println(j.postfixExpression);
//		System.out.println(j.toString()); // - (2 * 1 + - 3) * 5
//		j.postfix();
//		System.out.println(j.postfixExpression); // 2 1 * 3 ~ + ~ 5 *
//		
//		InfixExpression k = new InfixExpression("8 / ( 1 + 3 ) - 6 ^ 2");
//		System.out.println(k.toString()); // "8 / (1 + 3) - 6 ^ 2"
//		k.postfix();
//		System.out.println(k.postfixExpression); // "8 1 3 + / 6 2 ^ -"
//		System.out.println(k.evaluate()); // -34
//		
//		String str8 = "3 * ( a + b + c ) - ( e ^ 2 + f * g ) / h + i ^ 3";
//		InfixExpression l = new InfixExpression(str8);
//		System.out.println(l.postfixExpression); // 3 * ( a + b + c ) - ( e ^ 2 + f * g) / h + i ^ 3
//		System.out.println(l.toString()); // 3 * (a + b + c) - (e ^ 2 + f * g) / h + i ^ 3
//		l.postfix();
//		System.out.println(l.postfixExpression); // 3 a b + c + * e 2 ^ f g * + h / - i 3 ^ +
//		
//		String str9 = "a ^ b ^ c * ( d - e + c ) / e - ( f + g ) * h";
//		InfixExpression m = new InfixExpression(str9);
//		System.out.println(m.postfixExpression); // a ^ b ^ c * ( d - e + c ) / e - ( f + g ) * h
//		System.out.println(m.toString()); // a ^ b ^ c * (d - e + c) / e - (f + g) * h
//		m.postfix();
//		System.out.println(m.postfixExpression); // a b c ^ ^ d e - c + * e / f g + h * -
//		
//		InfixExpression f = new InfixExpression("5 - 3 +");
//		System.out.println(f.toString()); // "5 - 3 +"
//		System.out.println(f.postfixString()); // null
//		
//		InfixExpression g = new InfixExpression("( 5 - - 1 ) % 3 + 90 / 9 - - 2 ^ 3");
//		System.out.println(g.toString()); // (5 - - 1) % 3 + 90 / 9 - - 2 ^ 3
//		System.out.println(g.postfixString()); // 5 1 ~ - 3 % 90 9 / + 2 ~ 3 ^ -
//		System.out.println(g.evaluate()); // 18
//		
//		f.resetInfix("2 + 1 / 3");
//		System.out.println(f.toString()); // 2 + 1 / 3
//		System.out.println(f.postfixString()); // 2 1 3 / +
//		
//		InfixExpression x = new InfixExpression ("( 2 * ) 3");
//		System.out.println(x.postfixString()); // 2 * 3
		
	}

}
