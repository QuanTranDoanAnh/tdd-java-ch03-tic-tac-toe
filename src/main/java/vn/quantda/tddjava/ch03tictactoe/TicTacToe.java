package vn.quantda.tddjava.ch03tictactoe;

public class TicTacToe {
	private Character[][] board = {
			{'\0', '\0', '\0'},
			{'\0', '\0', '\0'},
			{'\0', '\0', '\0'}
	};
	
	private char lastPlayer = '\0';
	private static final int SIZE = 3;
	
	public String play(int x, int y) {
		checkXAxis(x);
		checkYAxis(y);
		lastPlayer = nextPlayer();
		setBox(x, y, lastPlayer);
		if (isWin()) {
			return lastPlayer + " is the winner";
		}
		return "No winner";
	}

	private boolean isWin() {
		int playerTotal = lastPlayer * SIZE;
		for (int index = 0; index < SIZE; index++) {
			if (board[0][index] + board[1][index] + board[2][index] == playerTotal) {
				return true;
			} else if (board[index][0] + board[index][1] + board[index][2] == playerTotal) {
				return true;
			}
		}
		if (board[0][0] + board[1][1] + board[2][2] == playerTotal) {
			return true;
		}
		return false;
	}

	private void setBox(int x, int y, char lastPlayer) {
		if (board[x -1][y - 1] != '\0') {
			throw new RuntimeException("Box is occupied");
		} else {
			board[x -1][y - 1] = lastPlayer;
		}
	}

	private void checkYAxis(int y) {
		if (y <1 || y > 3) {
			throw new RuntimeException("Y is outside board");
		}
	}

	private void checkXAxis(int x) {
		if (x < 1 || x > 3) {
			throw new RuntimeException("X is outside board");
		}
	}

	public char nextPlayer() {
		if (lastPlayer == 'X') {
			return 'O';
		}
		return 'X';
	}

}
