package sose15.vorbereitungen.uebungen.uebung6;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class KursAnlegen extends JDialog{
	JButton b_kursAnlegen, b_abbrechen, b_ende;
	JTextField tf_kursName;
	Container contentPane;
	JSpinner maxAnzahl;
	Kurse kurse;
	
	
	KursAnlegen(JFrame owner,final Kurse kurse)
	{
		super(owner, true);
		this.kurse=kurse;
		contentPane= this.getContentPane();
		contentPane.add(erzeugeGUI());
		
		JLabel oben = new JLabel(" ");
		contentPane.add(oben, BorderLayout.NORTH);
		
		JLabel unten = new JLabel(" ");
		contentPane.add(unten, BorderLayout.SOUTH);
		
		JLabel links = new JLabel("    ");
		contentPane.add(links, BorderLayout.WEST);
		
		JLabel rechts = new JLabel("    ");
		contentPane.add(rechts, BorderLayout.EAST);
		
		tf_kursName.requestFocus();
		this.setTitle("Kurs anlegen");
		this.setSize(600, 350);
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	private JPanel erzeugeGUI()
	{
		JPanel panel = new JPanel();
		JPanel panelCenter = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 30));
		JPanel panelLabels = new JPanel(new GridLayout(0,1, 20, 50));
		JPanel panelTextFields = new JPanel(new GridLayout(0,1,  20, 50));
		JPanel buttonPanel = new JPanel();
		
		panel.setLayout(new BorderLayout());
		panelCenter.setBorder(new TitledBorder("Kurs anlegen"));
		
		b_kursAnlegen = new JButton("Kurs anlegen");
		b_kursAnlegen.setToolTipText("hier können Sie einen Kurs anlegen");
		
		b_kursAnlegen.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Kurs k = new Kurs(tf_kursName.getText(), (Integer)maxAnzahl.getValue());
				kurse.add(k);
			}
		});
		
		b_abbrechen = new JButton("Abbrechen");	
		
		b_abbrechen.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				tf_kursName.setText(null);
				tf_kursName.requestFocus();
				maxAnzahl.setValue(new Integer(10));
			}
		});
		b_ende = new JButton("Ende");
		b_ende.setToolTipText("hiermit beenden Sie diesen Dialog - zurück zum Hauptmenü");
		
		b_ende.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				KursAnlegen.this.setVisible(false);	
				KursAnlegen.this.dispose();
			}
		});
		
		buttonPanel.add(b_kursAnlegen);
		buttonPanel.add(b_abbrechen);
		buttonPanel.add(b_ende);
		
		JLabel kursName = new JLabel("Name des Kurses : ");
		JLabel obereGrenze = new JLabel("maximale Anzahl Teilnehmer : ");
		JLabel aktAnzahlTeilnehmer = new JLabel("aktuelle Anzahl Teilnehmer : ");
		
		panelLabels.add(kursName);
		panelLabels.add(obereGrenze);
		panelLabels.add(aktAnzahlTeilnehmer);
		
		tf_kursName = new JTextField(20);
		tf_kursName.setFocusable(true);
		maxAnzahl = new JSpinner(new SpinnerNumberModel(10, 1, 20, 1));
		JFormattedTextField aktAnzahl = new JFormattedTextField(new Integer(20));
		aktAnzahl.setValue(new Integer(0));
		aktAnzahl.setEditable(false);
		aktAnzahl.setForeground(Color.GRAY);
		
		panelTextFields.add(tf_kursName);
		panelTextFields.add(maxAnzahl);
		panelTextFields.add(aktAnzahl);
		
		panelCenter.add(panelLabels);
		panelCenter.add(panelTextFields);
		
		panel.add(panelCenter, BorderLayout.CENTER);
		panel.add(buttonPanel, BorderLayout.SOUTH);
		
		return panel;
	}
}
