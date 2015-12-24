package util;

import uk.co.kwrl.chess.core.ChessBoardState;
import uk.co.kwrl.chess.core.Move;

public class GameEvent {
	protected ChessBoardState oldState, newState;
	protected Move move;
	
	public GameEvent(ChessBoardState oldState, ChessBoardState newState, Move move) {
		super();
		this.oldState = oldState;
		this.newState = newState;
		this.move = move;
	}

	public ChessBoardState getOldState() {
		return oldState;
	}

	public ChessBoardState getNewState() {
		return newState;
	}
	
	public Move getMove() {
		return move;
	}
}
