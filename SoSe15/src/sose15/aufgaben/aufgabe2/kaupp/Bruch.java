package sose15.aufgaben.aufgabe2.kaupp;
/*
 * Klasse Bruch ist ein Entyty-Typ und enthält sinnvoller Weise keine überschriebene 
 * equals()-Methode. (Nur bei Value-Typen sinnvoll, bei denen sich ein definierter
 * Wert vergleichen lässt.
 */

/**
 * Die Klasse Bruch repraesentiert rationale Zahlen, definiert durch Zaehler und Nenner.
 * 
 * @author Suzanne Kaupp
 * @version 1.0
 */
public class Bruch {
	
	private int zaehler;
	private int nenner;
	
	/**
	 * Erzeugt einen Bruch, ohne Uebergabe von Argumenten.<br/>
	 * Der Zaehler erhaelt den Wert 1.<br/>
	 * Der Nenner erhaelt den Wert 1.
	 */
	public Bruch()
	{
		this.zaehler = 1;
		this.nenner = 1;
	}
	/**
	 * Erzeugt einen Bruch, spezifiziert durch die Werte 
	 * fuer Zaehler und Nenner.<br/>
	 * <b>Der Wert des Nenners muss kleiner 0 sein!</b>
	 * @param int zaehler Wert des Zaehlers
	 * @param int nenner Wert des Nenners
	 */
	public Bruch(int zaehler, int nenner)
	{
		if ( nenner == 0 ){
		    throw new IllegalArgumentException( "Der Wert des Nenners muss ungleich 0 sein!" );
		}
		this.zaehler = zaehler;		
		this.nenner = nenner;
	}
	//Einbau von Gettern, um Testen zu erleichtern, macht ja auch Sinn bei Brüchen
	/**
	 * Zugriff auf die Objektvariable <code>zaehler</code>
	 * @return int <code>zaehler</code>
	 */
	public int getZaehler() {
		return zaehler;
	}
	
	/**
	 * Zugriff auf die Objektvariable <code>nenner</code>
	 * @return int <code>nenner</code>
	 */
	public int getNenner() {
		return nenner;
	}
	
	/**
	 * Methode <code>plus</code> addiert den Bruch mit einem Bruch, der als Argument uebergeben wird.
	 * @param b Bruch, der addiert wird
	 * @return ein neues, gekuerztes Objekt Bruch
	 * @see #kuerzen()
	 */
	public Bruch plus(Bruch b)
	{
		int summeNenner = this.nenner * b.nenner;
		int summeZaehler = this.zaehler * b.nenner 
						+ b.zaehler * this.nenner;
		return new Bruch(summeZaehler, summeNenner).kuerzen();
	}	

	/**
	 * Methode <code>minus</code> substrahiert vom Bruch einen Bruch, der als Argument uebergeben wird.
	 * @param b Bruch der substrahiert wird
	 * @return ein neues, gekuerztes Objekt Bruch
	 * @see #kuerzen()
	 */
	public Bruch minus(Bruch b)
	{
		int zaehlerMinus = this.zaehler * b.nenner 
						- b.zaehler * this.nenner;
		int nennerMinus = this.nenner * b.nenner;			
		return new Bruch(zaehlerMinus, nennerMinus).kuerzen();
	}
	/**
	 * Methode <code>mal</code> multipliziert den Bruch mit dem als Argument uebergebenen Bruch.
	 * @param b Bruch, mit dem multipliziert wird
	 * @return ein neues, gekuerztes Objekt Bruch
	 * @see #kuerzen()
	 */
	public Bruch mal(Bruch b)
	{
		int zaehlerMal = this.zaehler * b.zaehler;
		int nennerMal = this.nenner * b.nenner;
		return new Bruch(zaehlerMal, nennerMal).kuerzen();
	}	
	/**
	 * Methode <code>geteilt</code> teilt den Bruch, durch den als Argument uebergebenen Bruch.
	 * @param b Bruch ist der Divisor
	 * @return ein neues, gekuerztes Objekt Bruch
	 * @see #kuerzen()
	 */
	public Bruch geteilt(Bruch b)
	{
		int zaehlerGeteilt = this.zaehler * b.nenner;
		int nennerGeteilt = this.nenner * b.zaehler;
		return new Bruch(zaehlerGeteilt, nennerGeteilt).kuerzen();
	}
	/**
	 * Methode <code>kuerzen</code> kuerzt den Bruch.
	 * @return ein neues, gekuerztes Objekt Bruch
	 * @see #ggT(int, int)
	 */
	public Bruch kuerzen()
	{
		int ggT = ggT(this.zaehler, this.nenner); //Aufruf der Methode ggT
		int zaehlerGek = this.zaehler / ggT;
		int nennerGek = this.nenner / ggT;
		return new Bruch(zaehlerGek, nennerGek); 
	}
	/**
	 * Methode <code>ggT</code> errechnet den groessten gemeinsamen Teiler von Zaehler und Nenner
	 * @param z int Wert des Zaehlers
	 * @param n int Wert des Nenners > 0 
	 * @return int Wert des ggT
	 */
	public int ggT(int z, int n)
	{
		z = zaehler;
		n = nenner;
		int rest;
		
		if(z==0 || n==0)	//n==0 sollte nicht möglich sein
		{
			return 1; 		// d.h. ggT = 1, es wird also nicht gekürzt
		}					
		while(n != 0)		
		{
			{	
				rest = z%n;
				z = n;
				n = rest;
			}
		}
		return z;	
	}

