import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Date;

public class Main extends Application {

    private ExpenseController controller;

    public Main(){
        controller = new ExpenseController();
    }

    @Override
    public void start(Stage primaryStage){
        // Create UI components
        TextField amountField = new TextField();
        amountField.setPromptText("Amount");

        TextField categoryField = new TextField();
        categoryField.setPromptText("Category");

        DatePicker datePicker = new DatePicker();
        TextField descriptionField = new TextField();
        descriptionField.setPromptText("Description");

        Button addButton = new Button("Add Expense");
        ListView<String> expenseListView = new ListView<>();

        // Add button event handler
        addButton.setOnAction(e -> {
            double amount = Double.parseDouble(amountField.getText());
            String category = categoryField.getText();
            java.util.Date date = java.sql.Date.valueOf(datePicker.getValue());
            String description = descriptionField.getText();

            controller.addExpense(amount, category, date, description);
            updateExpenseList(expenseListView);
        });

        // Layout
        VBox layout = new VBox(10, amountField, categoryField, datePicker, descriptionField, addButton, expenseListView);
        Scene scene = new Scene(layout, 400, 300);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Expense Tracker");
        primaryStage.show();

        // Initial update of the expense list
        updateExpenseList(expenseListView);
    }

    // Update the ListView with the latest expenses
    private void updateExpenseList(ListView<String> listView) {
        listView.getItems().clear();
        for (Expense expense : controller.getAllExpenses()) {
            listView.getItems().add(expense.toString());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }


}