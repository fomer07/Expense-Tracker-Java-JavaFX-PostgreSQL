import java.util.Date;

public class Expense {

    private double amount;
    private String category;
    private Date date;
    private String description;

    // Constructor
    public Expense(double amount,
                   String category,
                   Date date,
                   String description) {
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.description = description;
    }

    // Getters and Setters
    public double getAmount() { return amount; }
    public String getCategory() { return category; }
    public Date getDate() { return date; }
    public String getDescription() { return description; }

    // toString() to display the expense details
    @Override
    public String toString() {
        return "Expense{" +
                "amount=" + amount +
                ", category='" + category + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}
