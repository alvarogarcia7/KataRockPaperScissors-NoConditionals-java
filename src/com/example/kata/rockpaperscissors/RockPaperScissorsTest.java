package com.example.kata.rockpaperscissors;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class RockPaperScissorsTest {
	
	public enum Gesture {
		Rock, Paper, Scissors;

		public Result against(Gesture other) {
			if(this == Rock || this == Scissors){
				return Result.LOSE;
			}
			return Result.WIN;
		}

	}

	public enum Result {
		LOSE, WIN

	}

	@Test
	public void rockAgainstPaper_should_lose(){
		assertEquals(Result.LOSE, Gesture.Rock.against(Gesture.Paper));
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
