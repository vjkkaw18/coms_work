package edu.iastate.cs228.hw3;

/**
 *  
 * @author
 * Vance Kaw
 * 
 * The main implementation of the PrimeFactorization which includes multiplying, dividing, obtaining the gcd
 * through euclidean strategy. This is where all the process takes place. 
 * This class also has some methods calling from the PrimeFactor class.  
 *
 */

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class PrimeFactorization implements Iterable<PrimeFactor>
{
	private static final long OVERFLOW = -1;
	private long value; 	// the factored integer 
							// it is set to OVERFLOW when the number is greater than 2^63-1, the
						    // largest number representable by the type long. 
	
	/**
	 * Reference to dummy node at the head.
	 */
	private Node head;
	  
	/**
	 * Reference to dummy node at the tail.
	 */
	private Node tail;
	
	private int size;     	// number of distinct prime factors


	// ------------
	// CONSTRUCTORS
	// ------------
	
    /**
	 *  Default constructor constructs an empty list to represent the number 1.
	 *  
	 *  Combined with the add() method, it can be used to create a prime factorization.  
	 */
	public PrimeFactorization() 
	{	 
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.previous = head;
		size = 0;
		value = 1;
	}

	
	/** 
	 * Obtains the prime factorization of n and creates a doubly linked list to store the result.   
	 * Follows the direct search factorization algorithm in Section 1.2 of the project description. 
	 * 
	 * @param n
	 * @throws IllegalArgumentException if n < 1
	 */
	public PrimeFactorization(long n) throws IllegalArgumentException 
	{
		if (n < 1)
		{
			throw new IllegalArgumentException();
		}
		
		else 
		{
			head = new Node();
			tail = new Node();
			head.next = tail;
			tail.previous = head;
			size = 0;
			
			value = n;
			long tempValue = n;
			int prime;
			int multiplicity = 0;
			
			for (prime = 2; (prime * prime) <= tempValue; prime++)
			{
				multiplicity = 0;
				while (tempValue % prime == 0)
				{
					tempValue = tempValue / prime;
					multiplicity += 1;
				}
				
				if (multiplicity > 0)
				{
					this.add(prime, multiplicity);
				}
			}
			this.add((int) tempValue, 1);
			updateValue();
		}
	}
	
	
	/**
	 * Copy constructor. It is unnecessary to verify the primality of the numbers in the list.
	 * Calling the first constructor by massing pf.value then the creation of the list is taken care of 
	 * by the previous constructor. 
	 * 
	 * @param pf
	 */
	public PrimeFactorization(PrimeFactorization pf)
	{
		this(pf.value);
	}
	
	/**
	 * Constructs a factorization from an array of prime factors.  Useful when the number is 
	 * too large to be represented even as a long integer. 
	 * 
	 * @param pflist
	 */
	public PrimeFactorization (PrimeFactor[] pfList)
	{
		this();
		for(int i = 0; i < pfList.length; i++)
		{
			PrimeFactor pf = pfList[i];
			this.add(pf.prime, pf.multiplicity);
		}
		updateValue();
	}
	
	

	// --------------
	// PRIMALITY TEST
	// --------------
	
    /**
	 * Test if a number is a prime or not.  Check iteratively from 2 to the largest 
	 * integer not exceeding the square root of n to see if it divides n. 
	 * 
	 *@param n
	 *@return true if n is a prime 
	 * 		  false otherwise 
	 */
    public static boolean isPrime(long n) 
	{
    	if (n <= 1)
    	{
    		return false;
    	}
    	
    	else 
    	{
    		for (long i = 2; i < n; i++) 
        	{
    			if (n % i == 0) // meaning number is not prime or in other words, n is divisible to a number, i
    			{
    				return false;
    			}
    		}
    		return true; 
    	}
	}   

   
   
	// ---------------------------
	// MULTIPLICATION AND DIVISION
	// ---------------------------
	
	/**
	 * Multiplies the integer v represented by this object with another number n.  Note that v may 
	 * be too large (in which case this.value == OVERFLOW). You can do this in one loop: Factor n and 
	 * traverse the doubly linked list simultaneously. For details refer to Section 3.1 in the 
	 * project description. Store the prime factorization of the product. Update value and size. 
	 * 
	 * @param n
	 * @throws IllegalArgumentException if n < 1
	 */
	public void multiply(long n) throws IllegalArgumentException 
	{	
		if (n < 1)
		{
			throw new IllegalArgumentException();
		}
		
		else 
		{
			PrimeFactorization pf = new PrimeFactorization(n);
			PrimeFactorizationIterator iter = pf.iterator();
			value *= n;
			
			while (iter.hasNext())
			{
				PrimeFactor pFactor = iter.next();
				this.add(pFactor.prime, pFactor.multiplicity);
			}
		}
	}
	
	/**
	 * Multiplies the represented integer v with another number in the factorization form.  Traverse both 
	 * linked lists and store the result in this list object.  See Section 3.1 in the project description 
	 * for details of algorithm. 
	 * 
	 * @param pf 
	 */
	public void multiply(PrimeFactorization pf)
	{
		PrimeFactorizationIterator iter = pf.iterator();

		while (iter.hasNext())
		{
			PrimeFactor f = iter.next();
			int prime = f.prime;
			int multi = f.multiplicity;
			this.add(prime, multi);
			value *= Math.pow(f.prime, f.multiplicity);
		}
		updateValue();
	}
	
	
	/**
	 * Multiplies the integers represented by two PrimeFactorization objects.  
	 * 
	 * @param pf1
	 * @param pf2
	 * @return object of PrimeFactorization to represent the product 
	 */
	public static PrimeFactorization multiply(PrimeFactorization pf1, PrimeFactorization pf2)
	{
		PrimeFactorization newPrimeFactorization = new PrimeFactorization();
		
		newPrimeFactorization.multiply(pf1);
		newPrimeFactorization.multiply(pf2);
		
		return newPrimeFactorization;
	}

	
	/**
	 * Divides the represented integer v by n.  Make updates to the list, value, size if divisible.  
	 * No update otherwise. Refer to Section 3.2 in the project description for details. 
	 *  
	 * @param n
	 * @return  true if divisible 
	 *          false if not divisible 
	 * @throws IllegalArgumentException if n <= 0
	 */
	public boolean dividedBy(long n) throws IllegalArgumentException
	{
		if (n <= 0)
		{
			throw new IllegalArgumentException();
		}
		
		if ((this.value != -1) && (this.value < n))
		{
			return false; 
		}
		
		else 
		{
			PrimeFactorization pf = new PrimeFactorization(n);
			dividedBy(pf);
			
			return true;
		}
		
	}

	
	/**
	 * Division where the divisor is represented in the factorization form.  Update the linked 
	 * list of this object accordingly by removing those nodes housing prime factors that disappear  
	 * after the division.  No update if this number is not divisible by pf. Algorithm details are 
	 * given in Section 3.2. 
	 * 
	 * @param pf
	 * @return	true if divisible by pf
	 * 			false otherwise
	 */
	public boolean dividedBy(PrimeFactorization pf)
	{
		int tempSize = 1;
		int pfSize = pf.size;
		
		if ((this.value != -1) && (pf.value != -1) && (this.value < pf.value))
		{
			return false;
		}
		
		if ((this.value != -1) && (pf.value== -1))
		{
			return false;
		}
		
		PrimeFactorization copyPrimeFactorization = new PrimeFactorization(this);
		
		PrimeFactorizationIterator iterPf = pf.iterator();
		PrimeFactorizationIterator iterCopy = copyPrimeFactorization.iterator();
		
		if (copyPrimeFactorization.value == pf.value)
		{
			clearList();
			value = 1;
			return true;
		}
		
		while(iterCopy.hasNext())
		{
			PrimeFactor pFactor = iterCopy.cursor.pFactor;
			
			if (!iterCopy.hasNext() && iterPf.hasNext())
			{
				return false;
			}
			
			if (iterCopy.cursor.pFactor.prime >= iterPf.cursor.pFactor.prime)
			{
				if (iterCopy.cursor.pFactor.prime > iterPf.cursor.pFactor.prime)
				{
					return false;
				}
				
				else if ((iterCopy.cursor.pFactor.prime == iterPf.cursor.pFactor.prime) && 
						(iterCopy.cursor.pFactor.multiplicity < iterPf.cursor.pFactor.multiplicity))
				{
					return false;
				}
				
				if ((iterCopy.cursor.pFactor.prime == iterPf.cursor.pFactor.prime) && 
						(iterCopy.cursor.pFactor.multiplicity >= iterPf.cursor.pFactor.multiplicity))
				{
					iterCopy.cursor.pFactor.multiplicity -= iterPf.cursor.pFactor.multiplicity;
					
					if (iterCopy.cursor.pFactor.multiplicity == 0)
					{
						iterCopy.remove();
					}
					
					if(tempSize < pfSize)
					{
						iterCopy.next();
						iterPf.next();
						tempSize++;
					}
					
					else if (tempSize == pfSize)
					{
						iterPf.next();
						break;
					}
				}
				
				else 
				{
					iterCopy.next();
				}
		
			}
			else 
			{
				iterCopy.next();
			}
		
		}
		
//		if (iterPf.cursor == tail)
//		{
			this.head = copyPrimeFactorization.head;
			this.tail = copyPrimeFactorization.tail;
			this.size = copyPrimeFactorization.size;
			this.updateValue();
//		}
		
		return true;
	}

	
	/**
	 * Divide the integer represented by the object pf1 by that represented by the object pf2. 
	 * Return a new object representing the quotient if divisible. Do not make changes to pf1 and 
	 * pf2. No update if the first number is not divisible by the second one. 
	 *  
	 * @param pf1
	 * @param pf2
	 * @return quotient as a new PrimeFactorization object if divisible
	 *         null otherwise 
	 */
	public static PrimeFactorization dividedBy(PrimeFactorization pf1, PrimeFactorization pf2)
	{
		PrimeFactorization newPrimeFactorization = new PrimeFactorization(pf1);
		
		boolean divisibility = newPrimeFactorization.dividedBy(pf2.value);
		
		if (divisibility == false)
		{
			return null;
		}
		
		return newPrimeFactorization; 
	}

	
	// -----------------------
	// GREATEST COMMON DIVISOR (GCD)
	// -----------------------

	/**
	 * Computes the greatest common divisor (gcd) of the represented integer v and an input integer n.
	 * Returns the result as a PrimeFactor object.  Calls the method Euclidean() if 
	 * this.value != OVERFLOW.
	 *     
	 * It is more efficient to factorize the gcd than n, which can be much greater. 
	 *     
	 * @param n
	 * @return prime factorization of gcd
	 * @throws IllegalArgumentException if n < 1
	 */
	public PrimeFactorization gcd(long n) throws IllegalArgumentException
	{
		if (n < 1)
		{
			throw new IllegalArgumentException();
		}
		
		PrimeFactorization pf = null;
		long gcdValue = 0;
		
		if(this.value != OVERFLOW)
		{
			gcdValue = Euclidean(this.value, n);
			pf = new PrimeFactorization(gcdValue);
		}
		
		return pf; 
	}
	

	/**
	  * Implements the Euclidean algorithm to compute the gcd of two natural numbers m and n. 
	  * The algorithm is described in Section 4.1 of the project description. 
	  * 
	  * @param m
	  * @param n
	  * @return gcd of m and n. 
	  * @throws IllegalArgumentException if m < 1 or n < 1
	  */
 	public static long Euclidean(long m, long n) throws IllegalArgumentException
	{
 		if (m < 1 || n < 1)
 		{
 			throw new IllegalArgumentException();
 		}
 		long gcdValue = 0;
 		long tempM = m;
 		long tempN = n;
 		long remainder = tempM % tempN;
 		
 		while (remainder != 0)
 		{
 			tempM = tempN;
 			tempN = remainder;
 			remainder = tempM % tempN;
 		}
 		gcdValue = tempN;
 		
 		return gcdValue; 
	}

 	
	/**
	 * Computes the gcd of the values represented by this object and pf by traversing the two lists.  No 
	 * direct computation involving value and pf.value. Refer to Section 5 in the project description 
	 * on how to proceed.  
	 * 
	 * @param  pf
	 * @return prime factorization of the gcd
	 */
	public PrimeFactorization gcd(PrimeFactorization pf)
	{
		PrimeFactorization pfFinal = new PrimeFactorization();
		
		PrimeFactorizationIterator iter = iterator();
		PrimeFactorizationIterator pfIter = pf.iterator();
		
		if ((this.value == -1) || pf.value == -1)
		{
			updateValue();
		}
		
		if (this.value != -1)
		{
			while(pfIter.hasNext())
			{
				PrimeFactor thisPrimeFactor = iter.cursor.pFactor;
				PrimeFactor pfPrimeFactor = pfIter.cursor.pFactor;
				
				if(containsPrimeFactor(pfPrimeFactor.prime))
				{
					if(thisPrimeFactor.prime == pfPrimeFactor.prime)
					{
						if(pfPrimeFactor.multiplicity < thisPrimeFactor.multiplicity)
						{
							pfFinal.add(pfPrimeFactor.prime, pfPrimeFactor.multiplicity);
							iter.next();
							pfIter.next();
						}

						else if (pfPrimeFactor.multiplicity > thisPrimeFactor.multiplicity)
						{
							pfFinal.add(thisPrimeFactor.prime, thisPrimeFactor.multiplicity);
							iter.next();
							pfIter.next();
						}

						else 
						{
							pfFinal.add(pfPrimeFactor.prime, pfPrimeFactor.multiplicity);
							iter.next();
							pfIter.next();
						}
					}

					else 
					{
						iter.next();
					}
				}
				
				else 
				{
					pfIter.next();
				}
			}
		}
		return pfFinal; 
	}
	
	
	/**
	 * 
	 * @param pf1
	 * @param pf2
	 * @return prime factorization of the gcd of two numbers represented by pf1 and pf2
	 */
	public static PrimeFactorization gcd(PrimeFactorization pf1, PrimeFactorization pf2)
	{
		PrimeFactorization newPrimeFactorization = new PrimeFactorization();
		
		newPrimeFactorization = pf1.gcd(pf2);
		
		return newPrimeFactorization; 
	}

	// ------------
	// LIST METHODS
	// ------------
	
	/**
	 * Traverses the list to determine if p is a prime factor. 
	 * 
	 * Precondition: p is a prime. 
	 * 
	 * @param p  
	 * @return true  if p is a prime factor of the number v represented by this linked list
	 *         false otherwise 
	 * @throws IllegalArgumentException if p is not a prime
	 */
	public boolean containsPrimeFactor(int p) throws IllegalArgumentException
	{
		if (!isPrime(p))
		{
			throw new IllegalArgumentException();
		}
		
		PrimeFactorizationIterator iter = iterator();
		
		while(iter.hasNext())
		{
			PrimeFactor pf = iter.next();
			if (pf.prime == p)
			{
				return true;
			}
		}
		return false;
	}
	
	// The next two methods ought to be private but are made public for testing purpose. Keep
	// them public 
	
	/**
	 * Adds a prime factor p of multiplicity m.  Search for p in the linked list.  If p is found at 
	 * a node N, add m to N.multiplicity.  Otherwise, create a new node to store p and m. 
	 *  
	 * Precondition: p is a prime. 
	 * 
	 * @param p  prime 
	 * @param m  multiplicity
	 * @return   true  if m >= 1
	 *           false if m < 1   
	 */
    public boolean add(int p, int m) 
    {
    	if (m < 1)
    	{
    		return false;
    	}
    	
    	else 
    	{
    		if (isPrime(p))
        	{
        		PrimeFactorizationIterator iter = iterator();
        		  
            	if (size == 0)
            	{
            		PrimeFactor pFactor = new PrimeFactor(p, m);
            		iter.add(pFactor);
            	
            		return true;
            	}
            	
            	else 
            	{
            		while (iter.hasNext())
                	{
                		iter.next();
                		
                		PrimeFactor cursorPrev = iter.cursor.previous.pFactor;
                		PrimeFactor cursorCurrent = iter.cursor.pFactor;
                		
                		if (p == cursorPrev.prime)
                		{
                			cursorPrev.multiplicity += m;
                			break;
                		}
                		
                		else if (cursorCurrent == null)
                		{
                			PrimeFactor pFactor = new PrimeFactor(p, m);
                			iter.add(pFactor);
                			break;
                			
                		}
                		else if (p < cursorCurrent.prime)
                		{
                			PrimeFactor pFactor = new PrimeFactor(p, m);
                			iter.add(pFactor);
                			break;
                		}
                	}
            		updateValue();
            	}
        	}
    		return true;
    	}
    }

	    
    /**
     * Removes m from the multiplicity of a prime p on the linked list.  It starts by searching 
     * for p.  Returns false if p is not found, and true if p is found. In the latter case, let 
     * N be the node that stores p. If N.multiplicity > m, subtracts m from N.multiplicity.  
     * If N.multiplicity <= m, removes the node N.  
     * 
     * Precondition: p is a prime. 
     * 
     * @param p
     * @param m
     * @return true  when p is found. 
     *         false when p is not found. 
     * @throws IllegalArgumentException if m < 1
     */
    public boolean remove(int p, int m) throws IllegalArgumentException
    {
    	if (m < 1)
    	{
    		throw new IllegalArgumentException();
    	}
    	
    	PrimeFactorizationIterator iter = iterator();
    	
    	while (iter.hasNext())
    	{	
    		iter.next();
    		PrimeFactor cursorPrev = iter.cursor.previous.pFactor;
    		
    		if ((cursorPrev.prime == p) && (cursorPrev.multiplicity > m))
    		{
    			cursorPrev.multiplicity -= m;
    			return true;
    		}
    		
    		else if ((cursorPrev.prime == p) && (cursorPrev.multiplicity <= m))
    		{
    			iter.remove();
    			return true;
    		}
    	}
    	return false; 
    }


    /**
     * 
     * @return size of the list
     */
	public int size() 
	{
		return size; 
	}

	
	/**
	 * Writes out the list as a factorization in the form of a product. Represents exponentiation 
	 * by a caret.  For example, if the number is 5814, the returned string would be printed out 
	 * as "2 * 3^2 * 17 * 19". 
	 */
	@Override 
	public String toString()
	{
		String str = "";
		
		PrimeFactorizationIterator iter = iterator();
		
		int index = 0;
		
		while (iter.hasNext())
		{
			PrimeFactor pf = iter.cursor.pFactor;
			if (index < size - 1)
			{
				str += pf.toString() + " * ";
			}
			
			else if (index == size - 1)
			{
				str += pf.toString();
				break;
			}
			index++;
			iter.next();
		}
		
		return str; 
	}

	
	// The next three methods are for testing, but you may use them as you like.  

	/**
	 * @return true if this PrimeFactorization is representing a value that is too large to be within 
	 *              long's range. e.g. 999^999. false otherwise.
	 */
	public boolean valueOverflow() {
		return value == OVERFLOW;
	}

	/**
	 * @return value represented by this PrimeFactorization, or -1 if valueOverflow()
	 */
	public long value() {
		return value;
	}

	public PrimeFactor[] toArray() {
		PrimeFactor[] arr = new PrimeFactor[size];
		int i = 0;
		for (PrimeFactor pf : this)
			arr[i++] = pf;
		return arr;
	}
	
	@Override
	public PrimeFactorizationIterator iterator()
	{
	    return new PrimeFactorizationIterator();
	}
	
	
	//************ DOUBLY LINKED LIST (DLL) ****************
	/**
	 * Doubly-linked node type for this class.
	 */
    private class Node 
    {
		public PrimeFactor pFactor; 	// prime factor 
		public Node next;
		public Node previous;
		
		/**
		 * Default constructor for creating a dummy node.
		 */
		public Node()
		{
			pFactor = null; 
			next = null;
			previous = null;
		}
	    
		/**
		 * Precondition: p is a prime
		 * 
		 * @param p	 prime number 
		 * @param m  multiplicity 
		 * @throws IllegalArgumentException if m < 1 
		 */
		public Node(int p, int m) throws IllegalArgumentException 
		{	
			if (m < 1)
			{
				throw new IllegalArgumentException();
			}
			
			else if (isPrime(p))
			{
				pFactor = new PrimeFactor(p, m);
				next = null;
				previous = null;
			}
		}   

		
		/**
		 * Constructs a node over a provided PrimeFactor object. 
		 * 
		 * @param pf
		 * @throws IllegalArgumentException
		 */
		public Node(PrimeFactor pf)  
		{
			if (pf == null)
			{
				throw new IllegalArgumentException();
			}
			
			else 
			{
				this.pFactor = pf;
				this.next = null;
				this.previous = null;
			}
		}


		/**
		 * Printed out in the form: prime + "^" + multiplicity.  For instance "2^3". 
		 * Also, deal with the case pFactor == null in which a string "dummy" is 
		 * returned instead.  
		 */
		@Override
		public String toString() 
		{
			String str = "";
			
			if (pFactor == null)
			{
				str += "dummy";
			}
			
			else 
			{
				str += pFactor.toString();
			}
			
			return str; 
		}
    }

    
    //************ ITERATOR ****************
    private class PrimeFactorizationIterator implements ListIterator<PrimeFactor>
    {  	
        // Class invariants: 
        // 1) logical cursor position is always between cursor.previous and cursor
        // 2) after a call to next(), cursor.previous refers to the node just returned 
        // 3) after a call to previous() cursor refers to the node just returned 
        // 4) index is always the logical index of node pointed to by cursor

        private Node cursor = head.next;
        private Node pending = null;    // node pending for removal
        private int index = 0;      

    	// other instance variables ... 
    	  
      
        /**
    	 * Default constructor positions the cursor before the smallest prime factor.
    	 */
    	public PrimeFactorizationIterator()
    	{
//    		direction = NONE;
    		cursor = head.next;
    	}

    	@Override
    	public boolean hasNext()
    	{
    		return index < size;
    	}

    	
    	@Override
    	public boolean hasPrevious()
    	{
    		return index >= 0; 
    	}

 
    	@Override 
    	public PrimeFactor next() 
    	{
    		if (!hasNext())
    		{
    			throw new NoSuchElementException();
    		}
    		
    		else 
    		{
    			pending = cursor;
        		cursor = cursor.next;
        		index++;
        		
        		return pending.pFactor;
    		}
    	}

 
    	@Override 
    	public PrimeFactor previous() 
    	{
    		if (!hasPrevious())
    		{
    			throw new NoSuchElementException();
    		}
    		
    		else 
    		{
    			pending = cursor;
        		cursor = cursor.previous;
        		index--;
        		
        		return pending.pFactor; 
    		}
    	}

   
    	/**
    	 *  Removes the prime factor returned by next() or previous()
    	 *  
    	 *  @throws IllegalStateException if pending == null 
    	 */
    	@Override
    	public void remove() throws IllegalStateException
    	{	
    		if (pending == null)
    		{
    			throw new IllegalArgumentException();
    		}

    		unlink(cursor);
    		size--;
    		pending = null;
    		index--;
    	}
 
 
    	/**
    	 * Adds a prime factor at the cursor position. The cursor is at a wrong position 
    	 * in either of the two situations below: 
    	 * 
    	 *    a) pf.prime < cursor.previous.pFactor.prime if cursor.previous != head. 
    	 *    b) pf.prime > cursor.pFactor.prime if cursor != tail. 
    	 * 
    	 * Take into account the possibility that pf.prime == cursor.pFactor.prime. 
    	 * 
    	 * Precondition: pf.prime is a prime. 
    	 * 
    	 * @param pf  
    	 * @throws IllegalArgumentException if the cursor is at a wrong position. 
    	 */
    	@Override
    	public void add(PrimeFactor pf) throws IllegalArgumentException 
    	{
    		// This makes sure that you are not adding a prime at current place that is greater than the 
    		// previous.prime.
    		// If previous is head, then it doesn't matter
    		if (cursor.previous != head)
    		{
    			if (pf.prime < this.cursor.previous.pFactor.prime)
    			{
    				throw new IllegalArgumentException();
    			}
    		}

    		// This makes sure the prime you are adding is not greater than the next (which cursor currently
    		// refers to) prime. 
    		if (cursor != tail)
    		{
    			if (pf.prime > this.cursor.pFactor.prime)
    			{
    				throw new IllegalArgumentException();
    			}
    		}

    	
    		if (isPrime(pf.prime))
    		{
    			Node temp = new Node(pf);
    			link(cursor.previous, temp);
    			pending = null;
    			index++;
    			size++;
    		} 

    	}


    	@Override
		public int nextIndex() 
		{
			return index;
		}


    	@Override
		public int previousIndex() 
		{
			return index - 1;
		}

		@Deprecated
		@Override
		public void set(PrimeFactor pf) 
		{
			throw new UnsupportedOperationException(getClass().getSimpleName() + " does not support set method");
		}
        
    	// Other methods you may want to add or override that could possibly facilitate 
    	// other operations, for instance, addition, access to the previous element, etc.
    	// 
    	// ...
    	// 
    }

    
    // --------------
    // Helper methods 
    // -------------- 
    
    /**
     * Inserts toAdd into the list after current without updating size.
     * 
     * Precondition: current != null, toAdd != null
     */
    private void link(Node current, Node toAdd)
    {
    	if (current != null && toAdd != null)
    	{
    		toAdd.previous = current;
    		toAdd.next = current.next;
    		current.next.previous = toAdd;
    		current.next = toAdd;
    	}
    }

	 
    /**
     * Removes toRemove from the list without updating size.
     */
    private void unlink(Node toRemove)
    {
    	toRemove.previous.next = toRemove.next;
    	toRemove.next.previous = toRemove.previous;
    }


    /**
	  * Remove all the nodes in the linked list except the two dummy nodes. 
	  * 
	  * Made public for testing purpose.  Ought to be private otherwise. 
	  */
	public void clearList()
	{
		head.next = tail;
		tail.previous = head;
		size = 0;
	}	
	
	/**
	 * Multiply the prime factors (with multiplicities) out to obtain the represented integer.  
	 * Use Math.multiply(). If an exception is throw, assign OVERFLOW to the instance variable value.  
	 * Otherwise, assign the multiplication result to the variable. 
	 * 
	 */
	private void updateValue()
	{
		try 
		{		
			PrimeFactorizationIterator iter = iterator();
			value = 1;

			while (iter.hasNext())
			{
				PrimeFactor pf = iter.next();
				long temp = 1;
				
				temp *= (long) Math.pow(pf.prime, pf.multiplicity);
				value = Math.multiplyExact(value, temp);
			}
		} 
			
		catch (ArithmeticException e) 
		{
			value = OVERFLOW;
		}
		
	}
}
