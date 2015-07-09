package sose15.vorbereitungen.listener;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ChangeColorAnonymClass extends JFrame
{
	Container contentPane;
	JButton button;
	
	ChangeColorAnonymClass()
	{
		contentPane = this.getContentPane();
		button = new JButton("Change Background Color");
		contentPane.add(button, BorderLayout.NORTH);
		
		// anonyme Listener-Klasse
		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				float r = (float) Math.random();
				float g = (float) Math.random();
				float b = (float) Math.random();
				contentPane.setBackground(new Color(r,g,b));
			}
			
		}; // Ende anonyme Klasse
		
		button.addActionListener(al);
		
		this.setTitle("Change Background Color");
		this.setSize(400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new ChangeColorAnonymClass();

	}

}
