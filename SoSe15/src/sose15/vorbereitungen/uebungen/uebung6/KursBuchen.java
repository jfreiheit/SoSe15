package sose15.vorbereitungen.uebungen.uebung6;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class KursBuchen extends JDialog{
	Kurse kurse;
	JButton[] buchButton;
	JLabel[] kursNamen;
	JProgressBar[] progressBar;
	Container contentPane;
	JButton b_ende;
	int anzKurse;
	int aktIndex;
	
	KursBuchen(final JFrame owner, final Kurse kurse)
	{
		super(owner, true);
		this.kurse=kurse;
		anzKurse = kurse.size();
		buchButton = new JButton[anzKurse];
		kursNamen = new JLabel[anzKurse];
		progressBar = new JProgressBar[anzKurse];
		aktIndex=0;
		
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
		
		this.setTitle("Kurs buchen");
		this.pack();
		this.setLocation(200,200);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	private JPanel erzeugeGUI()
	{
		JPanel panel = new JPanel(new BorderLayout(30,30));
		JPanel listPanel = new JPanel(new GridLayout(anzKurse, 3, 30, 30));
		for(Kurs k : kurse.getKurse())
		{
			kursNamen[aktIndex]=new JLabel(k.getKursName());
			listPanel.add(kursNamen[aktIndex]);
			
			progressBar[aktIndex] = new JProgressBar(0, k.getObereGrenze().intValue()){

		        @Override
		        public String getString() {
		            int max = getMaximum();
		            return getValue() + "/" + max;
		        }

		    };
			progressBar[aktIndex].setValue(k.getAktTeilnehmer().intValue());
			progressBar[aktIndex].setStringPainted(true);
			listPanel.add(progressBar[aktIndex]);
			
			buchButton[aktIndex] = new JButton("Buchen");
			if(k.getAktTeilnehmer().intValue()==k.getObereGrenze().intValue()) 
				buchButton[aktIndex].setEnabled(false);
			listPanel.add(buchButton[aktIndex]);
			
			buchButton[aktIndex].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					k.buchen();
					for(int i=0; i<anzKurse; i++)
					{
						if(k.getKursName().equals(kursNamen[i].getText())) aktIndex=i;
						//System.out.println("k  : " + k.getKursName());
						//System.out.println("[] : " + kursNamen[i].getText());
					}
					progressBar[aktIndex].setValue(k.getAktTeilnehmer().intValue());
					progressBar[aktIndex].revalidate();
					//System.out.println(aktIndex);
					if(k.getAktTeilnehmer().intValue()==k.getObereGrenze().intValue()) 
					{
						buchButton[aktIndex].setEnabled(false);
						buchButton[aktIndex].revalidate();
					}
					
				}	
			});
			
			
			aktIndex++;
		}
		panel.add(listPanel, BorderLayout.CENTER);
		
		b_ende = new JButton("Ende");
		b_ende.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				KursBuchen.this.setVisible(false);	
				KursBuchen.this.dispose();
			}
		});
		
		panel.add(b_ende, BorderLayout.SOUTH);
		
		return panel;
	}
}
