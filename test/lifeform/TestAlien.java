package lifeform;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import recovery.RecoveryBehavior;
import recovery.RecoveryLinear;

/**
 * The test cases for the Alien class.
 * @author : Sameer Kumar Kotra
 */
public class TestAlien
{

	/**
	 * Test the default Strength of the Alien.
	 */
	@Test
	public void testLifeStrength()
	{
		Alien alien = new Alien("Bob", 40);
		assertEquals(10, alien.getAttachStrength());
	}

	/**
	 * Old tests for Strategy pattern.
	 * Test the initialization of the Alien.
	 */
	@Test
	public void testInitiization()
	{
		Alien alien = new Alien("Bob", 40);
		assertEquals("Bob", alien.getName());
		assertEquals(40, alien.getCurrentLifePoints());

		alien = new Alien("Bob", -40);
		alien.recover();
		assertEquals(0, alien.getCurrentLifePoints());

		RecoveryBehavior rb = new RecoveryLinear(5);
		alien = new Alien("Bob", 40, rb);
		alien.takeHit(20);

		alien.recover();
		// Test with RecovaryLinear.
		assertEquals(25, alien.getCurrentLifePoints());
	}

	/**
	 * Test set current life points of Aliean.
	 */
	@Test
	public void testSetCurrentLifePoints()
	{
		Alien alien = new Alien("Bob", 40);

		alien.setCurrentLifePoints(30);
		assertEquals(30, alien.getCurrentLifePoints());

		alien.setCurrentLifePoints(-30);
		// Can not set negative values.
		assertEquals(0, alien.getCurrentLifePoints());

		alien.setCurrentLifePoints(50);
		// Can not set values more than the max life points in this case it is
		// 40.
		assertEquals(0, alien.getCurrentLifePoints());

	}

}
