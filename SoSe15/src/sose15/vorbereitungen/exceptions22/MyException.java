package sose15.vorbereitungen.exceptions22;

public class MyException {

	public static int subtract(int z1, int z2){
		if (z1<z2)
			throw new IllegalArgumentException("difference below zero");
		else return z1-z2;
	}
	
	public static void main(String[] args) {
		try
		{
			System.out.println(subtract(10, 20));
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
	}
}
