// declare your package here
package sose15.aufgaben.aufgabe2.freiheit;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SortedSetTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}

	@Test
	public void testInsertInteger() {
		SortedSet s1 = new SortedSet();
		assertTrue("int 3 inserted ", s1.insert(3));
		assertTrue("Integer 8 inserted ", s1.insert(new Integer(8)));
		assertTrue("Integer 4 inserted ", s1.insert(new Integer("4")));
		assertTrue("Integer 5 inserted ", s1.insert(Integer.valueOf(5)));
		assertFalse("int 5 inserted ", s1.insert(5));
	}
	
	@Test
	public void testEqual() {
		SortedSet s1 = new SortedSet();
		SortedSet s2 = new SortedSet();
		s1.insert(3);
		s1.insert(8);
		s1.insert(0);
		s1.insert(1);	
		s1.insert(0);
		s1.insert(8);
		s1.insert(4);
		s1.insert(4);
		
		s2.insert(0);
		s2.insert(1);
		s2.insert(3);
		s2.insert(4);
		
		assertFalse("s1 not equal s2", s1.equal(s2));
		s2.insert(8);	
		assertTrue("s1 equal s2", s1.equal(s2));
	}


	@Test
	public void testRemoveInteger() {
		SortedSet s1 = new SortedSet();
		SortedSet s2 = new SortedSet();
		s1.insert(3);
		s1.insert(8);
		s1.insert(0);
		s1.insert(1);	
		s1.insert(4);
		assertTrue("3 removed", s1.remove(3));
		assertFalse("3 not in the set", s1.remove(new Integer(3)));
		
		s2.insert(0);
		s2.insert(1);
		s2.insert(4);
		s2.insert(8);
		assertTrue("[0, 1, 4, 8]", s1.equal(s2));
		
		assertTrue("0 removed from s1 ", s1.remove(new Integer(0)));
		assertTrue("0 removed from s2 ", s2.remove(new Integer("0")));
		assertTrue("[1, 4, 8]", s1.equal(s2));
	}

	@Test
	public void testInsertSortedSet() {
		SortedSet s1 = new SortedSet();
		SortedSet s2 = new SortedSet();
		s1.insert(3);
		s1.insert(8);
		s1.insert(0);
		s1.insert(1);	
		s1.insert(4);
		
		s2.insert(0);
		s2.insert(1);
		s2.insert(2);
		s2.insert(3);
		
		assertFalse("s2 insert into s1 ", s1.insert(s2));
		s2.insert(4);
		s2.insert(8);
		assertTrue("[0, 1, 2, 3, 4, 8]", s1.equal(s2));
	}

	@Test
	public void testPrintElementObject() {
		SortedSet s1 = new SortedSet();
		s1.insert(3);
		s1.insert(8);
		s1.insert(0);
		s1.insert(1);	
		s1.insert(4);

		// several tests
		// just one test per method!
		
/*		// Test 1 
		s1.printElement(Integer.valueOf("3"));
		assertEquals("3",outContent.toString().trim());*/

/*		// Test 2
		s1.printElement(new Integer(3));
		assertEquals("3",outContent.toString().trim());*/

		// Test 3
		s1.printElement(new Integer(5));
		assertEquals("not a number or not in the set",outContent.toString().trim());
		
	}

	@Test
	public void testPrintElementInt() {
		SortedSet s1 = new SortedSet();
		s1.insert(3);
		s1.insert(8);
		s1.insert(0);
		s1.insert(1);	
		s1.insert(4);

		
/*		// Test 1
		s1.printElement(2);
		assertEquals("3",outContent.toString().trim());*/
		
		// Test 2
		s1.printElement(5);
		assertEquals("index out of bounds",outContent.toString().trim());
	}

	@Test
	public void testPrintAll() {
		SortedSet s1 = new SortedSet();
		s1.insert(3);
		s1.insert(8);
		s1.insert(0);
		s1.insert(1);	
		s1.insert(4);

		s1.printAll();
		assertEquals("5 : [ 0, 1, 3, 4, 8 ]",outContent.toString().trim());
	}

}
