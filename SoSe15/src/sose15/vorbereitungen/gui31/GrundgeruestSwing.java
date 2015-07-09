package sose15.vorbereitungen.gui31;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GrundgeruestSwing extends JFrame{

	public GrundgeruestSwing() {
		super(); 				// Konstruktor von JFrame
		setTitle("Titel Swing-Fenster"); 	// Titel des Fensters
		getContentPane().setBackground(Color.WHITE); // Hintergrundfarbe
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Klick auf x
		JPanel hauptPanel = init(); // eigene Methode init()
		this.add(hauptPanel);// Hauptpanel dem Fenster hinzufügen
	}

	private JPanel init()
	{
		JPanel panel = new JPanel();

		JLabel label1 = new JLabel("Hallo FIW!");		// Label erzeugen
		JButton button1 = new JButton("Klick mich");	// Button erzeugen
		JButton button2 = new JButton("Ende");		// Button erzeugen

		panel.add(label1);		// Label ans Panel
		panel.add(button1);		// Button ans Panel
		panel.add(button2);		// Button ans Panel

		return panel;
	}

	public static void main(String args[]){
		GrundgeruestSwing hauptfenster = new GrundgeruestSwing();
		hauptfenster.setSize(400,300);		// wie groß?
		hauptfenster.setLocation(200,300);		// wo ?
		hauptfenster.setVisible(true);		// sichtbar
	}

}
