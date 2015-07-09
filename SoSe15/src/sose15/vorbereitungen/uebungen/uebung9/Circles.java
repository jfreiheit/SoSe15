package sose15.vorbereitungen.uebungen.uebung9;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.util.HashSet;
import java.util.Set;

import javax.swing.*;

public class Circles extends JFrame implements MouseListener, MouseMotionListener{

	JPanel mainPanel;
	int diameter = 50;
	Ellipse2D.Float cur_circle;
	Set<Ellipse2D> circles;
	Point startPoint, endPoint;
	boolean drawing=false;
	Color cur_color;


	Circles(String title)
	{
		super(title);

		circles = new HashSet<>();

		mainPanel = new DrawPanel();
		mainPanel.addMouseListener(this);
		mainPanel.addMouseMotionListener(this);
		this.add(mainPanel, BorderLayout.CENTER);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,600);
		//this.pack();
		this.setVisible(true);
	}

	private class DrawPanel extends JPanel
	{
		@Override
		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g);

			Graphics2D g2 = (Graphics2D) g;
			//g2.setColor(cur_color);
			for (Ellipse2D e : circles)
			{
				g2.fill((Ellipse2D.Float)e);
			}
			//g2.setColor(cur_color);
			if(drawing) g2.fill(Circles.this.cur_circle);
		}
	}

	public static void main(String[] args) {
		new Circles("My Application");

	}


	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("clicked");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("pressed");
		drawing = true;
		startPoint = e.getPoint();
		float r = (float) Math.random();
		float g = (float) Math.random();
		float b = (float) Math.random();
		cur_color = new Color(r,g,b);
		cur_circle = new Ellipse2D.Float((float)startPoint.x, (float)startPoint.y, 0, 0);

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("released");
		drawing = false;
		endPoint = e.getPoint();
		if(endPoint.distance(startPoint)>0.0)
		{
			float w, h;
			if(endPoint.x>startPoint.x && endPoint.y>startPoint.y)
			{
				w = endPoint.x - startPoint.x;
				h = endPoint.y - startPoint.y;
			}
			else if(endPoint.x>startPoint.x && endPoint.y<=startPoint.y)
			{
				w = endPoint.x - startPoint.x;
				h = startPoint.y - endPoint.y;
				int tmp = startPoint.y;
				startPoint.y = endPoint.y;
				endPoint.y = tmp;
			}
			else if(endPoint.x<=startPoint.x && endPoint.y>startPoint.y)
			{
				w = startPoint.x - endPoint.x;
				h = endPoint.y - startPoint.y;
				int tmp = startPoint.x;
				startPoint.x = endPoint.x;
				endPoint.x = tmp;
			}
			else
			{
				w = startPoint.x - endPoint.x;
				h = startPoint.y - endPoint.y;
				int tmp = startPoint.x;
				startPoint.x = endPoint.x;
				endPoint.x = tmp;
				tmp = startPoint.y;
				startPoint.y = endPoint.y;
				endPoint.y = tmp;
			}
			circles.add(new Ellipse2D.Float(startPoint.x,startPoint.y,w,h));
		}
		else
		{
			float x = (float) e.getX();
			float y = (float) e.getY();
			float w = (float) diameter;
			float h = (float) diameter;
			circles.add(new Ellipse2D.Float(x,y,w,h));
		}
		mainPanel.repaint();

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("dragged");
		endPoint = e.getPoint();
		float w, h;
		if(endPoint.x>startPoint.x && endPoint.y>startPoint.y)
		{
			w = endPoint.x - startPoint.x;
			h = endPoint.y - startPoint.y;
		}
		else if(endPoint.x>startPoint.x && endPoint.y<=startPoint.y)
		{
			w = endPoint.x - startPoint.x;
			h = startPoint.y - endPoint.y;
			cur_circle.y = endPoint.y;	
/*			int tmp = startPoint.y;
			startPoint.y = endPoint.y;
			endPoint.y = tmp;*/
		}
		else if(endPoint.x<=startPoint.x && endPoint.y>startPoint.y)
		{
			w = startPoint.x - endPoint.x;
			h = endPoint.y - startPoint.y;
			cur_circle.x = endPoint.x;	
/*			int tmp = startPoint.x;
			startPoint.x = endPoint.x;
			endPoint.x = tmp;*/
		}
		else
		{
			w = startPoint.x - endPoint.x;
			h = startPoint.y - endPoint.y;
			cur_circle.x = endPoint.x;
			cur_circle.y = endPoint.y;	
/*			int tmp = startPoint.x;
			startPoint.x = endPoint.x;
			endPoint.x = tmp;
			tmp = startPoint.y;
			startPoint.y = endPoint.y;
			endPoint.y = tmp;*/
		}
/*		cur_circle.x = startPoint.x;
		cur_circle.y = startPoint.y;*/	
		cur_circle.width = w;
		cur_circle.height = h;
		mainPanel.repaint();
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
