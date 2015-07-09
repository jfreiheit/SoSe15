package sose15.vorbereitungen.generics;

import java.util.ArrayList;
import java.util.List;

public class TypeErasure {
	private List<Person<String>> personList = new ArrayList<>();
	
	public void add(Person<String> p)
	{
		personList.add(p);
	}
	
	public void print()
	{
		for(Person<String> p : personList)
		{
			System.out.println(p.getName() + " wohnt in " + p.getStadt());
		}
			
	}

	class Person<T>{
		private T name;
		public T getName() {
			return name;
		}

		public T getStadt() {
			return stadt;
		}

		private T stadt;
		
		public Person(T name, T stadt) {
			this.name = name;
			this.stadt = stadt;
		}
	}
	
	public static void main(String[] args)
	{
		TypeErasure te1 = new TypeErasure();
		Person<String> p1 = te1.new Person<String>("Max", "Musterstadt");
		te1.add(p1);
		Person<String> p2 = te1.new Person<String>("Maria", "Musterdorf");
		te1.add(p2);
		te1.print();
	}
	
	
}
