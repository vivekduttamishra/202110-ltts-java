package testapp13.exceptions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class TestForutneFinder {

	FortuneFinder finder =new FortuneFinder();
	
	@Test
	public void fortuneFinderWorksFindInValidCase() {
		
		var luck= finder.getForutune(1);
		
		assertEquals("Great Day Ahead", luck);
		
	}
	
	@Test
	public void fortuneFinderThrowNegativeLuckExceptionForLuckyNumberLessThanZero() {
		
		try {
			finder.getForutune(-4);
			//Oh! expected exception is not thrown
			fail("Expected exception is not thrown");
		} catch(NegativeLuckException ex) {
			
			//test has passed
			assertEquals(-4, ex.getValue());
		}
		
		
	}
	
	@Test(expected = NoLuckException.class)
	
	public void fortuneFinderThrowNoLuckExceptionForLuckyNumber0() {
		
		finder.getForutune(0);
		
		
	}
	
}
