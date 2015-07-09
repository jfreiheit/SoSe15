package sose15.vorbereitungen.gui31;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JToggleButton;

public class JToggleButtonDemo extends JFrame {
   Container contentPane = getContentPane();
   JToggleButton toggleButton;
   ButtonListener lauscher = new ButtonListener();

   public JToggleButtonDemo() {
      super();

      // Hauptfenster einrichten
      setTitle("JToggleButton-Demo");
      contentPane.setBackground(Color.lightGray);

      // Komponenten einf�gen
      toggleButton = new JToggleButton("Nicht ausgewählt");
      toggleButton.addItemListener(lauscher);

      contentPane.setLayout(new FlowLayout());
      contentPane.add(toggleButton);

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   // Ereignisbehandlungsmethoden f�r Komponenten
   class ButtonListener implements ItemListener {
      public void itemStateChanged(ItemEvent e) {
         int zustand = e.getStateChange();

         if(zustand == ItemEvent.SELECTED)
           toggleButton.setText("Ausgewählt");
         else
           toggleButton.setText("Nicht ausgewählt");
      }
   }

   public static void main(String args[]) {
      JToggleButtonDemo hauptfenster = new JToggleButtonDemo();
      hauptfenster.setSize(350,100);
      hauptfenster.setLocation(200,300);
      hauptfenster.setVisible(true);
   }
}