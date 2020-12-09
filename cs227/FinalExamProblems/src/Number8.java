


import java.util.Scanner;

public class Number8 {
	public static void main(String[] args) {

		int result = tryStuff("10 20 23skidoo 30 foo bar");
		System.out.print(result);
	}

	// problem 8
	public static int tryStuff(String text) {
		int total = 0;
		int i = 0;
		Scanner scanner = new Scanner(text);
		while (scanner.hasNext()) {
			try {
				String s = scanner.next();
				i = Integer.parseInt(s);
				total += i;
			} catch (NumberFormatException nfe) {
				total -= i;
			}
		}
		return total;
	}
}

