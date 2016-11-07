import java.util.*;
/* Each chess game is an object. As you can see below, the chess game object holds two player objects and a board object. */
public class Game
{
	/* CONSTANTS */
	public static final boolean BLACK = true;
	public static final boolean WHITE = false;
	public static final boolean USER = true;
	public static final boolean COMP = false;
	public static final int A = 0;
	public static final int B = 1;
	public static final int C = 2;
	public static final int D = 3;
	public static final int E = 4;
	public static final int F = 5;
	public static final int G = 6;
	public static final int H = 7;
	public static final int ONE = 0;
	public static final int TWO = 1;
	public static final int THREE = 2;
	public static final int FOUR = 3;
	public static final int FIVE = 4;
	public static final int SIX = 5;
	public static final int SEVEN = 6;
	public static final int EIGHT = 7;

	/* VARIABLES */
	Player player1; // a game of chess has two players
	Player player2;
	Board board; // a game of chess has a board
	String name; // a game has a name, this variable will probably be used once we get a save/load game system in place
	Stockfish engine;

	/* CONSTRUCTORS */
	/*Default constructor gives player the first move*/
	public Game()
	{
		board = new Board();
		engine =  new Stockfish();
		player1 = new Player(USER, WHITE, board);
		player2 = new Player(COMP, BLACK, board);

	}
	/*Providing a color to constructor will set the player's color to the parameter provided*/
	public Game(boolean color)
	{
		engine =  new Stockfish();
		Board board = new Board();
		player1 = new Player(USER, color, board);
		player2 = new Player(COMP, !color, board);
	}

	/* METHODS */
	public void setup()
	{
		ArrayList<Piece> wpcs;
		ArrayList<Piece> bpcs;
		Piece p;
		int i;

		//Get each players list of pieces
		if(player1.getColor() == WHITE){
			wpcs = player1.getPieces();
			bpcs = player2.getPieces();
		}
		else{
			wpcs = player2.getPieces();
			bpcs = player1.getPieces();
		}
		/**
		two for loops
		Using the circular relationship between to place and Square
		set each square on the board the piece's square
		*/
		for(Piece s: wpcs){
			Square position = s.getPosition();
			position.occupySquare(s);
		}
		for(Piece s: bpcs){
			Square position = s.getPosition();
			position.occupySquare(s);
		}
	}

	public Square getSquareAt(int file, int rank)
	{
		return board.getSquareAt(file, rank);
	}
}
