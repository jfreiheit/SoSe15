package sose15.vorbereitungen.collections21;

import java.util.*;

public class MapDemo {

	public static void main(String[] args)
	{
		HashMap<String, String> m1 = new HashMap<>();
		m1.put("anton", "anton@email.de");
		m1.put("berta", "berta@email.de");	
		m1.put("caesar", "caesar@email.de");	
		m1.put("anton", "antonius@email.de"); // Schlüssel existiert bereits
		m1.put("berta", "berta@email.de"); // Schlüssel existiert bereits

		for(Map.Entry<String, String> entry : m1.entrySet())
		{
			System.out.println(
				"Account : " + entry.getKey() + 
				"  E-Mail : " + entry.getValue());
		}
	}	
}
