import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Transactions {
    private List<Transaction> transactions;

    public Transactions() {
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Balance balance, boolean type, double amount){
        if(type){
            transactions.add(new Transaction("Income", amount, LocalDate.now()));
        } else {
            transactions.add(new Transaction("Expenditure", amount, LocalDate.now()));
        }

        balance.updateBalance(amount, type);
    }

    public void addTransaction(Balance balance, boolean type, double amount, LocalDate date){
        if(type){
            transactions.add(new Transaction("Income", amount, date));
        } else {
            transactions.add(new Transaction("Expenditure", amount, date));
        }

        balance.updateBalance(amount, type);
    }

    public void viewPeriodBalance(LocalDate startDate, LocalDate endDate){
        System.out.println("Transactions between " + startDate + " and  " + endDate +":");
        for(Transaction transaction : transactions){
            if(!transaction.getDate().isBefore(startDate) && !transaction.getDate().isAfter(endDate)){
                System.out.println("TYPE: " + transaction.getType() + ", AMOUNT: " + transaction.getAmount() + ", DATE: " + transaction.getDate());;
            }
        }
    }

    public double calculateBalanceForPeriod(LocalDate startDate, LocalDate endDate){
        double balanceForPeriod = 0.0;

        for(Transaction transaction : transactions){
            if(!transaction.getDate().isBefore(startDate) && !transaction.getDate().isAfter(endDate)){
                balanceForPeriod += (transaction.getType().equals("Income") ? 1 : -1) * transaction.getAmount();
            }
        }
        return balanceForPeriod;
    }

}
