package solutionsToExam1;

public class Problem6 {
	
	int minutesPerQuarter;
	int maximumTime;
	int coins;
	int currentTime;
	
	
	public Problem6(int minutesPerQuarter, int maximumTime)
	{
		this.minutesPerQuarter = minutesPerQuarter;
		this.maximumTime = maximumTime;
	}
	
	public void insertCoin(int howMany)
	{
		coins += howMany;
		currentTime += Math.min(minutesPerQuarter * howMany, maximumTime);
	}
	
	public void passtime(int minutes)
	{
		currentTime = Math.max(currentTime - minutes, 0);
	}
	
	public int getTimeRemaining() // this is an accessor method. don't change the value
	{
		return currentTime;
	}
	
	public int getTotal()
	{
		return coins;
	}

	public static void main(String[] args) {
		Problem6 p = new Problem6(15, 60);
		p.insertCoin(3);
		p.passtime(20);
		System.out.println(p.getTimeRemaining());
		System.out.println(p.getTotal());
		p.getTotal();
		p.insertCoin(4);
		p.passtime(90);
		System.out.println(p.getTimeRemaining());
		System.out.println(p.getTotal());
	}

}
