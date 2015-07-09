package sose15.vorbereitungen.javadoc01;

/**
 * Diese Klasse ist nur für Testzwecke und 
 * berechnet ein bisschen
 *  
 * @author Jörn Freiheit
 * @version 0.1
 */
public class Berechnungen {
	/**
	 * zwei Zahlen zahl1 und zahl2
	 * int
	 */
	public int zahl1;
	public int zahl2;
	
	/**
	 * parameterloser Konstruktor
	 * Zahlen auf 0
	 */
	public Berechnungen()
	{
		zahl1=0;
		zahl2=0;
	}
	
	/** 
	 * parametrisierter Konstruktor
	 * Werte der Parameter für Zahlen
	 * @param int zahl1
	 * @param int zahl2
	 */
	public Berechnungen(final int zahl1, final int zahl2)
	{
		this.zahl1=zahl1;
		this.zahl2=zahl2;
	}
	
	/**
	 * 
	 * @return int product of zahl1 and zahl2
	 */
	public int multiplizieren()
	{
		return this.zahl1*this.zahl2;
	}
}
