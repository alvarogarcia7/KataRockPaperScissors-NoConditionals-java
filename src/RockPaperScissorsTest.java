
import static org.junit.Assert.*;

import org.junit.Test;


public class RockPaperScissorsTest {
	
	public enum Gesture {
		Rock, Paper;

		public Result against(Gesture other) {
			if(this == Rock){
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


}
