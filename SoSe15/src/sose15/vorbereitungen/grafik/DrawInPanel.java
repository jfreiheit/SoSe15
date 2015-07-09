package sose15.vorbereitungen.grafik;

import java.awt.*;
import javax.swing.*;

public class DrawInPanel extends JFrame{

	private class Zeichenflaeche extends JPanel
	{

		@Override
		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g); 
/*			for(int i=0; i<10; i++)
				g.drawOval(50+i*10, 50, 80, 80);
			for(int i=0; i<10; i++)
				g.drawOval(50+i*10, 150, 80, 180);*/
			g.drawArc(30, 140, 200, 100, 225, 360 ); 
		}

	}

	DrawInPanel()
	{
		super("Erstes Zeichnen");
		getContentPane().add(new Zeichenflaeche(), BorderLayout.CENTER);
		setSize(300,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}


	public static void main(String[] args) {
		new DrawInPanel();
	}
}
