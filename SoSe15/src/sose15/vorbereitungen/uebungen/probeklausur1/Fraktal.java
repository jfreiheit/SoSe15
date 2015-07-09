package sose15.vorbereitungen.uebungen.probeklausur1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Fraktal extends JFrame{
	Canvas canvas;
	JPanel buttonPanel;
	JButton bColor, bNew, bFinish; 
	
	Fraktal(String title)
	{
		super(title);
		
		JMenuBar myMenu = initMyMenu();
		this.setJMenuBar(myMenu);
		
		canvas = new Canvas();
		this.add(canvas, BorderLayout.CENTER);
		
		buttonPanel = initButtonPanel();
		this.add(buttonPanel, BorderLayout.SOUTH);
		
		this.setSize(500,500);
		this.setVisible(true);
	}
	
	JMenuBar initMyMenu()
	{
		JMenuBar menubar = new JMenuBar();
		
		JMenu menu = new JMenu("Level");
		JMenuItem mi1 = new JMenuItem("1");
		mi1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.level=1;
				canvas.repaint();
			}});
		menu.add(mi1);
		
		JMenuItem mi3 = new JMenuItem("3");
		mi3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.level=3;
				canvas.repaint();
			}});
		menu.add(mi3);
		
		JMenuItem mi5 = new JMenuItem("5");
		mi5.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.level=5;
				canvas.repaint();
			}});
		menu.add(mi5);
		
		JMenuItem mi10 = new JMenuItem("10");
		mi10.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.level=10;
				canvas.repaint();
			}});
		menu.add(mi10);
		
		menubar.add(menu);
		return menubar;
	}
	
	JPanel initButtonPanel()
	{
		JPanel panel = new JPanel();
		
		bColor = new JButton("Color");
		bColor.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Color c = new Color((float) Math.random(), (float) Math.random(), (float) Math.random());
				canvas.setBackground(c);
				canvas.repaint();
			}});
		panel.add(bColor);
		
		bNew = new JButton("New");
		bNew.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.level = 0;
				canvas.repaint();
			}});
		panel.add(bNew);
		
		bFinish = new JButton("Exit");
		bFinish.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Fraktal.this.setVisible(false);
				Fraktal.this.dispose();
				System.exit(0);
			}});
		panel.add(bFinish);
		
		return panel;
	}
	
	class Canvas extends JPanel
	{
		int level = 5;
		
		Canvas()
		{
			this.setBackground(Color.WHITE);
		}
		
		@Override
		protected void paintComponent(Graphics g)
		{
			int[] xCoord = new int[3];
			int[] yCoord = new int[3];
			int panelWidth = this.getWidth();
			int panelHeight = this.getHeight();
			int x0 = panelWidth/10;
			int y0 = panelHeight/10;
			xCoord[0] = x0;
			xCoord[1] = panelWidth/2;
			xCoord[2] = panelWidth-x0;
			yCoord[0] = panelHeight-y0;
			yCoord[1] = y0;
			yCoord[2] = panelHeight-y0;
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.drawPolygon(xCoord, yCoord, 3);
			Point a = new Point(xCoord[0], yCoord[0]);
			Point b = new Point(xCoord[2], yCoord[2]);
			Point c = new Point(xCoord[1], yCoord[1]);
			drawTriangle(g2,a,b,c,level);
		}
		
		void drawTriangle(Graphics2D g2, Point a, Point b, Point c, int level)
		{
			if (level==0) return;
			Point aNeu = new Point((a.x+c.x)/2, (c.y+a.y)/2);
			Point bNeu = new Point((c.x+b.x)/2, (c.y+a.y)/2);
			Point cNeu = new Point(c.x,a.y);
			int[] xCoord = {aNeu.x, bNeu.x, cNeu.x};
			int[] yCoord = {aNeu.y, bNeu.y, cNeu.y};
			g2.drawPolygon(xCoord, yCoord, 3);
			drawTriangle(g2, a, cNeu, aNeu, level-1);
			drawTriangle(g2, aNeu, bNeu, c, level-1);
			drawTriangle(g2, cNeu, b, bNeu, level-1);
		}
	}

	public static void main(String[] args) {
		new Fraktal("Fraktal");

	}

}
