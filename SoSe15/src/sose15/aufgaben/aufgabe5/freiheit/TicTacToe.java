package sose15.aufgaben.aufgabe5.freiheit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TicTacToe extends JFrame implements ActionListener{
	JButton[] buttons; 
	JLabel label1;
	JButton bNeuRot, bNeuSchwarz;
	boolean rotDran = true;
	boolean ende = false;

	TicTacToe()
	{
		super();
		setTitle("TicTacToe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel hauptPanel = init();
		this.add(hauptPanel, BorderLayout.CENTER);
		JPanel labelPanel = new JPanel();
		label1 = new JLabel();
		label1.setFont(new Font("Verdana", Font.BOLD, 24));
		label1.setText(" ");
		labelPanel.add(label1);
		this.add(labelPanel, BorderLayout.NORTH);	
		JPanel buttonPanel = new JPanel();
		bNeuRot = new JButton("Rot beginnt");
		bNeuRot.setActionCommand("RB");
		bNeuSchwarz = new JButton("Schwarz beginnt");
		bNeuSchwarz.setActionCommand("SB");
		bNeuRot.addActionListener(this);
		bNeuSchwarz.addActionListener(this);
		buttonPanel.add(bNeuRot);
		buttonPanel.add(bNeuSchwarz);
		this.add(buttonPanel, BorderLayout.SOUTH);			
		setSize(400,400);
		setVisible(true);
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
		new TicTacToe();
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
					label1.setText("Rot hat gewonnen!");
					ende=true;
				}
				else if(unentschieden())
				{
					label1.setText("Unentschieden");
					ende=true;
				}
				else
				{
					rotDran=false; 
					label1.setForeground(Color.BLACK);
					label1.setText("Schwarz ist dran");
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
		else if(command.equals("RB") || command.equals("SB"))
		{
			if(command.equals("RB"))
			{
				rotDran=true;			
				label1.setForeground(Color.RED);
				label1.setText("Rot ist dran");	
			}
			else if(command.equals("SB"))
			{
				rotDran=false;
				label1.setForeground(Color.BLACK);
				label1.setText("Schwarz ist dran");
			}
			ende=false;
			for(int i=0; i<buttons.length; i++)
			{
				buttons[i].setText("");
			}
		}



	}

}
