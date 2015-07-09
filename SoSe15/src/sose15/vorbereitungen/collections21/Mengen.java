package sose15.vorbereitungen.collections21;

import java.util.*;

public class Mengen {

	public static void main(String[] args) {

		HashSet<Integer> s1 = new HashSet<>();
		HashSet<Integer> s2 = new HashSet<>();
		
		for (int i=1; i<=10; i++) s1.add(i);
		for (int i=9; i<=12; i++) s2.add(i);
		
		s1.addAll(s2); // true, aber 9 und 10 nicht übernommen

		Iterator<Integer> its = s1.iterator();

		while(its.hasNext())
		       System.out.println((its.next()).toString());
	}

}
