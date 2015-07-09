package sose15.vorbereitungen.menues;

import java.awt.*; 
import java.awt.event.*;

import javax.swing.*; 

public class MenuDemo extends JFrame 
implements ActionListener, ItemListener {

	// declare variables for global access
	private JCheckBoxMenuItem menuDateiCISymbolleiste;  
	private ButtonGroup menuDateiModus; 
	private JToolBar symbolLeiste;

	public MenuDemo() {
		super();
		setTitle("Menu-Demo");

		// insert components here

		// menu bar 
		JMenuBar menuLeiste = erzeugeMenueLeiste();     
		setJMenuBar(menuLeiste);

		// tool bar 
		symbolLeiste = erzeugeSymbolLeiste(); 
		getContentPane().add(symbolLeiste, BorderLayout.NORTH); 

		// listener for mouse events -> context menu
		KontextMenuLauscher kml = new KontextMenuLauscher(this); 
		addMouseListener(kml); 

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
	}


	// create menu bar
	private JMenuBar erzeugeMenueLeiste()  {
		JMenuBar menueLeiste = new JMenuBar();
		JMenu menuInfo = new JMenu("Program-Info"); 

		// Menu File
		JMenu menuDatei = new JMenu("File");
		JMenuItem menuDateiOeffnen = new JMenuItem("File open", new ImageIcon("bilder/middle.gif"));
		menuDateiOeffnen.addActionListener(this); 
		JMenuItem menuDateiSpeichern = new JMenuItem("File save", new ImageIcon("bilder/Save.gif"));
		menuDateiSpeichern.addActionListener(this); 

		menuDateiModus = new ButtonGroup();
		JRadioButtonMenuItem  menuDateiRBNormal = new JRadioButtonMenuItem("Normal", true);
		JRadioButtonMenuItem  menuDateiRBProfi = new JRadioButtonMenuItem("Profi", false);
		JRadioButtonMenuItem  menuDateiRBGuru = new JRadioButtonMenuItem("Guru", false);
		menuDateiModus.add(menuDateiRBNormal);
		menuDateiModus.add(menuDateiRBProfi);
		menuDateiModus.add(menuDateiRBGuru);

		menuDateiCISymbolleiste = new JCheckBoxMenuItem("Toolbar"); 
		menuDateiCISymbolleiste.setSelected(true); 
		menuDateiCISymbolleiste.addItemListener(this); 

		// submenu file/extras
		JMenu menuDateiExtras = new JMenu("Extras"); 
		JMenuItem menuDateiExtrasPfade = new JMenuItem("Path",'P');
		menuDateiExtrasPfade.addActionListener(this); 
		JMenuItem menuDateiExtrasFarben = new JMenuItem("Color",'F');
		menuDateiExtrasFarben.addActionListener(this); 
		JMenuItem menuDateiExtrasSprache = new JMenuItem("Language",'L');
		menuDateiExtrasSprache.addActionListener(this); 

		// create accelerators for path, color, language
		KeyStroke ks = KeyStroke.getKeyStroke(KeyEvent.VK_F1,0); 
		menuDateiExtrasPfade.setAccelerator(ks);
		ks = KeyStroke.getKeyStroke('F',Event.CTRL_MASK); 
		menuDateiExtrasFarben.setAccelerator(ks);
		ks = KeyStroke.getKeyStroke('L',Event.SHIFT_MASK); 
		menuDateiExtrasSprache.setAccelerator(ks);

		// prepared but not used yet -> try!
		KeyStroke ctrl_p = KeyStroke.getKeyStroke('P', Event.CTRL_MASK);
		KeyStroke manager = KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, Event.CTRL_MASK+Event.ALT_MASK);
		KeyStroke copy = KeyStroke.getKeyStroke('C', Event.CTRL_MASK);

		JMenuItem menuDateiBeenden = new JMenuItem("Exit");
		menuDateiBeenden.addActionListener(this); 


		// gather menu file
		menuDatei.add(menuDateiOeffnen);
		menuDatei.add(menuDateiSpeichern);
		menuDatei.addSeparator();
		menuDatei.add(menuDateiRBNormal);
		menuDatei.add(menuDateiRBProfi);
		menuDatei.add(menuDateiRBGuru);
		menuDatei.addSeparator();
		menuDatei.add(menuDateiCISymbolleiste);
		menuDatei.add(menuDateiExtras);
		menuDatei.addSeparator();
		menuDatei.add(menuDateiBeenden);

		// gather submenu extras
		menuDateiExtras.add(menuDateiExtrasPfade); 
		menuDateiExtras.add(menuDateiExtrasFarben); 
		menuDateiExtras.add(menuDateiExtrasSprache); 

		// gather menu bar 
		menueLeiste.add(menuInfo);  
		menueLeiste.add(menuDatei);

		return menueLeiste; 
	}


	// create tool bar 
	private JToolBar erzeugeSymbolLeiste() {
		JToolBar symbolLeiste = new JToolBar();

		JButton btnOeffnen = new JButton(new ImageIcon("bilder/open.gif"));
		btnOeffnen.setActionCommand("File open"); 
		btnOeffnen.setToolTipText("opens a file"); 
		symbolLeiste.add(btnOeffnen);
		btnOeffnen.addActionListener(this); 

		JButton btnSpeichern = new JButton(new ImageIcon("bilder/SAVE.GIF"));
		btnSpeichern.setActionCommand("File save"); 
		btnSpeichern.setToolTipText("saves the current file"); 
		symbolLeiste.add(btnSpeichern);
		btnSpeichern.addActionListener(this); 
		return symbolLeiste;
	}


	// event handler for components

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Exit"))
			System.exit(0); 

		// the other commands are just printed
		System.out.println(e.getActionCommand());
	}

	public void itemStateChanged(ItemEvent e) {
		Object item = e.getItemSelectable();

		if(item == menuDateiCISymbolleiste) {
			if(e.getStateChange() == ItemEvent.DESELECTED) 
				getContentPane().remove(symbolLeiste);  
			else
				getContentPane().add(symbolLeiste,BorderLayout.NORTH);  

			repaint(); 
		}
	}

	// further classes

	// context menu handling 
	protected final class KontextMenuLauscher extends MouseAdapter 
	{
		MenuDemo fenster;

		KontextMenuLauscher(MenuDemo f) {
			fenster = f; 
		}

		public void mouseReleased(MouseEvent e) {
/*
			if(e.isPopupTrigger() == true) {
				// create context menu  
				erzeugeKontextMenue(e);  
			}*/
		}

		public void mousePressed(MouseEvent e) {

			if(e.isPopupTrigger() == true) 
			{
				// create context menu  
				erzeugeKontextMenue(e);  
			}
		}



		// create context menu and show it
		private void erzeugeKontextMenue(MouseEvent e) 
		{
			JPopupMenu popup = new JPopupMenu(); 

			JMenuItem popupKopieren = new JMenuItem("Copy");
			popupKopieren.addActionListener(fenster);

			JMenuItem popupEinfuegen = new JMenuItem("Paste");
			popupEinfuegen.addActionListener(fenster);

			JMenuItem popupEnde = new JMenuItem("Exit");
			popupEnde.addActionListener(fenster);

			popup.add(popupKopieren);
			popup.add(popupEinfuegen);
			popup.addSeparator();
			popup.add(popupEnde);

			// show at current mouse position
			popup.show(e.getComponent(), e.getX(), e.getY());
		}

	}



	public static void main(String args[]) {
		// Fenster erzeugen und anzeigen
		MenuDemo hauptfenster = new MenuDemo();
		hauptfenster.setSize(400,350);                  // oder pack()    
		hauptfenster.setLocation(200,300);   
		hauptfenster.setVisible(true); 
	}

}

