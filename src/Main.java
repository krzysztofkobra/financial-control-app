import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Balance balance = new Balance(15);
        Transactions transactions = new Transactions();

        transactions.addTransaction(balance,true, 500.0);
        transactions.addTransaction(balance,false, 200.0);
        transactions.addTransaction(balance,true, 300.0, LocalDate.of(2024, 11, 1));

        LocalDate startDate = LocalDate.of(2024, 11, 5);
        LocalDate endDate = LocalDate.of(2024, 11, 30);

        balance.setDynamicBalance(transactions, startDate, endDate);
        balance.checkDynamicBalance();
        transactions.viewPeriodBalance(startDate, endDate);

        balance.viewBalance();
    }
}