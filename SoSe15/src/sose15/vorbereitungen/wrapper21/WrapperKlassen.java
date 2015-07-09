package sose15.vorbereitungen.wrapper21;

public class WrapperKlassen {

	public static void main(String[] args) {
		
/*		Integer i1 = Integer.valueOf(1);
		Integer i2 = Integer.valueOf("1");
		
		Boolean b1 = Boolean.valueOf(true);
		Boolean b2 = Boolean.valueOf("true");
		
		int i3 = new Integer("1234").intValue();
		int i4 = Integer.valueOf(123).intValue();
		int i5 = Double.valueOf(5.5).intValue();
		int i6 = Integer.parseInt("22");
		System.out.println("i3 : " + i3 + "   i4 : " + i4 + "   i5 : " + i5 + "   i6 : " + i6);
		System.out.println("Summe : " + (i3 + i4 + + i5 + i6));
		
		Integer autoBoxing = 7; 			// int -> Integer
		int autoUnboxing = new Integer(7); 	// Integer -> int
		
		System.out.println(autoBoxing);
		System.out.println(autoUnboxing);*/
		
/*		final Integer i1 = 7;		// Auto-Boxing => Cache
		final Integer i2 = 4711;	// Auto-Boxing => New
		
		System.out.println(i1 == new Integer(7));		// false, Cache!=New
		System.out.println(i2 == new Integer(4711));	// false, New!=New
		System.out.println(i1 == Integer.valueOf(7));	// TRUE !!! Cache == Cache
		System.out.println(i2 == Integer.valueOf(4711));// false, New != New
		// geht immer : 
		System.out.println(i1.intValue() == (new Integer(7)).intValue());
		System.out.println(i2.intValue() == (new Integer(4711)).intValue());
		// geht auch immer : 
		System.out.println(i1.equals(new Integer(7)));
		System.out.println(i2.equals(new Integer(4711)));*/

		final Integer i1 = new Integer(1);
		final Integer i2 = new Integer(1);
		
		System.out.println(i1 >= i2);	// true, Unboxing: >= nur für int
		System.out.println(i1 <= i2);	// true, Unboxing: <= nur für int
		System.out.println(i1 == i2);	// false !!, kein Unboxing: New == New

	}

}
