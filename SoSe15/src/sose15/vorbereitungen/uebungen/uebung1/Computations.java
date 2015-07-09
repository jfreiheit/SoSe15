package sose15.vorbereitungen.uebungen.uebung1;

/**
 * computation of square root via Newton's approach
 * computation of harmonic sum 
 * computation of Math.pow(number, 2)
 * 
 * @author joernfreiheit
 *
 */
public class Computations {
	
	/**
	 * computation of Math.pow(number,2)
	 * 
	 * @param number
	 * @return long Math.pow(number,2)
	 */
	static long powersOfTwo(int number)
	{
		long result=1;
		for(int i=1; i<=number; i++)
		{
			result*=2;
		}
		return result;
	}
	
	/**
	 * computation of the sum of 1, 1/2, 1/3 ... 1/number
	 * 
	 * @param number
	 * @return double 1 + 1/2 + 1/3 + ... + 1/number
	 */
	static double harmonicSum(int number)
	{
		double sum=0;
		for(int i=1; i<=number; i++)
		{
			sum+=1.0/i;
		}
		return sum;
	}
	
	/**
	 * computation of square root of quadrat
	 * Newton's approach
	 * 
	 * @param quadrat
	 * @return
	 */
	static double sqrtNewton(int quadrat)
	{
		double a = 1.0;
		double b = quadrat;
		double mid = (b+a)/2.0;
		int exit = 0; 
		double eps = 0.001;
		while(Math.abs(b/a-1.0)>eps || exit++>20)
		{
			mid = (b+a)/2.0;
			a = mid;
			b = quadrat/a;
		}
		return a;
	}

}
