package lifeform;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import environment.TestCell;
import environment.TestEnvironment;
import gameplay.TestSimpleTimer;
import recovery.TestRecoveryFractional;
import recovery.TestRecoveryLinear;
import recovery.TestRecoveryNone;

@RunWith(Suite.class)
@SuiteClasses(
{ TestAlien.class, TestHuman.class, TestLifeForm.class, TestCell.class, TestEnvironment.class, TestSimpleTimer.class,
		TestRecoveryFractional.class, TestRecoveryLinear.class, TestRecoveryNone.class })
public class AllTests
{

}
