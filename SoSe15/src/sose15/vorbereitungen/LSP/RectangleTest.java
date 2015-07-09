package sose15.vorbereitungen.LSP;

import static org.junit.Assert.*;

import org.junit.Test;

public class RectangleTest {

	@Test
	public void testRect() {
		Rectangle[] rect = new Rectangle[1];
		rect[0] = new Rectangle(5,10);
		//rect[0].setWidth(5);
		//rect[0].setHeight(10);

		assertEquals(50, rect[0].calcArea());
	}
	
	@Test
	public void testSquare() {
		Rectangle[] rect = new Rectangle[1];
		rect[0] = new Square(10);
		//rect[0].setWidth(5);
		//rect[0].setHeight(10);

		assertEquals(100, rect[0].calcArea());
	}
}
