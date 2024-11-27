import java.time.LocalDate;

public class Balance {
    private double balance;
    private double dynamicBalance;

    public Balance() {
        this.balance = 0.0;
        this.dynamicBalance = 0.0;
    }

    public Balance(double initialAmount){
        this.balance = initialAmount;
        this.dynamicBalance = 0.0;
    }

    public void setDynamicBalance(Transactions transactions, LocalDate startDate, LocalDate endDate){
        dynamicBalance = transactions.calculateBalanceForPeriod(startDate, endDate);
        System.out.println(dynamicBalance);
    }

    public void updateBalance(double amount, boolean type) {
        if (type) {
            balance += amount;
        } else {
            balance -= amount;
        }
    }

    public double checkBalance(){
        return balance;
    }

    public double checkDynamicBalance(){
        return dynamicBalance;
    }

    public void viewDynamicBalance(){
        System.out.println("Balance for period: " + dynamicBalance);
    }

    public void viewBalance(){
        System.out.println("Actual balance: " + balance);
    }
}
