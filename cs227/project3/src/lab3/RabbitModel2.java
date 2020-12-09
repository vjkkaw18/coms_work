package lab3;

/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits. 
 */
public class RabbitModel2
{
  private int population; 
  private int year;
	
  
  /**
   * Constructs a new RabbitModel2.
   */
  public RabbitModel2()
  {
    population = 0;
  }  
 
  /**
   * Returns the current number of rabbits.
   * @return
   *   current rabbit population
   */
  public int getPopulation()
  {
    return population;
  }
  
  /**
   * Updates the population to simulate the
   * passing of one year.
   */
  public void simulateYear()
  {
    year = year + 1;
    
    if ((year % 5) == 0) 
    {
    	population = 0;
    } 
    else 
    {
    	population = population + 1;
    }
 
  }
  
  /**
   * Sets or resets the state of the model to the 
   * initial conditions.
   */
  public void reset()
  {
    population = 0;
    year = 0;
  }
}