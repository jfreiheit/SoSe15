package sose15.vorbereitungen.uebungen.uebung5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class MyWindow extends JFrame implements ActionListener{
	JPanel mainPanel;
	JButton windowBigger, windowSmaller, textBigger, textSmaller, changeColor;
	JLabel textLabel;
	
	MyWindow()
	{
		super();
		setTitle("Aktionen behandeln");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = init();
		this.add(mainPanel, BorderLayout.NORTH);
		
		textLabel = new JLabel("Text");
		textLabel.setHorizontalAlignment(JLabel.CENTER);
		textLabel.setFont(new Font("Verdana", Font.BOLD, 24));
		this.add(textLabel, BorderLayout.CENTER);
		
		this.setSize(800,350);
		this.setVisible(true);
	}
	
	private JPanel init()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		windowBigger = new JButton("Window bigger");
		windowSmaller = new JButton("Window smaller");
		textBigger = new JButton("Text bigger");
		textSmaller = new JButton("Text smaller");
		changeColor = new JButton("change color");
		
		windowBigger.addActionListener(this);
		windowSmaller.addActionListener(this);
		textBigger.addActionListener(this);
		textSmaller.addActionListener(this);
		changeColor.addActionListener(this);
		
		panel.add(windowBigger);
		panel.add(windowSmaller);
		panel.add(textBigger);
		panel.add(textSmaller);
		panel.add(changeColor);
		
		return panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source instanceof JButton)
		{
			switch(e.getActionCommand())
			{
			case "Window bigger": this.setSize((int)(getWidth()*1.1), (int)(getHeight()*1.1)); break;
			case "Window smaller": this.setSize((int)(getWidth()*0.9), (int)(getHeight()*0.9)); break;
			case "Text bigger": textLabel.setFont(new Font("Verdana", Font.BOLD, (int)(textLabel.getFont().getSize()*1.1))); break;
			case "Text smaller": textLabel.setFont(new Font("Verdana", Font.BOLD, (int)(textLabel.getFont().getSize()*0.9))); break;
			case "change color": float r = (float) Math.random(); float g = (float) Math.random(); float b = (float) Math.random();
								Color c = new Color(r,g,b);
								 mainPanel.setBackground(c); 
								 textLabel.setForeground(c); break;
			}
		}
		
	}
	
	public static void main(String[] args)
	{
		new MyWindow();
	}

}
