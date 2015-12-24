package util;

import uk.co.kwrl.chess.core.Piece;
import uk.co.kwrl.chess.core.Piece.Color;
import uk.co.kwrl.chess.core.Piece.PieceType;

public class PieceFactory {
	protected Color color;
	
	public static PieceFactory WHITE = new PieceFactory(Color.WHITE);
	public static PieceFactory BLACK = new PieceFactory(Color.BLACK);
	
	public PieceFactory(Color color) {
		this.color = color;
	}
	
	public Piece createPawn() {
		return new Piece(PieceType.PAWN, color);
	}
	
	public Piece createBishop() {
		return new Piece(PieceType.BISHOP, color);
	}
	
	public Piece createRook() {
		return new Piece(PieceType.ROOK, color);
	}
	
	public Piece createKnight() {
		return new Piece(PieceType.KNIGHT, color);
	}
	
	public Piece createKing() {
		return new Piece(PieceType.KING, color);
	}
	
	public Piece createQueen() {
		return new Piece(PieceType.QUEEN, color);
	}
}