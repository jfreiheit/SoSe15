package sose15.vorbereitungen.uebungen.taschenrechner;

import java.awt.*;
import java.awt.event.*;
import java.util.IllegalFormatException;

import javax.swing.*;

// Klammern werden ignoriert
public class Taschenrechner extends JFrame implements ActionListener{
	JPanel hauptPanel;
	JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bMal, bPlus, bMinus, bDurch, bErg, bKlauf, bKlzu, bKomma, bC, bCE;
	JTextField tf;
	double zahl1, zahl2, zahl3;
	boolean zahl1Gesetzt=false; 
	boolean zahl2Gesetzt=false;
	boolean zahl3Gesetzt=false;
	boolean letztesZeichenZiffer=false;
	String eingabe="", aktEingabe="0";
	String op1="", op2="";
	int anzKlammern=0;

	Taschenrechner()
	{
		super();
		setTitle("Taschenrechner");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		hauptPanel = init();
		tf = new JTextField();
		tf.setFont(new Font("Verdana", Font.BOLD, 24));
		tf.setHorizontalAlignment(JTextField.RIGHT);
		this.add(tf, BorderLayout.NORTH);
		this.add(hauptPanel, BorderLayout.CENTER);
		setSize(250,350);
		setVisible(true);
	}

	private JPanel init()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(6,3,10,10));

		b0 = new JButton("0");
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		bMal = new JButton("*");
		bDurch = new JButton("/");
		bPlus = new JButton("+");
		bMinus = new JButton("-");
		bKlauf = new JButton("(");
		bKlzu = new JButton(")");
		bKomma = new JButton(".");
		bC = new JButton("C");
		bCE = new JButton("CE");
		bErg = new JButton("=");

		b0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		bMal.addActionListener(this);
		bDurch.addActionListener(this);
		bPlus.addActionListener(this);
		bMinus.addActionListener(this);
		bErg.addActionListener(this);
		bKlauf.addActionListener(this);
		bKlzu.addActionListener(this);
		bC.addActionListener(this);
		bCE.addActionListener(this);
		bKomma.addActionListener(this);


		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(b5);
		panel.add(b6);
		panel.add(b7);
		panel.add(b8);
		panel.add(b9);
		panel.add(bKlauf);		
		panel.add(b0);
		panel.add(bKlzu);		
		panel.add(bMal);
		panel.add(bDurch);
		panel.add(bPlus);
		panel.add(bMinus);
		panel.add(bKomma);
		panel.add(bErg);
		return panel;
	}

	public static void main(String[] args) {
		new Taschenrechner();

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		Object quelle = event.getSource();

		if(quelle instanceof JButton)
		{
			
			switch(((JButton)quelle).getActionCommand())
			{
			case "0": eingabeZiffer(0); tf.setText(aktEingabe); break;
			case "1": eingabeZiffer(1); tf.setText(aktEingabe); break;
			case "2": eingabeZiffer(2); tf.setText(aktEingabe); break;
			case "3": eingabeZiffer(3); tf.setText(aktEingabe); break;
			case "4": eingabeZiffer(4); tf.setText(aktEingabe); break;
			case "5": eingabeZiffer(5); tf.setText(aktEingabe); break;
			case "6": eingabeZiffer(6); tf.setText(aktEingabe); break;
			case "7": eingabeZiffer(7); tf.setText(aktEingabe); break;
			case "8": eingabeZiffer(8); tf.setText(aktEingabe); break;
			case "9": eingabeZiffer(9); tf.setText(aktEingabe); break;
			case "*": eingabePunktOperator("*"); tf.setText(eingabe); break;
			case "/": eingabePunktOperator("/"); tf.setText(eingabe); break;
			case "+": eingabeStrichOperator("+"); tf.setText(eingabe); break;
			case "-": eingabeStrichOperator("-"); tf.setText(eingabe); break;
			case "=": eingabeGleich(); tf.setText(eingabe); break;
			case ".": eingabeKomma(); tf.setText(aktEingabe); break;
			case "(": eingabeOeffnendeKlammer(); tf.setText(eingabe); break;
			case ")": eingabeSchliessendeKlammer(); tf.setText(aktEingabe); break;
			case "C": tf.setText(""); break;

			}
		}
	}

	void eingabeOeffnendeKlammer()
	{
		if(!letztesZeichenZiffer)
		{
			anzKlammern++;

		}
	}


	void eingabeSchliessendeKlammer()
	{
		if(letztesZeichenZiffer)
		{
			anzKlammern--;
			letztesZeichenZiffer=false;
		}
	}

	void eingabeZiffer(int ziffer)
	{
		if(letztesZeichenZiffer)
		{
			aktEingabe+=(new Integer(ziffer)).toString();
		}
		else
		{
			aktEingabe=(new Integer(ziffer)).toString();
			letztesZeichenZiffer=true;
		}
	}

	void eingabeKomma()
	{
		if(aktEingabeIstIntZahl()) aktEingabe+=".";
		letztesZeichenZiffer=true;
		if(aktEingabeIstDoubleZahl()) System.out.println("ok");
		else System.out.println("kein double");
	}

	void eingabeGleich()
	{	
		letztesZeichenZiffer=false;
		if (aktEingabeIstDoubleZahl())
		{
			// in aktEingabe steht Zahl1 
			// Op1 wurde eingegeben
			if(!zahl1Gesetzt){
				zahl1Gesetzt=false;
				zahl1=Double.parseDouble(aktEingabe);
				eingabe=(new Double(zahl1)).toString();
				aktEingabe="0";
				op1=""; op2="";
			}
			// in aktEingabe steht zahl2; zahl1 bereits gespeichert 
			// op2 wurde eingegeben; mit op1 wird gerechnet		
			else if(!zahl2Gesetzt){
				zahl1Gesetzt=false;
				zahl2=Double.parseDouble(aktEingabe);
				switch(op1)
				{
				case "+": zahl1=zahl1+zahl2; break;
				case "-": zahl1=zahl1-zahl2; break;
				case "*": zahl1=zahl1*zahl2; break;
				case "/": zahl1=zahl1/zahl2; break;
				}
				eingabe=(new Double(zahl1)).toString();
				aktEingabe="0";
				op1=""; op2="";
			}
			// in aktEingabe steht zahl3; zahl1 und zahl2 bereits gespeichert 
			// op3 wurde eingegeben; mit op1 und op2 (* od. /) wird gerechnet		
			else if(!zahl3Gesetzt){
				zahl1Gesetzt=false;
				zahl2Gesetzt=false;
				zahl3=Double.parseDouble(aktEingabe);
				if(op2.equals("*"))
				{
					switch(op1)
					{
					case "+": zahl1=zahl1+zahl2*zahl3; break;
					case "-": zahl1=zahl1-zahl2*zahl3; break;
					case "*": zahl1=zahl1*zahl2*zahl3; break;
					case "/": zahl1=zahl1/zahl2*zahl3; break;
					}
				}
				else if(op2.equals("/"))
				{
					switch(op1)
					{
					case "+": zahl1=zahl1+zahl2/zahl3; break;
					case "-": zahl1=zahl1-zahl2/zahl3; break;
					case "*": zahl1=zahl1*zahl2/zahl3; break;
					case "/": zahl1=zahl1/zahl2/zahl3; break;
					}
				} 
				eingabe=(new Double(zahl1)).toString();
				aktEingabe="0";
				op1=""; op2="";
			}
		}
	}

	void eingabeStrichOperator(String operator)
	{	
		letztesZeichenZiffer=false;
		if (aktEingabeIstDoubleZahl())
		{
			// in aktEingabe steht Zahl1 
			// Op1 wurde eingegeben
			if(!zahl1Gesetzt){
				zahl1Gesetzt=true;
				zahl1=Double.parseDouble(aktEingabe);
				eingabe=aktEingabe+operator;
				aktEingabe="0";
				op1=operator;
			}
			// in aktEingabe steht zahl2; zahl1 bereits gespeichert 
			// op2 wurde eingegeben; mit op1 wird gerechnet		
			else if(!zahl2Gesetzt){
				zahl1Gesetzt=true;
				zahl2=Double.parseDouble(aktEingabe);
				switch(op1)
				{
				case "+": zahl1=zahl1+zahl2; break;
				case "-": zahl1=zahl1-zahl2; break;
				case "*": zahl1=zahl1*zahl2; break;
				case "/": zahl1=zahl1/zahl2; break;
				}
				eingabe=(new Double(zahl1)).toString()+operator;
				aktEingabe="0";
				op1=operator;
			}
			// in aktEingabe steht zahl3; zahl1 und zahl2 bereits gespeichert 
			// op3 wurde eingegeben; mit op1 und op2 (* od. /) wird gerechnet		
			else if(!zahl3Gesetzt){
				zahl1Gesetzt=true;
				zahl2Gesetzt=false;
				zahl3=Double.parseDouble(aktEingabe);
				if(op2.equals("*"))
				{
					switch(op1)
					{
					case "+": zahl1=zahl1+zahl2*zahl3; break;
					case "-": zahl1=zahl1-zahl2*zahl3; break;
					case "*": zahl1=zahl1*zahl2*zahl3; break;
					case "/": zahl1=zahl1/zahl2*zahl3; break;
					}
				}
				else if(op2.equals("/"))
				{
					switch(op1)
					{
					case "+": zahl1=zahl1+zahl2/zahl3; break;
					case "-": zahl1=zahl1-zahl2/zahl3; break;
					case "*": zahl1=zahl1*zahl2/zahl3; break;
					case "/": zahl1=zahl1/zahl2/zahl3; break;
					}
				} 
				eingabe=(new Double(zahl1)).toString()+operator;
				aktEingabe="0";
				op1=operator;
			}
		}
	}

	void eingabePunktOperator(String operator)
	{
		letztesZeichenZiffer=false;
		if (aktEingabeIstDoubleZahl())
		{
			// in aktEingabe steht Zahl1 
			// Op1 wurde eingegeben
			if(!zahl1Gesetzt){
				zahl1Gesetzt=true;
				zahl1=Double.parseDouble(aktEingabe);
				eingabe=aktEingabe+operator;
				aktEingabe="0";
				op1=operator;
			}
			// in aktEingabe steht zahl2; zahl1 bereits gespeichert 
			// op2 wurde eingegeben; mit op1 wird gerechnet		
			else if(!zahl2Gesetzt){
				zahl1Gesetzt=true;
				zahl2=Double.parseDouble(aktEingabe);
				if(op1.equals("*") || op1.equals("/"))
				{
					switch(op1)
					{
					case "*": zahl1=zahl1*zahl2; break;
					case "/": zahl1=zahl1/zahl2; break;
					}
					eingabe=(new Double(zahl1)).toString();
					aktEingabe="0";
					op1=operator;
				}
				else
				{
					op2=operator;
					eingabe=eingabe+aktEingabe+operator;
					aktEingabe="0";
					zahl2Gesetzt=true;
				}
			}
			// in aktEingabe steht zahl3; zahl1 und zahl2 bereits gespeichert 
			// op3 wurde eingegeben; mit op1 und op2 (* od. /) wird gerechnet		
			else if(!zahl3Gesetzt){
				zahl1Gesetzt=true;
				zahl2Gesetzt=true;
				zahl3=Double.parseDouble(aktEingabe);
				if(op2.equals("*"))
				{
					zahl2=zahl2*zahl3;
				}
				else if(op2.equals("/"))
				{
					zahl2=zahl2/zahl3;
				} 
				eingabe=(new Double(zahl1)).toString()+op1+(new Double(zahl2)).toString()+op2;
				aktEingabe="0";
				op2=operator;
			}
		}
	}

	boolean aktEingabeIstIntZahl()
	{
		try
		{
			Integer.parseInt(aktEingabe);
		}
		catch(NumberFormatException e)
		{
			return false;
		}
		return true;
	}


	boolean aktEingabeIstDoubleZahl()
	{
		try
		{
			Double.parseDouble(aktEingabe);
		}
		catch(NumberFormatException e)
		{
			return false;
		}
		return true;
	}



}
