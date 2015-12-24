package uk.co.kwrl.chess.core;

import util.InvalidMoveException;

public interface ChessGameLogic {
	public boolean isValidMove(Move move);
	
	public ChessGameLogic performMove(Move move) throws InvalidMoveException;
	
	public Piece.Color getCurrentPlayer();
	
	public Piece[][] getRawBoard();
}
