package sose15.vorbereitungen.grafik;

import java.awt.*;
import javax.swing.*;

public class InFrameZeichnen extends JFrame{

	private class Zeichenflaeche extends JPanel
	{

		@Override
		protected void paintComponent(Graphics g)
		{
			g.drawRect(40, 30, 200, 200);
			g.drawOval(40, 30, 200, 200);
		}
	}

	InFrameZeichnen()
	{
		super("Erstes Zeichnen");
		getContentPane().add(new Zeichenflaeche(), BorderLayout.CENTER);
		setSize(300,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}


	public static void main(String[] args) {
		new InFrameZeichnen();
	}
}
