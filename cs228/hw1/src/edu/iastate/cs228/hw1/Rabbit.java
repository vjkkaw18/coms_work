package edu.iastate.cs228.hw1;

/**
 *  
 * @author
 *
 */

/*
 * A rabbit eats grass and lives no more than three years.
 */
public class Rabbit extends Animal 
{	
	/**
	 * Creates a Rabbit object.
	 * @param p: plain  
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Rabbit (Plain p, int r, int c, int a) 
	{
		super(p, r, c);
		age = a;
		
	}
		
	// Rabbit occupies the square.
	public State who()
	{
		return State.RABBIT; 
	}
	
	/**
	 * A rabbit dies of old age or hunger. It may also be eaten by a badger or a fox.  
	 * @param pNew     plain of the next cycle 
	 * @return Living  new life form occupying the same square
	 */
	public Living next(Plain pNew)
	{
		// TODO 
		// 
		// See Living.java for an outline of the function. 
		// See the project description for the survival rules for a rabbit. 
		int[] count = new int[Living.NUM_LIFE_FORMS]; // an array that keeps track of the count for each animal
		this.census(count);
		
		if(this.age == Living.RABBIT_MAX_AGE)
		{
			return new Empty(pNew, this.row, this.column);
		}
		
		else if (count[Living.GRASS] == 0)
		
		{
			return new Empty(pNew, this.row, this.column);
		}
		
		else if (((count[Living.FOX] + count[Living.BADGER]) >= count[Living.RABBIT]) && 
				(count[Living.FOX] > count[Living.BADGER]))
		{
			return new Fox(pNew, this.row, this.column, 0);
		}
		
		else if (count[Living.BADGER] > count[Living.RABBIT])
		{
			return new Badger(pNew, this.row, this.column, 0);
		}
		
		else 
		{
			int newAge = age + 1;
			return new Rabbit(pNew, this.row, this.column, newAge);
		}
	}
}
