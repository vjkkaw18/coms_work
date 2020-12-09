package lab2;

public class StringTest {
	public static void main(String[] args) {
		String message;
		message = "Hello World!";
			
		System.out.println(message);
			
		int theLength = message.length();
		System.out.println(theLength);
			
		char theChar = message.charAt(0);
		System.out.println(theChar);
			
		theChar = message.charAt(1);
		System.out.println(theChar);
			
		String upperCase = message.toUpperCase();
		System.out.println(upperCase);
		
		String firstFive = message.substring(0, 5);
		System.out.println(firstFive);
		
		//replaces  current character with a different character
		System.out.println(message.replace((message.charAt(0)+""), "v"));
			
	}
}