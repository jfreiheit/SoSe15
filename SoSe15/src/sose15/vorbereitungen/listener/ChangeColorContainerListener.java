package sose15.vorbereitungen.listener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class ChangeColorContainerListener extends JFrame implements ActionListener
{
	Container contentPane;
	JButton button;

	ChangeColorContainerListener()
	{
		contentPane = this.getContentPane();
		button = new JButton("Change Background Color");
		contentPane.add(button, BorderLayout.NORTH);

		// am ActionListener anmelden
		button.addActionListener(this);

		this.setTitle("Change Background Color");
		this.setSize(400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		float r = (float) Math.random();
		float g = (float) Math.random();
		float b = (float) Math.random();
		contentPane.setBackground(new Color(r,g,b));
	}

	public static void main(String[] args) {
		new ChangeColorContainerListener();

	}

}
