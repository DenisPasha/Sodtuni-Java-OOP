package P08UnitTesting.Exercise.P01Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;


public class DatabaseTest {

    private static final Integer[] DATA = {1,3,43,65,34};
    Database database;

    @Before
    public void setup() throws OperationNotSupportedException {
        database = new Database(DATA);
    }


    @Test
    public void testAddValidElementOnFreeCell() throws OperationNotSupportedException {

        int lengthBeforeAdding = database.getElements().length;
        database.add(100);
        int lengthAfterAdding = database.getElements().length;
        int lastElementOfArray = database.getElements()[database.getElements().length-1];

        Assert.assertEquals(lengthAfterAdding,lengthBeforeAdding+1);
        Assert.assertEquals(100,lastElementOfArray);


    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testAddElementOnFullArray() throws OperationNotSupportedException {
        database = new Database(1,2,3,3,2,5,7,934,54,67,64,32,12,32,43,55);
        database.add(3);

    }

    @Test (expected = OperationNotSupportedException.class)
    public void testAddIfPassedElementIsNull() throws OperationNotSupportedException {
        database.add(null);
    }


    @Test (expected = OperationNotSupportedException.class )
    public void testRemoveIfArrayIsEmpty() throws OperationNotSupportedException {
        database = new Database();
        database.remove();

    }

    @Test
    public void testRemoveElementFromLastIndex() throws OperationNotSupportedException {

        int arraySize = database.getElements().length;
        int lastNumberAfterRemove = database.getElements()[database.getElements().length-2];
        database.remove();
        int lastNumAfterRemove = database.getElements()[database.getElements().length-1];

        Assert.assertEquals(lastNumberAfterRemove,lastNumAfterRemove);
        Assert.assertEquals(arraySize-1,database.getElements().length);

    }
}