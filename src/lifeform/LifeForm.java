package lifeform;

/**
 * This class consists members and functions related to LifeForm.
 * @author : Sameer Kumar Kotra
 */
public abstract class LifeForm
{
	/**
	 * String to store the name of the LifeForm.
	 */
	private String myName;

	/**
	 * int to store the life points of the LifeForm. It can be accessed by sub
	 * classes.
	 */
	protected int currentLifePoints;

	/**
	 * int to store the strength of the LifeForm.
	 */
	protected int attachStrength;

	/**
	 * Create an instance of LifeForm with given values.
	 * @param name: The name of the life form.
	 * @param points :The current starting life points of the life form.
	 */
	public LifeForm(String name, int points)
	{
		myName = name;
		currentLifePoints = (points >= 0) ? points : 0;
		attachStrength = 0;
	}

	/**
	 * Create an instance of LifeForm with given values.
	 * @param name: The name of the life form.
	 * @param points : The current starting life points of the life form.
	 * @param strength: The Strength of the LifeForm.
	 */
	public LifeForm(String name, int points, int strength)
	{
		this(name, points);
		this.attachStrength = (strength >= 0) ? strength : 0;
	}

	/**
	 * Returns the name of the LifeForm.
	 * @return the name of the life form.
	 */
	public String getName()
	{
		return myName;
	}

	/**
	 * Returns the current life points of a LifeForm.
	 * @return the amount of current life points the life form has.
	 */
	public int getCurrentLifePoints()
	{
		return currentLifePoints;
	}

	/**
	 * Reduces the damage from current life points.
	 * @param damage : specifies the damage to the LifeForm.
	 */
	public void takeHit(int damage)
	{
		if (damage > 0)
		{
			currentLifePoints -= damage;
			currentLifePoints = (currentLifePoints >= 0) ? currentLifePoints : 0;
		}
	}

	/**
	 * Returns the strength of a LifeForm.
	 * @return the strength the life form has.
	 */
	public int getAttachStrength()
	{
		return attachStrength;
	}

	public void attack(LifeForm lifeForm2)
	{
		if (getCurrentLifePoints() > 0)
		{
			lifeForm2.takeHit(getAttachStrength());
		}
	}

}
