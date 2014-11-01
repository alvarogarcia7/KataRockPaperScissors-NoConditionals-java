package com.example.kata.rockpaperscissors;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import static com.example.kata.rockpaperscissors.RockPaperScissorsTest.Gesture.*;
import static com.example.kata.rockpaperscissors.RockPaperScissorsTest.Result.*;


public class RockPaperScissorsTest {
	
	public enum Gesture {
		Rock, Paper, Scissors;

		public Result against(Gesture other) {
			if(other == this ){
				return TRUCE;
			}
			if(this == Rock || this == Scissors){
				if(other == Scissors){
					return WIN;
				}
				if(this == Scissors && other == Paper){
					return WIN;
				}
				return LOSE;
			}
			if(this == Paper && other == Scissors){
				return LOSE;
			}
			return WIN;
		}

	}

	public enum Result {
		LOSE, WIN, TRUCE
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

	@Test
	public void rockAgainstRock_should_truce() {
		assertRockPaperScissors(TRUCE, Rock, Rock);
	}
	
	@Test
	public void paperAgainstScissors_should_lose(){
		assertRockPaperScissors(LOSE, Paper, Scissors);
	}
	
	@Test
	public void scissorsAgainstPaper_should_win(){
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
