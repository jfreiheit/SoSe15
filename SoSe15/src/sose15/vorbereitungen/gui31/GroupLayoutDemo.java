package sose15.vorbereitungen.gui31;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GroupLayoutDemo extends JFrame {
	JPanel hauptPanel;
	
	public GroupLayoutDemo()
	{
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.GREEN);
		this.setSize(300,200);
		this.setLocation(200,100);
		
		hauptPanel = init();
		this.add(hauptPanel);
		
		this.setVisible(true);
	}
	
	
	private JPanel init()
	{
		JPanel panel = new JPanel();
		
		// Layout-Manager instanziieren und einrichten
		GroupLayout panelLayout = new GroupLayout(panel);
		panel.setLayout(panelLayout);
		
		//automatische Abst�nde einstellen
		panelLayout.setAutoCreateGaps(true);
		panelLayout.setAutoCreateContainerGaps(true);
		
		// Komponenten erzeugen
		JLabel label1 = new JLabel("Eins");
		label1.setBorder(BorderFactory.createEtchedBorder());
		label1.setFont(new Font("Georgia", Font.ITALIC, 18));
		JLabel label2 = new JLabel("Zwei");
		label2.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
		label2.setFont(new Font("Verdana", Font.BOLD, 24));
		JLabel label3 = new JLabel("Drei");
		label3.setBorder(BorderFactory.createBevelBorder(1, Color.RED, Color.BLACK));
		label3.setFont(new Font("Arial", Font.ITALIC, 16));
		
		//horizontale Gruppe
		GroupLayout.SequentialGroup horizGroup = panelLayout.createSequentialGroup();
		horizGroup.addComponent(label1);
		horizGroup.addComponent(label2);
		horizGroup.addComponent(label3);
		
		//vertikale Gruppe
		//GroupLayout.ParallelGroup vertGroup = panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING); //oben
		GroupLayout.SequentialGroup vertGroup = panelLayout.createSequentialGroup();
		vertGroup.addComponent(label1);
		vertGroup.addComponent(label2);
		vertGroup.addComponent(label3);
		
		panelLayout.setHorizontalGroup(horizGroup);
		panelLayout.setVerticalGroup(vertGroup);
		
		return panel;
	}
	
	public static void main(String[] args) {
		new GroupLayoutDemo();

	}

}
