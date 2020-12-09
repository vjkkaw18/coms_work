package kautzLecture;

/**
 * An Order models an order of some number of t-shirts. T-shirts cost 10.00/each
 * plus 2.00/each per shirt for shipping, except that orders of 25 or more shirts 
 * ship free. MN residents pay 5% sales tax on the entire order.
 */
public class Order
{
  public static final double PRICE = 10.0;
  public static final double SHIPPING_COST_PER_SHIRT = 2.0;
  public static final int FREE_SHIPPING_THRESHOLD = 25;
  public static final double TAX_RATE = .05;
  
  /**
   * Number of shirts in this order.
   */
  private int numShirts;
  
  /**
   * True if this is for a MN resident. 
   */
  private boolean isResident;
  
  /**
   * Constructs on order with no shirts for a non-MN resident.
   */
  public Order()
  {
    numShirts = 0;
    isResident = false;
  }

  /**
   * Adds the given number of shirts to this order.
   * 
   * @param numToAdd
   *          how many shirts to add
   */
  public void addShirts(int numToAdd)
  {
    numShirts = numShirts + numToAdd;
  }

  /**
   * Sets whether or not this order is for a MN resident
   * 
   * @param givenResidentStatus
   *          true if the order is for a MN resident, false otherwise
   */
  public void setResidentStatus(boolean givenResidentStatus)
  {
    isResident = givenResidentStatus;
  }

  /**
   * Returns the number of shirts currently in this order.
   * 
   * @return number of shirts in this order
   */
  public int getNumShirts()
  {
    return numShirts;
  }

  /**
   * Determines whether this order is for a MN resident
   * 
   * @return true if the order is for a MN resident, false otherwise
   */
  public boolean isMNResident()
  {
    return isResident;
  }

  /**
   * Returns the total for this order, including shipping and tax if applicable.
   * 
   * @return total for this order
   */
  public double getTotal()
  {
    double shirtCost = 10.00 * numShirts;
    
    double shipping;    
    if (numShirts < 25)
    {
      shipping = 2.00 * numShirts;
    }
    else
    {
      shipping = 0;
    }
    
    double tax;
    if (isResident)
    {
      tax = .05 * (shirtCost + shipping);
    }
    else
    {
      tax = 0;
    }
    
    double total = shirtCost + shipping + tax;
    return total;
  }
 
  public double getTotalAlt()
  {
    double shirtCost = numShirts * PRICE;
    double shipping = 0;
    if (numShirts < FREE_SHIPPING_THRESHOLD)
    {
      shipping = numShirts * SHIPPING_COST_PER_SHIRT;
    }
    
    double tax = 0;
    if (isResident)
    {
      tax = (shirtCost + shipping) * TAX_RATE;
    }
    
    double total = shirtCost + shipping + tax;
    return total;
  }

  
  public double getTotalAlt2()
  {
    double total = numShirts * PRICE;
    if (numShirts < FREE_SHIPPING_THRESHOLD)
    {
      total += numShirts * SHIPPING_COST_PER_SHIRT;
    }
    if (isResident)
    {
      total += total * TAX_RATE;
    }
    return total;
  }
//
//
//
//  // yeah, we can do it on one line using "ternary expressions", but pretty hard to read...
//  public double getTotalAlt3()
//  {
//    return numShirts * PRICE + (numShirts < FREE_SHIPPING_THRESHOLD ? numShirts * SHIPPING_COST_PER_SHIRT : 0) + (isResident ?  (numShirts + (numShirts < FREE_SHIPPING_THRESHOLD ? numShirts * SHIPPING_COST_PER_SHIRT : 0)) * TAX_RATE : 0);
//  }
  

}