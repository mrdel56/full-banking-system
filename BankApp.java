import java.util.Scanner;
public class BankApp{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Bank my = new Bank("*********************DEL Bank Limited************************");

        MainLoop1: while(true){
            System.out.println();
            System.out.println("*********************Welcome To Del Bank************************\n 1.Create Account,\n 2.Deposite,"
                    + "\n 3.Withdraw,\n 4.Check Balance,\n 5.View transaction record,\n 6.Display Account,\n 7.Display Accounts list,\n" 
                    +" 0.Exit");

            int option = scan.nextInt();

            switch (option) {
                case 0:
                    break MainLoop1;

                case 1: {
                    
                    while(true){
                        System.out.println("Which account do you want to create: ");
                        System.out.println("1.Savings Account\n2.Current Account");
                        int option2 = scan.nextInt();
                        switch(option2){
                            case 1: {
                                
                                System.out.println("Enter Account holder name: ");
                                String name = scan.next();
                                System.out.println("Enter Balance: ");
                                double  balance = scan.nextDouble();
                                System.out.println("Enter maxWithLimit: ");
                                double maxWithLimit = scan.nextDouble();                                
                                my.addAccount(name, balance, maxWithLimit);
                                break;
                            }
                            case 2: {
                                System.out.println("Enter Account holder name: ");
                                String name = scan.next();
                                System.out.println("Enter Balance: ");
                                double  balance = scan.nextDouble();
                                System.out.println("Enter Trade Lisence Number: ");
                                String tradeLicense = scan.next();
                                
                                my.addAccount(name,  balance, tradeLicense);
                                break;
                            }
                        }
                        break ;
                    }
                    break;
                }
                case 2: {
                    System.out.println("Enter account number: ");
                    String accountNumber = scan.next();
                    System.out.println("Enter ammount: ");
                    double withAmount = scan.nextDouble();                    
                    my.deposit(accountNumber, withAmount);
                    break;
                }
                case 3: {
                    System.out.println("Enter account number: ");
                    String accountNumber = scan.next();
                    System.out.println("Enter ammount: ");
                    double withAmount = scan.nextDouble();                   
                    my.withdraw(accountNumber, withAmount);
                    break;
                }
                case 4: {
                    System.out.println("Enter account number: ");
                    String accountNumber = scan.next();                    
                    my.getBalance(accountNumber);
                    break;
                }
                case 5:{
                    System.out.println("Enter account number: ");
                    String accountNumber = scan.next();
                    my.displayTransactions(accountNumber); 
                   break;
                }

                case 6: {
                    System.out.println("Enter account number: ");
                    String accountNumber = scan.next();
                    System.out.println("===============================================");
                    my.display(accountNumber);
                    System.out.println("===============================================");
                    break;
                }
                case 7: {                
                    my.display();
                    break;
                }
                
        }
    }
}
}