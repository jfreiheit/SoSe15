package sose15.aufgaben.aufgabe7.freiheit;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Stroke;
import java.awt.event.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;

public class PI extends JFrame implements ChangeListener{
	JLabel ergebnisLabel;
	JTextField tf1, tf2, tf3;
	JSlider anzPunkte;
	int aktAnzPunkte = 50000;
	Zeichenflaeche zf;

	private class Zeichenflaeche extends JPanel
	{
		int radius = 400;
		Random r = new Random();

		@Override
		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			int max = aktAnzPunkte;
			int anzRotePunkte=0;
			int anzBlauePunkte=0;
			int x0, y0, x, y;
			Graphics2D g2 = (Graphics2D) g;

			radius = (getWidth()>getHeight()) ? (int)(4.0/5.0*getWidth()) : (int)(4.0/5.0*getHeight());
			x0 = (int)(1.0/8.0*radius);
			y0 = (int)(1.0/8.0*radius);
			g2.setColor(Color.WHITE);
			g2.fillRect(x0, y0, radius, radius);
			g2.setColor(Color.BLACK);
			g2.setStroke(new BasicStroke(3.0f));
			g2.drawRect(x0, y0, radius, radius);
			g2.setStroke(new BasicStroke(2.0f));
			g2.drawArc(x0, y0, 2*radius, 2*radius, 90, 90);

			g2.setStroke(new BasicStroke(1.0f));
			for(int i=0; i<max; i++)
			{
				x=r.nextInt(radius)+x0+1;		// 20 wg. Randabstand und 1 wg. Random
				y=r.nextInt(radius)+y0+1;
				if((x-(radius+x0))*(x-(radius+x0))+(y-(radius+y0))*(y-(radius+y0))<((radius)*(radius)))
				{
					g2.setColor(Color.RED);
					g2.fillOval(x, y, 2, 2);
					anzRotePunkte++;
				}
				else
				{
					g2.setColor(Color.BLUE);
					g2.fillOval(x, y, 2, 2);
					anzBlauePunkte++;
				}
			}
			tf1.setText((new Integer(max)).toString());
			tf2.setText((new Integer(anzRotePunkte)).toString());
			tf3.setText((new Integer(anzBlauePunkte)).toString());
			double pi = ((double)anzRotePunkte)/((double)max)*4.0;
			ergebnisLabel.setText((new Double(pi)).toString());

		}
	}

	PI()
	{
		super("Berechnung von PI");
		zf = new Zeichenflaeche();
		getContentPane().add(zf, BorderLayout.CENTER);
		JPanel infoPanel = createInfoPanel();
		getContentPane().add(infoPanel, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(460,750);
		setVisible(true);
	}

	JPanel createInfoPanel()
	{
		final int MIN = 10000;
		final int MAX = 100000;
		int INIT = aktAnzPunkte;    // initial		

		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new BorderLayout(20,20));


		anzPunkte = new JSlider(JSlider.HORIZONTAL, MIN, MAX, INIT);
		anzPunkte.setBorder(new EmptyBorder(10,10,10,10));
		anzPunkte.addChangeListener(this);

		anzPunkte.setMajorTickSpacing(20000);
		anzPunkte.setMinorTickSpacing(5000);
		anzPunkte.setPaintTicks(true);
		anzPunkte.setPaintLabels(true);

		infoPanel.add(anzPunkte,BorderLayout.NORTH);

		JPanel panel = new JPanel();

		panel.setBorder(new EmptyBorder(10,30, 10, 30));
		panel.setLayout(new GridLayout(3,2));

		JLabel label1 = new JLabel("Nr of points:");
		panel.add(label1);
		tf1 = new JTextField();
		panel.add(tf1);
		JLabel label2 = new JLabel("Nr of red points:");
		panel.add(label2);
		tf2 = new JTextField();
		panel.add(tf2);
		JLabel label3 = new JLabel("Nr of blue points:");
		panel.add(label3);
		tf3 = new JTextField();
		panel.add(tf3);
		infoPanel.add(panel,BorderLayout.CENTER);

		JPanel ergebnisPanel = new JPanel();
		ergebnisPanel.setBorder(new EmptyBorder(0,0,20,0));
		JLabel label4 = new JLabel("PI is approx.: ");
		label4.setFont(new Font("Verdana", Font.ITALIC, 16));
		ergebnisPanel.add(label4);
		ergebnisLabel = new JLabel("0.0");
		ergebnisLabel.setFont(new Font("Verdana", Font.ITALIC, 16));
		ergebnisPanel.add(ergebnisLabel);	
		infoPanel.add(ergebnisPanel,BorderLayout.SOUTH);

		return infoPanel;
	}

	public static void main(String[] args) {
		new PI();

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider)e.getSource();
		if (!source.getValueIsAdjusting()) {
			aktAnzPunkte=(int)source.getValue();
			zf.repaint();
		}
	}
}