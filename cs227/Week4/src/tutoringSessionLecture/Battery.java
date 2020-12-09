package tutoringSessionLecture;

public class Battery {
	
	private int life;
	private boolean status;
	
	public Battery()
	{
		life = 0;
		status = false;
	}
	
	public Battery(int givenMin)
	{
		life = givenMin;
		status = true;
		
	}
	
	public int lifeLeft() 
	{
		return life;
	}
	
	public boolean isAlive()
	{
		return true;
		
	}
	
	public void use(int min)
	{
		life = life - min;
	}

}
