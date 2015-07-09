package sose15.vorbereitungen.gui31;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class JRadioButtonDemo extends JFrame {
   JLabel anzeigeLabel;

   public JRadioButtonDemo() {
      super();

      // Hauptfenster einrichten
      setTitle("JRadioButton-Demo");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // RadioButtons erzeugen und in Gruppe einf�gen
      ActionListener buttonLauscher = new MeinActionListener();

      JRadioButton eins = new JRadioButton("Eins");
      eins.addActionListener(buttonLauscher);
      eins.setSelected(true);
      
      JRadioButton zwei = new JRadioButton("Zwei");
      zwei.addActionListener(buttonLauscher);
      JRadioButton drei = new JRadioButton("Drei");
      drei.addActionListener(buttonLauscher);

      ButtonGroup gruppe = new ButtonGroup();
      gruppe.add(eins);
      gruppe.add(zwei);
      gruppe.add(drei);

      // Optionsfelder in Grundfl�che einf�gen
      Box box = new Box(BoxLayout.Y_AXIS);
      box.add(Box.createVerticalGlue());
      box.add(eins);
      box.add(zwei);
      box.add(drei);
      box.add(Box.createVerticalGlue());  

      JPanel panel1 = new JPanel();
      panel1.add(box);

      JPanel panel2 = new JPanel();
      anzeigeLabel = new JLabel("Ausgewählt ist: " + eins.getActionCommand());
      panel2.add(anzeigeLabel);   
	  
      getContentPane().add(panel1, BorderLayout.NORTH);
      getContentPane().add(panel2, BorderLayout.SOUTH);
   }

   class MeinActionListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
        JRadioButton button = (JRadioButton) e.getSource();
        String ausgewaehlt = button.getActionCommand();
        anzeigeLabel.setText("Ausgew�hlt ist: " + ausgewaehlt);
      }

   }

   public static void main(String args[]) {
      JRadioButtonDemo hauptfenster = new JRadioButtonDemo();
      hauptfenster.setSize(250,250);
      hauptfenster.setLocation(200,300);
      hauptfenster.setVisible(true);
   }
}