import java.util.*;

class Expense {
    private static int counter = 1;
    private int id;
    private String description;
    private double amount;
    private String date;

    public Expense(String description, double amount, String date) {
        this.id = counter++;
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void display() {
        System.out.printf("ID: %d | Description: %s | Amount: ₹%.2f | Date: %s\n", id, description, amount, date);
    }
}

public class ExpenseTracker {
    static List<Expense> expenseList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Expense Tracker ---");
            System.out.println("1. Add Expense");
            System.out.println("2. List Expenses");
            System.out.println("3. Search Expense by ID");
            System.out.println("4. Update Expense");
            System.out.println("5. Delete Expense");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addExpense();
                case 2 -> listExpenses();
                case 3 -> searchExpense();
                case 4 -> updateExpense();
                case 5 -> deleteExpense();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    public static void addExpense() {
        System.out.print("Enter description: ");
        String desc = sc.nextLine();
        System.out.print("Enter amount: ");
        double amt = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter date (dd-mm-yyyy): ");
        String date = sc.nextLine();

        Expense exp = new Expense(desc, amt, date);
        expenseList.add(exp);
        System.out.println("Expense added successfully.");
    }

    public static void listExpenses() {
        if (expenseList.isEmpty()) {
            System.out.println("No expenses recorded.");
        } else {
            System.out.println("\nAll Expenses:");
            for (Expense exp : expenseList) {
                exp.display();
            }
        }
    }

    public static void searchExpense() {
        System.out.print("Enter Expense ID to search: ");
        int id = sc.nextInt();
        boolean found = false;
        for (Expense exp : expenseList) {
            if (exp.getId() == id) {
                exp.display();
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Expense not found.");
    }

    public static void updateExpense() {
        System.out.print("Enter Expense ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (Expense exp : expenseList) {
            if (exp.getId() == id) {
                System.out.print("Enter new description: ");
                String desc = sc.nextLine();
                System.out.print("Enter new amount: ");
                double amt = sc.nextDouble();
                sc.nextLine();
                System.out.print("Enter new date (dd-mm-yyyy): ");
                String date = sc.nextLine();

                exp.setDescription(desc);
                exp.setAmount(amt);
                exp.setDate(date);
                System.out.println("Expense updated.");
                return;
            }
        }
        System.out.println("Expense not found.");
    }

    public static void deleteExpense() {
        System.out.print("Enter Expense ID to delete: ");
        int id = sc.nextInt();
        Iterator<Expense> iterator = expenseList.iterator();
        while (iterator.hasNext()) {
            Expense exp = iterator.next();
            if (exp.getId() == id) {
                iterator.remove();
                System.out.println("Expense deleted.");
                return;
            }
        }
        System.out.println("Expense not found.");
    }
}
