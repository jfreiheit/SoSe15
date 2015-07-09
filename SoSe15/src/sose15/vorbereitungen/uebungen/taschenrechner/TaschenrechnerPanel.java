package sose15.vorbereitungen.uebungen.taschenrechner;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * Panel-Klasse, indem die Variablen gesetzt und
 * das Textfeld erstellt wird
 */
public class TaschenrechnerPanel extends JPanel {
	
	private JButton textfield;
	private JPanel panel;
	private String letzterBefehl;
	private double summe;
	private boolean start;
	private JButton clear;
	
	private double zahl1 = 0.0;
	private boolean zahl1Vorhanden = false;
	private double zahl2 = 0.0;
	private boolean zahl2Vorhanden = false;
	private double zahl3 = 0.0;
	private boolean zahl3Vorhanden = false;
	private String operator1 = "";
	private boolean operator1Vorhanden = false;
	private String operator2 = "";
	private boolean operator2Vorhanden = false;
	private String operator3 = ""; 
	static String input = "";

	/*
	 * Layout gesetzt, Textfeld-Zahlen an die rechte Seite
	 * ActionListener und ActionEvent benutzt 
	 * Farbe, Buttons mit Panel verbunden und gesagt, was da auf jedem Button stehen soll
	 */
	public TaschenrechnerPanel(){
		
		setLayout(new BorderLayout());
		summe = 0;
		letzterBefehl = "=";
		start = true;
		
		textfield = new JButton("0");
		textfield.setEnabled(false);
		textfield.setHorizontalAlignment(JTextField.RIGHT);
		add(textfield, BorderLayout.NORTH);
		
		ActionListener insert = new InsertAction();
		ActionListener command = new CommandAction();

		
		panel = new JPanel();
		panel.setBackground(Color.blue);
		panel.setLayout(new GridLayout(4, 3, 3, 3));
		
		this.add(panel);
		
		addButton("1", insert);
		addButton("2", insert);
		addButton("3", insert);
		addButton("4", insert);
		addButton("5", insert);
		addButton("6", insert);
		addButton("7", insert);
		addButton("8", insert);
		addButton("9", insert);
		addButton("0", insert); 

		addButton(".", command);
		addButton("+", command);
		addButton("-", command);
		addButton("*", command);
		addButton("/", command);
		addButton("=", command); 
	 }
	
	/*
	 * Buttons an den ActionListener und ans Panel angemeldet
	 */
   private void addButton(String label, ActionListener al) {
	   
	   JButton button = new JButton(label);
	   button.addActionListener(al);
	   panel.add(button);
   	}
 
   /*
    * ActionListener gesagt, was passieren soll, wenn Event kommt
    */
   private class InsertAction implements ActionListener{
	   
      public void actionPerformed(ActionEvent event){
    	   
         TaschenrechnerPanel.input = event.getActionCommand();
         if (start) {
            textfield.setText("");
            start = false;
         }
         textfield.setText(textfield.getText() + input);         
      }
   }
   
   /*
    * Rechnen
    */
   private class CommandAction implements ActionListener {
	   
      public void actionPerformed(ActionEvent ae) {
    	  
    	 TaschenrechnerPanel.input = ""; 
    	 start = true; 
         String befehl = ae.getActionCommand();
         /*
          * hier geht man die Reihenfolge f�r folgendes Muster ab:
          * zahl1 op1 zahl2 op2 zahl3 op3
          * dabei wird die Punkt-vor-StrichRechnung beachtet
          */
         if (!zahl1Vorhanden){
        	 zahl1 = Double.parseDouble(textfield.getText());
        	 zahl1Vorhanden = true; 
         }else if (!zahl2Vorhanden){
        	 zahl2 = Double.parseDouble(textfield.getText());
        	 zahl2Vorhanden = true;
         }else {
        	 zahl3 = Double.parseDouble(textfield.getText());
        	 zahl3Vorhanden = true;
         }
         
         if (!operator1Vorhanden) {
        	 operator1 = befehl; 
        	 operator1Vorhanden = true; 
         }else if (!operator2Vorhanden) {
        	 operator2 = befehl; 
        	 operator2Vorhanden = true; 
         }else {
        	 operator3 = befehl; 
         }
         
         if (zahl1Vorhanden && zahl2Vorhanden && zahl3Vorhanden){
        	 double zwischenergebnis = Rechnen(zahl2, zahl3, operator2); 
        	 zahl2 = zwischenergebnis;
        	 zahl3Vorhanden = false;
        	 operator2 = operator3;
         }
         if (zahl1Vorhanden && zahl2Vorhanden && (
        		 operator1.equals("*") || operator1.equals("/") || operator2.equals("-") || operator2.equals("+") || operator2.equals("="))){
        	 double zwischenergebnis = Rechnen(zahl1, zahl2, operator1); 
        	 zahl1 = zwischenergebnis; 
        	 zahl2Vorhanden = false;
        	 operator1 = operator2; 
        	 operator2Vorhanden = false; 
        	 if (operator1.equals("=")){
        		 textfield.setText(Double.toString(zahl1));
        		 zahl1Vorhanden = false; 
        		 operator1Vorhanden = false; 
        	}
         }
       }
  	}
   
   /*
    * Befehle zu den einzelnen Operatoren
    */
   public double Rechnen(double z1, double z2, String operator){ 
	   
	   if (operator.equals("*")){
		   return z1*z2; 
	   } else if (operator.equals("/")){
		   return z1/z2; 
	   }else if (operator.equals("+")){
		   return z1+z2; 
	   }else {
		   return z1-z2; 
	   }
   }

}