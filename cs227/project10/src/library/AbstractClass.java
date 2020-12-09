package library;

import java.util.Date;


public abstract class AbstractClass implements Item{

	private String title;
	private Date dueDate;
	private Patron checkedOutTo;
	private double replacementCost;
	private int duration;
	

	public int compareTo1(Item p)
	{
		return title.compareTo(p.getTitle());
	}
	
	
	@Override
	public void checkOut(Patron p, Date now)
	{
		
	}
	
	@Override
	public boolean isCheckedOut(){
		return dueDate != null;
	}
	
	@Override
	public void checkIn()
	{
		if (isCheckedOut())
		{
			checkedOutTo = null;
			dueDate = null;
		}
	}

	@Override
	public boolean isOverdue(Date now){
		if (!isCheckedOut()) {
			return false;
		}
		return now.after(dueDate);
	}

	@Override
	public int compareTo(Item other){
		return title.compareTo(other.getTitle());
	}
	@Override

	public String getTitle(){
		return title;
	}
	
	@Override
	public Date getDueDate(){
		return dueDate;
	}

	@Override
	public Patron getPatron(){
		return checkedOutTo;
	}

	@Override
	public double getFine(Date now){
		if (isCheckedOut() && isOverdue(now))
		{
			double elapsed = now.getTime() - dueDate.getTime();

			int millisPerDay = 24 * 60 * 60 * 1000;
			int daysLate = (int) Math.ceil(elapsed / millisPerDay);

			double fine;
			if (daysLate <= 5)
			{
				fine = daysLate;
			}
			else
			{
				fine = 5 + (daysLate - 5) * .50;
			}
			return Math.min(fine, replacementCost);    }
		else
		{
			return 0;
		}
	}
	@Override
	public void renew(Date now){}

}
