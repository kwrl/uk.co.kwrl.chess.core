package util;

import java.util.ArrayList;
import java.util.List;

import uk.co.kwrl.chess.core.ChessBoardState;
import uk.co.kwrl.chess.core.ChessGameLogic;
import uk.co.kwrl.chess.core.Move;
import uk.co.kwrl.chess.core.Piece;

public class ChessBoard implements ChessGameLogic {
	protected ChessBoardState currentState;
	protected List<ChessGameListener> gameListeners = new ArrayList<ChessGameListener>();
	
	public ChessBoard() {
		this.currentState = ChessBoardState.createInitialState();
	}
	
	public ChessBoard(ChessBoardState state) {
		this.currentState = state;
	}
	
	public void addChessGameListener(ChessGameListener listener) {
		gameListeners.add(listener);
	}
	
	public void fireGameEvent(GameEvent event) {
		for(ChessGameListener listener: gameListeners) {
			listener.onMoveExecuted(event);
		}
	}

	@Override
	public boolean isValidMove(Move move) {
		return currentState.isValidMove(move);
	}

	@Override
	public Piece.Color getCurrentPlayer() {
		return currentState.getCurrentPlayer();
	}

	@Override
	public ChessGameLogic performMove(Move move) throws InvalidMoveException {
		ChessBoardState newState, oldState;
		
		oldState = currentState;
		newState = currentState.performMove(move);
	
		fireGameEvent(new GameEvent(oldState, newState, move));
		
		return currentState;
	}

	@Override
	public Piece[][] getRawBoard() {
		return currentState.getRawBoard();
	}
}
