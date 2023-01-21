package P08UnitTesting.Exercise.P04BubleSort;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {

    @Test
    public void testBubbleSort(){
        int[] rawArr = {545,1,65,2121,4,0};
        int[] sortedArr = {0,1,4,65,545,2121};

        Bubble.sort(rawArr);
        Assert.assertArrayEquals(sortedArr,rawArr);
    }

}