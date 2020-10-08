
public class TicTacToeGame {

	public static void main(String args[])
	{
		TicTacToeGame tic = new TicTacToeGame();
		tic.boardCreation();
	}
	public void boardCreation()
	{
		char [] board = new char[10];
		for(int i=0;i<10;i++)
		{
			board[i]=' ';
		}
	}
}
