package sose15.vorbereitungen.gui31;

import java.awt.Color;
import java.awt.Container;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class ButtonGroupDemo extends javax.swing.JFrame {
   Container contentPane = getContentPane();
   ButtonGroup gruppe = new ButtonGroup();
   Box box = Box.createVerticalBox();
   JToggleButton eins, zwei, drei;

   public ButtonGroupDemo() {
      super();

      // Hauptfenster einrichten
      setTitle("ButtonGroup-Demo");
      contentPane.setBackground(Color.LIGHT_GRAY);

      // Wechselschalter erzeugen und in Gruppe einf�gen
      // Der erste Schalter wird anfangs ausgew�hlt
      eins = new JToggleButton("Nummer 1", true);
      zwei = new JToggleButton("Nummer 2");
      drei = new JToggleButton("Nummer 3");
      gruppe.add(eins);
      gruppe.add(zwei);
      gruppe.add(drei);

      // Wechselschalter in Box einf�gen
      box.add(Box.createVerticalGlue());
      box.add(eins);
      box.add(zwei);
      box.add(drei);
      box.add(Box.createVerticalGlue());

	   JPanel panel = new JPanel();
	   panel.add(box);
      contentPane.add(panel);

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public static void main(String args[]) {
      ButtonGroupDemo hauptfenster = new ButtonGroupDemo();
      hauptfenster.setSize(300,200);
      hauptfenster.setLocation(200,300);
      hauptfenster.setVisible(true);
   }
}
