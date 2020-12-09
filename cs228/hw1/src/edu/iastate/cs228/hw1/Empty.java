package edu.iastate.cs228.hw1;

/**
 *  
 * @author
 * Vance Kaw
 *
 */

/** 
 * Empty squares are competed by various forms of life.
 */
public class Empty extends Living 
{
	
	/**
	 * Constructor that initializes the plain on the grid based on the row and column.
	 * @param p
	 * plain grid
	 * @param r
	 * row
	 * @param c
	 * column
	 */
	public Empty (Plain p, int r, int c) 
	{
		super(p, r, c);
	}
	
	/**
	 * Empty occupies the square. 	 
	 */
	public State who()
	{
		return State.EMPTY; 
	}
	
	/**
	 * An empty square will be occupied by a neighboring Badger, Fox, Rabbit, or Grass, or remain empty. 
	 * @param pNew     plain of the next life cycle.
	 * @return Living  life form in the next cycle.   
	 */
	public Living next(Plain pNew)
	{
		// 
		// See Living.java for an outline of the function. 
		// See the project description for corresponding survival rules. 
		
		int[] count = new int[Living.NUM_LIFE_FORMS]; // an array that keeps track of the count for each animal
		this.census(count);
		
		if((count[Living.RABBIT] > 1))
		{
			return new Rabbit(pNew, this.row, this.column, 0);
		}
		
		else if (count[Living.FOX] > 1)
		{
			return new Fox(pNew, this.row, this.column, 0);
		}
		
		else if (count[Living.BADGER] > 1)
		{
			return new Badger(pNew, this.row, this.column, 0);
		}
		
		else if (count[Living.GRASS] >= 1)
		{
			return new Grass(pNew, this.row, this.column);
		}
		
		else 
		{
			return new Empty(pNew, this.row, this.column);
		}
	}
}
