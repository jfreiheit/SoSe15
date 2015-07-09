package sose15.vorbereitungen.gui31;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JListDemo extends JFrame {
   JList<String> liste;
   JScrollPane scrollPane;
   JLabel anzeigeLabel; 
 
   public JListDemo() {
      super();

      // Hauptfenster einrichten
      setTitle("JList-Demo");
      setBackground(Color.LIGHT_GRAY);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


      // Layout f�r Container festlegen
      setLayout(new BorderLayout());
      
      // Bezeichnungsfeld f�r Anzeige der ausgew�hlten Elemente
      Label elabel = new Label();

      // Grundfl�che f�r Listenfeld
      Panel lpanel = new Panel();

      // Grundfl�che f�r Button
      Panel bpanel = new Panel();
      JButton button = new JButton("Ans Ende");
      button.addActionListener(new AktionLauscher());
      bpanel.add(button);
      
      // Listenfeld 
      liste = new JList<String>();

      // Elemente in Array eintragen und in Liste hinzuf�gen
      String[] elemente = {"Eins", "Zwei", "Drei", "Vier", "Fünf", "Sechs",
                           "Sieben", "Acht", "Neun", "Zehn", "Elf", "Zwölf", 
                           "Dreizehn", "Vierzehn", "Fünfzehn"};

      liste.setListData(elemente);

      // Listenfeld in Grundfl�che einf�gen
      scrollPane = new JScrollPane(liste);
      lpanel.add(scrollPane) ;
      
      // Standardeintrag ausw�hlen
      liste.setSelectedIndex(11);
      liste.ensureIndexIsVisible(11);

      // Ereignisempf�nger registrieren
      AuswahlListener auswahlLauscher = new AuswahlListener();
      liste.addListSelectionListener(auswahlLauscher);
	  
      // Bezeichnungsfeld f�r aktiviertes Optionsfeld
      Panel anzeigePanel = new Panel();
      anzeigePanel.setLayout(new GridLayout());

      // Anf�nglich leeres Bezeichnungsfeld anzeigen
      anzeigeLabel = new JLabel("");

      // Bezeichnungsfeld in Panel einf�gen
      anzeigePanel.add(anzeigeLabel);

      // Grundfl�chen in Frame hinzuf�gen
      add(lpanel, BorderLayout.CENTER);
      add(anzeigePanel, BorderLayout.SOUTH);
      add(bpanel, BorderLayout.EAST);
   }

   class AktionLauscher implements ActionListener {
        public AktionLauscher() {
        }

        public void actionPerformed(ActionEvent e) {
           int anzahl = liste.getModel().getSize();
           liste.setSelectedIndex(anzahl-1);
           liste.ensureIndexIsVisible(anzahl-1);
        }
    }
   
   // Listenauswahlereignisse auswerten
   class AuswahlListener implements ListSelectionListener {
      public void valueChanged(ListSelectionEvent e) {
         if(e.getValueIsAdjusting() == false) {
            JList elemente         = (JList) e.getSource();
            java.util.List auswahl = elemente.getSelectedValuesList();
            String s = "Ausgewählt: "; 

            for(int i = 0; i < auswahl.size(); i++)
              s = s + auswahl.get(i) + " ";

            // Ergebnis in Bezeichnungsfeld anzeigen
            anzeigeLabel.setText(s);
         }       
      }
   }


   public static void main(String args[]) {
      JListDemo hauptfenster = new JListDemo();
      hauptfenster.setSize(250,250);
      hauptfenster.setLocation(200,300);
      hauptfenster.setVisible(true);
   }
}