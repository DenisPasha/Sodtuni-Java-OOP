package P08UnitTesting.Exercise.P03Iterator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.List;

import static org.junit.Assert.*;

public class ListIteratorTest {

    ListIterator listIterator;

    @Before
    public void setup() throws OperationNotSupportedException {
         listIterator = new ListIterator("a","b");
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testIfIteratorIsEmptyThrowsException() throws OperationNotSupportedException {
        listIterator = new ListIterator(null);
    }


    @Test
    public void testMoveAndHasNext(){
        Assert.assertTrue(listIterator.move());
        Assert.assertFalse(listIterator.move());
    }

    @Test (expected = IllegalStateException.class)
    public void testPrintThrowsExceptionWhenArrayEmpty() throws OperationNotSupportedException {
        listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void testPrintWhenValid(){
        String print = listIterator.print();
        Assert.assertEquals("a",print);
    }


}