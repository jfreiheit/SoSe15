package sose15.vorbereitungen.enums;

public class Game {

	int[] field;
	State[] board;
	public static final int LEER    = 0;
	public static final int ROT     = 1;
	public static final int SCHWARZ = 2;

	Game()
	{
		field = new int[9];
		board = new State[9];
	}

	void initField()
	{
		for(int i=0; i<field.length; i++)
		{
			field[i]=LEER;		// Spielfeld unbelegt
		}
		field[3] = ROT; 		// rot auf 3 
		field[5] = SCHWARZ;		// schwarz auf 5
	}

	void initBoard()
	{
		for(int i=0; i<field.length; i++)
		{
			board[i]=State.EMPTY;		// Spielfeld unbelegt
		}
		board[3] = State.RED; 		// rot auf 3 
		board[5] = State.BLACK;		// schwarz auf 5

		State currentState = State.RED;
		System.out.println(currentState);
	}

	public enum State {
		EMPTY, RED, BLACK
	}

	public static void main(String[] args) {
		new Game().initBoard();

	}

}
