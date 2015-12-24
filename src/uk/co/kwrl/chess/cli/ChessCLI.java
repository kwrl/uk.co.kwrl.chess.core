package uk.co.kwrl.chess.cli;

import java.util.Scanner;

import uk.co.kwrl.chess.core.Piece;
import util.ChessBoard;
import util.ChessGameListener;
import util.GameEvent;

public class ChessCLI implements ChessGameListener {
	protected ChessBoard board;
	
	public ChessCLI() {
		this.board = new ChessBoard();
		board.addChessGameListener(this);
	}
	
	public static void main() {
		ChessCLI cli = new ChessCLI();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
		}
	}

	@Override
	public void onMoveExecuted(GameEvent event) {
		
	}
	
	public void printRawBoard(Piece[][] board) {
		for(Piece[] row : board) {
			for(Piece cell : row) {
				//System.out.print();
			}
			System.out.println();
		}
	}
}
