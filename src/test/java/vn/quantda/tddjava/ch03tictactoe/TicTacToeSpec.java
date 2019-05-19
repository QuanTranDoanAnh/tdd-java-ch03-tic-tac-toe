package vn.quantda.tddjava.ch03tictactoe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TicTacToeSpec {

	@Rule
	public ExpectedException exception = ExpectedException.none();
	private TicTacToe ticTacToe;
	
	@Before
	public final void before() {
		ticTacToe = new TicTacToe();
	}
	
	@Test
	public void whenXOutsideBoardThenRuntimeException() {
		exception.expect(RuntimeException.class);
		ticTacToe.play(5,2);
	}
	
	@Test
	public void whenYOutsideBoardThenRuntimeException() {
		exception.expect(RuntimeException.class);
		ticTacToe.play(2, 5);
	}
	
	@Test
	public void whenOccupiedThenRuntimeException() {
		ticTacToe.play(2, 1);
		exception.expect(RuntimeException.class);
		ticTacToe.play(2, 1);
	}
	
	@Test
	public void givenFirstTurnWhenNextPlayerThenX() {
		assertEquals('X', ticTacToe.nextPlayer());
	}
	
	@Test
	public void givenLastTurnWasXWhenNextPlayerThenO() {
		ticTacToe.play(1, 1);
		assertEquals('O', ticTacToe.nextPlayer());
	}
	
	@Test
	public void whenPlayThenNoWinner( ) {
		String actual = ticTacToe.play(1,1);
		assertEquals("No winner", actual);
	}
	
	@Test
	public void whenPlayAndWholeHorizontalLineThenWinner() {
		ticTacToe.play(1, 1); // X
		ticTacToe.play(1, 2); // O
		ticTacToe.play(2, 1); // X
		ticTacToe.play(2, 2); // O
		String actual = ticTacToe.play(3, 1); // X
		assertEquals("X is the winner", actual);
 	}
	
	@Test
	public void whenPlayAndWholeVerticalLineThenWinner() {
		ticTacToe.play(1, 1); // X
		ticTacToe.play(2, 1); // O
		ticTacToe.play(1, 2); // X
		ticTacToe.play(2, 2); // O
		String actual = ticTacToe.play(1, 3); // X
		assertEquals("X is the winner", actual);
 	}
	
	@Test
	public void whenPlayAndWholeDiagonalLineThenWinner() {
		ticTacToe.play(1, 1); // X
		ticTacToe.play(2, 1); // O
		ticTacToe.play(2, 2); // X
		ticTacToe.play(3, 2); // O
		String actual = ticTacToe.play(3, 3); // X
		assertEquals("X is the winner", actual);
 	}
} 
