package question1;

public class TimeForDoubleBalance {

	public static void main(String[] args) {
		System.out.println(InterestsInMonths(5.0, 1000));

	}
	
	//interest rate expressed in %
	public static int InterestsInMonths(double interestRate, double balance)
	{
		int numMonths = 0; 
		double interestValue = interestRate / 100;
		double balanceWithInterest = balance + (balance * interestValue); 
		double newBalanceDoubled = balanceWithInterest * 2;
		
		while (balanceWithInterest < newBalanceDoubled)
		{
			balanceWithInterest = balanceWithInterest + (balanceWithInterest * interestValue);
			numMonths += 1;
		}
		
		return numMonths;
	}

}
