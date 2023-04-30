
public class SavingsAccount extends BankAccount {
    private double interest;
    private double maxWithLimit;
    

    SavingsAccount(String memberName, double accountBalance, double maxWithLimit) {
        super(memberName, accountBalance, 2000.0);
        this.interest = 0.05;
        this.maxWithLimit = maxWithLimit;
    }

    private double calculateInterest() {
        return getAccountBalance() * interest;
    }

    public double getNetBalance() {
        return getAccountBalance() + calculateInterest();
    }

    public double getInterest() {
        return interest;
    }

    public double getMaxWithLimit() {
        return maxWithLimit;
    }
    public void setMaxWithLimit(double maxWithLimit) {
        this.maxWithLimit = maxWithLimit;
    }
}

