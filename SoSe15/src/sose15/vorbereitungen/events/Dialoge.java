package sose15.vorbereitungen.events;

import java.awt.Color;

import javax.swing.*;

public class Dialoge {

	public static void main(String[] args) {

		Color ausgewaehlteFarbe = 	JColorChooser.showDialog(null, "Farbauswahl", null);
// statische Methode der Klasse JColorChooser
		System.out.println(ausgewaehlteFarbe);




	}

}
