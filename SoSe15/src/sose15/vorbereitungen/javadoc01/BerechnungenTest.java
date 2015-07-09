package sose15.vorbereitungen.javadoc01;

import static org.junit.Assert.*;
import org.junit.*;

public class BerechnungenTest {
	
	@Test
	public void testMultiplizieren1() {
		Berechnungen b2 = new Berechnungen(3,4);
		int ergebnis = 0;
		ergebnis = b2.multiplizieren();
		assertFalse("3 * 4 = 12", ergebnis != 12);
	}
	
	@Test
	public void testMultiplizieren2() {
		Berechnungen b2 = new Berechnungen(3,4);
		int ergebnis = 0;
		ergebnis = b2.multiplizieren();
		assertTrue("3 * 4 = 12", ergebnis == 12);
	}

}
