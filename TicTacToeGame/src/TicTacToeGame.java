import java.util.Scanner;
import java.util.*;
public class TicTacToeGame {
        
	         /*uc1*/
	public static char[] boardCreation()
	{
		char [] board = new char[10];
		for(int i=0;i<10;i++)
		{
			board[i]=' ';
		}
		return board;
	}
	
	         /*uc2*/

	public static char chooseLetter()
	{
		System.out.println("Enter letter X or O");
		Scanner sc =new Scanner(System.in);
		char letter=sc.next().charAt(0);
		return letter;
	}
	  
	/*uc3*/
	
	public static void displayBoard(char[] board)
	{
		System.out.println(" "+board[0]+" | "+board[1]+ " | "+board[2]+ " ");
		System.out.println("-----------");
		System.out.println(" "+board[3]+" | "+board[4]+ " | "+board[5]+ " ");
		System.out.println("-----------");
		System.out.println(" "+board[6]+" | "+board[7]+ " | "+board[8]+ " ");
	}

		
	/*uc5*/
	
	public static void choosePosition(int position, char[] board)
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
		   if(freeSpace(board,position))
		   {
			   System.out.println("Position is free");
			   System.out.println("enter players character X or O");
			   char playerCharacter=sc.next().charAt(0);
			   board[position]=playerCharacter;
			   displayBoard(board);
			   break;
		   }
		   else
			   System.out.println("Position isnt free, enter another position");
		}
	}
	
	/*uc4*/
	
	public static boolean freeSpace(char[] board, int position) 
	{
		if (board[position] == ' ')
			return true;

		else
			return false;

	}
	
	/*uc6*/
	public static String toss()
	{
		int toss = ( int) Math.floor(Math.random()*10  % 2);
		if(toss==0) 
			return "player";
		else 
			return "computer";
		
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
		displayBoard(board);
		
		String gamer=toss();
		System.out.println(gamer);
		System.out.println("Enter the position");
		int position = sc.nextInt();
		choosePosition(position,board);
		freeSpace(board,position);
		
		
	}
	
}
