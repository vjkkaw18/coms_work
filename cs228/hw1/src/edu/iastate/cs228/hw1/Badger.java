package edu.iastate.cs228.hw1;

/**
 *  
 * @author
 * Vance Kaw
 *
 */

/**
 * A badger eats a rabbit and competes against a fox. 
 */
public class Badger extends Animal
{
	/**
	 * Constructor 
	 * @param p: plain
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	
	/**
	 * Constructor that initializes the plain on the grid based on the row and column. This includes the age too
	 * @param p
	 * plain grid
	 * @param r
	 * row
	 * @param c
	 * column 
	 * @param a
	 * age
	 */
	public Badger (Plain p, int r, int c, int a) 
	{
		super(p, r, c);
		age = a;

	}
	
	/**
	 * A badger occupies the square. 	 
	 */
	public State who()
	{
		return State.BADGER; 
	}
	
	/**
	 * A badger dies of old age or hunger, or from isolation and attack by a group of foxes. 
	 * @param pNew     plain of the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(Plain pNew)
	{
		// 
		// See Living.java for an outline of the function. 
		// See the project description for the survival rules for a badger. 
		
		int[] count = new int[Living.NUM_LIFE_FORMS]; // an array that keeps track of the count for each animal
		this.census(count);
		
		if(this.age == Living.BADGER_MAX_AGE)
		{
			return new Empty(pNew, this.row, this.column);
		}
		
		else if (count[Living.BADGER] == 1 && count[Living.FOX] > 1)
		{
			return new Fox(pNew, this.row, this.column, 0);
		}
		
		else if ((count[Living.BADGER] + count[Living.FOX]) > count[Living.RABBIT])
		{
			return new Empty(pNew, this.row, this.column);
		}
		
		else 
		{
			int newAge = age + 1;
			return new Badger(pNew, this.row, this.column, newAge); 
		}
	}
}
