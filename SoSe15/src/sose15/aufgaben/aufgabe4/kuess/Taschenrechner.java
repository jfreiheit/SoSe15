package sose15.aufgaben.aufgabe4.kuess;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


@SuppressWarnings("serial")
public class Taschenrechner extends JFrame {

	JPanel buttonPanel;
	JPanel textPanel;
	JPanel operatorPanel;
	JButton button;
	JTextField textfield;
	boolean start;
	String op1;
	String op2;
	ArrayList<String> elements =new ArrayList<>();



	/**
	 * Constructor of the calculator. 
	 */
	Taschenrechner(){
		super("Taschenrechner");
		
		textPanel = initTextPanel();
		this.add(textPanel, BorderLayout.NORTH);

		buttonPanel = initButtonPanel();
		this.add(buttonPanel, BorderLayout.CENTER);

		operatorPanel = initOperatorPanel();
		this.add(operatorPanel, BorderLayout.SOUTH);

		pack();
		this.setVisible(true);		
	}

	/**
	 * Initiates the panel (Gridlayout) with the buttons "0" - "9", "." and "C".
	 * @return JPanel
	 */
	private JPanel initButtonPanel(){ 
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 3, 5, 5));
		panel.setBackground(Color.BLUE);
		ActionListener insert = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				if (start){
					if(!(e.getActionCommand()=="C" || e.getActionCommand()==".")){
						textfield.setText(e.getActionCommand());
						start=false;
					}else{
						textfield.setText("0");
						start=true;
					}
				}else{
					if(e.getActionCommand()=="C"){
						elements.clear();
						textfield.setText("0");
					}
					else{
						if(!(e.getActionCommand()==".") || !(textfield.getText().contains("."))){
							textfield.setText(textfield.getText()+e.getActionCommand());
						}
					}
					if (textfield.getText().startsWith("0")&& !start && !(textfield.getText().charAt(1)=='.')){
						textfield.setText(textfield.getText().substring(1));
					}
				}
			}

		};


		panel.add(addButton("7", insert));
		panel.add(addButton("8", insert));
		panel.add(addButton("9", insert));

		panel.add(addButton("4", insert));
		panel.add(addButton("5", insert));
		panel.add(addButton("6", insert));

		panel.add(addButton("1", insert));
		panel.add(addButton("2", insert));
		panel.add(addButton("3", insert));

		panel.add(addButton("C", insert));
		panel.add(addButton("0", insert));
		panel.add(addButton(".", insert));

		return panel;
	}

	/**
	 * Initiates the panel (Borderlayout) with the operators for calculating (namely "+", "-", "*", "/","="). 
	 * @return JPanel
	 */
	private JPanel initOperatorPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(5,5));
		panel.setBackground(Color.BLUE);

		ActionListener calculate = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				if(start && e.getActionCommand()=="-"){
					textfield.setText("-");
					start=false;
				}else{

					elements.add(textfield.getText());

					if(elements.size()==1){								//erst eine Zahl eingegeben
						if (e.getActionCommand()=="="){					//wenn operator = wird die eingegebene Zahl ausgegeben
							getResult();
						}else{
							op1 = e.getActionCommand();
						}
					}

					if(elements.size()== 2){
						if (e.getActionCommand()=="="){
							elements.set(0, (calculate(Double.parseDouble(elements.get(0)), Double.parseDouble(elements.get(1)), op1)));
							getResult();
						}else{
							if (op1=="*" || op1 == "/"){
								elements.set(0, (calculate(Double.parseDouble(elements.get(0)), Double.parseDouble(elements.get(1)), op1)));
								elements.remove(1);
								op1 = e.getActionCommand();
							}else{
								op2 = e.getActionCommand();
							}
						}
					}

					if(elements.size() == 3){
						if (e.getActionCommand()== "="){
							elements.set(1, (calculate(Double.parseDouble(elements.get(1)), Double.parseDouble(elements.get(2)), op2)));
							elements.set(0, (calculate(Double.parseDouble(elements.get(0)), Double.parseDouble(elements.get(1)), op1)));
							getResult();
						}else{
							if (op2 == "*" || op2 == "/"){
								elements.set(1, (calculate(Double.parseDouble(elements.get(1)), Double.parseDouble(elements.get(2)), op2)));
								elements.remove(2);
								op2 = e.getActionCommand();
							}else{
								elements.set(0, (calculate(Double.parseDouble(elements.get(0)), Double.parseDouble(elements.get(1)), op1)));
								elements.set(1, elements.get(2));
								elements.remove(2);
								op1 = op2;
								op2 = e.getActionCommand();
							}
						}
					}
					start = true;
				}
			}
		};

		panel.add(addButton("*", calculate), BorderLayout.NORTH);
		panel.add(addButton("/", calculate), BorderLayout.SOUTH);
		panel.add(addButton("+", calculate), BorderLayout.EAST);
		panel.add(addButton("-", calculate), BorderLayout.WEST);
		panel.add(addButton("=", calculate), BorderLayout.CENTER);

		return panel;
	}

	/**
	 * Used in a panel to create and add a button with the name specified in the parameter and activate the corresponding listener,
	 * also specified in the corresponding parameter
	 * @param String text - name of button
	 * @param ActionListener listener
	 * @return JButton
	 */
	private JButton addButton(String text, ActionListener listener){

		button = new JButton(text);
		button.setFont(new Font("Lucida Console", Font.BOLD, 40));
		button.setForeground(Color.GREEN);
		button.setBackground(Color.BLACK);
		button.addActionListener(listener);
		return button;	
	}

	/**
	 * Initiates the Panel (Flowlayout) in which the text field of the calculator is set. 
	 * @return JPanel
	 */
	private JPanel initTextPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(5));
		panel.setBackground(Color.BLUE);
		textfield = initTextField();
		panel.add(textfield);
		return panel;
	}
	
	/**
	 * Initiates the text field of the calculator. 
	 * @return JTextField
	 */
	private JTextField initTextField(){

		JTextField text = new JTextField("0", 15);
		text.setHorizontalAlignment(JTextField.RIGHT);
		text.setBackground(Color.BLACK);
		text.setFont(new Font ("Simplified Arabic", Font.BOLD, 50));
		text.setEnabled(false);
		start = true;
		return text;
	}

	/**
	 * Does the calculation of two values (given in parameter) and an operator (parameter). Returns the result
	 * in int if no data is lost. 
	 * @param double nbr1
	 * @param double nbr2
	 * @param String operator
	 * @return double/int result
	 */
	private String calculate(double nbr1, double nbr2, String operator){
		double calc = 0.0;
		switch (operator){
		case "+": calc = nbr1 + nbr2;
		break;
		case "-": calc = nbr1- nbr2;
		break;
		case "*": calc = nbr1 * nbr2;
		break;
		case "/": calc = nbr1/nbr2;
		break;
		}
		if (calc%1 == 0){
			int value = new Double(calc).intValue();
			return String.valueOf(value);
		}else{
			return String.valueOf(calc);
		}
	}

	/**
	 * Displays the result of a calculation, which is stored at index [0] of the list, in the text field. 
	 * Empties the list afterwards. 
	 */
	private void getResult(){
		textfield.setText(elements.get(0));
		elements.clear();			
	}


}
