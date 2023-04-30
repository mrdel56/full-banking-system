
public class CurrentAccount extends BankAccount {
    private String tradeLicenseNumber;
    

    public CurrentAccount(String memberName, double accountBalance, String tradeLicenseNumber) {
        super(memberName, accountBalance, 5000.0);
        this.tradeLicenseNumber = tradeLicenseNumber;
        
    }

    public String getTradeLicenseNumber() {
        return tradeLicenseNumber;
    }
   

    public void setTradeLicenseNumber(String tradeLicenseNumber) {
        this.tradeLicenseNumber = tradeLicenseNumber;
    }
}

