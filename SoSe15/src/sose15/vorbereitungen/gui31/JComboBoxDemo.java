package sose15.vorbereitungen.gui31;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JComboBoxDemo extends JFrame implements ItemListener{

	JLabel anzeigeLabel; 
	
    public JComboBoxDemo() {
        super();
        setTitle("JComboBox-Demo");
       
        String[] elemente = new String[]{"Null", "Eins", "Zwei", "Drei", "Vier", "Fünf"};

        JComboBox<String> combo = new JComboBox<String>(elemente);
        int anzahl      = combo.getItemCount();
        combo.setSelectedIndex(anzahl-1); // letzten Eintrag selektieren
        combo.addItemListener(this);
		
        JPanel panel = new JPanel();
        panel.add(combo);
       
        getContentPane().add(panel, BorderLayout.NORTH);
        
        anzeigeLabel = new JLabel();
        getContentPane().add(anzeigeLabel, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
   
    public static void main(String[] args) {
        JComboBoxDemo fenster = new JComboBoxDemo();
        fenster.setSize(300,200);
        fenster.setVisible(true);
    }

	@Override
	public void itemStateChanged(ItemEvent e) {
		int zustand = e.getStateChange();
		String s = "";
		if(zustand==ItemEvent.SELECTED)
			s="Ausgewählt: "+e.getItem();
		anzeigeLabel.setText(s);
	}
}