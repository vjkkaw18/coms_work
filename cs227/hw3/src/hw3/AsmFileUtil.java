package hw3;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A collection of utility methods for working with files containing programs 
 * for the CS227Comp architecture.
 * A utility containing some static methods for working with files. 
 * This class would read its source from a file and write the machine code to another file. 
 * The necessary file operations are to be implemented by us as static methods in the utility class AsmFileUtil. 
 * @author Vance Kaw
 */
public class AsmFileUtil {
	
	/**
	 * Reads the given file and assembles the program, writing the machine code
	 * to a file. 
	 * Descriptions are included only if the annotated parameter is true 
	 * Otherwise, each line in the output file includes just the first five characters
	 * (representing the integer value of the instruction).
	 * The name of the output file is the same as the name of the input file, with the file extension
	 * (portion after the last dot) removed and replaced with ".mach227". 
	 * @param filename
	 * name of the file to read
	 * @param annotated
	 * true if the instruction descriptions should be included in the output file
	 * false otherwise
	 * @throws java.io.FileNotFoundException
	 * throws file not found exception when file is not found. 
	 */
	public static void assembleAndWriteFile(java.lang.String filename, boolean annotated) throws java.io.FileNotFoundException
	{
		boolean isAnnotated = annotated;
		File inFile = new File(filename);
		int [] memoryImage = new int[filename.length()];
		ArrayList<String> arrList = new ArrayList<>();
		
		String newFilename = "";
		String test1 = "";
		int lastIndex = filename.lastIndexOf(".");
		int length = filename.length();
		for (int i = 0; i < lastIndex; i++)
		{
			test1.substring(i);
		}
		String temp = filename.substring(lastIndex, length); // returns .asm227
		String wordReplaced = temp.replace(temp, ".mach227"); // replaces the file extension
		newFilename = test1 + wordReplaced;
		File outFile = new File(newFilename);
		PrintWriter out = new PrintWriter(outFile);
		
		
		if (isAnnotated == true)
		{
			arrList = assembleFromFile(filename);
			for (int k = 0; k < arrList.size(); k++)
			{
				out.println(arrList.get(k));
			}
		}
		
		else if (isAnnotated == false)
		{
			memoryImage = createMemoryImageFromFile(filename);
			for (int j = 0; j < memoryImage.length; j++) 
			{
                out.println(memoryImage[j]);
            }
		}
		
	}
	
	/**
	 * Reads the given file and assembles the program, returning the machine code
	 * as a list of strings (including descriptions)
	 * @param filename
	 * name of the file to read
	 * @return
	 * assembled machine code as an array of integer values
	 * @throws java.io.FileNotFoundException
	 * throws file not found exception when file is not found.
	 */
	public static java.util.ArrayList<java.lang.String> assembleFromFile(java.lang.String filename) throws java.io.FileNotFoundException
	{
		File file = new File(filename);
		Scanner scanner = new Scanner(file);
		
		ArrayList<String> fileCode = new ArrayList<>();
		while(scanner.hasNextLine())
		{
			fileCode.add(scanner.nextLine());
		}
	
		CS227Asm program = new CS227Asm(fileCode);
		
		ArrayList<String> result = new ArrayList<>();
		result = program.assemble();	
		
		return result;
		
	}
	
	/**
	 * Reads the given file and assembles the program, returning the machine code
	 * as an array of integer values (not including the sentinel value).
	 * @param filename
	 * name of the file to read
	 * @return
	 * assembled machine code as an array of integer value
	 * @throws java.io.FileNotFoundException
	 * throws file not found exception when file is not found.
	 */
	public static int[] createMemoryImageFromFile(java.lang.String filename) throws java.io.FileNotFoundException
	{

		ArrayList<String> result = new ArrayList<>();
		result = assembleFromFile(filename);
		int sizeArray = result.size() - 1;
		
		int[] arr = new int[sizeArray];
		
		for (int i = 0; i < result.size() - 1; i++)
		{
			Scanner scanner = new Scanner(result.get(i));
			int machineCode = scanner.nextInt();
			arr[i] = machineCode;
		}
		return arr;
	}
	
	public AsmFileUtil()
	{
		
	}
	
}
