package P09TestDrivenDevelopment.Exercise;

import java.util.*;

public class ChainblockImpl implements Chainblock{

   private Map<Integer ,Transaction> transactionMap;

    public ChainblockImpl() {
        this.transactionMap = new HashMap<>();
    }

    public Map<Integer, Transaction> getTransactionMap() {
        return transactionMap;
    }

    public void add(Transaction transaction) {
        transactionMap.putIfAbsent(transaction.getId(),transaction);
    }

    public boolean contains(Transaction transaction) {
        Transaction transaction1 = transaction;
        contains(transaction1.getId());
       return transactionMap.containsKey(transaction1.getId());
    }

    public boolean contains(int id) {
        return transactionMap.containsKey(id);
    }


    public int getCount() {
        return transactionMap.size();
    }



    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        if (transactionMap.containsKey(id)){
            Transaction transaction = transactionMap.get(id);
            transaction.setStatus(newStatus);
            transactionMap.put(id,transaction);
        }else {
            throw new IllegalArgumentException();
        }
    }

    public void removeTransactionById(int id) {
        if (transactionMap.containsKey(id)){
            transactionMap.remove(id);
        }else {
            throw new IllegalArgumentException();
        }
    }

    public Transaction getById(int id) {
        if (transactionMap.containsKey(id)){
            return transactionMap.get(id);
        }else {
            throw new IllegalArgumentException();
        }
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> transactionList = new ArrayList<>();

        for (Map.Entry<Integer, Transaction> entry : transactionMap.entrySet()) {
            Integer key = entry.getKey();
            Transaction currentTransaction = entry.getValue();
            if (currentTransaction.getStatus().equals(status)) {
                transactionList.add(currentTransaction);
            }
        }
        if (transactionList.size() == 0){
            throw new IllegalArgumentException();
        }else {
            transactionList.sort(Comparator.comparing(Transaction::getAmount).reversed());
            return transactionList;
        }

    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        return null;
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        return null;
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return null;
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        return null;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        return null;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return null;
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        return null;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        return null;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return null;
    }

    public Iterator<Transaction> iterator() {
        return null;
    }
}
