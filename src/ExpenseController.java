import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class ExpenseController {

    private ExpenseDAO expenseDAO;

    public ExpenseController() {
        expenseDAO = new ExpenseDAO();
    }

    // Add an expense
    public void addExpense(double amount, String category, Date date, String description) {
        try {
            Expense expense = new Expense(amount, category, date, description);
            expenseDAO.addExpense(expense);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all expenses
    public List<Expense> getAllExpenses() {
        try {
            return expenseDAO.getAllExpenses();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
