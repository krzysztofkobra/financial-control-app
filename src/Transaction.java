import java.time.LocalDate;

public class Transaction {
    private String type;
    private double amount;
    private LocalDate date;

    public Transaction(String type, double amount, LocalDate date){
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }
}
