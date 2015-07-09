package sose15.vorbereitungen.events;

import java.awt.event.*;

import javax.swing.JFrame;

public class TestMouseEvents extends JFrame implements MouseListener
{
	int cnt = 0;

	public TestMouseEvents()
	{
		super("Mausklicks");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addMouseListener(this);
		this.setSize(300,200);
		this.setVisible(true);
	}


	public static void main(String[] args)
	{
		new TestMouseEvents();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Mouse clicked");
	}

	@Override
	public void mousePressed(MouseEvent event) {
		int x = event.getX();
		int y = event.getY();
		int nrClicks =  event.getClickCount();
		boolean rightClick = event.isMetaDown();
		System.out.println("Mouse pressed");
		System.out.println("--> x : " + x + "  y : " + y);
		System.out.println("--> Anzahl clicks  " + nrClicks);
		if(rightClick) System.out.println("--> rechte Taste ");
		else System.out.println("--> linke Taste");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("Mouse released");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("ins Fenster bewegt");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("aus dem Fenster bewegt");
	}
}