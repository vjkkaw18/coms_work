package exam3practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionListIterator {

	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();
		c.add("Honey");
		c.add("Dewey");
		c.add("Louie");
		
		Iterator <String> iter = c.iterator();
		
		while(iter.hasNext())
		{
			String s = iter.next();
			System.out.println(s);
		}
		// ANOTHER METHOD OF THE WHILE LOOP ABOVE
		for(String s : c)
		{
			System.out.println(s);
		}

	}
}
