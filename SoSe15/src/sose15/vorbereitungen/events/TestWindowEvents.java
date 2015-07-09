package sose15.vorbereitungen.events;

import java.awt.event.*;
import javax.swing.*;

public class TestWindowEvents extends JFrame implements WindowListener {
	
	TestWindowEvents() {
		super("Window closing");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(this);
		this.setSize(200,100);
		this.setVisible(true);
	}

	// implemented empty - not used
	@Override public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened aufgerufen");
	}
	@Override public void windowClosed(WindowEvent e) {}
	@Override public void windowIconified(WindowEvent e) {
		System.out.println("windowIconified aufgerufen");}
	@Override public void windowDeiconified(WindowEvent e) {System.out.println("windowDeiconified aufgerufen");}
	@Override public void windowActivated(WindowEvent e) {}
	@Override public void windowDeactivated(WindowEvent e) {}
	
	@Override public void windowClosing(WindowEvent e) {
		final int answer = JOptionPane.showConfirmDialog(this, "Programm wirklich beenden?");
		if(answer==JOptionPane.YES_OPTION)
		{
			this.setVisible(false);
			this.dispose();
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new TestWindowEvents();
	}

}
