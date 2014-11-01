package com.example.kata.rockpaperscissors;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import static com.example.kata.rockpaperscissors.RockPaperScissorsTest.Gesture.*;
import static com.example.kata.rockpaperscissors.RockPaperScissorsTest.Result.*;


public class RockPaperScissorsTest {
	
	public enum Gesture {
		Rock, Paper, Scissors;

		public Result against(Gesture other) {
			if(this == Rock || this == Scissors){
				if(other == Scissors){
					return WIN;
				}
				return LOSE;
			}
			return WIN;
		}

	}

	public enum Result {
		LOSE, WIN

	}

	@Test
	public void rockAgainstPaper_should_lose(){
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

	private void assertRockPaperScissors(Result expected, Gesture gesture1,
			Gesture gesture2) {
		assertEquals(expected, gesture1.against(gesture2));
	}
}
