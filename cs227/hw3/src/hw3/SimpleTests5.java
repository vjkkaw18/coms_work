package hw3;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class SimpleTests5 {

	public static void main(String[] args) throws FileNotFoundException
	{
		ArrayList<String> result = AsmFileUtil.assembleFromFile("primes.mach227"); 
		for (String s : result)
		{ 
			System.out.println(s);
		}

	}

}
