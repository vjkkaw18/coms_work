package edu.iastate.cs228.hw1;

/**
 *  
 * @author
 * Vance Kaw
 *
 */

/**
 * Grass remains if more than rabbits in the neighborhood; otherwise, it is eaten. 
 *
 */
public class Grass extends Living 
{
	
	/**
	 * Default constructor for Grass that initializes the plain, row, column
	 * @param p: plain
	 * @param r: row
	 * @param c: column
	 */
	public Grass (Plain p, int r, int c) 
	{
		super(p, r, c); 
	}

	/**
	 * Grass occupies the grid
	 */
	public State who()
	{ 
		return State.GRASS; 
	}
	
	/**
	 * Grass can be eaten out by too many rabbits. Rabbits may also multiply fast enough to take over Grass.
	 */
	public Living next(Plain pNew)
	{
		// TODO 
		// 
		// See Living.java for an outline of the function. 
		// See the project description for the survival rules for grass. 
		
		int[] count = new int[Living.NUM_LIFE_FORMS]; // an array that keeps track of the count for each animal
		this.census(count);
		
		if((count[Living.RABBIT]) >= ((count[Living.GRASS]) * 3))
		{
			return new Empty(pNew, this.row, this.column);
		}
		
		else if (count[Living.RABBIT] >= 3)
		{
			return new Rabbit(pNew, this.row, this.column, 0);
		}
		
		else 
		{
			return new Grass(pNew, this.row, this.column);
		}
	}
}
