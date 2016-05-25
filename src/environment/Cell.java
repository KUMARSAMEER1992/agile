package environment;

import lifeform.LifeForm;

/**
 * This class consists members and functions related to Cell. Each Cell can hold
 * one life form.
 * @author : Sameer Kumar Kotra
 */

public class Cell
{
	/**
	 * LifeForm to store the LifeForm in the cell.
	 */
	private LifeForm entity;

	/**
	 * Create an instance of Cell.
	 */
	public Cell()
	{
		entity = null;
	}

	/**
	 * Adds the LifeForm to the Cell. Will not add if LifeForm already in the
	 * Cell.
	 * @param entity: LifeForm object to be store in the Cell.
	 * @return true if added, false otherwise.
	 */
	public boolean addLifeForm(LifeForm entity)
	{
		if (this.entity == null)
		{
			this.entity = entity;
			return true;
		}
		return false;
	}

	/**
	 * Removes the LifeForm from the Cell.
	 * @return LifeForm removed, null if none is present.
	 */
	public LifeForm removeLifeForm()
	{
		if (entity != null)
		{
			LifeForm temp = entity;
			entity = null;
			return temp;
		}
		return null;
	}

	/**
	 * Returns the LifeForm in the Cell.
	 * @return LifeForm present in the Cell.
	 */
	public LifeForm getLifeForm()
	{
		return entity;
	}
}