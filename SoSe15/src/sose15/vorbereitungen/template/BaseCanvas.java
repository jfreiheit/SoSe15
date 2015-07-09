package sose15.vorbereitungen.template;

import java.awt.*;
import javax.swing.*;

public abstract class BaseCanvas extends JComponent{
	
	@Override
	public final void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		final Graphics2D g2 = (Graphics2D) g;
		drawBackground(g2);
		drawContent(g2);
		postDraw(g2);	//hook
	}
	
	private void drawBackground(final Graphics2D g2)
	{
		final Dimension componentSize = getSize();
		g2.setColor(Color.GRAY);
		g2.fillRect(0, 0, componentSize.width, componentSize.height);
	}
	
	protected abstract void drawContent(final Graphics2D g2);
	
	protected void postDraw(final Graphics2D g2)
	{
		
	}
}
