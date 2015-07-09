package sose15.vorbereitungen.uebungen.uebung7;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class MouseListenerLesson extends JFrame implements MouseListener{
	JLabel info;
	JPanel mainPanel;
	JPanel[] subPanel;
	int width, height;
	int rows, cols;
	JButton[] toolButtons;

	MouseListenerLesson(final int rows, final int cols)
	{
		super("MouseListener Lesson");

		this.rows = rows;
		this.cols = cols;

		JMenuBar myMenu = createMenu();
		this.setJMenuBar(myMenu);
		
		JPanel toolPanel = new JPanel();
		
		toolPanel.setLayout(new BoxLayout(toolPanel, BoxLayout.Y_AXIS));
		toolPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JToolBar buttonToolBar = createButtonToolBar();
		//buttonToolBar.setFloatable(true);
		//buttonToolBar.setRollover(true);
		toolPanel.add(buttonToolBar);
		
		JToolBar comboBoxToolBar = createComboBoxToolBar();
		toolPanel.add(comboBoxToolBar);
		
		this.add(toolPanel, BorderLayout.NORTH);
		
		mainPanel = initMainPanel(rows,cols);
		this.add(mainPanel, BorderLayout.CENTER);
		mainPanel.addMouseListener(this);

		info = new JLabel();
		this.add(info, BorderLayout.SOUTH);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,600);
		//this.pack();
		this.setVisible(true);
	}
	
	private JMenuBar createMenu()
	{
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("Panels");
		
		for(int i=0; i<rows*cols; i++)
		{
			JMenuItem jmi = new JMenuItem(Integer.valueOf(i).toString());
			
			jmi.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				int i = Integer.parseInt(cmd);
				subPanel[i].setBackground(new Color((float)Math.random(), (float)Math.random(), (float)Math.random()));	
				
			}});
			
			menu.add(jmi);		
		}
		JMenuItem jmi = new JMenuItem("Alle");
		jmi.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			for(int i=0; i<subPanel.length; i++)
			{
				subPanel[i].setBackground(new Color((float)Math.random(), (float)Math.random(), (float)Math.random()));	
			}
			
		}});
		menu.add(jmi);
		menubar.add(menu);

		
		return menubar;
	}

	private JToolBar createButtonToolBar()
	{
		JToolBar toolBar = new JToolBar();

		toolButtons = new JButton[rows*cols+1];
		for (int i=0; i<toolButtons.length-1; i++)
		{
			toolButtons[i] = new JButton(Integer.valueOf(i).toString());
			toolBar.add(toolButtons[i]);
			toolButtons[i].addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					String cmd = e.getActionCommand();
					int i = Integer.parseInt(cmd);
					subPanel[i].setBackground(new Color((float)Math.random(), (float)Math.random(), (float)Math.random()));	
				}

			});
		}

		toolButtons[toolButtons.length-1] = new JButton("Alle");
		toolBar.add(toolButtons[toolButtons.length-1]);
		toolButtons[toolButtons.length-1].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<subPanel.length; i++)
				{
					subPanel[i].setBackground(new Color((float)Math.random(), (float)Math.random(), (float)Math.random()));	
				}
			}
		});

		return toolBar;
	}
	
	private JToolBar createComboBoxToolBar()
	{
		JToolBar toolBar = new JToolBar();
		
		String[] choice = new String[rows*cols+1];
		for (int i=0; i<choice.length-1; i++)
		{
			choice[i] = Integer.valueOf(i).toString();
		}
		choice[choice.length-1] = "Alle";
		
		JComboBox<String> cb = new JComboBox<>(choice);
		cb.setOpaque(true);
		cb.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb = (JComboBox<String>)e.getSource();
		        String cmd = (String)cb.getSelectedItem();
		        try
		        {
				int i = Integer.parseInt(cmd);
				subPanel[i].setBackground(new Color((float)Math.random(), (float)Math.random(), (float)Math.random()));	
		        }
		        catch(NumberFormatException nfe)
		        {
		        	for(int i=0; i<subPanel.length; i++)
					{
						subPanel[i].setBackground(new Color((float)Math.random(), (float)Math.random(), (float)Math.random()));	
					}
		        }
				
			}});
		toolBar.add(cb);
		
		return toolBar;
	}

	JPanel initMainPanel(int cols, int rows)
	{
		JPanel mainPanel = new JPanel(new GridLayout(cols,rows));
		subPanel = new JPanel[cols*rows];
		for(int i=0; i<(cols*rows); i++)
		{
			subPanel[i] = new JPanel();
			subPanel[i].setBackground(new Color((float)Math.random(), (float)Math.random(), (float)Math.random()));
			mainPanel.add(subPanel[i]);
		}
		return mainPanel;
	}

	int whichPanelClicked(int x, int y)
	{
		width = mainPanel.getWidth();
		height = mainPanel.getHeight();
		//System.out.println(width + " , " + height);
		int row = y/(height/rows);
		int col = x/(width/cols);
		System.out.println("(w,h) = (" + width + " ," + height + ") --> (x,y) = (" + x + " ," + y + ") --> (r,c) = (" + row + " ," + col + ")");
		return row*cols + col;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int i = whichPanelClicked(e.getX(), e.getY());
		info.setText("clicked (" + i + ")");
		subPanel[i].setBackground(new Color((float)Math.random(), (float)Math.random(), (float)Math.random()));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//info.setText("pressed (" + e.getX() + " ," + getY() + ")");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//info.setText("released (" + e.getX() + " ," + getY() + ")");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new MouseListenerLesson(7,7);
	}

}
