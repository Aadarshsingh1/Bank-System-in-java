//This is Bank file
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Creating accounts
        bank.createAccount("123456");
        bank.createAccount("789012");

        // Accessing an account
        Account acc1 = bank.getAccount("123456");
        Account acc2 = bank.getAccount("789012");

        // Checking if accounts are null (in a real system, handle this scenario more gracefully)
        if (acc1 != null && acc2 != null) {
            // Depositing and withdrawing
            acc1.deposit(1000);
            acc2.deposit(500);
            acc1.withdraw(200);

            // Transferring funds
            bank.transfer(acc1, acc2, 300);

            // Checking balances and transactions
            System.out.println("Account 1 Balance: $" + acc1.getBalance());
            System.out.println("Account 2 Balance: $" + acc2.getBalance());

            System.out.println("Account 1 Transactions:");
            for (Transaction transaction : acc1.getTransactions()) {
                System.out.println(transaction.getType() + ": $" + transaction.getAmount());
            }

            System.out.println("Account 2 Transactions:");
            for (Transaction transaction : acc2.getTransactions()) {
                System.out.println(transaction.getType() + ": $" + transaction.getAmount());
            }
        } else {
            System.out.println("One or both accounts not found.");
        }
        
    }
   
}
