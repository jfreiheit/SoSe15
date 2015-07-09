package sose15.aufgaben.aufgabe8.kues;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.*;

public class ColoredSquares extends JFrame implements MouseMotionListener, MouseListener{

	int xStart, yStart, xEnd, yEnd, width, length, distancePointX, distancePointY;
	boolean dragging=false, inSquare=false;
	JPanel myPanel;
	Color randomColor, rememberColor;
	JPanel drawPanel;
	Rectangle rec, movingRec;
	Map<Rectangle, Color> lm = new ConcurrentHashMap<Rectangle, Color>();

	public ColoredSquares(){

		super("Farbige Rechtecke");

		myPanel = new DrawPanel();
		myPanel.setBackground(Color.black);
		myPanel.addMouseListener(this);
		myPanel.addMouseMotionListener(this);

		this.add(myPanel);
		this.setSize(1000, 1000);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);		
	}


	private class DrawPanel extends JPanel{

		@Override
		protected void paintComponent (Graphics g){
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			for (Rectangle key : lm.keySet()) {
				g2.setColor(lm.get(key));
				g2.fill(key);
			}
			if(dragging){
				g2.setColor(randomColor);
				g2.fill(rec);
			}
			if(inSquare){
				g2.setColor(rememberColor);
				g2.fill(movingRec);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) { 
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		Point p = e.getPoint();
		int cnt = 1;
		for (Rectangle key : lm.keySet()) {
			if(key.contains(p)){
				inSquare=true;
				movingRec = (Rectangle) key.clone();
				rememberColor = lm.get(key);
				distancePointX = (int) (p.x-key.getMinX());
				distancePointY = (int) (p.y-key.getMinY());
				System.out.println(cnt);

			}
			cnt++;
		}
		if (inSquare){
			for(Rectangle key : lm.keySet()){
				if(key.equals(movingRec)){
					lm.remove(key);
//					lm.remove(lm.get(key));
				}
			}
		}

		if (!inSquare){
			dragging = true;
			xStart = e.getX();
			yStart = e.getY();
			xEnd = xStart;
			yEnd = yStart;
			width = Math.abs(xEnd-xStart);
			length = Math.abs(yEnd-yStart);
			float r = (float) Math.random();
			float g = (float) Math.random();
			float b = (float) Math.random();
			randomColor = new Color (r, g, b);
			rec = new Rectangle (xStart, yStart, width, length);
		}
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(inSquare){
			inSquare = false;
			movingRec.setLocation(e.getX()-distancePointX, e.getY()-distancePointY);
			lm.put(movingRec, rememberColor);
		}
		if(dragging){
			dragging = false;
			rec.setLocation(Math.min(xStart, e.getX()), Math.min(yStart, e.getY()));
			rec.setSize(Math.abs(xStart-e.getX()), Math.abs(yStart-e.getY()));
			lm.put(rec, randomColor);
		}
		repaint();	
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(inSquare){
			movingRec.setLocation(e.getX()-distancePointX, e.getY()-distancePointY);

		}
		if(dragging){
			rec.setLocation(Math.min(xStart, e.getX()), Math.min(yStart, e.getY()));
			rec.setSize(Math.abs(xStart-e.getX()),Math.abs(yStart-e.getY()));
		}
		repaint();

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}


	public static void main(String[] args) {
		ColoredSquares cs = new ColoredSquares ();

	}

}
