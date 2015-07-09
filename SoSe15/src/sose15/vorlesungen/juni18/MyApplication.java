package sose15.vorlesungen.juni18;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MyApplication extends JFrame implements ChangeListener{
	
JPanel leftPanel, northPanel, rightPanel, southPanel, mainPanel;
int diameter = 300;
	
	MyApplication(String title)
	{
		super(title);
		
		JMenuBar myMenu = createMenu();
		this.setJMenuBar(myMenu);
		
		
		leftPanel = createLeftPanel();
		this.add(leftPanel, BorderLayout.WEST);
		
		rightPanel = createRightPanel();
		this.add(rightPanel, BorderLayout.EAST);
		
		northPanel = createNorthPanel();
		this.add(northPanel, BorderLayout.NORTH);
		
		southPanel = createSouthPanel();
		this.add(southPanel, BorderLayout.SOUTH);
		
		mainPanel = new DrawPanel();
		this.add(mainPanel, BorderLayout.CENTER);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,600);
		//this.pack();
		this.setVisible(true);
	}
	
	private JMenuBar createMenu()
	{
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("Diameter");
		
		JMenuItem jmi100 = new JMenuItem("100");
		jmi100.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				MyApplication.this.diameter = 100;
				MyApplication.this.mainPanel.repaint();
			}});
			
		menu.add(jmi100);		
	
		JMenuItem jmi200 = new JMenuItem("200");
		jmi200.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			MyApplication.this.diameter = 200;
			MyApplication.this.mainPanel.repaint();			
		}});
		menu.add(jmi200);
		
		JMenuItem jmi300 = new JMenuItem("300");
		jmi300.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			MyApplication.this.diameter = 300;
			MyApplication.this.mainPanel.repaint();			
		}});
		menu.add(jmi300);
		menubar.add(menu);

		
		return menubar;
	}
	
	JPanel createLeftPanel()
	{
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(30, 30, 30, 30));
		panel.setBackground(Color.BLUE);
		
		//add control elements
		JLabel label = new JLabel("left Panel");
		label.setForeground(Color.WHITE);
		panel.add(label);
		
		return panel;
	}
	
	
	JPanel createRightPanel()
	{
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(30, 30, 30, 30));
		panel.setBackground(Color.GREEN);
		//add control elements
		JLabel label = new JLabel("right Panel");
		panel.add(label);
		return panel;
	}
	
	JPanel createNorthPanel()
	{
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.setBorder(new EmptyBorder(0,0,30,0));
		panel.setBackground(Color.RED);
		
		JPanel toolPanel = new JPanel();
		toolPanel.setLayout(new BoxLayout(toolPanel, BoxLayout.Y_AXIS));
		toolPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JToolBar buttonToolBar = createButtonToolBar();
		toolPanel.add(buttonToolBar);
		
		JToolBar comboBoxToolBar = createComboBoxToolBar();
		toolPanel.add(comboBoxToolBar);
		
		panel.add(toolPanel);
		
		return panel;
	}
	

	private JToolBar createButtonToolBar()
	{
		JToolBar toolBar = new JToolBar();

		int diam = 100;
		JButton[] toolButtons = new JButton[5];
		for (int i=0; i<toolButtons.length; i++)
		{
			toolButtons[i] = new JButton(Integer.valueOf(diam).toString());
			toolBar.add(toolButtons[i]);
			toolButtons[i].addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					String cmd = e.getActionCommand();
					MyApplication.this.diameter = Integer.parseInt(cmd);
					MyApplication.this.mainPanel.repaint();
				}

			});
			diam +=100;
		}

		return toolBar;
	}
	
	private JToolBar createComboBoxToolBar()
	{
		JToolBar toolBar = new JToolBar();
		
		String[] choice = {"100", "200", "300", "400", "500"};
		
		JComboBox<String> cb = new JComboBox<>(choice);
		cb.setOpaque(true);
		cb.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb = (JComboBox<String>)e.getSource();
		        String cmd = (String)cb.getSelectedItem();
		        try
		        {
		        	MyApplication.this.diameter = Integer.parseInt(cmd);
		        	MyApplication.this.mainPanel.repaint();
		        }
		        catch(NumberFormatException nfe)
		        {

		        }
				
			}});
		toolBar.add(cb);
		
		return toolBar;
	}
	
	JPanel createSouthPanel()
	{
		JPanel panel = new JPanel(new BorderLayout()); // von FlowLayout zu BorderLayout
		panel.setBorder(new EmptyBorder(30, 30, 30, 30));
		panel.setBackground(Color.GRAY);
		
		//add control elements
		JLabel labelNorth = new JLabel("lower Panel NORTH");
		labelNorth.setHorizontalAlignment(JLabel.CENTER);
		panel.add(labelNorth, BorderLayout.NORTH);
		
		JLabel labelEast = new JLabel("lower Panel EAST");
		panel.add(labelEast, BorderLayout.EAST);
		
		JSlider slider = new JSlider(200,400);
		slider.addChangeListener(this);
		panel.add(slider, BorderLayout.CENTER);
		
		JLabel labelSouth = new JLabel("lower Panel SOUTH");
		labelSouth.setHorizontalAlignment(JLabel.CENTER);
		panel.add(labelSouth, BorderLayout.SOUTH);
		
		JLabel labelWest = new JLabel("lower Panel WEST");
		panel.add(labelWest, BorderLayout.WEST);
		
		return panel;
	}
	
	private class DrawPanel extends JPanel
	{
		@Override
		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			
			int widthPanel = this.getWidth();
			int heightPanel = this.getHeight();
			int width = diameter;
			int height= diameter;			
			int x = (widthPanel-width)/2; 
			int y = (heightPanel-height)/2;

			Graphics2D g2 = (Graphics2D) g;
			
			g2.setStroke(new BasicStroke(3)); //Strichstärke auf 3
			g2.setColor(Color.BLACK);
			g2.drawOval(x, y, width, height);
			g2.setColor(Color.WHITE);
			g2.fillOval(x, y, width, height);
		}
	}

	public static void main(String[] args) {
		new MyApplication("My Application");

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider src = (JSlider) e.getSource();
		//if(!src.getValueIsAdjusting())
		{
			diameter = src.getValue();
			mainPanel.repaint();
		}
		
	}

}
