package question6;

import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;


public class ContactDirectory {
	ArrayList<Contact> allContact = new ArrayList<Contact>();
	
	
	public void addContact(Contact c) {
		allContact.add(c);
	}
	
	public void addFromFile(String filename) throws FileNotFoundException
	{
		File file = new File(filename);
		Scanner s = new Scanner(file);
		while(s.hasNextLine()) {
			String line = s.nextLine();
			Scanner inner = new Scanner(line);
			String name = inner.next();
			String number = inner.next();
			name.replace(",", "");
			Contact c = new Contact(name,number);
			allContact.add(c);
		}
		
	}
	
	public String lookUp(String name) 
	{
		for(int i =0;i<allContact.size();i++) 
		{
			if(name.equals(allContact.get(i).getName())) 
			{
				return allContact.get(i).getPhoneNumber();
			}
		}
		return null;
	}
	
}