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
	
	public boolean isValidMove(Move move) {
		return false;
	}

	public enum PieceType {
		EMPTY("EMPTY"), 
		PAWN("PAWN"), 
		BISHOP("BISHOP"), 
		KNIGHT("KNIGHT"), 
		ROOK("ROOK"),
		KING("KING"),
		QUEEN("QUEEN");
		
		protected final String name;
		
		private PieceType(String name) {
			this.name = name;
		}
		
		public String toString() {
			return name;
		}
		
		public char toChar() {
			switch(this) {
			case EMPTY:
				return '.';
			case PAWN:
				return 'P';
			case BISHOP:
				return 'B';
			case KNIGHT:
				return 'K';
			case ROOK:
				return 'R';
			case QUEEN:
				return 'Q';
			case KING:
				return '*';
			}
			return 0;
		}
	}
	
	public enum Color {
		WHITE, BLACK, EMPTY 
	}
}
