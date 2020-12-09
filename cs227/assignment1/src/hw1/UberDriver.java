package hw1;

/**
 * Model of an Uber Driver that simulates the activity of a driver for a shared-ride service. 
 * @author vaka99
 */
public class UberDriver {
	
	/**
	 * Declares a global constant for maximum passengers and operating cost.
	 */
	public static final int MAX_PASSENGERS = 4;
	public static final double OPERATING_COST = 0.5;
	
	/**
	 * the total number of miles the UberDriver has currently driven.
	 */
	private int totalMiles = 0;
	
	/**
	 * the amount of time the UberDriver has been driving. 
	 */
	private int totalMinutes = 0;
	
	/**
	 * the amount of passengers currently in the vehicle. 
	 */
	private int passengers = 0;
	
	/**
	 * The per-mile rate of the vehicle.
	 */
	private double perMileRate;
	
	/**
	 * the per-minute rate of the vehicle.
	 */
	private double perMinuteRate;
	
	/**
	 * the total amount of credits the UberDriver currently gets.
	 */
	private double totalCredits = 0;

	
	
	/**
	 * Constructs an UberDriver with the given per-mile rate and per-minute rate.
	 * @param givenPerMileRate
	 * the given per mile rate of the UberDriver is initialized to the perMileRate instance variables.
	 * @param givenPerMinuteRate
	 * the given per minute rate of the UberDriver is initialized to the perMinuteRate instance variable.
	 */
	public UberDriver(double givenPerMileRate, double givenPerMinuteRate) 
	{
		perMileRate = givenPerMileRate;
		perMinuteRate = givenPerMinuteRate;
	}
	
	/**
	 * Returns the total miles driven by the UberDriver.
	 * @return
	 * total miles driven
	 */
	public int getTotalMiles() 
	{
		return totalMiles;
	}
	
	/**
	 * Returns the total minutes driven by the UberDriver.
	 * @return
	 * total minutes driven
	 */
	public int getTotalMinutes() 
	{
		return Math.max(totalMinutes, 0);
	}
	
	/**
	 * Drives the vehicle for the given number of miles over the given number of minutes.
	 * Total credits for the current drive is calculated based on the given miles, minutes, passengers.
	 * @param miles
	 * the given number of miles driven
	 * @param minutes
	 * the given number of minutes driven
	 */
	public void drive(int miles, int minutes)
	{
		totalMiles = totalMiles + miles;
		totalMinutes = totalMinutes + minutes;
		
		totalCredits = totalCredits + ((miles * perMileRate * passengers) + (minutes * perMinuteRate * passengers));
		
	}
	
	/**
	 * Simulates sitting in the vehicle without moving for the given number of minutes.
	 * @param minutes
	 * the given number of minutes 
	 */
	public void waitAround(int minutes) 
	{
		totalMiles = totalMiles + 0;
		totalMinutes = totalMinutes + minutes;
		totalCredits = totalCredits + (minutes * perMinuteRate * passengers);
		
	}
	
	/**
	 * Drives the vehicle for the given number of miles at the given speed. 
	 * @param miles
	 * the given number of miles
	 * @param averageSpeed
	 * the given average speed of the car
	 */
	public void driveAtSpeed(int miles, double averageSpeed)
	{
		totalMiles = miles + totalMiles;
		
		int tempMinutes = (int) Math.round((miles * 60) / averageSpeed);
		totalMinutes = totalMinutes + tempMinutes;
		
		totalCredits = totalCredits + (miles * perMileRate * passengers) + (tempMinutes * perMinuteRate * passengers);
		
	}
	
	/**
	 * Returns the number of passengers currently in the vehicle.
	 * @return
	 * number of passengers
	 */
	public int getPassengerCount() 
	{
		return passengers;
	}
	
	/**
	 * Increases the passenger count by 1, if possible (not exceeding the indicated maximum passengers).
	 */
	public void pickUp() 
	{
		passengers = Math.min(passengers + 1, MAX_PASSENGERS);
	}
	
	/**
	 * Decreases the passenger count by 1, if possible (not going below 0).
	 */
	public void dropOff() 
	{
		passengers = Math.max(passengers - 1, 0);
	}
	
	/**
	 * Returns this UberDriver's total credits
	 * @return
	 * total credits of the UberDriver
	 */
	public double getTotalCredits() 
	{	
		return totalCredits;
	}
	
	/**
	 * Returns this UberDriver's profit by subtracting totalCredits with the operating cost and miles
	 * @return
	 * profit of the UberDriver
	 */
	public double getProfit()
	{
		double profit = (totalCredits - (OPERATING_COST * totalMiles));
		
		return profit;
	}
	
	/**
	 * Returns this UberDriver's average profit per hour worked. 
	 * @return
	 * average profit per hour of the UberDriver
	 */
	public double getAverageProfitPerHour()
	{
		double averageProfitPerHour = (60 * getProfit()) / getTotalMinutes();
		// code above could also be written as
		// profit * ( 60.0 / minutes);
		// profit * (60 / (double) minutes;  <--- known as "cast"
		
		return averageProfitPerHour;
	}
	
	
}
