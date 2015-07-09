package sose15.aufgaben.aufgabe5.yavuz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

public class TicTacToeErweitert extends JFrame implements ActionListener
{
	private List<JButton> buttonListe;
	private JRadioButton xBeginnt;
	private JRadioButton oBeginnt;
	private JRadioButton menschGegenMensch;
	private JRadioButton computerGegenMensch;
	private JButton start;
	private JButton ende;
	private JButton neustart; 
	private JPanel panelObenLabel;
	private JPanel panelButtons;
	private JPanel panelStartEndeNeustartButtons;
	private JPanel panelUntenRadioButtons;
	private JLabel label;
	private boolean spieltComputer;
	private boolean xOderO;
	private int zaehler;

	private ImageIcon X;
	private ImageIcon O;

	public TicTacToeErweitert()
	{
		super();
		
		panelObenLabel = initPanelObenLabel();
		panelButtons = initPanelButtons();
		panelStartEndeNeustartButtons = initPanelStartEndeNeustartButtons();
		panelUntenRadioButtons = initPanelRadioButtons();
		setLayout(new GridLayout(4, 1));
		this.add(panelObenLabel);  
		this.add(panelButtons); 
		this.add(panelStartEndeNeustartButtons); 
		this.add(panelUntenRadioButtons); 
		
		initFrame();  
	}

	private void initFrame()
	{
		this.setTitle("TicTacToe");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(300, 380);
		this.setLocation(200, 300);
		panelObenLabel.setBackground(Color.PINK);
		panelButtons.setBackground(Color.PINK);
		panelStartEndeNeustartButtons.setBackground(Color.PINK);
		panelUntenRadioButtons.setBackground(Color.PINK);
		this.setVisible(true);
	}

	private JPanel initPanelObenLabel()
	{
		JPanel panelObenLabel = new JPanel(); 
		Dimension groesseDesLabels = new Dimension(300, 30); 

		label = new JLabel("Wer spielt?", JLabel.CENTER);
		label.setFont(new Font("Verdana", Font.BOLD, 24));
		label.setPreferredSize(groesseDesLabels);
		panelObenLabel.add(label);





		//add(label,BorderLayout.NORTH);

		//		panel.add(buttonListe.get(0), BorderLayout.WEST);
		//		panel.add(buttonListe.get(3), BorderLayout.WEST);
		//		panel.add(buttonListe.get(6), BorderLayout.WEST);


		//add(new JLabel("WER SPIELT?"),BorderLayout.NORTH);	
		return panelObenLabel;
	}

	private JPanel initPanelButtons()
	{
		JPanel panelButtons = new JPanel(new GridBagLayout());
		GridBagConstraints bedingungen = new GridBagConstraints(); 
		Dimension groesseDerSpielbutton = new Dimension(70, 50); 
		buttonListe = new ArrayList<JButton>();
		for(int i = 0; i < 9; i++)
		{
			buttonListe.add(new JButton());  
		}

		for(int i = 0; i < buttonListe.size(); i++)
		{
			buttonListe.get(i).setPreferredSize(groesseDerSpielbutton);
		}

		for(int i = 0; i < buttonListe.size(); i++)
		{
			buttonListe.get(i).setEnabled(false);
		}

		for(int i = 0; i < buttonListe.size(); i++)
		{
			buttonListe.get(i).addActionListener(this);
		}

		//Button1 (oben links)
		bedingungen.fill = GridBagConstraints.HORIZONTAL;
		bedingungen.gridx = 0;
		bedingungen.gridy = 0;
		
		panelButtons.add(buttonListe.get(0), bedingungen);

		//Button2 (oben Mitte)
		bedingungen.gridx = 1;
		bedingungen.gridy = 0;
		//bedingungen.gridheight = 2;
		//bedingungen.gridwidth = 2;
		panelButtons.add(buttonListe.get(1), bedingungen);


		//Button3 (oben rechts)
		bedingungen.gridx = 2;
		bedingungen.gridy = 0;
		panelButtons.add(buttonListe.get(2), bedingungen);

		//Button4 (Mitte links)
		bedingungen.gridx = 0;
		bedingungen.gridy = 1;
		panelButtons.add(buttonListe.get(3), bedingungen);
		
		//Button5 (Mitte Mitte)
		bedingungen.gridx = 1;
		bedingungen.gridy = 1;
		panelButtons.add(buttonListe.get(4), bedingungen);

		//Button6 (Mitte rechts)
		bedingungen.gridx = 2;
		bedingungen.gridy = 1;
		panelButtons.add(buttonListe.get(5), bedingungen);

		//Button7 (unten links)
		bedingungen.gridx = 0;
		bedingungen.gridy = 2;
		panelButtons.add(buttonListe.get(6), bedingungen);

		//Button8 (unten Mitte)
		bedingungen.gridx = 1;
		bedingungen.gridy = 2;
		panelButtons.add(buttonListe.get(7), bedingungen);

		//Button9 (unten rechts)
		bedingungen.gridx = 2;
		bedingungen.gridy = 2;
		panelButtons.add(buttonListe.get(8), bedingungen);

/*		for(int i = 0; i < buttonListe.size(); i++)
		{
			panelButtons.add(buttonListe.get(i));
		}*/

		return panelButtons;
	}

