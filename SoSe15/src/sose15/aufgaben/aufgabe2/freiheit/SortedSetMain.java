package sose15.aufgaben.aufgabe2.freiheit;

import java.util.Random;

public class SortedSetMain {

	public static void main(String[] args) {
		SortedSet s1 = new SortedSet();
		Random r = new Random();
		
		for(int i=0; i<20; i++)
		{
			s1.insert(r.nextInt(40));
		}
		
		s1.printAll();
		s1.remove(new Integer(3));
		s1.printAll();
/*		s1.printElement(8);
		s1.printElement(18);
		s1.printElement(Integer.valueOf(17));*/
		
/*		SortedSet s2 = new SortedSet();
		
		for(int i=0; i<10; i++)
		{
			s2.insert(Integer.valueOf(r.nextInt(40)));
		}
		
		s2.printAll();
		s2.printElement(8);
		s2.printElement(18);
		s2.printElement(Integer.valueOf(17));
		
		s1.insert(s2);
		s1.printAll();
		System.out.println("equal ? " + s1.equal(s2));
		s2.insert(s1);
		s2.printAll();
		System.out.println("equal ? " + s1.equal(s2));*/
	
	}

}
