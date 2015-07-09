package sose15.vorbereitungen.LSP;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.RectangularShape;
import java.util.*;

public class BaseFigure{

	Set<RectangularShape> figuresToDraw;

	BaseFigure()
	{
		figuresToDraw = new HashSet<>();
	}

	protected void add(RectangularShape f)
	{
		figuresToDraw.add(f);
	}

	protected void draw(Graphics2D g2, boolean filled)
	{
		if(filled)
		{
			for(RectangularShape f : figuresToDraw)
			{
				g2.fill(f);
			}
		}
		else
		{
			for(RectangularShape f : figuresToDraw)
			{
				g2.draw(f);
			}
		}	
	}
}