	private JPanel initPanelStartEndeNeustartButtons()
	{
		JPanel panelStartEndeNeustartButtons = new JPanel();
		Dimension groesseStartEndeNeustart = new Dimension(90, 15);

		start = new JButton("Start");
		ende = new JButton("Ende");
		neustart = new JButton("Neustart");

		start.setPreferredSize(groesseStartEndeNeustart);
		ende.setPreferredSize(groesseStartEndeNeustart);
		neustart.setPreferredSize(groesseStartEndeNeustart);

		start.addActionListener(this);
		ende.addActionListener(this);
		neustart.addActionListener(this);

		panelStartEndeNeustartButtons.add(start);
		panelStartEndeNeustartButtons.add(ende);
		panelStartEndeNeustartButtons.add(neustart);
		neustart.setVisible(false);

		return panelStartEndeNeustartButtons;
	}

	private JPanel initPanelRadioButtons()
	{
		JPanel panelRadioButtons = new JPanel();
		GridBagConstraints bedingungen = new GridBagConstraints();

		xBeginnt = new JRadioButton("X beginnt");
		oBeginnt = new JRadioButton("O beginnt");
		menschGegenMensch = new JRadioButton("Mensch vs. Mensch");
		computerGegenMensch = new JRadioButton("Computer vs. Mensch");

		xBeginnt.setBackground(Color.PINK);
		oBeginnt.setBackground(Color.PINK);
		menschGegenMensch.setBackground(Color.PINK);
		computerGegenMensch.setBackground(Color.PINK);
		
		ButtonGroup gruppeWerGegenWen = new ButtonGroup();
		gruppeWerGegenWen.add(menschGegenMensch);
		gruppeWerGegenWen.add(computerGegenMensch);
		
		ButtonGroup gruppeXundO = new ButtonGroup();
		gruppeXundO.add(xBeginnt);
		gruppeXundO.add(oBeginnt);

		//menschGegenMensch Button (oben links)
		bedingungen.gridx = 0;
		bedingungen.gridy = 0;
		panelButtons.add(menschGegenMensch, bedingungen);

		//computerGegenMensch Button (unten links)
		bedingungen.gridx = 0;
		bedingungen.gridy = 1;
		panelButtons.add(computerGegenMensch, bedingungen);

		//xBeginnt Button (oben rechts)
		bedingungen.gridx = 1;
		bedingungen.gridy = 0;
		panelButtons.add(xBeginnt, bedingungen);

		//oBeginnt Button (unten rechts)
		bedingungen.gridx = 1;
		bedingungen.gridy = 1;
		panelButtons.add(oBeginnt, bedingungen);

		panelRadioButtons.add(xBeginnt);
		panelRadioButtons.add(oBeginnt);
		panelRadioButtons.add(menschGegenMensch);
		panelRadioButtons.add(computerGegenMensch);

		return panelRadioButtons;
	}


