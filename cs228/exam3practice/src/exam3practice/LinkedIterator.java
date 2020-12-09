package exam3practice;

import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.xml.soap.Node;

public class LinkedIterator<E> implements Iterator<E> {

	private Node head;
	private Node cursor = head;
	private Node pending = null;
	
	@Override
	public boolean hasNext() {
		
		return cursor != null;
	}

	@Override
	public E next() {
		if(!hasNext())
		{
			throw new NoSuchElementException();
		}
		
		pending = cursor; 
		cursor = cursor.next;
	
		return pending.data;
	}
	
	@Override
	public void remove()
	{
		if (pending == null)
		{
			throw new IllegalStateException();
		}
		
		if (pending.next != null)
		{
			pending.next.prev = pending.prev;
		}
		
		if (pending.prev != null)
		{
			pending.prev.next = pending.next;
		}
		
		if (pending == head)
		{
			head = pending.next;
		}
		
		size--;
		pending = null;
	}

}
