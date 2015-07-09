package sose15.aufgaben.aufgabe5.freiheit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TicTacToe2 extends JFrame implements ActionListener{
	JButton[] buttons; 
	JLabel label1;
	JButton bNeu, bEnde;
	boolean rotDran = true;
	boolean ende = false;
	boolean schwarzBeginnt = true;
	boolean computer = false;
	JRadioButton rb1, rb2, rb3, rb4;

	TicTacToe2()
	{
		super();
		setTitle("TicTacToe");
		 try {
			    UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
			 } catch (Exception e) {
			            e.printStackTrace();
			 }
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel hauptPanel = init();
		this.add(hauptPanel, BorderLayout.CENTER);
		JPanel labelPanel = new JPanel();
		label1 = new JLabel();
		label1.setFont(new Font("Verdana", Font.BOLD, 24));
		label1.setText(" ");
		labelPanel.add(label1);
		this.add(labelPanel, BorderLayout.NORTH);	
		JPanel buttonPanel = erzeugeSteuerPanel();
		this.add(buttonPanel, BorderLayout.SOUTH);			
		setSize(400,400);
		setVisible(true);
	}

	private JPanel erzeugeSteuerPanel()
	{
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BorderLayout());

		JPanel centerPanel = new JPanel();
		bNeu = new JButton("Start");
		bNeu.setBackground(Color.DARK_GRAY);
        //bNeu.setContentAreaFilled(false);
        //bNeu.setOpaque(true);
		bNeu.setForeground(Color.WHITE);
		bNeu.addActionListener(this);
		bEnde = new JButton("Ende");
		bEnde.setBackground(Color.DARK_GRAY);
        //bEnde.setContentAreaFilled(false);
        //bEnde.setOpaque(true);
		bEnde.setForeground(Color.WHITE);
		bEnde.addActionListener(this);
		centerPanel.add(bNeu);
		centerPanel.add(bEnde);

		JPanel westPanel = new JPanel();
		westPanel.setLayout(new GridLayout(2,1, 5, 5));
		rb1 = new JRadioButton("Mensch vs. Mensch", true);
		rb2 = new JRadioButton("Mensch vs. Maschine");
		ButtonGroup rbg1 = new ButtonGroup();
		rbg1.add(rb1);
		rbg1.add(rb2);
		westPanel.add(rb1);
		westPanel.add(rb2);
		buttonPanel.add(westPanel, BorderLayout.WEST);

		JPanel eastPanel = new JPanel();
		eastPanel.setLayout(new GridLayout(2,1, 5, 5));
		rb3 = new JRadioButton("Schwarz beginnt", true);
		rb4 = new JRadioButton("Rot beginnt");
		ButtonGroup rbg2 = new ButtonGroup();
		rbg2.add(rb3);
		rbg2.add(rb4);
		eastPanel.add(rb3);
		eastPanel.add(rb4);
		buttonPanel.add(eastPanel, BorderLayout.EAST);

		JPanel southPanel = new JPanel();
		southPanel.setBackground(Color.DARK_GRAY);
		southPanel.setAlignmentX(CENTER_ALIGNMENT);
		JLabel l1 = new JLabel("Hinweis: Maschine spielt stets in Schwarz");
		l1.setForeground(Color.WHITE);
		southPanel.add(l1);

		buttonPanel.add(southPanel, BorderLayout.SOUTH);
		buttonPanel.add(centerPanel,BorderLayout.NORTH);


		return buttonPanel;
	}

	private JPanel init()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,3,10,10));

		buttons = new JButton[9];
		for (int i=0; i<buttons.length; i++)
		{
			buttons[i]=new JButton();
			buttons[i].addActionListener(this);		
			buttons[i].setFont(new Font("Verdana", Font.BOLD, 48));
			buttons[i].setActionCommand((new Integer(i)).toString());
			panel.add(buttons[i]);
		}

		return panel;
	}

	boolean gewonnen()
	{
		String dran = rotDran ? "O" : "X";
		//Spalten
		for(int i=0; i<3; i++)
		{
			if( buttons[i].getText().equals(dran) && 
					buttons[i+3].getText().equals(dran) && 
					buttons[i+6].getText().equals(dran)) return true;
		}
		//Zeilen
		for(int i=0; i<7; i+=3)
		{
			if( buttons[i].getText().equals(dran) && 
					buttons[i+1].getText().equals(dran) && 
					buttons[i+2].getText().equals(dran)) return true;
		}
		//Diagonalen
		if( buttons[0].getText().equals(dran) && 
				buttons[4].getText().equals(dran) && 
				buttons[8].getText().equals(dran)) return true;
		if( buttons[2].getText().equals(dran) && 
				buttons[4].getText().equals(dran) && 
				buttons[6].getText().equals(dran)) return true;
		return false;
	}

	boolean voll()
	{
		for(int i=0; i<buttons.length; i++)
		{
			if(!(buttons[i].getText().equals("X") || buttons[i].getText().equals("O"))) return false;
		}
		return true;
	}

	boolean unentschieden()
	{
		return (voll() && !gewonnen());
	}

	public static void main(String[] args) {
		new TicTacToe2();
	}

	public void nextPlay()
	{
		// kann der Computer gewinnen??
		for(int i=0; i<9 && !ende; i++)
		{
			if(buttons[i].getText().equals(""))
			{
				buttons[i].setForeground(Color.BLACK); 
				buttons[i].setText("X"); 
				if(gewonnen())
				{
					label1.setText("Schwarz hat gewonnen!");
					ende=true;
				}
				else
				{
					buttons[i].setText(""); 
				}
			}
		}
		if(ende) return;

		// kann O gewinnen??
		boolean zugende = false;
		rotDran=true;
		for(int i=0; i<9 && !zugende; i++)
		{
			if(buttons[i].getText().equals(""))
			{
				buttons[i].setText("O"); 
				if(gewonnen())
				{
					buttons[i].setForeground(Color.BLACK); 
					buttons[i].setText("X");
					zugende=true;
				}
				else
				{
					buttons[i].setText(""); 
				}
			}
		}

		// n�chste freie
		for(int i=0; i<9 && !zugende; i++)
		{
			if(buttons[i].getText().equals(""))
			{
				buttons[i].setForeground(Color.BLACK); 
				buttons[i].setText("X");
				zugende = true;
			}
		}
		if(zugende) 
		{
			rotDran=true;
			label1.setForeground(Color.RED);
			label1.setText("Rot ist dran");
			return;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean istZahl = true;
		int index=0;
		Object quelle = e.getSource();
		String command = ((JButton) quelle).getActionCommand();
		try{
			index = Integer.parseInt(command);
			istZahl=true;
		}
		catch(NumberFormatException nfe)
		{
			istZahl=false;
		}
		if(istZahl && !ende && !(buttons[index].getText().equals("X") || buttons[index].getText().equals("O")))
		{
			if(rotDran) 
			{
				buttons[index].setForeground(Color.RED); 
				buttons[index].setText("O"); 
				if(gewonnen())
				{
					label1.setForeground(Color.RED);
					label1.setText("Rot hat gewonnen!");
					ende=true;
				}
				else if(unentschieden())
				{
					label1.setText("Unentschieden");
					ende=true;
				}
				else if(!computer)
				{
					rotDran=false; 
					label1.setForeground(Color.BLACK);
					label1.setText("Schwarz ist dran");
				}
				else // computer
				{
					rotDran=false; 
					nextPlay();
					if(gewonnen())
					{
						label1.setForeground(Color.BLACK);
						label1.setText("Schwarz hat gewonnen!");
						ende=true;
					}
					else if(unentschieden())
					{
						label1.setText("Unentschieden");
						ende=true;
					}
					else
					{
						rotDran=true; 
						label1.setForeground(Color.RED);
						label1.setText("Rot ist dran");
					}
				}
			}
			else 
			{
				buttons[index].setForeground(Color.BLACK); 
				buttons[index].setText("X"); 
				if(gewonnen())
				{
					label1.setText("Schwarz hat gewonnen!");
					ende=true;
				}
				else if(unentschieden())
				{
					label1.setText("Unentschieden");
					ende=true;
				}
				else
				{
					rotDran=true; 
					label1.setForeground(Color.RED);
					label1.setText("Rot ist dran");
				}
			}
		}
		else if(command.equals("Start"))
		{
			if(rb1.isSelected())
			{
				computer=false;			
			}
			else //rb2.isEnabled()
			{
				computer=true;
			}
			if(rb3.isSelected())
			{
				schwarzBeginnt=true;
				rotDran=false;
			}
			else //rb4.isEnabled()
			{
				schwarzBeginnt=false;
				rotDran=true;
			}
			if(computer)
			{
				if(schwarzBeginnt)
				{
					label1.setForeground(Color.BLACK);
					label1.setText("Computer und Schwarz");
				}
				else
				{
					label1.setForeground(Color.RED);
					label1.setText("Computer und Rot");
				}
			}
			else
			{
				if(schwarzBeginnt)
				{
					label1.setForeground(Color.BLACK);
					label1.setText("Mensch und Schwarz");
				}
				else
				{
					label1.setForeground(Color.RED);
					label1.setText("Mensch und Rot");
				}
			}
			ende=false;
			for(int i=0; i<buttons.length; i++)
			{
				buttons[i].setText("");
			}
			if(computer && schwarzBeginnt) nextPlay();
		}
		else if(command.equals("Ende"))
		{
			int ok = JOptionPane.showConfirmDialog(this, "Wollen Sie wirklich beenden?", "Programmende", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(ok==JOptionPane.OK_OPTION)
			{
				setVisible(false);
				dispose();
				System.exit(0);
			}
		}



	}

}
