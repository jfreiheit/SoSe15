package sose15.vorbereitungen.listener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ChangeColorAnonymClass2 extends JFrame
{
	Container contentPane;
	JButton button;
	
	ChangeColorAnonymClass2()
	{
		contentPane = this.getContentPane();
		button = new JButton("Change Background Color");
		contentPane.add(button, BorderLayout.NORTH);
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				float r = (float) Math.random();
				float g = (float) Math.random();
				float b = (float) Math.random();
				contentPane.setBackground(new Color(r,g,b));
			}
			
		} // Ende anonyme Klasse
		); // Ende addActionListener
		
		this.setTitle("Change Background Color");
		this.setSize(400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new ChangeColorAnonymClass2();

	}

}