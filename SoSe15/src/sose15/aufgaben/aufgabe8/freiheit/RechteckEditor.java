package sose15.aufgaben.aufgabe8.freiheit;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RechteckEditor extends JFrame{
	Canvas canvas;

	private class Canvas extends JPanel implements MouseListener, MouseMotionListener
	{
		Point startpoint, endpoint;
		Random r = new Random();
		Rectangle rect;
		Color c;
		LinkedHashMap<Rectangle, Color> rectangles = new LinkedHashMap<>();

		Canvas()
		{
			addMouseListener(this);
			addMouseMotionListener(this);
		}

		@Override
		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			if(!rectangles.isEmpty())
			{
				for(Map.Entry<Rectangle, Color> entry : rectangles.entrySet())
				{
					g2.setColor(entry.getValue());
					g2.fill3DRect(entry.getKey().x, entry.getKey().y,entry.getKey().width, entry.getKey().height, true);
				}
			}
			if(rect != null)
			{
				g2.setColor(c);
				g2.fill3DRect(rect.x, rect.y,rect.width, rect.height, true);
			}
			
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			
			Point p = e.getPoint();
			int x1 = p.x>startpoint.x ? startpoint.x : p.x;
			int width = Math.abs(p.x-startpoint.x);			
			int y1 = p.y>startpoint.y ? startpoint.y : p.y;
			int height = Math.abs(p.y-startpoint.y);					
			rect.setRect(x1,y1,width,height);	
/*			// das anstelle von repaint() ginge auch
 			Graphics2D g2 = (Graphics2D) getGraphics();		
			g2.setColor(c);
			g2.fill3DRect(rect.x, rect.y, rect.width, rect.height, true);
			g2.dispose();*/
			repaint();

		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseClicked(MouseEvent e) {

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
		public void mousePressed(MouseEvent e) {
			startpoint = e.getPoint();
			rect = new Rectangle(startpoint.x, startpoint.y, 0, 0);
			int red = r.nextInt(256);
			int green = r.nextInt(256);
			int blue = r.nextInt(256);
			c = new Color(red, green, blue);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			endpoint = e.getPoint();
			int x1 = endpoint.x>startpoint.x ? startpoint.x : endpoint.x;
			int width = Math.abs(endpoint.x-startpoint.x);			
			int y1 = endpoint.y>startpoint.y ? startpoint.y : endpoint.y;
			int height = Math.abs(endpoint.y-startpoint.y);					
			rect.setRect(x1,y1,width,height);
			rectangles.put(rect, c);
			repaint();
		}
	}

	RechteckEditor()
	{
		super("Rechtecke zeichnen");
		canvas = new Canvas();
		getContentPane().add(canvas, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(460,560);
		setVisible(true);
	}

	public static void main(String[] args) {
		new RechteckEditor();

	}


}
