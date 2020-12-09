package question2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RemoveComments {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public static void removeComments() throws FileNotFoundException {
		Scanner scanner = new Scanner(System.in);
		String fileName = scanner.next();
			
		File infile = new File(fileName);
		Scanner in = new Scanner(infile);
			
		File outFile = new File(fileName.substring(0, fileName.indexOf('.')) + ".out");
		PrintWriter out = new PrintWriter(outFile);
			
		while(in.hasNextLine()) {
			String line = in.nextLine();
			
			if(line.trim().length() == 0) {
				out.println(line);
				continue;
			}
				
			int index = line.indexOf("//");
			String outString = line.substring(0, index == -1 ? line.length() : index);
				
			if(outString.trim().length() != 0)
				out.println(outString);
		}
			
		scanner.close();
		in.close();
		out.close();
	}
}
