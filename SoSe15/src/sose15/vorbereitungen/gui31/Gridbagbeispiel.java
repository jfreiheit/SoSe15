package sose15.vorbereitungen.gui31;

import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Gridbagbeispiel extends JFrame{

	public Gridbagbeispiel(){
		super("GridBagLayout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Klick auf x
		JPanel hauptPanel = init(); 		// eigene Methode init()
		this.add(hauptPanel);	
	}

	private JPanel init()
	{
		JPanel panel = new JPanel();		
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		GridBagConstraints gbc= new GridBagConstraints();

		String[] elemente = new String[20];
		for (int i=0; i<elemente.length; ++i)
			elemente[i]="Auswahl "+i;
		JList<String> list = new JList<String>(elemente);	
		JScrollPane scrollPane = new JScrollPane(list);
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=1;
		gbc.gridheight=3;
		gbc.insets = new Insets(1,1,1,1);
		gbc.weightx=100;
		gbc.weighty=200;
		gbc.fill = GridBagConstraints.BOTH;
		gbl.setConstraints(scrollPane, gbc);
		add(scrollPane);

		for (int i = 0; i<2; ++i)
		{
			// Label
			gbc.gridx=1;
			gbc.gridy=i;
			gbc.gridwidth=1;
			gbc.gridheight=1;
			gbc.insets = new Insets(1,1,1,1);
			gbc.fill = GridBagConstraints.NONE;
			JLabel label = new JLabel("Label " + (i+1));
			gbl.setConstraints(label, gbc);
			add(label);
		}

		for (int i = 0; i<2; ++i)
		{
			// Textfeld
			gbc.gridx=2;
			gbc.gridy=i;
			gbc.gridwidth=1;
			gbc.gridheight=1;
			gbc.weightx=100;
			gbc.insets = new Insets(1,1,1,1);
			gbc.fill = GridBagConstraints.HORIZONTAL;
			JTextField field = new JTextField("Textfeld " + (i+1));
			gbl.setConstraints(field, gbc);
			add(field);
		}
		
		gbc.gridx=2;
		gbc.gridy=2;
		gbc.gridwidth=0;
		gbc.gridheight=0;
		gbc.insets = new Insets(1,1,1,1);
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.SOUTHEAST;	// rechts unten
		Button button = new Button("Ende");
		gbl.setConstraints(button, gbc);
		add(button);


		return panel;
	}


	public static void main(String[] args) {
		Gridbagbeispiel dialog = new Gridbagbeispiel();
		dialog.pack();
		dialog.setVisible(true);
	}

}
