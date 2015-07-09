package sose15.vorbereitungen.exceptions22;

import javax.swing.JOptionPane;

public class ExceptionHandling {
	
	public static double divide(int z1, int z2) throws ArithmeticException {
		return (double)z1/(double)z2;
	}
	
	public static int input() throws NumberFormatException {
		String s = JOptionPane.showInputDialog("Zahl: ");
		return Integer.parseInt(s);
	}


	public static void main(String[] args) {
		int nr1, nr2;
		try
		{
			nr1=input();
			nr2=input();
			JOptionPane.showMessageDialog(null, divide(nr1,nr2));
		}
		catch (ArithmeticException e)
		{
			System.out.println("divide by zero not defined");
		}
		catch (NumberFormatException e)
		{
			System.out.println("not a number");
		}
	}

}
