package sose15.vorbereitungen.uebungen.uebung2;

public class NumberMain {

	public static void main(String[] args)
	{
		IntNumber i1 = new IntNumber(8);
		IntNumber i2 = new IntNumber(-7);
		DoubleNumber d1 = new DoubleNumber(5.5);
		DoubleNumber d2 = new DoubleNumber(-5.50);

		System.out.println(i1.compareTo(i2));
		System.out.println(i1.compareTo(d1));
		System.out.println(i1.compareTo(d2));
		
		System.out.println(d1.compareTo(i1));
		System.out.println(d1.compareTo(i2));
		System.out.println(d1.compareTo(d2));
		
		i1.printComparison(i2);
		i1.printComparison(d1);
		i1.printComparison(d2);
		
		d1.printComparison(i2);
		d1.printComparison(i2);
		d1.printComparison(i2);
		
		d2.printComparison(d1);

		MyComparable m1 = new IntNumber(8);
		MyComparable m2 = new IntNumber(-7);
		
		m1.compareTo(m2);
	}
}
