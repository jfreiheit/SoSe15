package sose15.aufgaben.aufgabe3.freiheit;

import java.util.*;

public class Eratosthenes {
	Set<Integer> all = new TreeSet<>();
	Set<Integer> sieve = new TreeSet<>();
	
	Eratosthenes(int n)
	{
		for(int i=2; i<=n; i++)
			all.add(i);
	}
	
	void createSieve()
	{
		int currentNumber = 2;
		while(currentNumber*currentNumber<=all.size())
		{
			int factor=2;
			while(factor*currentNumber<=all.size()+1)
			{
				sieve.add(factor*currentNumber);
				factor++;
			}
			do{
				currentNumber++;
			}while(sieve.contains(currentNumber));
		}
	}
	
	void printSieve()
	{
		Iterator<Integer> i = sieve.iterator();
		System.out.print("[ ");
		while(i.hasNext())
			System.out.print(i.next()+" ");
		System.out.println("]");
	}
	
	void printAll()
	{
		Iterator<Integer> i = all.iterator();
		System.out.print("[ ");
		while(i.hasNext())
			System.out.print(i.next()+" ");
		System.out.println("]");
	}
	
	void filter()
	{
		all.removeAll(sieve);
	}

}
