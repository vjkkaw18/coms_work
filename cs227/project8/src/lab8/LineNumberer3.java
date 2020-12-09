package lab8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LineNumberer3 {
	public static void main(String[] args) {
		try {
			File inFile = new File("/Users/vaka99/Desktop/COM S 227 ECLIPSE/project7/src/lab7/Deck.java");

			//   /Users/vaka99/Desktop/COM S 227 ECLIPSE/project8/story.txt


			File outFile = new File("/Users/vaka99/Desktop/COM S 227 ECLIPSE/project8/src/lab8/mydocuments.txt");
			Scanner in = new Scanner(System.in);
			Scanner fileScanner = new Scanner(inFile);
			PrintWriter out = new PrintWriter(outFile);

			int lineCount = 1;

			while(fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				System.out.print(lineCount + " ");
				out.print(lineCount + " ");
				System.out.println(line);
				out.println(line);
				lineCount += 1;
			}

			System.out.println("Done");
			out.close();
		} 
		catch (FileNotFoundException fileNotFoundException) {
			System.out.println("File Not Found");
		}
	}
}