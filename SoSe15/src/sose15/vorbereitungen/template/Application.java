package sose15.vorbereitungen.template;

import java.awt.BorderLayout;

import javax.swing.*;

public class Application extends JFrame{
	
	Application()
	{
		super("Template");
		SimpleCanvas canvas = new SimpleCanvas();
		this.add(canvas, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Application();
	}
}