	/**
	 * Ueberschriebene Methode <code>toString</code> der Klasse <code>Object</code> 
	 * gibt einen Bruch als String-Repraesentation zurueck.
	 * @return String  "(zaehler/nenner)"
	 */
	public String toString()
	{
		return (this.zaehler + "/" + this.nenner);
	}
	
	/**
	 * Konsolenausgabe des Bruchs und dessen Dezimalwert
	 */
	public void print()
	{
		System.out.printf("%3d / %-3d = %.2f", 
				zaehler, nenner, (double) zaehler/ (double) nenner);
	}
	
	/**
	 * Methode <code>printDezimal</code> gibt den Bruch als Dezimalwert zurueck
	 * @return double 
	 */
	public double printDezimal()
	{
		return (double) this.zaehler/this.nenner; 
	}
	
	/**
	 * Methode <code> vorzeichenKorrektur</code> bringt das Vorzeichen des Bruchs in den Zaehler.</br>
	 * Sind Zaehler und Nenner beide negativ, erhalten beide ein positives Vorzeichen.
	 * @param b1 Bruch
	 * @return Bruch mit korrigiertem Vorzeichen
	 */
	public Bruch vorzeichenKorrektur(Bruch b1){
		if(b1.nenner<0) {
			b1.zaehler *= -1; //das Vorzeichen des Bruchs muss im Zaehler stehen!
			b1.nenner *= -1;
		}	
		return b1;
	}
	
	/**
	 * Methode <code>vergleicheBrueche</code> bringt beide Brueche auf den gleichen Nenner 
	 * und vergleicht dann die Zaehler miteinander.</br>
	 * <b>Der Rueckgabewert ist folgendermassen kodiert:</b></br>
	 * Wenn der betrachtete Bruch <b>groesser</b> ist: <b>1</b></br>
	 * Wenn der betrachtete Bruch <b>kleiner</b> ist: <b>-1</b></br>
	 * Wenn beide Brueche <b>gleichwertig</b> sind: <b>0</b>
	 * @param b1 Bruch der betrachtet wird
	 * @param b2 Bruch mit dem verglichen wird
	 * @return int Wert der Kodierung
	 * @see #vorzeichenKorrektur(Bruch)
	 */
	public static int vergleicheBrueche(Bruch b1, Bruch b2){
		b1.vorzeichenKorrektur(b1);
		b2.vorzeichenKorrektur(b2);
		int zaehlerB1 = b1.zaehler * b2.nenner;
		int zaehlerB2 = b2.zaehler * b1.nenner;
		if(zaehlerB1 > zaehlerB2) {return 1;}		//macht man sowas oder lieber nicht?
		else if(zaehlerB1 < zaehlerB2) {return -1;}
		else {return 0;}
	}
	
	/**
	 * Methode <code>istGroesser</code> untersucht, ob das erste Argument Bruch 
	 * groesser ist als das zweite Argument Bruch
	 * @param b1 Bruch der betrachtet wird
	 * @param b2 Bruch mit dem verglichen wird
	 * @return boolean (b1 &gt; b2)
	 * @see #vergleicheBrueche(Bruch, Bruch)
	 */
	public static boolean istGroesser(Bruch b1, Bruch b2)
	{	
		return Bruch.vergleicheBrueche(b1, b2) == 1;
	}
	
	/**
	 * Methode <code>istKleiner</code> untersucht, ob das erste Argument Bruch 
	 * kleiner ist als das zweite Argument Bruch
	 * @param b1 Bruch der betrachtet wird
	 * @param b2 Bruch mit dem verglichen wird
	 * @return boolean (b1 &lt; b2)
	 * @see #vergleicheBrueche(Bruch, Bruch)
	 */
	public static boolean istKleiner(Bruch b1, Bruch b2)
	{	
		return Bruch.vergleicheBrueche(b1, b2) == -1;
	}
	
	/**
	 * Methode <code>sindGleich</code> vergleicht die Wertigkeit von zwei Bruechen,
	 * die als Argumente uebergeben werden. </br>
	 * <code>true</code>, wenn beide Brueche die gleiche Wertigkeit besitzen.
	 * @param b1 Bruch
	 * @param b2 Bruch
	 * @return boolean 
	 * @see #vergleicheBrueche(Bruch, Bruch)
	 */
	public static boolean sindGleich(Bruch b1, Bruch b2)
	{		
		return Bruch.vergleicheBrueche(b1, b2) == 0;
	}
}
