import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		String s = "Hi there, Vance";
		String x = "42       137";
		
		Scanner scanner = new Scanner(s);
		
		String t = scanner.next();
		System.out.println(t);
		String u = scanner.next();
		System.out.println(u);
		String v = scanner.next();
		System.out.println(v);
		
		
		Scanner scanner2 = new Scanner(x);
		String y = scanner2.next();
		System.out.println(y);
		String z = scanner2.next();
		System.out.println(z);
	}

}
