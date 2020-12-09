package kautzLecture;

/**
 * Model of a gas tank with fixed capacity
 * @author vaka99
 *
 */
public class GasTank 
{
	
	/**
	 * amount of gas currently in the tank 
	 */
	private double contents;
	
	/**
	 * capacity of this tank
	 */
	private double capacity;
	
	/**
	 * Constructs a gas tank with the given capacity that is initially empty.
	 * @param givenCapacity
	 * the fixed capacity for the tank
	 */
	public GasTank(double givenCapacity)
	{
		contents = 0;
		capacity = givenCapacity;
	}

	/**
	 * Fills the tank to its capacity.
	 */
	public void fill()
	{
		contents = capacity;
	}
	
	/**
	 * Returns the current contents of the tank
	 * @return
	 * amount of gas in the tank 
	 */
	public double getContents()
	{
		return contents;
	}
	
	/**
	 * Returns the capacity of this tank
	 * @return
	 * capacity of the tank
	 */
	public double getCapacity() 
	{
		return capacity;
	}
	
	/**
	 * Adds the given amount to the tank, if possible (not exceeding capacity)
	 * @param gallons
	 * amount to attempt to add
	 */
	public void add(double gallons) 
	{
		contents = Math.min(contents + gallons, capacity);
		
	}
	
	/**
	 * Uses the given amount from the tank, if possible (not going below zero)
	 * @param gallons
	 * amount to attempt to use
	 */
	public void use(double gallons)
	{
		contents = Math.max(contents - gallons, 0);
	}

	
}

