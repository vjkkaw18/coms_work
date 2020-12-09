package question8;

import java.io.File;
import java.util.ArrayList;

public class FindingJavaFiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int crossGrids(int r, int c)
	{
		if (r == 0 || c == 0)
		{
			return 1;
		}
		return crossGrids(r-1, c) + crossGrids(r, c-1);
	}
	
	
	
	// test.java
	public void findJavaFiles(File file, ArrayList<String> results)
	{
		//This is our base case. If the .java file is found, then stop or break.
		if (file.getName().contains(".java"))
		{
			results.add(file.getName());
		}
		
		// checks if a file is a folder
		else if (file.isDirectory())
		{
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++)
			{
				findJavaFiles(files[i], results);
			}
		}
	}

}
