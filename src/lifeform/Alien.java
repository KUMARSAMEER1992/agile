
package lifeform;

import recovery.RecoveryBehavior;

/**
 * This class consists members and functions related to Alien. Alien is a
 * LifeForm.
 * @author Sameer Kumar Kotra
 */
public class Alien extends LifeForm
{

	/**
	 * int to store max life points of the alien.
	 */
	private int maxLifePoints;

	/**
	 * RecoveryBehaviour to store the recovary behaviour of the alien at run
	 * time.
	 */
	private RecoveryBehavior recoveryBehavior;

	/**
	 * Create the instance of the Alien with given values.
	 * @param name: The name of the life form.
	 * @param points : The current starting life points of the life form.
	 */
	public Alien(String name, int points)
	{
		super(name, points);
		maxLifePoints = currentLifePoints;
		recoveryBehavior = null;
		attachStrength = 10;
	}

	/**
	 * Create the instance of the Alien with given values.
	 * @param name: The name of the life form.
	 * @param points : The current starting life points of the life form.
	 * @param rb : Recovery behavior of the Alien.
	 */
	public Alien(String name, int points, RecoveryBehavior rb)
	{
		this(name, points);
		recoveryBehavior = rb;
	}

	/**
	 * Sets the life point sof the Alien. Used for the recovery of the Alien.
	 * @param lifePoints : New life points to be stored. Stores only if new life
	 *            points is less than the max life points.
	 */
	public void setCurrentLifePoints(int lifePoints)
	{
		if (lifePoints < maxLifePoints)
		{
			currentLifePoints = (lifePoints >= 0) ? lifePoints : 0;
		}
	}

	/**
	 * Recovers the alien based on the recovery behavior stored in it.
	 */
	public void recover()
	{
		if (recoveryBehavior != null)
		{
			int lifePoints = recoveryBehavior.calculateRecovery(currentLifePoints, maxLifePoints);
			setCurrentLifePoints(lifePoints);
		}
	}

}
