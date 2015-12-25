package uk.co.kwrl.chess.cli;

import java.util.Scanner;

import uk.co.kwrl.chess.core.ChessBoardState;
import uk.co.kwrl.chess.core.Move;
import uk.co.kwrl.chess.core.Piece;
import uk.co.kwrl.chess.core.Piece.PieceType;
import util.ChessBoard;
import util.ChessGameListener;
import util.GameEvent;
import util.InvalidMoveException;

public class ChessCLI implements ChessGameListener {
	protected ChessBoard board;
	
	public ChessCLI() {
		this.board = new ChessBoard();
		board.addChessGameListener(this);
	}
	
	public static void main(String[] args) {
		ChessCLI cli = new ChessCLI();
		Scanner sc = new Scanner(System.in);
		int src_row, src_col, dst_row, dst_col;
		
		System.out.println("New game started.");
		cli.printRawBoard(cli.board.getRawBoard());
		while(true) {
			System.out.println("Current player is:" + cli.board.getCurrentPlayer());
			System.out.print("Src row:\t");
			src_row = sc.nextInt();
			System.out.println("Src col:\t");
			src_col = sc.nextInt();
			System.out.println("Dst row:\t");
			dst_row = sc.nextInt();
			System.out.println("Dst col:\t");
			dst_col = sc.nextInt();
			
			try {
				cli.board.performMove(new Move(src_row, src_col, dst_row, dst_col));
			} catch (InvalidMoveException e) {
				System.out.println("Invalid move!");
			}
		}
	}
	
	@Override
	public void onMoveExecuted(GameEvent event) {
		printRawBoard(event.getNewState().getRawBoard());
	}
	
	public void printRawBoard(Piece[][] board) {
		System.out.println(" ABCDEFGH");
		for(int row = 0; row < ChessBoardState.rowCount; row++) {
			System.out.print(row+1);
			for(Piece cell : board[row]) {
				if(cell!=null) {
					System.out.print(cell.getType().toChar());
				} else {
					System.out.print(PieceType.EMPTY.toChar());
				}
			}
			System.out.println(row+1);
		}
	}
}
