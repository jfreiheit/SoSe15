package sose15.vorbereitungen.uebungen.uebung6;

import java.util.HashSet;
import java.util.Set;

public class Kurse {
	private Set<Kurs> kurse;
	
	public Set<Kurs> getKurse() {
		return kurse;
	}

	public Kurse()
	{
		kurse = new HashSet<>();
	}
	
	public boolean add(Kurs k)
	{
		return kurse.add(k);
	}
	
	public int size()
	{
		return kurse.size();
	}
	
	

}
