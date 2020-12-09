package question6;


public class Contact {
	
	private String name;
	private String number;
	
	
	public Contact(String givenName, String givenPhoneNumber) 
	{
		name = givenName;
		number = givenPhoneNumber;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public String getPhoneNumber() 
	{
		return number;
	}
	
	public int[] getPhoneNumberArray() 
	{
		int toreturn[] = new int[10]; // creates a new array 
		int index = 0; 
		for(int i = 0; i < number.length(); i++) 
		{
			char toConvert = number.charAt(i);
			if(toConvert!= '-') {
				toreturn[index] = Integer.parseInt(toConvert+"");
				index++;
			}
		}
		return toreturn;
	}
	
}