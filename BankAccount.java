import java.util.Random;
import java.util.ArrayList;
public class BankAccount {
    private String memberName;
    private String accountNumber;
    private double accountBalance;
    private double minimumBalance;
    private ArrayList<Double> transactions= new ArrayList<>();

    BankAccount(String memberName, double accountBalance, double minimumBalance) {
        this.memberName = memberName;
        this.accountBalance = accountBalance;
        this.minimumBalance = minimumBalance;

        // generate 5-digit accountNumber
        Random rand = new Random();
        String num = "" + rand.nextInt(10) + rand.nextInt(10) +
                rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);
        this.accountNumber = num;
        transactions.add(accountBalance);
    }

    public void deposit(double depAmount) {
        accountBalance += depAmount;
        transactions.add(depAmount);
    }
    
    public void withdraw(double withAmount) {
        if (accountBalance - withAmount >= minimumBalance) {
            accountBalance -= withAmount;
            
            transactions.add(-withAmount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public String getMemberName() {
        return memberName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }


    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    @Override
    public String toString() {
        return memberName + "-" + accountNumber + "-" + accountBalance + "-" + minimumBalance;
    }
}

