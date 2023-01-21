package P08UnitTesting.Exercise.P02ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import java.util.Arrays;

import static org.junit.Assert.*;

public class DatabaseTest {

    Person[] persons = {new Person(1,"Denis"),new Person(2,"Pesho")};

    Database database;


    @Before
    public void setup() throws OperationNotSupportedException {
        database = new Database(persons);
    }


    @Test (expected = OperationNotSupportedException.class)
    public void addNullPersonToDatabase() throws OperationNotSupportedException {
        Person person = null;
        database.add(person);
    }

    @Test
    public void addValidPersonToDatabase() throws OperationNotSupportedException {
        Person person = new Person(3,"toni");
        int size = database.getElements().length + 1;
        database.add(person);
        Assert.assertEquals(size, database.getElements().length);
    }


    @Test
    public void removeLastPersonFromDatabase() throws OperationNotSupportedException {
        int databaseSize = database.getElements().length;
        database.remove();
        Assert.assertEquals(databaseSize-1,database.getElements().length);
    }

    @Test (expected = OperationNotSupportedException.class )
    public void testRemovePersonFromEmptyDatabase() throws OperationNotSupportedException {
        int databaseLength = database.getElements().length;
        for (int i = 0; i < databaseLength; i++) {
            database.remove();
        }

        database.remove();
    }

    @Test
    public void testGetCorrectElements(){
        int databaseLength = database.getElements().length;
        Assert.assertEquals(databaseLength,database.getElements().length);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testNullGivenUsernameGivesException() throws OperationNotSupportedException {
        database.findByUsername(null);
    }
    @Test (expected = OperationNotSupportedException.class)
    public void testRepeatedUsernameGivesException() throws OperationNotSupportedException {
        Person person = new Person(3,"Denis");
        database.add(person);
        database.findByUsername("Denis");
    }

    @Test
    public void testIfReturnsCorrectUsername() throws OperationNotSupportedException {
        Person denis = database.findByUsername("Denis");
        Assert.assertEquals("Denis",denis.getUsername());
    }









    @Test (expected = OperationNotSupportedException.class)
    public void testRepeatedIdGivesException() throws OperationNotSupportedException {
        Person person = new Person(1,"murdjo");
        database.add(person);
        database.findById(1);
    }

    @Test
    public void testIfReturnsCorrectId() throws OperationNotSupportedException {
        Person denis = database.findById(1);
        Assert.assertEquals(1,denis.getId());
    }


}