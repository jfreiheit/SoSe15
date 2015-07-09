package sose15.vorbereitungen.uebungen.uebung10;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

import javax.swing.*;

public class Lesson10 extends JFrame implements MouseListener, MouseMotionListener{
	Set<Point> filledRect = Collections.newSetFromMap(new ConcurrentHashMap<Point, Boolean>());
	//Set<Point> filledRect = Collections.synchronizedSet(new HashSet<>()); // reicht nicht
	//Set<Point> filledRect = new ConcurrentSkipListSet<>();

	
	Canvas canvas;
	enum State {
		STARTED, FIRST, SECOND, FINISHED
	}
	State state = State.STARTED;
	Rectangle curRect;
	boolean moving = false;
	int diffX, diffY;

	Lesson10()
	{
		super("Lesson 10");

		canvas = new Canvas();
		this.add(canvas, BorderLayout.CENTER);

		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,400);
		this.setVisible(true);
	}

	class Canvas extends JPanel
	{
		int length = 150;

		@Override
		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			// gray borders
			int width = this.getWidth();
			int height = this.getHeight();
			int x0 = width/15;
			int y0 = height/15;
			g2.setColor(Color.LIGHT_GRAY);
			g2.fillRect(x0, y0, length+4, length+4);
			g2.fillRect(width-x0-length, height-y0-length, length+4, length+4);
			g2.setStroke(new BasicStroke(3));
			g2.setColor(Color.DARK_GRAY);
			g2.drawRect(x0, y0, length+4, length+4);
			g2.drawRect(width-x0-length, height-y0-length, length+4, length+4);
			if(state==State.STARTED)
			{
				filledRect.add(new Point(width-x0-length, y0));
				filledRect.add(new Point(x0, height-y0-length));
				state = State.FIRST;			
			}
			g2.setColor(Color.RED);
			for(Point p : filledRect)
			{
				g2.fill3DRect(p.x, p.y, length, length, true);
			}
			if((state==State.FIRST || state==State.SECOND) && moving)
			{
				g2.fill3DRect(curRect.x, curRect.y, length, length, true);
			}

		}
	}


	public static void main(String[] args) {
		new Lesson10();

	}


	@Override
	public void mouseDragged(MouseEvent e) {
		if(moving)
		{
			int x = e.getX();
			int y = e.getY();
			curRect.x = x-diffX;
			curRect.y = y-diffY;
			if(state == State.FIRST)
			{
				int x0 = canvas.getWidth()/15;
				int y0 = canvas.getHeight()/15;
				if(Math.abs(curRect.x-x0)<4 && Math.abs(curRect.y-y0)<4)
				{
					filledRect.add(new Point(x0+2, y0+2));
					state = State.SECOND;
					moving = false;
				}
			}
			else if(state == State.SECOND)
			{
				int x0 = 14*canvas.getWidth()/15-canvas.length;
				int y0 = 14*canvas.getHeight()/15-canvas.length;
				if(Math.abs(curRect.x-x0)<4 && Math.abs(curRect.y-y0)<4)
				{
					filledRect.add(new Point(x0+2, y0+2));
					state = State.FINISHED;
					moving = false;
				}
			}
			canvas.repaint();
		}

	}


	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseClicked(MouseEvent e) {

	}


	@Override
	public void mousePressed(MouseEvent e) {
		if(!moving)
		{
			int x = e.getX();
			int y = e.getY();
			int x0 = canvas.getWidth()/15;
			int y0 = canvas.getHeight()/15;
			if(state == State.FIRST)
			{
				for(Point p : filledRect)
				{
					if(x>=p.x && x<=p.x+(this.canvas.length) && y>=p.y && y<=p.y+(this.canvas.length))
					{
						moving = true;
						filledRect.remove(p);
						diffX=x-p.x;
						diffY=y-p.y;
						curRect = new Rectangle(p.x, p.y, canvas.length, canvas.length);
						System.out.println("matched 1");
						
					}
				}
			}
			else if(state == State.SECOND)
			{
				for(Point p : filledRect)
				{
					if(x>=p.x && x<=p.x+(this.canvas.length) && y>=p.y && y<=p.y+(this.canvas.length) && (Math.abs(p.x-x0)>5 || Math.abs(p.y-y0)>5))
					{
						moving = true;
						filledRect.remove(p);
						diffX=x-p.x;
						diffY=y-p.y;
						curRect = new Rectangle(p.x, p.y, canvas.length, canvas.length);
						System.out.println("matched 2");
					}
				}
			}
			canvas.repaint();
		}

	}


	@Override
	public void mouseReleased(MouseEvent e) {
		if(moving)
		{
			filledRect.add(new Point(curRect.x, curRect.y));
			moving = false;
		}

	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
