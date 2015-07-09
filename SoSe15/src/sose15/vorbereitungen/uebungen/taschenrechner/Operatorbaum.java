package sose15.vorbereitungen.uebungen.taschenrechner;

public class Operatorbaum {
	private Term wurzel;
	
	public Operatorbaum()
	{
		wurzel = null;
	}
	
	public Operatorbaum(String zahl)
	{
		wurzel = new Term(null, zahl, null);
	}
	
	public Operatorbaum(Operatorbaum links, String operator, Operatorbaum rechts)
	{
		wurzel = new Term(links.wurzel, operator, rechts.wurzel);
	}
	
	public double getZahl() throws NumberFormatException
	{
		if(wurzel.getLeft()==null && wurzel.getRight()==null)
		{
			try{
				double wert = Double.parseDouble(wurzel.getValue());
				return wert;
			}
			catch(NumberFormatException e)
			{
				throw e;
			}
		}
		else
			throw new NumberFormatException();
	}
}
