package sose15.vorbereitungen.gui31;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
 
public class JCheckBoxDemo extends JFrame {
   ButtonListener lauscher = new ButtonListener();
   Label label = new Label();          // Beschriftungsfeld zur Anzeige des 
                                       // aktiviert. Kontrollk�stchens
   Box box = Box.createVerticalBox();  // Container f�r Kontrollk�stchen
   Panel panel = new Panel();          // Grundfl�che f�r Beschriftungsfeld
   JCheckBox eins, zwei, drei;
   String checkBoxText;                // Zeichenfolge f�r aktiviertes Kontrollk�stchen

   public JCheckBoxDemo() {
      super();

      // Hauptfenster einrichten
      setTitle("JCheckBox-Demo");
      getContentPane().setBackground(Color.LIGHT_GRAY);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Layout f�r Container festlegen
      getContentPane().setLayout(new BorderLayout());

      // Kontrollk�stchen erzeugen:
      eins = new JCheckBox("Eins");
      zwei = new JCheckBox("Zwei");
      drei = new JCheckBox("Drei");

      // Kontrollk�stchen in Grundfl�che einf�gen
      box.add(Box.createVerticalGlue());
      box.add(eins);
      box.add(zwei);
      box.add(drei);
      box.add(Box.createVerticalGlue());

      // Ereignisempf�nger registrieren
      eins.addItemListener(lauscher);
      zwei.addItemListener(lauscher);
      drei.addItemListener(lauscher);

      // Beschriftungsfeld f�r aktiviertes Kontrollk�stchen
      panel.setLayout(new GridLayout());
      checkBoxText = "";           // Anf�nglich leeres Beschriftungsfeld 
      label.setText(checkBoxText);

      // Ausrichtung f�r Beschriftungsfeld festlegen
      label.setAlignment(Label.LEFT);
      panel.add(label);

      // Grundfl�chen in JFrame hinzuf�gen
      getContentPane().add(box, BorderLayout.CENTER);
      getContentPane().add(panel, BorderLayout.SOUTH);
   }

   // Schaltfl�chenklicks auswerten
   class ButtonListener implements ItemListener {
      public void itemStateChanged(ItemEvent e) {
         String s = "Ausgewählt: ";
         
         // Feststellen, welche Kontrollk�stchen ausgew�hlt sind
         if (eins.isSelected()) s = s + " EINS";
         if (zwei.isSelected()) s = s + " ZWEI";
         if (drei.isSelected()) s = s + " DREI";
         
         // Ergebnis in Beschriftungsfeld anzeigen
         label.setText(s);
      }
   }



   public static void main(String args[]) {
      JCheckBoxDemo hauptfenster = new JCheckBoxDemo();
      hauptfenster.setSize(300,200);
      hauptfenster.setLocation(300,300);
      hauptfenster.setVisible(true);
   }
}
