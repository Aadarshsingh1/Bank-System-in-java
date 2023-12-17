/******************************************************************************
                          #Learn Flow Internship 
                          project -1 
                          Banking System
*******************************************************************************/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Transaction {
    private String description;
    private double amount;

    public Transaction(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }
    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    // Getters for description and amount
}

class Account {
    private double balance;
    private List<Transaction> transactionHistory;

    public Account() {
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add(new Transaction("Deposit", amount));
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdrawal", amount));
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
}

class User {
    private String username;
    private String password;
    private Account account;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.account = new Account();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Account getAccount() {
        return account;
    }
}

public class OnlineBankingSystem {
    public static void main(String[] args) {
        // Create users
        User user1 = new User("user1", "password1");
        User user2 = new User("user2", "password2");

        // Simulating banking operations
        user1.getAccount().deposit(1000);
        user1.getAccount().withdraw(500);

        user2.getAccount().deposit(1500);
        user2.getAccount().withdraw(200);

        // Displaying account information and transaction history
        displayAccountInfo(user1);
        displayAccountInfo(user2);
    }

    public static void displayAccountInfo(User user) {
        System.out.println("Account information for " + user.getUsername());
        System.out.println("Balance: $" + user.getAccount().getBalance());
        System.out.println("Transaction History:");
        List<Transaction> transactions = user.getAccount().getTransactionHistory();
        for (Transaction transaction : transactions) {
            System.out.println(transaction.getDescription() + ": $" + transaction.getAmount());
        }
        System.out.println();
    }
}
