package sose15.vorbereitungen.gui31;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class JProgressBarDemo  extends JFrame  implements ActionListener, Runnable {
    private JButton button1;
    private JButton button2;
    private JProgressBar progressBar;
    private JPanel progressBarPanel;
    
    public JProgressBarDemo() {
        setTitle("JProgressBar-Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel2 = new JPanel();
        button1 = new JButton("Von 0 bis 100");
        button1.addActionListener(this); 
        button2 = new JButton("Unbestimmt");
        button2.addActionListener(this); 
        
        panel2.add(button1); 
        panel2.add(button2); 
        
        progressBarPanel = new JPanel();
        getContentPane().add(progressBarPanel,  BorderLayout.CENTER);
        getContentPane().add(panel2, BorderLayout.NORTH);
    }
    
    public void actionPerformed(ActionEvent e) {
        JButton quelle = (JButton) e.getSource();
        
        // Schalter deaktivieren
        button1.setEnabled(false);
        button2.setEnabled(false);
        
        // wir befinden uns im Event-Thread
        boolean unbestimmt = (quelle == button2); 
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        
        progressBar.setIndeterminate(unbestimmt);
        progressBar.setStringPainted(!unbestimmt);
        progressBarPanel.add(progressBar);
        revalidate();
        
        Thread thread = new Thread(this);
        thread.start();
    }
    
    public void run() {
        for(int i = 0; i < 100; i++) {
            try {
               // hier wird gearbeitet und die Fortschrittsanzeige aktualisiert
               final int fortschritt = i; 
               SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                       progressBar.setValue(fortschritt);  
                    }
               });
				
               Thread.sleep(100);
            }
            catch(Exception ex) {
            }
        }
        
        // Schalter deaktivieren
        button1.setEnabled(true);
        button2.setEnabled(true);
        
        progressBar.setVisible(false);
        progressBarPanel.remove(progressBar);
        revalidate();
    }
    
    public static void main(String[] args) {
      JProgressBarDemo hauptfenster = new JProgressBarDemo();
      hauptfenster.setSize(250,250);
      hauptfenster.setLocation(200,300);
      hauptfenster.setVisible(true);
    }
}
