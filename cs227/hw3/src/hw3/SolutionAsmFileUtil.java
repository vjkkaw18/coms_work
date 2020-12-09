package hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A collection of utility methods for working with files containing programs for the
 * CS227Comp architecture.
 */
public class SolutionAsmFileUtil
{
  /**
   * Reads the given file and assembles the program, returning the machine code
   * as a list of strings (including descriptions).
   * @param filename
   *   name of the file to read
   * @return
   *   assembled machine code as a list of strings
   * @throws FileNotFoundException
   */
  public static ArrayList<String> assembleFromFile(String filename) throws FileNotFoundException
  {
    // read the file into an ArrayList
    File f = new File(filename);
    Scanner scanner = new Scanner(f);
    ArrayList<String> program = new ArrayList<>();
    while (scanner.hasNextLine())
    {
      program.add(scanner.nextLine());
    }
    scanner.close();
    
    // assemble and return the result
    CS227Asm assembler = new CS227Asm(program);
    ArrayList<String> result = assembler.assemble();
    return result;
  }
  
  /**
   * Reads the given file and assembles the program, returning the machine code
   * as an array of integer values (not including the sentinel value).
   * @param filename
   *   name of the file to read
   * @return
   *   assembled machine code as an array of integer values
   * @throws FileNotFoundException
   */
  public static int[] createMemoryImageFromFile(String filename) throws FileNotFoundException
  {
    // this gives the machine code as a list of strings
    ArrayList<String> result = assembleFromFile(filename);
    
    // now we just want to make it into an array of int. If the file is formatted
    // correctly, The first five characters on each line represent the actual 
    // machine code. (Could also do this with a scanner...)
    int[] code = new int[result.size()];
    for (int i = 0; i < code.length; ++i)
    {
      code[i] = Integer.parseInt(result.get(i).substring(0, 5));
    }
    return code;
  }
  
  /**
   * Reads the given file and assembles the program, writing the machine code
   * to a file.  Descriptions are included only if the <code>annotated</code> parameter
   * is true, otherwise each line in the output file includes just the first five characters 
   * (representing the integer value of the instruction). The name of the output file is 
   * the same as the name of the input file, with the file extension (portion after the 
   * last dot) removed and is replaced with ".mach227".  For example, given the 
   * filename "test1.asm227", the output file would be named "test1.mach227".
   * @param filename
   *   name of the file to read
   * @param annotated
   *   true if instruction descriptions should be included in the output file, false otherwise
   * @throws FileNotFoundException
   */
  public static void assembleAndWriteFile(String filename, boolean annotated) throws FileNotFoundException
  {
    // this gives the machine code as a list of strings
    ArrayList<String> result = assembleFromFile(filename);
    
    // make the file name for the output file
    String outputFileName = createOutputFilename(filename);

    // write each string to the file, possibly just taking the first 5 characters
    PrintWriter pw = new PrintWriter(outputFileName);
    for (String s : result)
    {
      if (annotated)
      {
        pw.println(s);       
      }
      else
      {
        pw.println(s.substring(0, 5));
      }
    }
    pw.close();
  }

  /**
   * Helper method to create the output file name from the input file name.
   * @param name
   *   given input file name
   * @return
   *   output file name ending with ".mach227"
   */
  private static String createOutputFilename(String name)
  {
    int i = name.lastIndexOf(".");
    if (i > 0)
    {
      name = name.substring(0, i);
    }
    return name + ".mach227";
  }
}