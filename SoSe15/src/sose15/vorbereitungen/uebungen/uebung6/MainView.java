package sose15.vorbereitungen.uebungen.uebung6;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;


public class MainView extends JFrame{
	Container contentPane;
	JButton b_kursAnlegen, b_kursBuchen, b_ende;
	Kurse kurse;
	
	MainView(final Kurse kurse)
	{
		this.kurse=kurse;
		
		contentPane = this.getContentPane();
		contentPane.add(erzeugeGUI());
		
		JLabel oben = new JLabel(" ");
		contentPane.add(oben, BorderLayout.NORTH);
		
		JLabel unten = new JLabel(" ");
		contentPane.add(unten, BorderLayout.SOUTH);
		
		JLabel links = new JLabel("    ");
		contentPane.add(links, BorderLayout.WEST);
		
		JLabel rechts = new JLabel("    ");
		contentPane.add(rechts, BorderLayout.EAST);
		
		this.setTitle("Kurse");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private JPanel erzeugeGUI()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,1,50,50));
		
		panel.setBorder(new TitledBorder("Main menu"));
		
		b_kursAnlegen = new JButton("Kurs anlegen");
		b_kursAnlegen.setToolTipText("hier können Sie einen Kurs anlegen");
		b_kursBuchen = new JButton("Kurs buchen");
		b_kursBuchen.setToolTipText("hier können Sie einen Kurs buchen");	
		b_ende = new JButton("Ende");
		b_ende.setToolTipText("hiermit beenden Sie das Programm");
		
		b_kursAnlegen.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				new KursAnlegen(MainView.this, kurse);	
			}
		});
		
		b_kursBuchen.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				new KursBuchen(MainView.this, kurse);	
			}
		});
		
		b_ende.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				MainView.this.setVisible(false);	
				MainView.this.dispose();
				System.exit(0);
			}
		});
		
		panel.add(b_kursAnlegen);
		panel.add(b_kursBuchen);
		panel.add(b_ende);
		
		return panel;
	}


}
