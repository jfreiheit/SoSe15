package sose15.vorbereitungen.uebungen.uebung9;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.HashSet;
import java.util.Set;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MyApplication extends JFrame implements ChangeListener, MouseListener{
	
JPanel leftPanel, northPanel, rightPanel, southPanel, mainPanel;
int diameter = 50;
Shape shape;
Ellipse2D cur_circle;
Rectangle2D cur_square;
Set<Ellipse2D> circles;
Set<Rectangle2D> squares;

	
	MyApplication(String title)
	{
		super(title);
		
		shape = Shape.CIRCLE;
		circles = new HashSet<>();
		squares = new HashSet<>();
		
		JMenuBar myMenu = createMenu();
		this.setJMenuBar(myMenu);
		
		
		/*leftPanel = createLeftPanel();
		this.add(leftPanel, BorderLayout.WEST);
		
		rightPanel = createRightPanel();
		this.add(rightPanel, BorderLayout.EAST);*/
		
		northPanel = createNorthPanel();
		this.add(northPanel, BorderLayout.NORTH);
		
		/*southPanel = createSouthPanel();
		this.add(southPanel, BorderLayout.SOUTH);
		*/
		mainPanel = new DrawPanel();
		mainPanel.addMouseListener(this);
		this.add(mainPanel, BorderLayout.CENTER);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,600);
		//this.pack();
		this.setVisible(true);
	}
	
	private JMenuBar createMenu()
	{
		JMenuBar menubar = new JMenuBar();
		JMenu menu1 = new JMenu("Size");
		
		JMenuItem jmi100 = new JMenuItem("20");
		jmi100.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				MyApplication.this.diameter = 20;
				MyApplication.this.mainPanel.repaint();
			}});
			
		menu1.add(jmi100);		
	
		JMenuItem jmi200 = new JMenuItem("50");
		jmi200.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			MyApplication.this.diameter = 50;
			MyApplication.this.mainPanel.repaint();			
		}});
		menu1.add(jmi200);
		
		JMenuItem jmi300 = new JMenuItem("100");
		jmi300.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			MyApplication.this.diameter = 100;
			MyApplication.this.mainPanel.repaint();			
		}});
		menu1.add(jmi300);
		menubar.add(menu1);

		JMenu menu2 = new JMenu("Shape");
		
		JMenuItem jmiCircle = new JMenuItem("Circle");
		jmiCircle.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				MyApplication.this.shape = Shape.CIRCLE;
				//MyApplication.this.mainPanel.repaint();
			}});
			
		menu2.add(jmiCircle);		
	
		JMenuItem jmiRect = new JMenuItem("Rectangle");
		jmiRect.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			MyApplication.this.shape = Shape.RECTANGLE;
			//MyApplication.this.mainPanel.repaint();			
		}});
		menu2.add(jmiRect);
		
		menubar.add(menu2);
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
/*		panel.setBorder(new EmptyBorder(0,0,30,0));
		panel.setBackground(Color.RED);*/
		
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

		int diam = 50;
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
			diam +=50;
		}

		return toolBar;
	}
	
	private JToolBar createComboBoxToolBar()
	{
		JToolBar toolBar = new JToolBar();
		
		String[] choice = {"20", "50", "100", "150", "200"};
		
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
			Graphics2D g2 = (Graphics2D) g;
			for (Ellipse2D e : circles)
			{
				g2.fill((Ellipse2D.Float)e);
			}
			for (Rectangle2D e : squares)
			{
				g2.fill((Rectangle2D.Float)e);
			}
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
	
	// inner class Shape -> enum
	enum Shape
	{
		CIRCLE, RECTANGLE
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("clicked");
		float x = (float) e.getX();
		float y = (float) e.getY();
		float w = (float) diameter;
		float h = (float) diameter;
		if(shape==Shape.CIRCLE)
		{
			circles.add(new Ellipse2D.Float(x,y,w,h));
		}
		else if(shape==Shape.RECTANGLE)
		{
			squares.add(new Rectangle2D.Float(x,y,w,h));
		}
		mainPanel.repaint();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