	private boolean hatEinerGewonnen(String spieler)
	{
		boolean hatEinerGewonnen = false;
		if(buttonListe.get(0).getText().equals(spieler) && buttonListe.get(1).getText().equals(spieler)&& buttonListe.get(2).getText().equals(spieler))
		{
			label.setText(spieler + " hat gewonnen!");

		}
		if(buttonListe.get(3).getText().equals(spieler) && buttonListe.get(4).getText().equals(spieler)&& buttonListe.get(5).getText().equals(spieler))
		{
			label.setText(spieler + " hat gewonnen!");
			hatEinerGewonnen = true;
		}
		if(buttonListe.get(6).getText().equals(spieler) && buttonListe.get(7).getText().equals(spieler)&& buttonListe.get(8).getText().equals(spieler))
		{
			label.setText(spieler + " hat gewonnen!");
			hatEinerGewonnen = true;
		}
		if(buttonListe.get(0).getText().equals(spieler) && buttonListe.get(3).getText().equals(spieler)&& buttonListe.get(6).getText().equals(spieler))
		{
			label.setText(spieler + " hat gewonnen!");
			hatEinerGewonnen = true;
		}
		if(buttonListe.get(1).getText().equals(spieler) && buttonListe.get(4).getText().equals(spieler)&& buttonListe.get(7).getText().equals(spieler))
		{
			label.setText(spieler + " hat gewonnen!");
			hatEinerGewonnen = true;
		}
		if(buttonListe.get(2).getText().equals(spieler) && buttonListe.get(5).getText().equals(spieler)&& buttonListe.get(8).getText().equals(spieler))
		{
			label.setText(spieler + " hat gewonnen!");
			hatEinerGewonnen = true;
		}
		if(buttonListe.get(0).getText().equals(spieler) && buttonListe.get(4).getText().equals(spieler)&& buttonListe.get(8).getText().equals(spieler))
		{
			label.setText(spieler + " hat gewonnen!");
			hatEinerGewonnen = true;
		}
		if(buttonListe.get(2).getText().equals(spieler) && buttonListe.get(4).getText().equals(spieler)&& buttonListe.get(6).getText().equals(spieler))
		{
			label.setText(spieler + " hat gewonnen!");
			hatEinerGewonnen = true;
		}
		return hatEinerGewonnen;
	}


	private boolean spieltComputer()
	{
		boolean spieltCom = false;
		if(computerGegenMensch.isSelected())
		{
			spieltCom = true;
		}
		return spieltCom;
	}

