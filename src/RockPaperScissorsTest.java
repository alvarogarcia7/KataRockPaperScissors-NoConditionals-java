
import static org.junit.Assert.*;

import org.junit.Test;


public class RockPaperScissorsTest {
	
	public enum Gesture {
		Rock, Paper;

		public Result against(Gesture paper2) {
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


}
