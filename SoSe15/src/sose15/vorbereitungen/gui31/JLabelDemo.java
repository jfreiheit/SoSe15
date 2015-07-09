package sose15.vorbereitungen.gui31;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class JLabelDemo extends JFrame {

   public JLabelDemo() {
      super();

      setTitle("JLabel-Demo");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      ImageIcon icon   = new ImageIcon("java_logo.png"); // in den Projektordner legen!
      JLabel label1    = new JLabel("Label 1", icon, SwingConstants.RIGHT);       
      JLabel label2    = new JLabel();    
      JLabel label3    = new JLabel("Label 3"); 
      JLabel label4    = new JLabel("Label 4", icon, SwingConstants.LEFT); 

      label2.setIcon(icon);
      label4.setHorizontalTextPosition(SwingConstants.LEADING);

      JPanel panel = new JPanel();
      panel.setBackground(Color.WHITE);
      panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
      panel.add(label1);
      panel.add(new JSeparator());
      panel.add(label2);
      panel.add(new JSeparator());
      panel.add(label3);
      panel.add(new JSeparator());
      panel.add(label4);
      getContentPane().add(panel);
    }

   public static void main(String args[]) {
      JLabelDemo hauptfenster = new JLabelDemo();
      hauptfenster.setSize(250, 450);
      hauptfenster.setLocation(200,350);
      hauptfenster.setVisible(true);
   }
}
