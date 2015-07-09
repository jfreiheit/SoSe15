package sose15.vorbereitungen.collections21;

import java.util.*;

public class CollectionsMain {
	Set<Integer> mySetU = new HashSet<>();
	Set<Integer> mySetO = new TreeSet<>();
	
	int fill(int size)
	{
		int counter=0;
		Random r = new Random();
		int randNumber;
		while(mySetU.size()<size)
		{
			randNumber=r.nextInt(2*size) + 500;
			System.out.print(randNumber+ " ");
			counter++;
			mySetU.add(randNumber);
			mySetO.add(randNumber);
		}
		System.out.println();
		return counter;
	}
	
	void printSets(int counter)
	{
		Iterator<Integer> i = mySetU.iterator();
		System.out.print("Anzahl Versuche : " + counter + " Größe : " + mySetU.size() + " [ ");
		while(i.hasNext())
			System.out.print(i.next() + " ");
		System.out.println("]");
		i = mySetO.iterator();
		System.out.print("Anzahl Versuche : " + counter + " Größe : " + mySetU.size() + " [ ");
		while(i.hasNext())
			System.out.print(i.next() + " ");
		System.out.println("]");
	}
	
	void print()
	{
		System.out.print(" Größe : " + mySetU.size() + " [ ");
		for(Integer elem : mySetU)
		{
			System.out.print(elem + " ");
		}
		System.out.println("]");
		System.out.print(" Größe : " + mySetO.size() + " [ ");
		for(Integer elem : mySetO)
		{
			System.out.print(elem + " ");
		}
		System.out.println("]");
		
	}
	
	static void fuelleListe(List<String> list)
	{
		for (int i = 0; i<10; i++) 
			list.add(""+i); 
	}
	
	static void auslesenListe(List<String> list)
	{
		for (int i=0; i<list.size(); i++) 			
			System.out.println(list.get(i));
		System.out.println("Listenende"); 	  
	}


	public static void main(String[] args) {
		List<Integer> l = new ArrayList<>();
		l.add(1);
		l.add(1,2);
		//l.add(3.0);	// Compilerfehler
		//l.add(3,4);	// Laufzeitfehler
		
		System.out.println(l.get(0));
		System.out.println(l.get(1));	
		
		ArrayList<String> list1 = new ArrayList<>();
		fuelleListe(list1);
		auslesenListe(list1);

		LinkedList<String> list2 = new LinkedList<>();
		fuelleListe(list2);
		list2.remove("3");		// Wert (Index 3)
		list2.remove(6);		// Index (Wert "7")
		list1.removeAll(list2);	// lösche 0 1 2 4 5 6 8 9 
		auslesenListe(list1);	// 3  7
		
		Stack<String> s = new Stack<>();
		s.push("Erstes");
		s.push("Zweites");
		s.push("Drittes");
		while(!s.empty()) 
			System.out.println(s.pop());

		//HashSet<Integer> zahlen = new HashSet<>();	 //unsortiert
		TreeSet<Integer> zahlen = new TreeSet<>();	 //sortiert
		Random r = new Random(); int anzVersuche =0;

		while(zahlen.size()!=10)
		{
		int z = r.nextInt(20);
		zahlen.add(z);
		anzVersuche++;
		}
		System.out.print("Folgende Zahlen zufällig in " + anzVersuche + " Versuchen : [ ");
		Iterator<Integer> i = zahlen.iterator();
		while(i.hasNext())
			System.out.print(i.next() + " ");
		System.out.println("]");

		CollectionsMain cm = new CollectionsMain();
		int counter = cm.fill(30);
		cm.print();
		
	}

}
