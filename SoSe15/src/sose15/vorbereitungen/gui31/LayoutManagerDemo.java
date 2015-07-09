package sose15.vorbereitungen.gui31;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.OverlayLayout;


public class LayoutManagerDemo extends JFrame implements ActionListener {
	private final String TITEL = "LayoutManager Demo";
	private JPanel anzeigePanel;  
	private JPanel buttonPanel;

	public LayoutManagerDemo() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(TITEL);
		this.setSize(new Dimension(400,300));

		setJMenuBar(erzeugeMenueLeiste());

		anzeigePanel = new JPanel();
		getContentPane().add(anzeigePanel, BorderLayout.CENTER);


		addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent arg0) {
				Dimension containerDim = getSize();

				Dimension panelDim   = anzeigePanel.getSize();
				Dimension dimNeu     = new Dimension(containerDim.width, panelDim.height);
				anzeigePanel.setPreferredSize(dimNeu);
				revalidate();
			}           
		});
	}

	private JMenuBar erzeugeMenueLeiste() {
		JMenuBar menuBar = new JMenuBar();
		JMenu layout     = new JMenu("Layout");

		JMenuItem flowLayoutItem    = new JMenuItem("FlowLayout");
		JMenuItem borderLayoutItem  = new JMenuItem("BorderLayout");
		JMenuItem gridLayoutItem    = new JMenuItem("GridLayout");
		JMenuItem overlayLayoutItem = new JMenuItem("OverlayLayout");
		JMenuItem groupLayoutItem   = new JMenuItem("GroupLayout");
		JMenuItem boxLayoutItem     = new JMenuItem("BoxLayout");
		JMenuItem cardLayoutItem     = new JMenuItem("CardLayout");

		layout.add(flowLayoutItem);
		layout.add(borderLayoutItem);
		layout.add(gridLayoutItem);
		layout.add(overlayLayoutItem);
		layout.add(groupLayoutItem);
		layout.add(boxLayoutItem);
		layout.add(cardLayoutItem);

		menuBar.add(layout);

		// Ereignisbehandlung
		flowLayoutItem.addActionListener(this);
		borderLayoutItem.addActionListener(this);
		gridLayoutItem.addActionListener(this);
		overlayLayoutItem.addActionListener(this);
		groupLayoutItem.addActionListener(this);
		boxLayoutItem.addActionListener(this);
		cardLayoutItem.addActionListener(this);
		return menuBar; 
	}

	private JPanel erzeugeAuswahlPanel() {
		JPanel panel    = new JPanel();
		JButton button1 = new JButton("FlowLayout");
		panel.add(button1); 

		return panel; 
	}


	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if(source instanceof JMenuItem)
		{
		String actionCommand = event.getActionCommand();
		JPanel panel         = null;
		getContentPane().remove(anzeigePanel); 

		switch(actionCommand) {
		case "FlowLayout"    : anzeigePanel = erzeugeFlowLayout();
		break;
		case "GridLayout"    : anzeigePanel = erzeugeGridLayout();
		break; 
		case "BorderLayout"  : anzeigePanel = erzeugeBorderLayout();
		break; 
		case "OverlayLayout" : anzeigePanel = erzeugeOverlayLayout();                              
		break; 
		case "GroupLayout"   : anzeigePanel = erzeugeGroupLayout();
		break;
		case "BoxLayout"     : anzeigePanel = erzeugeBoxLayout();
		break;
		case "CardLayout"     : anzeigePanel = erzeugeCardLayout();
		break;
		default:
		}

		setTitle(TITEL + " - " +  actionCommand);
		getContentPane().add(anzeigePanel, BorderLayout.CENTER);

		revalidate();
		}
		else if(source instanceof JButton)
		{
			if(anzeigePanel.getLayout() instanceof CardLayout)
			{
				CardLayout cl = 	(CardLayout)(anzeigePanel.getLayout());
			    cl.next(anzeigePanel);

			}
		}
	}

	public static void main(String[] args) {
		LayoutManagerDemo fenster = new LayoutManagerDemo();
		fenster.setPreferredSize(new Dimension(400,300)); 
		fenster.setVisible(true); 
	}

	private JPanel erzeugeBoxLayout() {
		JPanel panel = new JPanel();

		Box  box = Box.createVerticalBox();
		box.add(Box.createGlue());

		JButton button1 = new JButton("1");
		JButton button2 = new JButton("2");
		JButton button3 = new JButton("3");
		JButton button4 = new JButton("Ganz langer Text");

		box.add(button1);
		box.add(button2);
		box.add(button3);
		box.add(button4);
		box.add(Box.createGlue());

		panel.add(box);         

		return panel; 
	}

	private JPanel erzeugeGroupLayout() {
		JPanel panel = new JPanel();  
		GroupLayout groupLayout = new GroupLayout(panel); 
		panel.setLayout(groupLayout);

		JLabel label1       = new JLabel("Benutzername");
		JTextField textFeld = new JTextField("username");
		JLabel label2        = new JLabel("Passwort");
		JPasswordField passwortFeld = new JPasswordField(10);

		// automatische Abstande
		groupLayout.setAutoCreateGaps(true);
		groupLayout.setAutoCreateContainerGaps(true);


		GroupLayout.SequentialGroup horizGruppe = groupLayout.createSequentialGroup();
		GroupLayout.ParallelGroup hsub1 = groupLayout.createParallelGroup();
		hsub1.addComponent(label1);
		hsub1.addComponent(label2);
		GroupLayout.ParallelGroup hsub2 = groupLayout.createParallelGroup();
		hsub2.addComponent(textFeld);
		hsub2.addComponent(passwortFeld);
		horizGruppe.addGroup(hsub1);
		horizGruppe.addGroup(hsub2);


		GroupLayout.SequentialGroup vertGruppe = groupLayout.createSequentialGroup();
		GroupLayout.ParallelGroup vsub1 = groupLayout.createParallelGroup();
		vsub1.addComponent(label1);
		vsub1.addComponent(textFeld);
		GroupLayout.ParallelGroup vsub2 = groupLayout.createParallelGroup();
		vsub2.addComponent(label2);
		vsub2.addComponent(passwortFeld);

		vertGruppe.addGroup(vsub1);
		vertGruppe.addGroup(vsub2);

		groupLayout.setHorizontalGroup(horizGruppe);
		groupLayout.setVerticalGroup(vertGruppe);

		JPanel gesamt = new JPanel();
		gesamt.add(panel); 
		return gesamt; 
	}


	private JPanel erzeugeFlowLayout() {
		JPanel panel = new JPanel(); 

		// JPanel hat bereits FlowLayout; nur zur Demo hier:
		FlowLayout flowLayout = new FlowLayout();
		panel.setLayout(flowLayout);

		List<JButton> buttons = erzeugeButtons();

		for(JButton button : buttons) {
			panel.add(button);
		}

		return panel;
	}

	private JPanel erzeugeGridLayout() {
		JPanel panel = new JPanel();
		GridLayout gridLayout = new GridLayout(0, 3, 10, 10 );
		panel.setLayout(gridLayout);

		List<JButton> buttons = erzeugeButtons();

		for(JButton button : buttons) {
			panel.add(button);
		}

		return panel; 
	}

	private JPanel erzeugeOverlayLayout() {
		JPanel panel = new JPanel();
		OverlayLayout overlayLayout = new OverlayLayout(panel);
		panel.setLayout(overlayLayout);


		JButton klein = new JButton("Klein");
		klein.setMaximumSize(new Dimension(100, 100));
		panel.add(klein);


		JButton mittel = new JButton("Mittel");
		mittel.setMaximumSize(new Dimension(200, 200));
		panel.add(mittel);


		JButton gross = new JButton("Groß");
		gross.setMaximumSize(new Dimension(300, 300));
		panel.add(gross);

		return panel; 
	}

	private JPanel erzeugeBorderLayout() {
		JPanel panel = new JPanel();
		BorderLayout borderLayout = new BorderLayout();
		panel.setLayout(borderLayout);
		JButton nord   = new JButton("Norden");
		JButton sued   = new JButton("Süden");
		JButton ost    = new JButton("Osten");
		JButton west   = new JButton("Westen"); 
		JButton center = new JButton("Center");
		panel.add(nord, BorderLayout.NORTH);
		panel.add(sued, BorderLayout.SOUTH);
		panel.add(ost, BorderLayout.EAST);
		panel.add(west, BorderLayout.WEST);
		panel.add(center, BorderLayout.CENTER);

		return panel; 
	}


	private List<JButton> erzeugeButtons() {
		List<JButton> buttons = new ArrayList<>();

		for(int i = 1; i <= 9; i++) {
			JButton button = new JButton(String.valueOf(i));
			buttons.add(button);
		}

		JButton button = new JButton("*");
		buttons.add(button);
		button = new JButton("0");
		buttons.add(button);
		button = new JButton("#");
		buttons.add(button); 

		return buttons; 
	}


	private JPanel erzeugeCardLayout() {
		JPanel panel = new JPanel(); 

		CardLayout cardLayout = new CardLayout(10,10);
		panel.setLayout(cardLayout);

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
		add(panel);


		return panel;
	}
}
