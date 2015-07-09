package sose15.vorlesungen.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFirstWindow extends JFrame implements ActionListener{
	
	MyFirstWindow()
	{
		super();
		this.setTitle("My first window");
		this.getContentPane().setBackground(Color.PINK);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = init();
		this.add(mainPanel);
		
		this.setSize(400, 300);
		this.setLocation(200, 300);
		this.setVisible(true);
	}
	
	private JPanel init()
	{
		JPanel panel = new JPanel();
		
		JLabel label1 = new JLabel("Hallo FIW!");
		JButton button1 = new JButton("Klick mich");
		JButton button2 = new JButton("Ende");
		// weitere Steuerlemente erzeugen
		
		panel.add(label1);
		panel.add(button1);
		panel.add(button2);
		// Steuerelemente mit add dem Panel hinzufuegen
		
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
