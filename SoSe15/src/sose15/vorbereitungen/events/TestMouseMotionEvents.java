package sose15.vorbereitungen.events;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class TestMouseMotionEvents extends JFrame implements MouseMotionListener
{
	public TestMouseMotionEvents()
	{
		super("Mausklicks");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addMouseMotionListener(this);
		this.setSize(300,200);
		this.setVisible(true);
	}

	public static void main(String[] args)
	{
		new TestMouseMotionEvents();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("Mouse dragged");
		System.out.println("--> (" + e.getX() + ", "+e.getY()+")");
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("Mouse moved");
		System.out.println("--> (" + e.getX() + ", "+e.getY()+")");	
	}
}
