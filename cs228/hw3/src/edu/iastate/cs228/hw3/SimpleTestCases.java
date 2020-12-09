package edu.iastate.cs228.hw3;

public class SimpleTestCases {

	public static void main(String[] args) {	
		
//-------------------------------------------------------------------------		
		
//		PrimeFactor a = new PrimeFactor(2, 3);
//		
//		System.out.println(a.prime); // 2
//		System.out.println(a.multiplicity); // 3
//		System.out.println(a.toString()); // 2^3
//		
//		a = new PrimeFactor(2, 1);
//		System.out.println(a.toString()); // 2
//		
//		PrimeFactor b = a.clone();
//		System.out.println(b.prime); // 2
//		System.out.println(b.multiplicity); // 1
//		System.out.println(b.toString()); // a.toString 
//		
//		PrimeFactor c =new PrimeFactor(3, 0);
//		System.out.println(c.toString()); // should throw an exception because multiplicity is <= 0
		
//-------------------------------------------------------------------------		
		
//		//PRIMALITY TEST
//		System.out.println(PrimeFactorization.isPrime(0)); // return false
//		System.out.println(PrimeFactorization.isPrime(1)); // return false
//		System.out.println(PrimeFactorization.isPrime(2)); // return true
//		System.out.println(PrimeFactorization.isPrime(3)); // return true
//		System.out.println(PrimeFactorization.isPrime(4)); // return false
//		System.out.println(PrimeFactorization.isPrime(81)); // return false
//		System.out.println(PrimeFactorization.isPrime(97)); // return true
//		System.out.println(PrimeFactorization.isPrime(25480)); // return false
//		System.out.println(PrimeFactorization.isPrime(10000)); // return false
		
//-------------------------------------------------------------------------	
		
		//TEST CONSTRUCTOR
		// Default constructor
		PrimeFactorization a = new PrimeFactorization();
		System.out.println(a.value()); // 1
		System.out.println(a.toString()); // 0
		System.out.println(a.size()); // 0

		// Direct search factorization on prime number
		a = new PrimeFactorization(89);
		System.out.println(a.value()); // 89
		System.out.println(a.toString()); // 89
		System.out.println(a.size()); // 1 
		
		// Direct search factorization constructor
		a = new PrimeFactorization(25480);
		System.out.println(a.value()); // 25480
		System.out.println(a.toString()); // 2^3 * 5 * 7^2 * 13
		System.out.println(a.size()); // 4

		// Copy constructor
		PrimeFactorization b = new PrimeFactorization(a);
		System.out.println(b.value()); // 25480
		System.out.println(b.toString()); // 2^3 * 5 * 7^2 * 13
		System.out.println(b.size()); // 4

		// Array constructor
		PrimeFactor[] pf = new PrimeFactor[4];
		pf[0] = new PrimeFactor(2, 3);
		pf[1] = new PrimeFactor(5, 1);
		pf[2] = new PrimeFactor(7, 2);
		pf[3] = new PrimeFactor(13, 1);
		PrimeFactorization c = new PrimeFactorization(pf);
		
		System.out.println(c.value()); // 25480
		System.out.println(c.toString()); // 2^3 * 5 * 7^2 * 13
		System.out.println(c.size()); // 4
//
//		// Array constructor used with a primeFactorials that combine to be an overflow value
//		PrimeFactor[] of = new PrimeFactor[2];
//		of[0] = new PrimeFactor(2, 64);
//		of[1] = new PrimeFactor(3, 64);
//		PrimeFactorization d = new PrimeFactorization(of);
//		System.out.println(d.value()); // -1
//		System.out.println(d.toString()); // 2^64 * 3^64 
//		System.out.println(d.size()); // 2
		
//-------------------------------------------------------------------------		
		
//		//MULTIPLICATION TESTS
//		// First multiply method
//		PrimeFactorization e = new PrimeFactorization(25480);
//		e.multiply(405);
//		System.out.println(e.value()); // 10319400
//		System.out.println(e.toString()); // 2^3 * 3^4 * 5^2 * 7^2 * 13
//
//		// Second multiply method
//		e = new PrimeFactorization(25480);
//		PrimeFactorization f = new PrimeFactorization(405);
//		e.multiply(f);
//		System.out.println(e.value()); // 10319400
//		System.out.println(e.toString()); // 2^3 * 3^4 * 5^2 * 7^2 * 13
//
//		// Third multiply method
//		e = new PrimeFactorization(25480);
//		f = new PrimeFactorization(405);
//		PrimeFactorization g = PrimeFactorization.multiply(e, f);
//		System.out.println(g.value()); // 10319400
//		System.out.println(g.toString()); // 2^3 * 3^4 * 5^2 * 7^2 * 13
//
//		// First multiply method to test case with an overflow value
//		PrimeFactor[] of1 = new PrimeFactor[1];
//		of1[0] = new PrimeFactor(2, 64);
//		e = new PrimeFactorization(of1);
//		e.multiply(10000);
//		System.out.println(e.value()); // -1
//		System.out.println(e.toString()); // 2^68 * 5^4
		
//		PrimeFactorization pf = new PrimeFactorization(25480);
//		PrimeFactorization pf2 = new PrimeFactorization(405);
//		PrimeFactorization pf3 = PrimeFactorization.multiply(pf, pf2);
//		
//		// System.out.println(pf.toArray());
//		
//		System.out.println(pf.toString()); // 2^3 * 5 * 7^2 * 13
//		System.out.println(pf2.toString()); // 3^4 * 5
//		
//		System.out.println(pf3.toString()); // 2^3 * 3^4 * 5^2 * 7^2 * 13
		
//-------------------------------------------------------------------------	
		
//		// DIVISION TESTS
//		// First dividedBy method
//		PrimeFactorization a = new PrimeFactorization(25480);
//		System.out.println(a.dividedBy(98)); // true
//		System.out.println(a.value()); // 260
//		System.out.println(a.toString()); // 2^2 * 5 * 13
//
//
//		// Second dividedBy method
//		a = new PrimeFactorization(25480);
//		PrimeFactorization b = new PrimeFactorization(98);
//		System.out.println(a.dividedBy(b)); // true
//		System.out.println(a.value()); // 260
//		System.out.println(a.toString()); // 2^2 * 5 * 13
//		
//		// Third dividedBy method
//		a = new PrimeFactorization(25480);
//		b = new PrimeFactorization(98);
//		PrimeFactorization c = PrimeFactorization.dividedBy(a, b);
//		System.out.println(c.value()); // 260
//		System.out.println(c.toString()); // 2^2 * 5 * 13
//		
//
//		// Not divisible tests
//		System.out.println(b.dividedBy(25480)); // false
//		System.out.println(b.value()); // 98
//		System.out.println(b.dividedBy(a)); // false
//		System.out.println(PrimeFactorization.dividedBy(b, a)); // null
		
//-------------------------------------------------------------------------	
		
		//EUCLIDEAN TEST/S
//		System.out.println(PrimeFactorization.Euclidean(184,69)); // 23
		
//-------------------------------------------------------------------------	
		
//		//GREATEST COMMON DIVISOR TESTS
//		PrimeFactorization a = new PrimeFactorization(25480);
//		PrimeFactorization b = new PrimeFactorization(98);
//
//		// First method tests
//		PrimeFactorization c = a.gcd(98);
//		System.out.println(c.value()); // 98
//	
//		// Second method tests
//		c = a.gcd(b);
//		System.out.println(c.value()); // 98
//
//		// Third method tests
//		System.out.println(PrimeFactorization.gcd(a, b).value()); // 98
		
	}

}
