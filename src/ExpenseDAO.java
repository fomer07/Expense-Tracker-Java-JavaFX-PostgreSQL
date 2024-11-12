import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAO {

    public void addExpense(Expense expense) throws SQLException {
        String sql = "INSERT INTO expenses (amount, category, date, description) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, expense.getAmount());
            ps.setString(2, expense.getCategory());
            ps.setDate(3,new java.sql.Date(expense.getDate().getTime()));
            ps.setString(4, expense.getDescription());
            ps.executeUpdate();
        }
    }

    public List<Expense> getAllExpenses() throws SQLException {
        List<Expense> expenses = new ArrayList<>();
        String sql = "SELECT * FROM expenses";
        try (Connection conn = DatabaseManager.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Expense expense = new Expense(
                        rs.getDouble("amount"),
                        rs.getString("category"),
                        rs.getDate("date"),
                        rs.getString("description")
                );
                expenses.add(expense);
            }
        }
        return expenses;
    }
}
