package com.example.kata.rockpaperscissors;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import static com.example.kata.rockpaperscissors.RockPaperScissorsTest.Gesture.*;
import static com.example.kata.rockpaperscissors.RockPaperScissorsTest.Result.*;

public class RockPaperScissorsTest {

	public enum Gesture {
		Rock {
			@Override
			Result againstOther(Gesture other) {
				return other.againstRock();
			}

			@Override
			protected Result againstPaper() {
				return WIN;
			}

			@Override
			protected Result againstScissors() {
				return LOSE;
			}

			@Override
			protected Result againstRock() {
				return TRUCE;
			}
		},
		Paper {
			@Override
			Result againstOther(Gesture other) {
				return other.againstPaper();
			}

			@Override
			protected Result againstPaper() {
				return TRUCE;
			}

			@Override
			protected Result againstScissors() {
				return WIN;
			}

			@Override
			protected Result againstRock() {
				return LOSE;
			}
		},
		Scissors {
			@Override
			Result againstOther(Gesture other) {
				return other.againstScissors();
			}

			@Override
			protected Result againstPaper() {
				return LOSE;
			}

			@Override
			protected Result againstScissors() {
				return TRUCE;
			}

			@Override
			protected Result againstRock() {
				return WIN;
			}
		};

		public Result against(Gesture other) {
			return this.againstOther(other);
		}

		protected abstract Result againstRock();

		protected abstract Result againstScissors();

		protected abstract Result againstPaper();

		abstract Result againstOther(Gesture other);

	}

	public enum Result {
		LOSE, WIN, TRUCE
	}

	@Test
	public void rockAgainstPaper_should_lose() {
		assertRockPaperScissors(LOSE, Rock, Paper);
	}

	@Test
	public void paperAgainstRock_should_win() {
		assertRockPaperScissors(WIN, Paper, Rock);
	}

	@Test
	public void scissorsAgainstRock_should_lose() {
		assertRockPaperScissors(LOSE, Scissors, Rock);
	}

	@Test
	public void rockAgainstScissors_should_win() {
		assertRockPaperScissors(WIN, Rock, Scissors);
	}

	@Test
	public void rockAgainstRock_should_truce() {
		assertRockPaperScissors(TRUCE, Rock, Rock);
	}

	@Test
	public void paperAgainstScissors_should_lose() {
		assertRockPaperScissors(LOSE, Paper, Scissors);
	}

	@Test
	public void scissorsAgainstPaper_should_win() {
		assertRockPaperScissors(WIN, Scissors, Paper);
	}

	@Test
	public void scissorsAgainstScissors_should_truce() {
		assertRockPaperScissors(TRUCE, Scissors, Scissors);
	}

	@Test
	public void paperAgainstPaper_should_truce() {
		assertRockPaperScissors(TRUCE, Paper, Paper);
	}

	private void assertRockPaperScissors(Result expected, Gesture gesture1,
			Gesture gesture2) {
		assertEquals(expected, gesture1.against(gesture2));
	}
}
