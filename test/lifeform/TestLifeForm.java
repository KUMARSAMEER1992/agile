package lifeform;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The test cases for the LifeForm class.
 * @author : Sameer Kumar Kotra
 */
public class TestLifeForm
{

	/**
	 * Test the Strength of the LifeForm.
	 */
	@Test
	public void testLifeStrength()
	{
		LifeForm entity = new MockLifeForm("Bob", 40, 10);
		// Test getAttachStrength
		assertEquals(10, entity.getAttachStrength());
		entity = new MockLifeForm("Bob", 40, -10);
		assertEquals(0, entity.getAttachStrength());
	}

	/**
	 * Test the attack method of the LifeForm.
	 */
	@Test
	public void testAttack()
	{
		LifeForm lifeForm1 = new MockLifeForm("Bob", 40, 10);
		LifeForm lifeForm2 = new MockLifeForm("Alice", 30, 10);

		lifeForm1.attack(lifeForm2);
		// lifeForm2 decreases from 30 to 20.
		assertEquals(20, lifeForm2.getCurrentLifePoints());

		lifeForm1.currentLifePoints = 0;

		lifeForm1.attack(lifeForm2);
		// lifeForm2 remains 20 as lifeForm1 id dead.
		assertEquals(20, lifeForm2.getCurrentLifePoints());
	}

	/**
	 * Old tests for Strategy pattern.
	 * Test the initialization of the LifeForm.
	 */
	@Test
	public void testInitialization()
	{
		LifeForm entity = new MockLifeForm("Bob", 40);
		assertEquals("Bob", entity.getName());
		assertEquals(40, entity.getCurrentLifePoints());

		entity = new MockLifeForm("Bob", -40);
		assertEquals("Bob", entity.getName());
		// LifeForm can not have negative life points so it should have 0.
		assertEquals(0, entity.getCurrentLifePoints());
	}

	/**
	 * Test the takeHit cases of the LifeForm.
	 */
	@Test
	public void testTakeHit()
	{
		LifeForm entity = new MockLifeForm("Bob", 50);

		// Take first hit.
		entity.takeHit(20);
		assertEquals(30, entity.getCurrentLifePoints());

		// Take hit when 0<current life points.
		entity.takeHit(30);
		assertEquals(0, entity.getCurrentLifePoints());

		// Take hit when life points is 0.
		entity.takeHit(10);
		assertEquals(0, entity.getCurrentLifePoints());

		// Can not take hit with negative damage points.
		entity.takeHit(-20);
		assertEquals(0, entity.getCurrentLifePoints());
	}

}