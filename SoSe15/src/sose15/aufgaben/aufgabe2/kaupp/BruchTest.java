package sose15.aufgaben.aufgabe2.kaupp;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.rules.ExpectedException;

public class BruchTest {

	Bruch bruch1;
	Bruch bruch2;
	Bruch bruch3;
	Bruch bruch4;
	Bruch ergebnisBruch;

	//nicht @BeforeClass, da sonst side-effects möglich, wenn Objekte beim Test verändert werden 
	//wenn auch bei der Klasse Bruch unwahrscheinlich
	@Before
	public void initialize(){
		bruch1 = new Bruch(3,7);
		bruch2 = new Bruch(13,17);
		bruch3 = new Bruch(13,-17);
		bruch4 = new Bruch(12,48);
	}

	@Test
	public void testBruch() {
		Bruch bruch5 = new Bruch();
		assertTrue("Expected Bruch 1/1", bruch5.getZaehler()==1 && bruch5.getNenner()==1);
	}
	
	@Rule
	public ExpectedException thrown= ExpectedException.none();

	@Test
	public void testBruchIntInt() {
		assertTrue("Expected Bruch 3/7", bruch1.getZaehler()==3 && bruch1.getNenner()==7);
		assertNotEquals(bruch1, bruch2);
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Der Wert des Nenners muss ungleich 0 sein!");
		new Bruch(11,0);
	}

	@Test
	public void testPlus() {
		ergebnisBruch = bruch1.plus(bruch2);
		assertTrue("Expected result 142/119", 
				Bruch.sindGleich(ergebnisBruch, new Bruch(142,119)));
		ergebnisBruch = bruch2.plus(bruch3);
		assertTrue("Expected result 0/17", 
				Bruch.sindGleich(ergebnisBruch, new Bruch(0,17)));
	}

	@Test
	public void testMinus() {
		ergebnisBruch = bruch1.minus(bruch2);
		assertTrue("Expected result -40/119", 
				Bruch.sindGleich(ergebnisBruch, new Bruch(-40,119)));	
		ergebnisBruch = bruch4.minus(bruch2);
		assertTrue("Expected result -35/68", 
				Bruch.sindGleich(ergebnisBruch, new Bruch(-35,68)));
		assertFalse("Expected result -35/68", 
				!Bruch.sindGleich(ergebnisBruch, new Bruch(-35,68)));
	}

	@Test
	public void testMal() {
		ergebnisBruch = bruch1.mal(bruch2);
		assertTrue("Expected result 39/119", 
				Bruch.sindGleich(ergebnisBruch, new Bruch(39,119)));
	}

	@Test
	public void testGeteilt() {
		ergebnisBruch = bruch1.geteilt(bruch2);
		assertTrue("Expected result 51/91", 
				Bruch.sindGleich(ergebnisBruch, new Bruch(51,91)));	
	}

	@Test
	public void testKuerzen() {
		ergebnisBruch = bruch4.kuerzen();
		assertTrue("Expected result 1/4" , ergebnisBruch.getZaehler()==1 &&
				ergebnisBruch.getNenner()==4);
	}

	@Test
	public void testGgT() {
		int ggT = bruch4.ggT(bruch4.getZaehler(), bruch4.getNenner());
		assertTrue("Expected result 12" , ggT==12);
		Bruch bruch5 = new Bruch(0,12);
		ggT = bruch5.ggT(bruch5.getZaehler(), bruch5.getNenner());
		assertTrue("Expected result 12" , ggT==1);
	}

	@Test
	public void testToString() {
		String bruchAlsString = bruch1.toString();
		assertEquals("3/7", bruchAlsString);
	}

	@Test
	public void testPrintDezimal() {
		double result= bruch4.printDezimal();
		double delta = Math.abs(result/10_000);
		assertEquals(0.25, result, delta);
		result= bruch3.printDezimal();
		assertEquals(-0.7647, result, delta);
	}

	@Test
	public void testIstGroesser() {
		boolean bruchIstGroesser = Bruch.istGroesser(bruch2, bruch3);
		assertTrue(bruchIstGroesser);
		bruchIstGroesser = Bruch.istGroesser(bruch3, bruch2);
		assertFalse(bruchIstGroesser);	}

	@Test
	public void testIstKleiner() {
		boolean bruchIstKleiner = Bruch.istKleiner(bruch3, bruch2);
		assertTrue(bruchIstKleiner);
		bruchIstKleiner = Bruch.istKleiner(bruch2, bruch3);
		assertFalse(bruchIstKleiner);
	}

	@Test
	public void testSindGleich() {
		boolean isEqual = Bruch.sindGleich(bruch1, bruch2);
		assertFalse("False expected for 3/7 == 13/17", bruch1.getNenner() == bruch2.getNenner() &&
				bruch1.getZaehler()!=bruch2.getZaehler());
		assertTrue(isEqual==false);
		Bruch bruch3 = new Bruch(3,7);
		isEqual = Bruch.sindGleich(bruch1, bruch3);
		assertTrue(isEqual==true);
	}
}
