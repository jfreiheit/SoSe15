package sose15.vorbereitungen.javadoc01;

/** 
 * Main-Klasse für Berechnungen
 * mit main-Methode
 * @author joernfreiheit
 *
 */
public class BerechnungenMain {

	public static void main(String[] args) {
		Berechnungen b1 = new Berechnungen();
		Berechnungen b2 = new Berechnungen(3,4);
		
		System.out.println(b1.multiplizieren());
		System.out.println(b2.multiplizieren());
		

	}

}
