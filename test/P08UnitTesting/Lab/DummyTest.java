package P08UnitTesting.Lab;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {

    @Test
    public void testIfDummyLoosesHealthIfAttacked(){
        Axe axe = new Axe(10,10);
        Dummy dummy = new Dummy(10 ,10);

        dummy.takeAttack(10);

        Assert.assertEquals(0,dummy.getHealth());
    }


    @Test (expected = IllegalStateException.class)
    public void testIfDeadDummyThrowsException(){
        Dummy dummy = new Dummy(0,10);

        dummy.takeAttack(1);
    }

    @Test
    public void deadDummyCanGiveXP(){
        Dummy dummy = new Dummy(0,100);

        dummy.giveExperience();
        Assert.assertEquals(100,dummy.giveExperience());
    }

    @Test (expected = IllegalStateException.class)
    public void testAliveDummyCantGiveXP(){
        Dummy dummy = new Dummy(10,10);
        dummy.giveExperience();

    }
}