	private void sollNeuStarten()
	{
		for(int i = 0; i < buttonListe.size(); i++)
		{
			buttonListe.get(i).setText("");
			buttonListe.get(i).setEnabled(false);
		}
		neustart.setVisible(false); 
		xBeginnt.setEnabled(true);  
		oBeginnt.setEnabled(true);  
	}



	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object quelle = e.getSource();
		if(quelle instanceof JButton)
		{

			if(quelle == xBeginnt)
			{
				neustart.setVisible(true);
				label.setText("X ist dran");
				xOderO = true;
				xBeginnt.setEnabled(false);
				oBeginnt.setEnabled(false);
				for(int i = 0; i < buttonListe.size(); i++)
				{
					buttonListe.get(i).setEnabled(true);
				}
			}
			if(quelle == oBeginnt)
			{
				neustart.setVisible(true);
				label.setText("O ist dran");
				xOderO = false;
				xBeginnt.setEnabled(false);
				oBeginnt.setEnabled(false);
				for(int i = 0; i < buttonListe.size(); i++)
				{
					buttonListe.get(i).setEnabled(true);
				}
			}
			if(quelle == neustart)
			{
				sollNeuStarten();
			}

			if(quelle == buttonListe.get(0))
			{

				if(xOderO)
				{
					buttonListe.get(0).setText("X");
					buttonListe.get(0).setEnabled(false);
					xOderO = false;
					label.setText("O ist dran");
					zaehler++;
				}
				else
				{
					buttonListe.get(0).setText("O");
					buttonListe.get(0).setEnabled(false);
					xOderO = true;
					label.setText("X ist dran");
					zaehler++;

				}	
			}
			if(quelle == buttonListe.get(1))
			{
				if(xOderO)
				{
					buttonListe.get(1).setText("X");
					buttonListe.get(1).setEnabled(false);
					xOderO = false;
					label.setText("O ist dran");
					zaehler++;
				}
				else
				{
					buttonListe.get(1).setText("O");
					buttonListe.get(1).setEnabled(false);
					xOderO = true;
					label.setText("X ist dran");
					zaehler++;
				}	
			}
			if(quelle == buttonListe.get(2))
			{
				if(xOderO)
				{
					buttonListe.get(2).setText("X");
					buttonListe.get(2).setEnabled(false);
					xOderO = false;
					label.setText("O ist dran");
					zaehler++;
				}
				else
				{
					buttonListe.get(2).setText("O");
					buttonListe.get(2).setEnabled(false);
					xOderO = true;
					label.setText("X ist dran");
					zaehler++;
				}	
			}
			if(quelle == buttonListe.get(3))
			{
				if(xOderO)
				{
					buttonListe.get(3).setText("X");
					buttonListe.get(3).setEnabled(false);
					xOderO = false;
					label.setText("O ist dran");
					zaehler++;
				}
				else
				{
					buttonListe.get(3).setText("O");
					buttonListe.get(3).setEnabled(false);
					xOderO = true;
					label.setText("X ist dran");
					zaehler++;
				}	
			}
			if(quelle == buttonListe.get(4))
			{
				if(xOderO)
				{
					buttonListe.get(4).setText("X");
					buttonListe.get(4).setEnabled(false);
					xOderO = false;
					label.setText("O ist dran");
					zaehler++;
				}
				else
				{
					buttonListe.get(4).setText("O");
					buttonListe.get(4).setEnabled(false);
					xOderO = true;
					label.setText("X ist dran");
					zaehler++;
				}	
			}
			if(quelle == buttonListe.get(5))
			{
				if(xOderO)
				{
					buttonListe.get(5).setText("X");
					buttonListe.get(5).setEnabled(false);
					xOderO = false;
					label.setText("O ist dran");
					zaehler++;
				}
				else
				{
					buttonListe.get(5).setText("O");
					buttonListe.get(5).setEnabled(false);
					xOderO = true;
					label.setText("X ist dran");
					zaehler++;
				}	
			}
			if(quelle == buttonListe.get(6))
			{
				if(xOderO)
				{
					buttonListe.get(6).setText("X");
					buttonListe.get(6).setEnabled(false);
					xOderO = false;
					label.setText("O ist dran");
					zaehler++;
				}
				else
				{
					buttonListe.get(6).setText("O");
					buttonListe.get(6).setEnabled(false);
					xOderO = true;
					label.setText("X ist dran");
					zaehler++;
				}	
			}
			if(quelle == buttonListe.get(7))
			{
				if(xOderO)
				{
					buttonListe.get(7).setText("X");
					buttonListe.get(7).setEnabled(false);
					xOderO = false;
					label.setText("O ist dran");
					zaehler++;
				}
				else
				{
					buttonListe.get(7).setText("O");
					buttonListe.get(7).setEnabled(false);
					xOderO = true;
					label.setText("X ist dran");
					zaehler++;
				}	
			}
			if(quelle == buttonListe.get(8))
			{
				if(xOderO)
				{
					buttonListe.get(8).setText("X");
					buttonListe.get(8).setEnabled(false);
					xOderO = false;
					label.setText("O ist dran");
					zaehler++;
				}
				else
				{
					buttonListe.get(8).setText("O");
					buttonListe.get(8).setEnabled(false);
					xOderO = true;
					label.setText("X ist dran");
					zaehler++;
				}	
			}

			if(!hatEinerGewonnen("O") && !hatEinerGewonnen("X") && zaehler == 9)
			{
				label.setText("Unentschieden!");
			}
		}


	}

}
