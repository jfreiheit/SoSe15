package sose15.vorbereitungen.collections21;

import java.util.*;

public class Container {

	public static void main(String[] args) {
		HashSet<String> menge = new HashSet<>();
		ArrayList<Integer> liste = new ArrayList<>();
		HashMap<Double, Boolean> tabelle = new HashMap<>();
		menge.add("Element 1");
		menge.add("Element 3");		
		menge.add("Element 2");

		menge.add("Element 1");
		
		Iterator<String> i = menge.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
		

	}

}
