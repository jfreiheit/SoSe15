package sose15.vorbereitungen.exceptions22;

import java.awt.HeadlessException;

import javax.swing.JOptionPane;

public class MyExceptions {

	public static void main(String[] args) {
/*		boolean isNumber = false;
		int nr1=0, nr2=0;
		String s1="", s2="", s3="", s4="";

		do{
			try {
				isNumber = true;
				s1 = JOptionPane.showInputDialog("Geben Sie eine erste Zahl ein!");
				System.out.println(s1);
				nr1 = Integer.valueOf(s1).intValue();
			}
			catch(NumberFormatException e)
			{
				System.out.println(s1 + " ist keine Zahl");
				isNumber = false;
			}
		}while(!isNumber);

		boolean isZero = false;
		int result=0, rest=0;

		do {
			do {
				try {
					isNumber = true;
					s2 = JOptionPane
							.showInputDialog("Geben Sie eine zweite Zahl ein!");
					System.out.println(s2);
					nr2 = Integer.valueOf(s2).intValue();
				} catch (NumberFormatException e) {
					System.out.println(s2 + " ist keine Zahl");
					isNumber = false;
				}
			} while (!isNumber);

			try {
				isZero = false;
				result = nr1 / nr2;
				rest = nr1 % nr2;
			} catch (ArithmeticException e) {
				isZero = true;
				System.out.println("Division durch 0 nicht definiert");
			}
		} while (isZero);

		s3 = Integer.valueOf(result).toString();
		s4 = Integer.valueOf(rest).toString();
		JOptionPane.showMessageDialog(null, s1 + " / " + s2 +" = " + s3 + "   Rest " + s4);*/
	
		int[] numbers = {6,7,8};
		boolean isIndex = true, outOfBounds=false;
		String output = "Index :";
		do {
			String s5 = JOptionPane.showInputDialog(output);
			try {
				isIndex = true; outOfBounds = false;
				int index = Integer.valueOf(s5).intValue();
				JOptionPane.showMessageDialog(null, "Wert von numbers["+s5+"] ist " + numbers[index]);
			} catch (NumberFormatException e) {
				isIndex=false;
				System.out.println("keine Zahl!");
				output = "Bitte eine Zahl eingeben!";
			} catch (ArrayIndexOutOfBoundsException e) {
				outOfBounds=true;
				System.out.println("außerhalb des Arrays!");
				output = "Zahl kein korrekter Index!";
			}
		} while (!isIndex || outOfBounds) ;
	}

}
