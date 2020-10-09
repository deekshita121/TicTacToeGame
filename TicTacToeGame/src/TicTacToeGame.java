
import java.util.*;

public class TicTacToeGame {

	private static final int TAILS = 0;
	private static final int HEADS = 1;
	private static final String PLAYER = "PLAYER";
	private static final String COMPUTER = "COMPUTER";
	static Scanner sc = new Scanner(System.in);

	/**
	 * uc1
	 * 
	 * @return
	 **/

	public static char[] boardCreation() {
		char[] board = new char[10];
		for (int i = 0; i < 10; i++) {
			board[i] = ' ';
		}
		return board;
	}

	/*
	 * uc2
	 * 
	 * @no parameters
	 **/

	public static char chooseLetter(char letter) {
		System.out.println("Enter letter X or O for player");
		letter = sc.next().charAt(0);
		return letter;
	}

	/**
	 * uc3
	 * 
	 * @param board
	 */

	public static void displayBoard(char[] board) {
		System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2] + " ");
		System.out.println("-----------");
		System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5] + " ");
		System.out.println("-----------");
		System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8] + " ");
	}

	/**
	 * uc4
	 * 
	 * @param position
	 * @param board
	 * @param input
	 */
	public static void choosePosition(int position, char[] board, char input) {
		while (true) {
			if (freeSpace(board, position)) {
				System.out.println("Position is free");
				board[position] = input;
				displayBoard(board);
				break;

			} else {
				System.out.println("Position isnt free, enter another position");
				displayBoard(board);
				position = sc.nextInt();
				choosePosition(position, board, input);
				break;
			}

		}
	}

	/**
	 * uc4
	 * 
	 * @param board
	 * @param position
	 * @return
	 */
	public static boolean freeSpace(char[] board, int position) {
		if (board[position] == ' ')
			return true;

		else
			return false;

	}

	/**
	 * uc6
	 * 
	 * @return
	 */
	public static String toss() {
		int toss = (int) Math.floor(Math.random() * 10 % 2);
		if (toss == HEADS)
			return PLAYER;
		else
			return COMPUTER;

	}

	/**
	 * uc7
	 * 
	 * @param board
	 * @param input
	 * @return
	 */

	public static String result(char[] board, char input) {
		int count = 0;
		for (int i = 0; i < 10; i++) {
			if (board[i] != ' ') {
				count++;

			}
		}
		if ((board[0] == input && board[1] == input && board[2] == input)
				|| (board[3] == input && board[4] == input && board[5] == input)
				|| (board[6] == input && board[7] == input && board[8] == input)
				|| (board[0] == input && board[3] == input && board[6] == input)
				|| (board[1] == input && board[4] == input && board[7] == input)
				|| (board[2] == input && board[5] == input && board[8] == input)
				|| (board[0] == input && board[4] == input && board[8] == input)
				|| (board[2] == input && board[4] == input && board[6] == input))

			return "WIN";

		else if (count == 9)
			return "TIE";

		else
			return "CHANGE TURN";

	}

	/**
	 * 
	 * @param input
	 * @param playerLetter
	 * @param computerLetter
	 * @return
	 */

	public static char changeInput(char input, char playerLetter, char computerLetter) {
		if (input == playerLetter)
			input = computerLetter;
		else
			input = playerLetter;
		return input;
	}

	/**
	 * 
	 * @param gamer
	 * @return
	 */
	public static String changeTurn(String gamer) {
		if (gamer == PLAYER)
			gamer = COMPUTER;
		else
			gamer = PLAYER;
		return gamer;
	}

	/**
	 * uc8
	 * 
	 * @param board
	 * @param input
	 * @return
	 */
	public static int computerWin(char[] board, char input) {
		String computerWinPossibility;
		int positionForComputerWin = 10;

		for (int i = 0; i < 10; i++) {
			if (board[i] == ' ') {
				board[i] = input;
				computerWinPossibility = result(board, input);
				if (computerWinPossibility.contains("WIN")) {
					positionForComputerWin = i;
					break;
				}
				board[i] = ' ';
			}
		}
		return positionForComputerWin;
	}

	/**
	 * uc9
	 * 
	 * @param board
	 * @param input
	 * @param playerLetter
	 * @param computerLetter
	 * @return
	 */
	public static int computerBlock(char[] board, char input, char playerLetter, char computerLetter) {
		String playerWinPossibility;
		int positionForPlayerWin = 10;
		char prevInput = changeInput(input, playerLetter, computerLetter);
		for (int i = 0; i < 10; i++) {
			if (board[i] == ' ') {
				board[i] = prevInput;
				playerWinPossibility = result(board, prevInput);
				if (playerWinPossibility.contains("WIN")) {
					positionForPlayerWin = i;
					board[i] = ' ';
					break;
				}
				board[i] = ' ';
			}
		}
		return positionForPlayerWin;
	}
	/**
	 * uc10
	 * @param board
	 * @return
	 */
	public static int computerCorner(char[] board)
	{
		int cornerIndex = 10;
		if(board[0]==' ')
			cornerIndex = 0;
		else if(board[2]==' ')
			cornerIndex = 2;
		else if(board[6]==' ')
			cornerIndex = 6;
		else if(board[8]==' ')
			cornerIndex = 8;
		return cornerIndex;
	}
	/**
	 * 
	 * @param board
	 * @param positionC
	 * @param computerLetter
	 */
	public static void computerMove(char[] board, int positionC, char computerLetter) {
		while (true) {
			if (freeSpace(board, positionC)) {
				System.out.println("Position is free");
				board[positionC] = computerLetter;
				displayBoard(board);
				break;

			} else {
				System.out.println("Position isnt free, enter another position");
				displayBoard(board);
			    positionC = (int) (Math.floor(Math.random() * 10 % 9));
				System.out.println("Computer choose "+positionC);
				computerMove(board, positionC, computerLetter);
				break;
			}

		}
	}

	public static void main(String args[]) {

		char[] board = boardCreation();
		char letter = ' ';
		displayBoard(board);
		char playerLetter = chooseLetter(letter);
		char computerLetter = ' ';
		if (playerLetter == 'X') {
			computerLetter = 'O';
			System.out.println("Players symbol is " + playerLetter + " and Computers lettter is " + computerLetter);
		} else {
			computerLetter = 'X';
			System.out.println("Players symbol is " + playerLetter + " and Computers lettter is " + computerLetter);
		}
		String gamer = toss();
		System.out.println("First chance " + gamer);
		char input = ' ';
		if (gamer == PLAYER)
			input = playerLetter;
		else
			input = computerLetter;

		System.out.println("Input taken for gamer is " + input);
		int turn = 0;
		do {
			int positionComputer = 0;
			int blockPlayer = 0;
			int cornerPosition = 0;
			if (gamer == COMPUTER) {
				displayBoard(board);
				positionComputer = computerWin(board, input);
				blockPlayer = computerBlock(board, input, playerLetter, computerLetter);
				cornerPosition = computerCorner(board);
				if (positionComputer != 10) {
					System.out.println("Computer will win if " + positionComputer + " is choosen");
					board[positionComputer] = input;
					displayBoard(board);
				} else if (blockPlayer != 10) {
					System.out.println("Player will win if " + blockPlayer + " is choosen. So block that");
					board[blockPlayer] = input;
					displayBoard(board);
				} else if (cornerPosition != 10) {
					System.out.println("Computer choose corner position "+cornerPosition);
					board[cornerPosition] = input;
					displayBoard(board);
				} else {
					System.out.println("Enter position for computer ");
					int positionC = (int) (Math.floor(Math.random() * 10 % 9));
					System.out.println("Computer choose position " + positionC);
					computerMove(board, positionC, computerLetter);
					displayBoard(board);
				}
			} else {
				System.out.println("Enter the position player want to move");
				int position = sc.nextInt();
				choosePosition(position, board, input);
			}
			// freeSpace(board,position);
			String outcome = result(board, input);
			System.out.println("Outcome of the move is " + outcome);
			if (outcome == "WIN")
				turn = 1;
			else if (outcome == "CHANGE TURN") {
				input = changeInput(input, playerLetter, computerLetter);
				gamer = changeTurn(gamer);
				turn = 0;
			} else
				turn = 1;
		} while (turn != 1);
	}

}
