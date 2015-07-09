package sose15.vorbereitungen.collections21;

import java.util.*;

public class HashSetDemo {

	public static void main(String[] args) {
		HashSet<Integer> zahlen = new HashSet<>();
		//TreeSet<Integer> zahlen = new TreeSet<>();
		Random r = new Random();
		int anzVersuche =0;
		
		while(zahlen.size()!=10)
		{
			int z = r.nextInt(20);
			zahlen.add(z);
			anzVersuche++;
		}
		System.out.print("Folgende Zahlen zufällig in " + anzVersuche + " Versuchen : [ ");
		Iterator<Integer> i = zahlen.iterator();
		while(i.hasNext())
		{
			System.out.print(i.next() + " ");
		}
		System.out.println("]");
	}

}
