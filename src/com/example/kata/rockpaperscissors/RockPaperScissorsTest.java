package com.example.kata.rockpaperscissors;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class RockPaperScissorsTest {
	
	public enum Gesture {
		Rock, Paper, Scissors;

		public Result against(Gesture other) {
			if(this == Rock || this == Scissors){
				if(other == Scissors){
					return Result.WIN;
				}
				return Result.LOSE;
			}
			return Result.WIN;
		}

	}

	public enum Result {
		LOSE, WIN

	}

	private static final Result LOSE = Result.LOSE;
	private static final Gesture Rock = Gesture.Rock;
	private static final Gesture Paper = Gesture.Paper;
	

	@Test
	public void rockAgainstPaper_should_lose(){
		assertRockPaperScissors(LOSE, Rock, Paper);
	}
	
	private void assertRockPaperScissors(Result expected, Gesture gesture1,
			Gesture gesture2) {
		assertEquals(expected, gesture1.against(gesture2));
	}

	@Test
	public void paperAgainstRock_should_win(){
		assertEquals(Result.WIN, Gesture.Paper.against(Gesture.Rock));
	}
	
	@Test
	public void scissorsAgainstRock_should_lose(){
		assertEquals(Result.LOSE, Gesture.Scissors.against(Gesture.Rock));
	}
	
	@Test
	public void rockAgainstScissors_should_win(){
		assertEquals(Result.WIN, Gesture.Rock.against(Gesture.Scissors));
	}


}
