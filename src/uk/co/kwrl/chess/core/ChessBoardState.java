package uk.co.kwrl.chess.core;

import uk.co.kwrl.chess.core.Piece.Color;
import uk.co.kwrl.chess.core.Piece.PieceType;
import util.InvalidMoveException;
import util.PieceFactory;

public class ChessBoardState implements ChessGameLogic {
	public static final int rowCount = 8;
	public static final int colCount = 8;
	protected Piece[][] rawBoard = new Piece[rowCount][colCount];
	protected Piece.Color currentPlayer = Piece.Color.WHITE;

	public ChessBoardState() {
	}

	protected ChessBoardState(Piece[][] rawBoard, Piece.Color currentPlayer) {
		for (int row = 0; row < rawBoard.length; row++) {
			for (int col = 0; col < rawBoard[0].length; col++) {
				this.rawBoard[row][col] = rawBoard[row][col];
			}
		}
		this.currentPlayer = currentPlayer;
	}

	public boolean isValidMove(Move newMove) {
		Piece srcPiece, dstPiece;

		try {
			srcPiece = rawBoard[newMove.startRow][newMove.startCol];
			dstPiece = rawBoard[newMove.endRow][newMove.endCol];
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			return false;
		}

		if (srcPiece.isEmpty() || srcPiece.getColor() != getCurrentPlayer()) {
			return false;
		}

		if (srcPiece.getColor() == dstPiece.getColor()) {
			return false;
		}

		return true;
	}

	public Piece.Color getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Piece.Color currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public ChessBoardState performMove(Move newMove) throws InvalidMoveException {
		if (!isValidMove(newMove)) {
			throw new InvalidMoveException();
		}

		ChessBoardState newBoard = this.clone();
		newBoard.rawBoard[newMove.endRow][newMove.endCol] = rawBoard[newMove.startRow][newMove.startCol];
		newBoard.rawBoard[newMove.startRow][newMove.startCol] = new Piece(PieceType.EMPTY, Color.EMPTY);

		if (this.currentPlayer == Piece.Color.BLACK) {
			newBoard.setCurrentPlayer(Piece.Color.WHITE);
		} else if (this.currentPlayer == Piece.Color.WHITE) {
			newBoard.setCurrentPlayer(Piece.Color.BLACK);
		} else {
			throw new InvalidMoveException();
		}

		return newBoard;
	}

	public ChessBoardState clone() {
		return new ChessBoardState(this.rawBoard, this.currentPlayer);
	}

	@Override
	public Piece[][] getRawBoard() {
		return rawBoard;
	}

	public static ChessBoardState createInitialState() {
		Piece[][] rawBoard = new Piece[ChessBoardState.rowCount][ChessBoardState.colCount];
		
		for(int row = 0; row < ChessBoardState.rowCount; row++) {
			for(int col = 0; col < ChessBoardState.colCount; col++) {
				rawBoard[row][col] = new Piece(PieceType.EMPTY, Color.EMPTY);
			}
		}

		// Place pawns
		for (int col = 0; col < ChessBoardState.colCount; col++) {
			rawBoard[1][col] = PieceFactory.BLACK.createPawn();
			rawBoard[ChessBoardState.rowCount-2][col] = PieceFactory.WHITE.createPawn();
		}

		// Place rooks
		rawBoard[0][0] = PieceFactory.BLACK.createRook();
		rawBoard[0][ChessBoardState.colCount - 1] = PieceFactory.BLACK.createRook();
		
		rawBoard[ChessBoardState.rowCount - 1][0] = PieceFactory.WHITE.createRook();
		rawBoard[ChessBoardState.rowCount - 1][ChessBoardState.colCount - 1] = PieceFactory.WHITE.createRook();
		
		// Place knights
		rawBoard[0][1] = PieceFactory.BLACK.createKnight();
		rawBoard[0][ChessBoardState.colCount -2] = PieceFactory.BLACK.createKnight();
		
		rawBoard[ChessBoardState.rowCount-1][1] = PieceFactory.WHITE.createKnight();
		rawBoard[ChessBoardState.rowCount-1][ChessBoardState.colCount -2] = PieceFactory.WHITE.createKnight();
		
		// Place bishops
		rawBoard[0][2] = PieceFactory.BLACK.createBishop();
		rawBoard[0][ChessBoardState.colCount-3] = PieceFactory.BLACK.createBishop();
		
		rawBoard[ChessBoardState.rowCount-1][2] = PieceFactory.WHITE.createBishop();
		rawBoard[ChessBoardState.rowCount-1][ChessBoardState.colCount-3] = PieceFactory.WHITE.createBishop();
		
		// Place king and queen
		rawBoard[0][3] = PieceFactory.BLACK.createQueen();
		rawBoard[0][4] = PieceFactory.BLACK.createKing();
		
		rawBoard[ChessBoardState.rowCount-1][3] = PieceFactory.WHITE.createQueen();
		rawBoard[ChessBoardState.rowCount-1][4] = PieceFactory.WHITE.createKing();

		return new ChessBoardState(rawBoard, Color.WHITE);
	}

}
