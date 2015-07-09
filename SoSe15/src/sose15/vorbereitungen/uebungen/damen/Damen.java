package sose15.vorbereitungen.uebungen.damen;

public class Damen 
{

	static int anzLoesungen = 0;

	boolean schlaegt(boolean[][] feld, int zeile, int spalte)
	{
		for(int i=0; i<zeile; i++)
			for(int j=0; j<8; j++)
				if(feld[i][j] && j==spalte) return true;

		for(int i=0; i<zeile; i++)
			for(int j=0; j<8; j++)
				if(feld[i][j] && ((zeile-i)==(j-spalte))) return true;

		for(int i=0; i<zeile; i++)
			for(int j=0; j<8; j++)
				if(feld[i][j] && ((zeile-i)==(spalte-j))) return true;

		return false;
	}

	void druckeLoesung(boolean[][] feld)
	{
		anzLoesungen++;
		System.out.println();
		System.out.println("------------------");
		System.out.println("Lösung Nr. " + anzLoesungen);
		System.out.println();
		for(int i=0; i<8; i++)
		{
			for(int j=0; j<8; j++)
			{
				if(feld[i][j])
					System.out.print("D ");
				else 
					System.out.print("_ ");
			}
			System.out.println();
		}
		System.out.println("------------------");
		System.out.println();
	}

	void setzen(boolean[][] feld, int zeile)
	{
		if(zeile==8) druckeLoesung(feld);
		else
		{
			for(int j=0; j<8; j++)
			{
				if(!schlaegt(feld, zeile,j)) 
				{	
					feld[zeile][j] = true;	
					setzen(feld, zeile+1);
					feld[zeile][j] = false;	
				}
			}
		}
	}

	public static void main(String[] args) 
	{
		Damen d = new Damen();
		boolean[][] feld = new boolean[8][8];
		for(int i=0; i<8; i++)
			for(int j=0; j<8; j++)
				feld[i][j] = false;
		d.setzen(feld, 0);
	}

}
