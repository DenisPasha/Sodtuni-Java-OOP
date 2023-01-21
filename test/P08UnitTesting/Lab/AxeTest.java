package P08UnitTesting.Lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AxeTest {

    public static final int ATTACK_POINTS = 10;
    public static final int DURABILITY_POINTS = 0;
    public static final int DUMMY_HEALTH = 10;
    public static final int DUMMY_EXPERIENCE = 10;

    Dummy dummy ;
    Axe axe;
    @Before

    public void setup(){
         axe = new Axe(ATTACK_POINTS,DURABILITY_POINTS );
         dummy = new Dummy(DUMMY_HEALTH,DUMMY_EXPERIENCE);
    }


    @Test
    public void testIfDurabilityPointsReducesAfterAttack(){
        axe.attack(dummy);
        Assert.assertEquals(9,axe.getDurabilityPoints());
    }

    @Test (expected = IllegalStateException.class)

    public void testIfCanAttackWithBrokenWeapon(){
        axe.attack(dummy);

    }





}