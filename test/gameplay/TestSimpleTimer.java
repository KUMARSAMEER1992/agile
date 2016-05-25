package gameplay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * The test cases for the SimpleTimer class.
 * @author : Sameer Kumar Kotra
 */
public class TestSimpleTimer
{

	/**
	 * Test the initialization of the SimpleTimer.
	 */
	@Test
	public void testInitilization()
	{
		SimpleTimer simpleTimer = new SimpleTimer();
		assertTrue(simpleTimer instanceof Timer);
		assertEquals(0, simpleTimer.getRound());
		assertEquals(0, simpleTimer.theObservers.size());

	}

	// TODO test
	/**
	 * Test the adding and removing of Observer.
	 */
	@Test
	public void testObserverOperations()
	{
		SimpleTimer simpleTimer = new SimpleTimer();
		TimeObserver observer = new MockSimpleTimerObserver();
		simpleTimer.addTimeObserver(observer);
		// Observer added.
		assertEquals(1, simpleTimer.theObservers.size());

		simpleTimer.removeTimeObserver(observer);
		// Observer removed.
		assertEquals(0, simpleTimer.theObservers.size());
	}

	@Test
	public void testUpdateObservers()
	{
		SimpleTimer simpleTimer = new SimpleTimer();
		MockSimpleTimerObserver observer = new MockSimpleTimerObserver();
		simpleTimer.addTimeObserver(observer);

		// Initial 0.
		assertEquals(0, observer.myTime);
		simpleTimer.timeChanged();
		// Updated 1.
		assertEquals(1, observer.myTime);
	}

	/**
	 * This tests that SimpleTimer will update time once every second.
	 */
	// @Test
	public void testSimpleTimerAsThread() throws InterruptedException
	{
		SimpleTimer st = new SimpleTimer(1000);
		// st.start();
		Thread.sleep(250);// So we are 1/4th a second different
		for (int x = 0; x < 5; x++)
		{
			assertEquals(x, st.getRound());// assumes round starts at 0.
			Thread.sleep(1000); // wait for the next time change.
		}

	}
}

/**
 * Mock class for TimeObserver.
 * @author Sameer Kumar Kotra.
 */
class MockSimpleTimerObserver implements TimeObserver
{

	public int myTime = 0;

	public void updateTime(int time)
	{
		myTime = time;
	}
}
