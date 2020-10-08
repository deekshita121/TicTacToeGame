import java.util.Scanner;

public class TicTacToeGame {

	Scanner sc =new Scanner(System.in);
	public static char[] boardCreation()
	{
		char [] board = new char[10];
		for(int i=0;i<10;i++)
		{
			board[i]=' ';
		}
		return board;
	}
	
	public static char chooseLetter()
	{
		System.out.println("Enter letter X or O");
		Scanner sc =new Scanner(System.in);
		char letter=sc.next().charAt(0);
		return letter;
	}
	
	public static void displayBoard()
	{
		char board[] = boardCreation();
		System.out.println(" "+board[0]+" | "+board[1]+ " | "+board[2]+ " ");
		System.out.println("-----------");
		System.out.println(" "+board[3]+" | "+board[4]+ " | "+board[5]+ " ");
		System.out.println("-----------");
		System.out.println(" "+board[6]+" | "+board[7]+ " | "+board[8]+ " ");
	}

		
	public static void choosePosition(int position, char[] board)
	{
		while(true)
		{
		   if(freeSpace(board,position))
			   break;
		   else
			   System.out.println("Position isnt free, enter another position");
		}
	}
	
	public static boolean freeSpace(char[] board, int position) 
	{
		if (board[position] == ' ')
			return true;

		else
			return false;

	}
	
	
	public static void main(String args[])
	{
		Scanner sc =new Scanner(System.in);
		char computerLetter;
		char[] board = boardCreation();
		char playerLetter=chooseLetter();
		if(playerLetter=='X')
			computerLetter='O';
		else
			computerLetter='X';
		
		System.out.println("Computer Letter "+computerLetter);
		System.out.println("Player Letter "+playerLetter);
		displayBoard();
		
		System.out.println("Enter the position");
		int position = sc.nextInt();
		choosePosition(position,board);
		freeSpace(board,position);
		
	}
	
}
