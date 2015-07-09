package sose15.vorbereitungen.uebungen.taschenrechner;

public class Term {
	private Term links;
	private String wert;
	private Term rechts;

	public Term(Term links, String wert, Term rechts) 
	{
		this.links = links;
		this.wert = wert;
		this.rechts = rechts;
	}
	
	public String getValue()
	{
		return wert;
	}
	
	public Term getLeft()
	{
		return links;
	}
	
	public Term getRight()
	{
		return rechts;
	} 
}
