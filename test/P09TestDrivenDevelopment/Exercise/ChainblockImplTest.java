package P09TestDrivenDevelopment.Exercise;

import net.bytebuddy.agent.builder.AgentBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChainblockImplTest {

    ChainblockImpl chainblock;

    private void addTransactionsToChainblock(){
        Transaction transaction = new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"dem","men",231);
        Transaction transaction1 = new TransactionImpl(2,TransactionStatus.SUCCESSFUL,"dem","men",21);

         chainblock = new ChainblockImpl();
        chainblock.getTransactionMap().put(transaction.getId(),transaction);
        chainblock.getTransactionMap().put(transaction1.getId(),transaction1);
    }

    @Test
    public void testContainsIDValid(){
       addTransactionsToChainblock();
       Assert.assertTrue(chainblock.contains(2));

    }

    @Test
    public void testContainsTransaction(){
        addTransactionsToChainblock();
        Transaction transaction = new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"dem","men",231);

        Assert.assertTrue(chainblock.contains(transaction));
    }


    @Test
    public void testAddWithValidData(){
        addTransactionsToChainblock();
        Transaction transaction = new TransactionImpl(3,TransactionStatus.SUCCESSFUL,"frf","dad",21);
        chainblock.add(transaction);
        int size = chainblock.getTransactionMap().size();
        Assert.assertEquals(3,size);

      Assert.assertTrue(chainblock.getTransactionMap().get(3).equals(transaction));
    }

    @Test
    public void testAddWithInvalidDataShouldNotAdd(){
        addTransactionsToChainblock();
        Transaction transaction = new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"dada","dad",21);
        chainblock.add(transaction);
        Assert.assertEquals(2,chainblock.getTransactionMap().size());
    }

    @Test
    public void testGetCountReturnsCorrectValue(){
        addTransactionsToChainblock();
        Assert.assertEquals(2,chainblock.getCount());
    }

    @Test
    public void testChangeTransactionStatusValidInput(){
        addTransactionsToChainblock();
        chainblock.changeTransactionStatus(1,TransactionStatus.FAILED);

        Transaction transaction = chainblock.getTransactionMap().get(1);
      Assert.assertTrue(transaction.getStatus().equals(TransactionStatus.FAILED));

    }

    @Test (expected = IllegalArgumentException.class)
    public void testChangeTransactionStatusInvalidInput(){
        addTransactionsToChainblock();
        chainblock.changeTransactionStatus(21,TransactionStatus.ABORTED);

    }

    @Test
    public void testRemoveTransactionByValidId(){
        addTransactionsToChainblock();
        chainblock.removeTransactionById(1);
        int size = chainblock.getTransactionMap().size();
        Assert.assertEquals(1,size);
    }

    @Test (expected = IllegalArgumentException.class)
   public void testRemoveTransactionByInvalidId(){
        addTransactionsToChainblock();
        chainblock.removeTransactionById(11);
    }

    @Test
    public void testGetByValidId(){
        addTransactionsToChainblock();
        Transaction transaction = new TransactionImpl(1,TransactionStatus.SUCCESSFUL,"dem","men",231);

        Transaction byId = chainblock.getById(1);
        Assert.assertEquals(transaction.getId(),byId.getId());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetByInvalidId(){
        addTransactionsToChainblock();

        chainblock.getById(212);
    }

    @Test
    public void testGetByTransactionStatusValid(){
        addTransactionsToChainblock();
        Transaction transaction = new TransactionImpl(3,TransactionStatus.FAILED,"ada","dada",21);
        chainblock.add(transaction);

        Iterable<Transaction> byTransactionStatus = chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
        int count = 0;
        for (Transaction transaction1 : byTransactionStatus){
            count++;
        }
        System.out.println();
        Assert.assertEquals(2,count);
    }

    @Test (expected = IllegalArgumentException.class)
   public void testGetByTransactionStatusInvalid(){
        addTransactionsToChainblock();
        chainblock.getByTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void testGetAllSendersWithTransactionStatusValid(){
        addTransactionsToChainblock();
        Transaction transaction = new TransactionImpl(3,TransactionStatus.FAILED,"Sam","someone",5);
        Transaction transaction1 = new TransactionImpl(4,TransactionStatus.FAILED,"Adam","moione",2);
        Transaction transaction2 = new TransactionImpl(5,TransactionStatus.FAILED,"Sam","daadadadada",6);
        chainblock.add(transaction);
        chainblock.add(transaction1);
        chainblock.add(transaction2);


        List<String> expectedList = new ArrayList<>();
        expectedList.add("Adam");
        expectedList.add("Sam");
        expectedList.add("Sam");

        Iterable<String> allSendersWithTransactionStatus = chainblock.getAllSendersWithTransactionStatus(TransactionStatus.FAILED);


        List<String> givenList = new ArrayList<>();

        int count = 0;
        for (String person : allSendersWithTransactionStatus){
            givenList.add(person);
            count++;
        }

        Assert.assertEquals(3,count);
        Assert.assertEquals(expectedList,givenList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllSendersWithTransactionInvalidStatus(){
        addTransactionsToChainblock();
        chainblock.getAllSendersWithTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void testGetAllReceiversWithTransactionValidStatus(){
        Transaction transaction = new TransactionImpl(1,TransactionStatus.FAILED,"da","Denis",21);
        Transaction transaction1 = new TransactionImpl(1,TransactionStatus.FAILED,"da","Denis",20);
        Transaction transaction2 = new TransactionImpl(1,TransactionStatus.FAILED,"da","Pesho",200);

        addTransactionsToChainblock();
        chainblock.add(transaction);
        chainblock.add(transaction1);
        chainblock.add(transaction2);

        Iterable<String> allReceiversIter = chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);

        int count = 0;
        List<String> receiversNames = new ArrayList<>();
        List<String>expectedNames = new ArrayList<>();
        expectedNames.add("men");
        expectedNames.add("men");

        for (String receiverName : allReceiversIter){
            receiversNames.add(receiverName);
            count++;
        }

        Assert.assertEquals(2,count);
        Assert.assertEquals(expectedNames,receiversNames);

    }




}