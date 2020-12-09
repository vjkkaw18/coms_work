package edu.iastate.cs228.hw1;

/**
 *  
 * @author
 * Vance Kaw
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner; 

/**
 * 
 * The plain is represented as a square grid of size width x width. 
 *
 */
public class Plain 
{
	private int width; // grid size: width X width 
	
	public Living[][] grid; 
	
	
	
	/**
	 *  Default constructor reads from a file 
	 */
	public Plain(String inputFileName) throws FileNotFoundException
	{		

		// Assumption: The input file is in correct format. 
		// 
		// You may create the grid plain in the following steps: 
		// 
		// 1) Reads the first line to determine the width of the grid.
		// 
		// 2) Creates a grid object. 
		// 
		// 3) Fills in the grid according to the input file. 
		// 
		// Be sure to close the input file when you are done. 
		
		File file = new File(inputFileName);
		Scanner scanner = new Scanner(file);
		
		
		int i = 0; 

		while (scanner.hasNext())
		{
			scanner.next();
			i++;
		}
		
		scanner.close();


		width = (int) Math.sqrt(i);
		
		grid = new Living[width][width];
		
		Scanner scan = new Scanner(file);

		for (int row = 0; row < width; row++)
		{
			for (int col = 0; col < width; col++)
			{
				String x = scan.next(); // Letter followed by number indicating the age if applicable
				char letter = x.charAt(0); 

				int num = 0; 
				if (x.length() == 2)
				{
					num = Integer.parseInt(x.substring(1));
				}

				if (letter == 'B')
				{
					grid[row][col] = new Badger(this, row, col, num);
				}

				else if (letter == 'F')
				{
					grid[row][col] = new Fox(this, row, col, num);
				}

				else if (letter == 'R')
				{
					grid[row][col] = new Rabbit(this, row, col, num);
				}

				else if (letter == 'E')
				{
					grid[row][col] = new Empty(this, row, col);
				}

				else if (letter == 'G')
				{
					grid[row][col] = new Grass(this, row, col);
				}
			}

		}
		scan.close();
	}
	
	/**
	 * Constructor that builds a w x w grid without initializing it. 
	 * @param width  the grid 
	 */
	public Plain(int w)
	{
		width = w;
		grid = new Living[w][w]; 
		
	}
	
	
	public int getWidth()
	{
		return width;
	}
	
	/**
	 * Initialize the plain by randomly assigning to every square of the grid  
	 * one of BADGER, FOX, RABBIT, GRASS, or EMPTY.  
	 * 
	 * Every animal starts at age 0.
	 */
	public void randomInit()
	{
		for (int i = 0; i < width; i++)
		{
			for (int j = 0; j < width; j++)
			{
				Random generator = new Random(); 
				int randomNum = generator.nextInt(5); 
				
				if (randomNum == Living.EMPTY)
				{
					grid[i][j] = new Empty(this, i, j);
				}
				
				else if (randomNum == Living.GRASS)
				{
					grid[i][j] = new Grass(this, i, j);
				}
				
				else if (randomNum == Living.BADGER)
				{
					grid[i][j] = new Badger(this, i, j, 0);
				}
				
				else if (randomNum == Living.FOX)
				{
					grid[i][j] = new Fox(this, i, j, 0);
				}
				
				else if (randomNum == Living.RABBIT)
				{
					grid[i][j] = new Rabbit(this, i, j, 0);
				}
			}
		}
	}
	
	
	/**
	 * Output the plain grid. For each square, output the first letter of the living form
	 * occupying the square. If the living form is an animal, then output the age of the animal 
	 * followed by a blank space; otherwise, output two blanks.  
	 */
	public String toString()
	{
		String output = "";
		
		for (int i = 0; i < width; i++)
		{
			for (int j = 0; j < width; j++)
			{	
				if(grid[i][j].who().equals(State.EMPTY))
				{
					output = output + grid[i][j].who().name().charAt(0) + "  ";
				}
				
				else if(grid[i][j].who().equals(State.GRASS))
				{
					output = output + grid[i][j].who().name().charAt(0) + "  ";
				}			
				
				
				else if(grid[i][j].who().equals(State.BADGER))
				{
					output = output + grid[i][j].who().name().charAt(0) + 
							((Animal) grid[i][j]).myAge() + " ";
				}
				
				else if(grid[i][j].who().equals(State.FOX))
				{
					output = output + grid[i][j].who().name().charAt(0) + 
							((Animal) grid[i][j]).myAge() + " ";
				}
				
				else if(grid[i][j].who().equals(State.RABBIT))
				{
					output = output + grid[i][j].who().name().charAt(0) + 
							((Animal) grid[i][j]).myAge() + " ";
				}
				
				if (j == width - 1)
				{
					output = output + "\n";
				}
			}
		}
		
		return output; 
	}
	

	/**
	 * Write the plain grid to an output file.  Also useful for saving a randomly 
	 * generated plain for debugging purpose. 
	 * @throws FileNotFoundException
	 */
	public void write(String outputFileName) throws FileNotFoundException
	{
		// 
		// 1. Open the file. 
		// 
		// 2. Write to the file. The five life forms are represented by characters 
		//    B, E, F, G, R. Leave one blank space in between. Examples are given in
		//    the project description. 
		// 
		// 3. Close the file. 
		
		File file = new File(outputFileName);
		PrintWriter pw = new PrintWriter(file);
		String str = this.toString();
		pw.write(str);
		pw.close();
	}			
}
