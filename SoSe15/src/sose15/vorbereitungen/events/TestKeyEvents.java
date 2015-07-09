package sose15.vorbereitungen.events;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class TestKeyEvents extends JFrame implements KeyListener
{
	JTextField textField = new JTextField(20);
	JLabel label = new JLabel("Enter some text (at least 3 letters) : ");
	JButton button = new JButton("Press me");
	
	public TestKeyEvents()
	{
		super("Tastatureriegnisse");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel inputPanel = new JPanel();
		inputPanel.add(label);
		inputPanel.add(textField);
		this.add(inputPanel,BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		buttonPanel.add(button);
		button.setEnabled(false);
		this.add(buttonPanel, BorderLayout.SOUTH);
		textField.addKeyListener(this);
		this.setSize(300,200);
		this.setVisible(true);
	}

	public static void main(String[] args)
	{
		new TestKeyEvents();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("keyTyped --> Taste getKeyCode() : " + e.getKeyCode());
		System.out.println("keyTyped --> Taste getKeyChar() : " + e.getKeyChar());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("keyPressed --> Taste getKeyCode() : " + e.getKeyCode());
		System.out.println("keyPressed --> Taste getKeyChar() : " + e.getKeyChar());	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("keyReleased --> Taste getKeyCode() : " + e.getKeyCode());
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_ENTER : System.out.println("Enter"); break;
		case KeyEvent.VK_ESCAPE : System.out.println("ESC"); break;
		case KeyEvent.VK_F1 : System.out.println("f1"); break;
		case KeyEvent.VK_DOWN : System.out.println("down"); break;
		}
		
		System.out.println("keyReleased --> Taste getKeyChar() : " + e.getKeyChar());
		System.out.println();
		if(textField.getText().length()>=3) button.setEnabled(true);
	}

}
