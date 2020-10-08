import java.util.Scanner;

public class TicTacToeGame {

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
	
	public static void main(String args[])
	{
		char computerLetter;
		char[] board = boardCreation();
		char playerLetter=chooseLetter();
		if(playerLetter=='X')
			computerLetter='O';
		else
			computerLetter='X';
		
		System.out.println("Computer Letter "+computerLetter);
		System.out.println("Player Letter "+playerLetter);
		
	}
	
}
