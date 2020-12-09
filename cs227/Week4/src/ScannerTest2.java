import java.util.Scanner;

public class ScannerTest2 {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Type a couple of words: ");
		String t = scanner.next();
		String r = scanner.next();
		System.out.println("You typed " + t + " and " + r);
		
	}

}
