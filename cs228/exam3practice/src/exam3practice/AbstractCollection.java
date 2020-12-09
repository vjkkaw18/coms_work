package exam3practice;

import java.util.Collection;
import java.util.Iterator;

public abstract class AbstractCollection<E> implements Collection<E>
{
	public abstract Iterator<E> iterator();
	public abstract int size();
	
	public boolean contains(Object o)
	{
		Iterator<E> e = iterator();
		if (o == null)
		{
			while(e.hasNext())
			{
				if (e.next() == null)
				{
					return true;
				}
			}
			return false;
		}
		
		else 
		{
			while(e.hasNext())
			{
				if (o.equals(e.next()))
				{
					return true;
				}
			}
			
			return false;
		}
	}

}
