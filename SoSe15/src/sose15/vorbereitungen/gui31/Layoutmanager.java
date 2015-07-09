package sose15.vorbereitungen.gui31;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

public class Layoutmanager extends JFrame implements ActionListener{

	JPanel panel;
	public Layoutmanager()
	{
		super("Layoutmanager");		// unser Fenster
		//setLayout(new FlowLayout());	// Layoutmanager
		//setLayout(new GridLayout(3,2,15,10)); //z, s, hgap, vgap
/*		add(new JButton("1"));
		add(new JButton("2"));
		add(new JButton("3"));
		add(new JButton("4"));
		add(new JButton("5"));
		add(new JButton("6"));*/
		
		// CardLayout
		/*panel=new JPanel();
		panel.setLayout(new CardLayout(10,10));	//hgap, vgap
		JButton b1 = new JButton("1");
		panel.add(b1);
		b1.addActionListener(this);
		JButton b2 = new JButton("2");
		panel.add(b2);
		b2.addActionListener(this);
		JButton b3 = new JButton("3");
		panel.add(b3);
		b3.addActionListener(this);
		JButton b4 = new JButton("4");
		panel.add(b4);
		b4.addActionListener(this);
		JButton b5 = new JButton("5");
		panel.add(b5);
		b5.addActionListener(this);
		JButton b6 = new JButton("6");
		panel.add(b6);
		b6.addActionListener(this);
		add(panel);*/
		
		//BorderLayout
		/* panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JButton nord = new JButton("Norden");
		JButton sued = new JButton("S�den");
		JButton ost = new JButton("Osten");
		JButton west = new JButton("Westen");
		JButton center = new JButton("Center");
		panel.add(nord, BorderLayout.NORTH);
		panel.add(ost, BorderLayout.EAST);
		panel.add(sued, BorderLayout.SOUTH);
		panel.add(west, BorderLayout.WEST);
		panel.add(center, BorderLayout.CENTER);
		add(panel);*/
		
		//OverlayLayout
		panel = new JPanel();
		OverlayLayout oll = new OverlayLayout(panel);
		panel.setLayout(oll);
		
		JButton klein = new JButton("klein");
		klein.setMaximumSize(new Dimension(50,50));
		panel.add(klein);
		
		JButton mittel = new JButton("mittel");
		klein.setMaximumSize(new Dimension(100,100));
		panel.add(mittel);
		
		JButton gross = new JButton("groß");
		klein.setMaximumSize(new Dimension(150,150));
		panel.add(gross);
		
		add(panel);
		
		//pack();			// kleinstm�gliches Fenster
		setSize(300,200);			// Gr��e selbst gesetzt
	}

	public static void main(String[] args) {
		Layoutmanager dialog = new Layoutmanager();
		dialog.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	    //CardLayout cl = (CardLayout)(panel.getLayout());
	    //cl.next(panel);
		
	}
}
