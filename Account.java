//This is Account file
import java.util.ArrayList;
import java.util.List;

class Account {
    private String accountNumber;
    private double balance;
    private List<Transaction> transactions;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction(TransactionType.DEPOSIT, amount));
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactions.add(new Transaction(TransactionType.WITHDRAWAL, amount));
            return true;
        }
        return false;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
