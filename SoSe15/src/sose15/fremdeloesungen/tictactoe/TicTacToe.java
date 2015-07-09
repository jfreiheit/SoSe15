package sose15.fremdeloesungen.tictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TicTacToe extends JFrame implements ActionListener{

	JLabel instructionLabel;
	JPanel labelPanel;
	JButton[] buttonArr = new JButton[9];
	boolean blackPlaying = false;
	boolean endOfGame = false;

	private TicTacToe(){
		//super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Tic Tac Toe");
		this.setSize(500, 570);

		this.add(initInstrucionLabel(), BorderLayout.NORTH);
		this.add(initGameField(), BorderLayout.CENTER);
		this.add(initOptionPanel(), BorderLayout.SOUTH);

		this.setVisible(true);
	}

	private JPanel initInstrucionLabel(){
		labelPanel = new JPanel();
		instructionLabel = new JLabel(" ");
		labelPanel.add(instructionLabel);
		labelPanel.setBackground(Color.WHITE);
		instructionLabel.setHorizontalAlignment(JLabel.CENTER);
		labelPanel.setBorder(new EmptyBorder(15, 30, 15, 30));
		instructionLabel.setFont(new Font("Arial Black", Font.BOLD, 26));
		return labelPanel;
	}

	private JPanel initGameField(){
		JPanel gameField = new JPanel();
		gameField.setBackground(new Color(42,144,145));
		gameField.setBorder(new EmptyBorder(20, 40, 20, 40));
		gameField.setLayout(new GridLayout(3, 3, 5, 5));

		for(int i = 0; i < buttonArr.length; i++){
			buttonArr[i] = new JButton();
			buttonArr[i].setFont(new Font("Arial Black", Font.BOLD, 60));
			buttonArr[i].addActionListener(this); //dem Fenster hinzufügen
			buttonArr[i].setActionCommand((new Integer(i)).toString()); //besser als valueOf??
			gameField.add(buttonArr[i]);
		}
		return gameField;
	}		

	private JPanel initOptionPanel(){
		JPanel optionPanel = new JPanel();
		optionPanel.setBackground(new Color(88, 235, 237));
		optionPanel.setBorder(new EmptyBorder(20, 20, 15, 20));
		JButton redStarts = new JButton("Rot beginnt");
		JButton blackStarts = new JButton("Schwarz beginnt");
		optionPanel.add(redStarts);
		optionPanel.add(blackStarts);
		redStarts.setActionCommand("rs"); //besser als valueOf??
		redStarts.addActionListener(this);
		blackStarts.setActionCommand("bs");
		blackStarts.addActionListener(this);
		return optionPanel;
	}

	/**
	 * Starts the Game, when pressing an option button.
	 * @param command ActionCommand of option-button
	 */
	private void startGame(String command){
		reset();
		switch(command){
		case "rs":
			instructionLabel.setForeground(Color.RED);
			instructionLabel.setText("Rot beginnt");
			blackPlaying = false;
			break;
		case "bs":
			instructionLabel.setForeground(Color.BLACK);
			instructionLabel.setText("Schwarz beginnt");
			blackPlaying = true;
			break;
		}
	}

	/**
	 * Method is called, when pressing a button on the gameField.
	 * By default red starts the game.
	 * @param command the String-version of the index of the pressed button
	 */
	private void playGame(String command){
		if(!endOfGame){
			int index = Integer.parseInt(command);
			if(buttonArr[index].getText().isEmpty()){
				if(blackPlaying){
					buttonArr[index].setForeground(Color.BLACK);
					buttonArr[index].setText("O");
					initRedisNext(); //Spielzug von schwarz ist beendet
				}
				else{
					buttonArr[index].setForeground(Color.RED);
					buttonArr[index].setText("X");
					initBlackisNext(); //Spielzug von rot ist beendet
				}
			}
		}
	}

	/**
	 * Prepares for the next player. Red is next.
	 * Checks if Black already wins the game or if field is completed.
	 */
	private void initRedisNext(){
		if(!isWinner()){
			if(!checkFieldFull()){
				blackPlaying = false;
				instructionLabel.setForeground(Color.RED);
				instructionLabel.setText("Rot ist am Zug");
			}
			else{
				labelPanel.setBackground(new Color(88, 235, 237)); //42,144,145
				instructionLabel.setText("Unentschieden!");
			}
		}
	}

	/**
	 * Prepares for the next player. Black is next.
	 * Checks if Red already wins the game or if field is completed.
	 */
	private void initBlackisNext(){
		if(!isWinner()){
			if(!checkFieldFull()){
				blackPlaying = true;
				instructionLabel.setForeground(Color.BLACK);
				instructionLabel.setText("Schwarz ist am Zug");
			}
			else{
				labelPanel.setBackground(new Color(88, 235, 237));
				instructionLabel.setText("Unentschieden!");
			}
		}
	}

	/**
	 * Checks if all the buttons have been played.
	 * Returns true if the game is completed.
	 * @return boolean
	 */
	private boolean checkFieldFull(){
		for(int i = 0; i < buttonArr.length; i++){
			if(buttonArr[i].getText().isEmpty()){
				return false;
			}	
		}
		endOfGame = true;
		return true;
	}

	/**
	 * checks if there is already a winner in the game.
	 * returns true if the last move wins
	 * @return boolean
	 */
	private boolean isWinner(){
		String sign= blackPlaying ? "O" : "X";
		System.out.println(blackPlaying);
		System.out.println(sign);
		if(checkRows(sign) ||
				checkColumns(sign)||
				checkDiagonals(sign)){
			switch(sign){
			case "O": 
				instructionLabel.setText("Schwarz hat gewonnen!"); break;
			case "X":
				instructionLabel.setText("Rot hat gewonnen!"); break;
			}
			labelPanel.setBackground(new Color(88, 235, 237));
			endOfGame = true;
			return true;
		}
		return false;
	}

	//Row
	private boolean checkRows(String sign){
		for (int i = 0; i < 7; i+=3) {
			if(buttonArr[i].getText().equals(sign) &&
					buttonArr[i+1].getText().equals(sign) &&
					buttonArr[i+2].getText().equals(sign)){
				return true;
			}
		}
		return false;
	}

	//Column
	private boolean checkColumns(String sign){
		for (int i = 0; i < 3; i++) {
			if(buttonArr[i].getText().equals(sign) &&
					buttonArr[i+3].getText().equals(sign) &&
					buttonArr[i+6].getText().equals(sign)){
				return true;
			}
		}
		return false;
	}

	//Diagonal
	private boolean checkDiagonals(String sign){
		if(buttonArr[0].getText().equals(sign) &&
				buttonArr[4].getText().equals(sign) &&
				buttonArr[8].getText().equals(sign)){
			return true;
		}
		else if(buttonArr[2].getText().equals(sign) &&
				buttonArr[4].getText().equals(sign) &&
				buttonArr[6].getText().equals(sign)){
			return true;
		}
		return false;
	}

	/**
	 * reset all buttons = delete text on buttons
	 */
	private void reset(){
		for(int i = 0; i < buttonArr.length; i++){
			buttonArr[i].setText("");
		}
		labelPanel.setBackground(Color.WHITE);
		endOfGame = false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = "";
		Object source = e.getSource(); //liefert Object zurück das den Event ausgelöst hat
		if(source instanceof JButton){ 
			command = ((JButton)source).getActionCommand();
			System.out.println(command);
		}
		if(command.charAt(0) < 48 || command.charAt(0) > 57){ //if command is one of the startbuttons
			startGame(command);
		}
		else{playGame(command);} //if command is a number
		System.out.println(command);
	}

	//Main
	public static void main(String[] args) {
		new TicTacToe();
	}
}
