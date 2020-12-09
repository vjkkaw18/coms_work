package exam3practice;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorMethodImplementation<E> implements Iterator<E>{
	private int cursor = 0;
	private boolean canRemove = false;
	private int size;
	private E[] data;
	
	@Override
	public boolean hasNext() {
		
		return cursor < size;
	
	}
	@Override
	public E next() {
		
		
		if (cursor >= size)
		{
			throw new NoSuchElementException();
		}
		canRemove = true;
		return data[cursor++];
	}

	public void remove()
	{
		if (!canRemove)
		{
			throw new IllegalStateException();
		}
		// delete element before cursor.
		// Note that must have cursor >= 1
		for (int i = cursor; i < size; ++i)
		{
			data[i - 1] = data[i];
		}
		// null out the vacated cell to avoid
		// memory leak
		data[size - 1] = null;
		--size;
		--cursor;
		canRemove = false;
	}
}

