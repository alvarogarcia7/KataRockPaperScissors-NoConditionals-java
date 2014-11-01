
import org.junit.Test;


public class RockPaperScissorsTest {
	
	@Test
	public void rockAgainstPaper_should_lose(){
		assertEquals(Result.LOSE, Gesture.Rock.against(Gesture.Paper));
	}


}
