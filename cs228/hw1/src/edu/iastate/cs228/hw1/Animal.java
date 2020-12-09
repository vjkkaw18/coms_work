package edu.iastate.cs228.hw1;

/**
 *  
 * @author
 * Vance Kaw
 *
 */

/*
 * This class is to be extended by the Badger, Fox, and Rabbit classes. 
 */
public abstract class Animal extends Living implements MyAge
{ 	
	protected int age;   // age of the animal 
	
	/**
	 * Creates a constructor that calls on the Living constructor to pass on the parameters. 
	 * @param p
	 * plain
	 * @param r
	 * current row
	 * @param c
	 * current column 
	 */
	public Animal(Plain p, int r, int c) {
		super(p, r, c);
	
	}

	/**
	 *	Method that overrides from the interface class for keeping track of animal's age. 
	 * @return age of the animal 
	 */
	@Override
	public int myAge()
	{
		return age; 
	}
}
