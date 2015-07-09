package sose15.vorbereitungen.uebungen.uebung1;

import static org.junit.Assert.*;
import org.junit.Test;

public class ComputationsTest {

	@Test
	public void testPow() {
		long pow2 = Computations.powersOfTwo(5);
		System.out.println(pow2);
		assertTrue("2 hoch 5 = " + pow2, pow2==32);
		pow2 = Computations.powersOfTwo(-5);
		System.out.println(pow2);
		assertTrue("2 hoch -5 = " + pow2, pow2==1);
		pow2 = Computations.powersOfTwo(0);
		System.out.println(pow2);
		assertTrue("2 hoch 0 = " + pow2, pow2==1);
		pow2 = Computations.powersOfTwo(15);
		System.out.println(pow2);
		assertTrue("2 hoch 5 = " + pow2, pow2==32768);
		pow2 = Computations.powersOfTwo(30);
		System.out.println(pow2);
		assertTrue("2 hoch 5 = " + pow2, pow2==1073741824);
	}
	
	@Test
	public void testHarm() {
		double delta = 0.001;
		double sum = Computations.harmonicSum(2);
		assertEquals(sum, 1.5, delta);
		sum = Computations.harmonicSum(5);
		System.out.println(sum);
		assertEquals(sum, 2.28333, delta);
		sum = Computations.harmonicSum(15);
		System.out.println(sum);
		assertEquals(sum, 3.318228993, delta);
		sum = Computations.harmonicSum(-5);
		System.out.println(sum);
		assertEquals(sum, 0.0, delta);	
	}
	
	@Test
	public void testSqrt() {
		double delta = 0.001;
		double sqrt = Computations.sqrtNewton(2);
		System.out.println(sqrt);
		assertEquals(sqrt, 1.414215, delta);	
		sqrt = Computations.sqrtNewton(81);
		System.out.println(sqrt);
		assertEquals(sqrt, 9.0, delta);
		sqrt = Computations.sqrtNewton(0);
		System.out.println(sqrt);
		assertEquals(sqrt, 0.0, delta);
		sqrt = Computations.sqrtNewton(1);
		System.out.println(sqrt);
		assertEquals(sqrt, 1.0, delta);
	}

}
