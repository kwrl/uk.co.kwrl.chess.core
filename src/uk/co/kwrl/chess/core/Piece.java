package uk.co.kwrl.chess.core;

public class Piece {
	protected PieceType type;
	protected Color color;
	
	public Piece(PieceType type, Color color) {
		this.type = type; 
		this.color = color;
	}
	
	public PieceType getType() {
		return type;
	}

	public Color getColor() {
		if(type==PieceType.EMPTY) {
			return Color.EMPTY;
		}
		return color;
	}
	
	public boolean isEmpty() {
		return getType()==PieceType.EMPTY;
	}

	public enum PieceType {
		EMPTY, PAWN, KNIGHT, BISHOP, ROOK, KING, QUEEN
	}
	
	public enum Color {
		WHITE, BLACK, EMPTY 
	}
}
