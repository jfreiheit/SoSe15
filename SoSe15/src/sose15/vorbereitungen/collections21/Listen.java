package sose15.vorbereitungen.collections21;

import java.util.*;

public class Listen {
	
	static void fuelleListe(List<Integer> list){
		list.add(2); // Werte
		list.add(4); // Werte
		list.add(6); // Werte
		}

	static void auslesenListe(List<Integer> list){
		for (int i=0; i<list.size();i++) 			
			System.out.println(list.get(i));
		System.out.println("Listenende"); 	  
		}


	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>();
		fuelleListe(list1);
		list1.remove(2);
		auslesenListe(list1);

		LinkedList<Integer> list2 = new LinkedList<>();
		fuelleListe(list2);
		list2.remove(Integer.valueOf(2));		// Wert (Index 2) 
		auslesenListe(list2);	// 3  7 


	}

}
