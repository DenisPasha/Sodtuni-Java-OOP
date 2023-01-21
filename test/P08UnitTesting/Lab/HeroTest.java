package P08UnitTesting.Lab;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class HeroTest {


    @Test
    public void canHeroGainXPafterDummyDead(){
        Target dummyMock = Mockito.mock(Target.class);
        Weapon axeMock = Mockito.mock(Weapon.class);

        Mockito.when(dummyMock.isDead()).thenReturn(true);
        Mockito.when(dummyMock.giveExperience()).thenReturn(10);

        Hero hero = new Hero("Denis");

        hero.attack(dummyMock);
        int experience = hero.getExperience();

        Assert.assertEquals(experience,dummyMock.giveExperience());

    }
}