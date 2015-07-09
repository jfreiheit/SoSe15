package sose15.vorlesungen.exceptions;

import java.awt.HeadlessException;

import javax.swing.JOptionPane;

public class MyExceptions {

	public static void main(String[] args) {
		int nr1=0, nr2=0, result=0, rest=0;
		String s1="", s2="", s3="", output="";
		boolean isNumber=true, isZero = false;
		output="Geben Sie erste Zahl ein : ";
		do {
			s1 = JOptionPane.showInputDialog(output);
			try {
				//kritischer Bereich
				nr1 = Integer.valueOf(s1).intValue();
				isNumber = true;
			} catch (NumberFormatException e) {
				isNumber = false;
				output = s1 + " keine Zahl! Bitte ZAHL eingeben";
			}
		} while (!isNumber);
		
		output = "Geben Sie eine zweite Zahl ein :";
		do {
			s2 = JOptionPane.showInputDialog(output);
			try {
				nr2 = Integer.valueOf(s2).intValue();
				isNumber = true;		
				result = nr1/nr2;
				rest = nr1 % nr2;
				isZero = false;
			} 
			catch (NumberFormatException e) {
				isNumber = false;
				output = s2 + " ist keine Zahl! Bitte Zahl eingeben";
			} 
			catch(ArithmeticException e)
			{
				isZero = true;
				output = "Division durch 0! Keine 0 eingeben!";
			}
		} while (!isNumber || isZero);
		
		s3 = nr1 + " / " + nr2 + " = " + result + " Rest " + rest;
		JOptionPane.showMessageDialog(null, s3);
		
		
		
		int[] numbers = {6,7,8};
		String output2 = "Index :";
		int index = 0;
		
		String s = "";
		boolean isIndex = true, outOfBounds = false;
		do {
			try {
				s = JOptionPane.showInputDialog(output2);
				index = Integer.valueOf(s).intValue();
				isIndex = true;
				JOptionPane.showMessageDialog(null, "Wert von numbers["+index+"] ist " 
											+ numbers[index]);
				outOfBounds = false;
			} catch (NumberFormatException e) {
				output2 = "keine Zahl! neuer Index :";
				isIndex = false;
			} catch (ArrayIndexOutOfBoundsException e) {
				output2 = "Index außerhalb! neuer Index :";
				outOfBounds = true;
			}
		} while (!isIndex || outOfBounds);

		
		

	}

}
