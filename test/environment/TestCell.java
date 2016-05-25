package environment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import lifeform.LifeForm;
import lifeform.MockLifeForm;

/**
 * The test cases for the Cell class
 * @author : Sameer Kumar Kotra
 */
public class TestCell
{

	/**
	 * Test the initialization of the Cell.
	 */
	@Test
	public void testInitialization()
	{
		Cell cell = new Cell();
		// LifeForm will be null when new Cell is created.
		assertNull(cell.getLifeForm());
	}

	/**
	 * Test the setting of LifeFrom in the Cell.
	 */
	@Test
	public void testSetLifeForm()
	{
		LifeForm bob = new MockLifeForm("Bob", 40);
		LifeForm fred = new MockLifeForm("Fred", 40);
		Cell cell = new Cell();

		// The cell is empty so this should work.
		boolean success = cell.addLifeForm(bob);
		assertTrue(success);
		assertEquals(bob, cell.getLifeForm());

		// The cell is not empty so this should fail.
		success = cell.addLifeForm(fred);
		assertFalse(success);
		assertEquals(bob, cell.getLifeForm());
	}

	/**
	 * Test the removing of LifeFrom from the Cell.
	 */
	@Test
	public void testRemoveLifeForm()
	{
		LifeForm bob = new MockLifeForm("Bob", 40);
		Cell cell = new Cell();

		// The cell is empty so this should work.
		boolean success = cell.addLifeForm(bob);
		assertTrue(success);

		// LifeForm is present so it should return the LifeForm
		assertEquals(bob, cell.removeLifeForm());

		// LifeForm is removed so it should return null
		assertNull(cell.removeLifeForm());
	}

}