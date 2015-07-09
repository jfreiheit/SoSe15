package sose15.vorlesungen.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ereignisbehandlung extends JFrame implements ActionListener{
	private JButton klickMichbutton;
	private JButton endeButton; 
	private Color[] farben;
	private int farbIndex; 
	private JPanel hauptPanel;
	private JLabel label;

	public Ereignisbehandlung() {
		super(); 
		setTitle("Ereignisbehandlung");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		farben = new Color[]{Color.WHITE, Color.ORANGE, Color.YELLOW, 
				Color.MAGENTA, Color.BLUE, Color.CYAN};
		farbIndex = 0;
		hauptPanel = init();
		this.add(hauptPanel);  // short for this.getContentPane().add(hauptPanel);
	}

	public static void main(String args[]) {
		Ereignisbehandlung hauptfenster = new Ereignisbehandlung();
		hauptfenster.setSize(400,300);
		hauptfenster.setLocation(200,300);
		hauptfenster.setVisible(true);
	}

	/**
	 * initialize components
	 */
	private JPanel init() {
		JPanel panel = new JPanel();

		label    = new JLabel("Hallo Welt!");
		klickMichbutton          = new JButton("Klick mich"); 
		endeButton         = new JButton("Ende"); 

		klickMichbutton.addActionListener(this); 
		endeButton.addActionListener(this);

		panel.add(label);
		panel.add(klickMichbutton);
		panel.add(endeButton); 

		panel.setBackground(farben[farbIndex]); // starting with white
		return panel; 
	}

	/**
	 * event handling for clicks
	 */
	public void actionPerformed(ActionEvent event) {
		Object quelle = event.getSource();
		if(quelle instanceof JButton)
		{
			if(quelle == klickMichbutton) {
				// change color
				farbIndex++;

				if(farbIndex == farben.length) {
					farbIndex = 0;     
				}

				hauptPanel.setBackground(farben[farbIndex]);
				label.setText(event.getActionCommand());
			}
			else if(quelle == endeButton) {
				// exit program
				System.exit(0); 
			}
		}
	}
}
