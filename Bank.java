import java.util.ArrayList;
import java.lang.Math;
import java.io.*;

public class Bank {

    String BankName;
    double previousTransaction;
    Bank (String BankName){
        this.BankName = BankName;
    }
    public ArrayList<BankAccount> accounts = new ArrayList<>();
    
    public void addAccount(BankAccount acc) {
        accounts.add(acc);
        System.out.println("Account added successfully!");
        System.out.println("Account number: " + acc.getAccountNumber());
    }

    public void addAccount(String name, double balance, double maxWithLimit) {
        
        SavingsAccount acc = new SavingsAccount(name, balance, maxWithLimit);
        if (balance >= 2000.0){
            addAccount(acc);
        }
        else if(balance < 2000.0){
            System.out.println("***************WARNING!!***********");
            System.out.println("Initial Balance cannot be less than 2000");
            System.out.println();
        }
    }

    public void addAccount(String name, double balance, String tradeLicense) {
        
        CurrentAccount acc = new CurrentAccount(name,balance, tradeLicense);
        if (balance >= 5000.0){
            addAccount(acc);
        }
        else if(balance < 5000.0){
            System.out.println("***************WARNING!!***********");
            System.out.println("Initial Balance cannot be less than 5000");
            System.out.println();
        }
    }

    public BankAccount findAccount(String accountNumber) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    public void deposit(String accountNumber, double amt) {
        BankAccount acc = findAccount(accountNumber);
        if (acc != null) {
            acc.deposit(amt);
            previousTransaction = amt;
            System.out.println("Deposit : " +amt);
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Account not found!");
        }
    }

    public void withdraw(String accountNumber, double amt) {
        BankAccount acc = findAccount(accountNumber);
        if (acc != null) {
            if (acc instanceof CurrentAccount) {
                CurrentAccount currAcc = (CurrentAccount) acc;                
                    acc.withdraw(amt);
                    previousTransaction=-amt;
                    System.out.println("Withdrawal : " +amt);
                    System.out.println("Withdrawal successful!");
                
            } else {
                SavingsAccount SavAcc = (SavingsAccount) acc;
                if (SavAcc.getNetBalance() - amt >= SavAcc.getMinimumBalance()) {
                    acc.withdraw(amt);
                    previousTransaction = -amt;
                    System.out.println("Withdrawal : " +amt);
                    System.out.println("Withdrawal successful!");
                } else {
                    System.out.println("Insufficient balance!");
                }
            }
        } 
        else {
            System.out.println("Account not found!");
        
    }
    }

    
    public void getBalance(String accountNumber) {
        BankAccount acc = findAccount(accountNumber);
        if (acc != null) {
            if (acc instanceof CurrentAccount) {
                CurrentAccount currAcc = (CurrentAccount) acc;
                System.out.println("Your Current Account Balance is: ");
                System.out.println(currAcc.getAccountBalance());
            } else {
                SavingsAccount SavAcc = (SavingsAccount) acc;
                System.out.println("Your Savings Account Balance is: ");
                System.out.println(SavAcc.getNetBalance());
            }
        } else {
            System.out.println("Account not found!");
            
        }
    }

    
        public void displayTransactions(String accountNumber){
            BankAccount acc = findAccount(accountNumber);
            if(acc != null){
                for (double i: acc.getTransactions()) {
                    System.out.println(i);
                }
            }
            else {
                System.out.println("Account not found!");
            }
        }

    public void display(String accountNumber) {
        BankAccount acc = findAccount(accountNumber);
        if (acc != null) {
            acc.toString();
            System.out.println(acc);
        } else {
            System.out.println("Account not found!");
        }
    }

    public void display() {
        if (accounts.size() == 0) {
            System.out.println("No accounts found!");
        } else {
            for (BankAccount acc : accounts) {
                acc.toString();
                System.out.println("===============================================");
                System.out.println(acc);
                System.out.println("===============================================");
            }
        }
    }
    
}

