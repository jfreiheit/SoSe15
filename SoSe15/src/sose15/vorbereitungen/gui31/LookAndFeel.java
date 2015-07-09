package sose15.vorbereitungen.gui31;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class LookAndFeel extends JFrame {
   Box rbox;
   JPanel lpanel;

   JButton bmotif, bnativ, bcross, bnimbus;
   ButtonListener butLis = new ButtonListener();

   Container contentPane = getContentPane();
   
   public LookAndFeel() {

      super();
      // Hauptfenster einrichten
      setTitle("Look and Feel");
      contentPane.setBackground(Color.LIGHT_GRAY);
      contentPane.setLayout(new GridLayout(0,2));
      bmotif   = new JButton("Motif");

      String osName = System.getProperty("os.name");

      bnativ   = new JButton(osName);
      bcross   = new JButton("Cross-Platform (Metal)");
      bnimbus  = new JButton("Nimbus");
      bmotif.addActionListener(butLis);
      bnativ.addActionListener(butLis);
      bcross.addActionListener(butLis);
      bnimbus.addActionListener(butLis);

      // Rechte Grundfl�che mit Schaltfl�chen zum
      // Umschalten des Look&Feel

      // Box-Container mit vertikaler Ausrichtung
      rbox = Box.createVerticalBox();
      rbox.add(Box.createGlue());
      rbox.add(bmotif);
      rbox.add(bnativ);
      rbox.add(bcross);
      rbox.add(bnimbus);
      rbox.add(Box.createGlue());

      // Linke Grundfl�che zeigt lediglich einige Elemente
      //  zur Demonstration des Erscheinungsbildes
      // BoxLayout-Manager f�r linke Grundfl�che festlegen
      lpanel = new JPanel();
      lpanel.setLayout(new BoxLayout(lpanel, BoxLayout.Y_AXIS));

      JCheckBox chk1 = new JCheckBox("Unterstrichen");
      JCheckBox chk2 = new JCheckBox("Kursiv");
      JSlider slider = new JSlider(0,100);
      JRadioButton radio1 = new JRadioButton("Radio");
      JRadioButton radio2 = new JRadioButton("TV");

      lpanel.add(Box.createVerticalStrut(30));
      lpanel.add(chk1);
      lpanel.add(chk2);
      lpanel.add(slider);
      lpanel.add(radio1);
      lpanel.add(radio2);
      contentPane.add(lpanel);
      contentPane.add(rbox);

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setTitle("Look & Feel : " + UIManager.getLookAndFeel().getName());
   }

 

   // Hier Ereignisbehandlungsmethoden f�r Komponenten
   // Ereignisbehandlung f�r Schaltfl�chen zum Umschalten des Look&Feel
   private class ButtonListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {

       try {
         if (e.getSource()==bmotif) {
            UIManager.setLookAndFeel("com.sun.java.swing.pLookAndFeel.motif.MotifLookAndFeel");
         }

         if (e.getSource()==bnativ) {
             UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
         }

         if (e.getSource()==bcross) {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
         }

         if(e.getSource() == bnimbus) {
             UIManager.setLookAndFeel("com.sun.java.swing.pLookAndFeel.nimbus.NimbusLookAndFeel");
         }

         }
      catch(Exception ex) {
             System.err.println(ex.getMessage());
      }

      // Das neue Look&Feel allen Komponenten mitteilen
      SwingUtilities.updateComponentTreeUI(contentPane);
      setTitle("Look & Feel : " + UIManager.getLookAndFeel().getName());
      }

   }

   public static void main(String args[]) {
      // Fenster erzeugen und anzeigen
      LookAndFeel hauptfenster = new LookAndFeel();
      hauptfenster.setSize(400,200);
      hauptfenster.setLocation(200,300);
      hauptfenster.setVisible(true);
   }

}