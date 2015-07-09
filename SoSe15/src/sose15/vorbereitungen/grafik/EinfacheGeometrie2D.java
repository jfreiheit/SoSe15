package sose15.vorbereitungen.grafik;

import java.awt.*;
import java.awt.geom.*;

import javax.swing.*;

public class EinfacheGeometrie2D extends JFrame{

	private class Zeichenflaeche extends JPanel
	{

		@Override
		protected void paintComponent(Graphics g)
		{
			Graphics2D g2 = (Graphics2D) g;
			
			// Linienenden
			g2.setStroke(new BasicStroke(20, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER));
			g2.drawLine(30, 50, 200, 50);
			g2.setStroke(new BasicStroke(20, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
			g2.drawLine(30, 100, 200, 100);			
			g2.setStroke(new BasicStroke(20, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER));
			g2.drawLine(30, 150, 200, 150);
			
/*			// Linienverbindungen
			BasicStroke stroke = new BasicStroke(20, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
			g2.setStroke(stroke);
			
			Path2D shape = new GeneralPath();
			shape.moveTo(25, 25);
			shape.lineTo(50, 100);
			shape.lineTo(75, 25);
			g2.draw(shape);
			
			stroke = new BasicStroke(20, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
			g2.setStroke(stroke);
			
			shape = new GeneralPath();
			shape.moveTo(25+100, 25);
			shape.lineTo(50+100, 100);
			shape.lineTo(75+100, 25);
			g2.draw(shape);
			
			stroke = new BasicStroke(20, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND);
			g2.setStroke(stroke);
			
			shape = new GeneralPath();
			shape.moveTo(25+200, 25);
			shape.lineTo(50+200, 100);
			shape.lineTo(75+200, 25);
			g2.draw(shape);*/
			
			/*GradientPaint gp = new GradientPaint(0,0,Color.RED, 0, getHeight(), Color.WHITE, true);
			g2.setPaint(gp);
			g2.fillRect(0, 0, getWidth(), getHeight());*/
			
		}
	}

	EinfacheGeometrie2D()
	{
		super("Einfaches Zeichnen 2D");
		getContentPane().add(new Zeichenflaeche(), BorderLayout.CENTER);
		setSize(250,250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}


	public static void main(String[] args) {
		new EinfacheGeometrie2D();
	}
}