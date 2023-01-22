package P09TestDrivenDevelopment.Exercise;

public interface Transaction {
    int getId();
   void setStatus(TransactionStatus status );
   TransactionStatus getStatus();

    double getAmount();
}
