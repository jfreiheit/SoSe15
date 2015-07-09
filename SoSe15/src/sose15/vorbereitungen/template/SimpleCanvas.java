package sose15.vorbereitungen.template;

import java.awt.Color;
import java.awt.Graphics2D;

public class SimpleCanvas extends BaseCanvas{

	@Override
	protected void drawContent(Graphics2D g2) {
		int width = getWidth();
		int height = getHeight();
		int x0 = width/10;
		int y0 = height/10;
		g2.setColor(Color.RED);
		g2.fill3DRect(x0, y0, width-2*x0, height-2*y0, true);	
	}
}
