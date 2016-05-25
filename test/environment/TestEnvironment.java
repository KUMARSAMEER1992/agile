package environment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import lifeform.LifeForm;
import lifeform.MockLifeForm;

/**
 * The test cases for the Environment class.
 * @author : Sameer Kumar Kotra
 */
public class TestEnvironment
{

	/**
	 * Test the initialization of the Environment.
	 */
	@Test
	public void testInitialization()
	{
		Environment environment = new Environment(1, 1);
		// Life form will be null for a newly created Environment.
		assertNull(environment.getLifeForm(0, 0));
		assertNull(environment.getLifeForm(1, 1));
	}

	/**
	 * Test the setting of LifeFrom in the Environment.
	 */
	@Test
	public void testSetLifeForm()
	{
		Environment environment = new Environment(2, 3);
		LifeForm bob = new MockLifeForm("Bob", 40);

		// The cell is empty so this should work.
		boolean success = environment.addLifeForm(1, 2, bob);
		assertTrue(success);
		assertEquals(bob, environment.getLifeForm(1, 2));

		// The cell is not empty so this should fail.
		success = environment.addLifeForm(1, 2, bob);
		assertFalse(success);

		// The cell in empty we should get null
		assertNull(environment.getLifeForm(0, 0));

		// The cell location is invalid we should get null
		assertNull(environment.getLifeForm(0, 5));
	}

	/**
	 * Test the border conditions while adding the LifeFrom to Environment.
	 */
	@Test
	public void testBorderConditions()
	{
		Environment environment = new Environment(1, 1);
		LifeForm bob = new MockLifeForm("Bob", 40);

		// Can not add at location 2,0 as rows exceed size
		boolean success = environment.addLifeForm(2, 0, bob);
		assertFalse(success);

		// Can not add at location 0,2 as column exceed size
		success = environment.addLifeForm(0, 2, bob);
		assertFalse(success);

	}

	/**
	 * Test the removing of LifeFrom from the Environment.
	 */
	@Test
	public void testRemoveLifeForm()
	{
		Environment environment = new Environment(2, 3);
		LifeForm bob = new MockLifeForm("Bob", 40);

		// The cell is empty so this should work.
		boolean success = environment.addLifeForm(1, 2, bob);
		assertTrue(success);

		// Life form is added do it should work.
		assertEquals(bob, environment.removeLifeForm(1, 2));

		// Life form is not added at location 1,4 so it should fail.
		assertNull(environment.removeLifeForm(1, 1));

		// Location out of range so it should return null
		assertNull(environment.removeLifeForm(2, 3));

		// Location out of range so it should return null
		assertNull(environment.removeLifeForm(1, 3));

		// Location out of range so it should return null
		assertNull(environment.removeLifeForm(2, 1));

	}
}
