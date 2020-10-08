import java.util.*;

public class TicTacToeGame {

	private static final int TAILS = 0;
	private static final int HEADS = 1;
	private static final String PLAYER = "PLAYER";
	private static final String COMPUTER = "COMPUTER";
	static Scanner sc = new Scanner(System.in);

	/**
	  *  uc1 
	  *  @return
	  **/
	public static char[] boardCreation() {
		char[] board = new char[10];
		for (int i = 0; i < 10; i++) {
			board[i] = ' ';
		}
		return board;
	}

	/*
	 *  uc2
	 * @no parameters
	 **/

	public static void chooseLetter() {
		System.out.println("Enter letter X or O");
		char playerLetter = sc.next().charAt(0);
		if (playerLetter == 'X') {
			System.out.println("Players symbol is " + playerLetter + " and Computers lettter is O");
		} else
			System.out.println("Players symbol is " + playerLetter + " and Computers lettter is X");
	}

	/*
	 * uc3
	 *@param input
	 **/

	public static void displayBoard(char[] board) {
		System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2] + " ");
		System.out.println("-----------");
		System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5] + " ");
		System.out.println("-----------");
		System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8] + " ");
	}

	/* 
	 * uc5 
	 * @param input
	 **/

	public static void choosePosition(int position, char[] board, char input) {
		while (true) {
			if (freeSpace(board, position)) {
				System.out.println("Position is free");
				board[position] = input;
				displayBoard(board);
				break;

			} else
				System.out.println("Position isnt free, enter another position");
		}
	}

	/* 
	 * uc4
	 * @return
	 **/

	public static boolean freeSpace(char[] board, int position) {
		if (board[position] == ' ')
			return true;

		else
			return false;

	}

	/*
	 *  uc6
	 *@return
	 **/
	public static String toss() {
		int toss = (int) Math.floor(Math.random() * 10 % 2);
		if (toss == HEADS)
			return PLAYER;
		else
			return COMPUTER;

	}

	public static void main(String args[]) {

		char[] board = boardCreation();

		displayBoard(board);
		chooseLetter();
		String gamer = toss();
		System.out.println("First chance " + gamer);
		System.out.println("Enter the character of the player (X or O)");
		char input = sc.next().charAt(0);
		System.out.println("Enter the position player want to move");
		int position = sc.nextInt();
		choosePosition(position, board, input);
		// freeSpace(board,position);

	}

}
