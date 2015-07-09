package sose15.vorbereitungen.LSP;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Application extends JFrame{
	BaseFigure figures;
	
	Application()
	{
		super("Template");
		figures = new BaseFigure();
		fill();
		Canvas canvas = new Canvas();
		this.add(canvas, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setVisible(true);
	}
	
	void fill()
	{
		figures.add(new Rectangle2D.Double(10.0, 10.0, 100, 50));
		figures.add(new Rectangle2D.Double(240.0, 270.0, 70, 80));
		figures.add(new Ellipse2D.Double(110.0, 210.0, 100, 100));
		figures.add(new Ellipse2D.Double(310.0, 110.0, 50, 80));
		figures.add(new RoundRectangle2D.Double(80.0, 150.0, 100, 100, 20, 20));
		figures.add(new Arc2D.Double(180.0, 10.0, 100, 100, 90, 90, Arc2D.PIE));	
	}
	
	class Canvas extends JPanel
	{
		@Override
		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(Color.GRAY);
			figures.draw(g2, true);
			g2.setColor(Color.BLACK);
			g2.setStroke(new BasicStroke(3));
			figures.draw(g2, false);
		}
	}

	public static void main(String[] args) {
		new Application();
	}
}
