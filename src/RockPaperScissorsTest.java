
import static org.junit.Assert.*;

import org.junit.Test;


public class RockPaperScissorsTest {
	
	public enum Gesture {
		Rock, Paper;

		public Result against(Gesture other) {
			return Result.LOSE;
		}

	}

	public enum Result {
		LOSE

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
