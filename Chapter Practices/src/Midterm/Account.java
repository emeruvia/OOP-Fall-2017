package Midterm;

/**
 * Question #1 on the Midterm, Fall 2017 OOP.
 */
public class Account {
    private int balance;
    private static int numOfAccounts;
    private static int totalBalance;
    
    public Account(int initDeposit) {
        balance = initDeposit;
        totalBalance += initDeposit;
        numOfAccounts++;
    }
    
    public void saveMoney(int money) {
        balance += money;
        totalBalance += money;
    }
    
    public void withdrawMoney(int money) {
        balance -= money;
        totalBalance -= money;
    }
    
    private static int getTotalBalance() {
        return totalBalance;
    }
    
    private static int getNumOfAccounts() {
        return numOfAccounts;
    }
    
    public static void main(String args[]) {
        Account acct1 = new Account(100);
        Account acct2 = new Account(200);
        
        acct1.saveMoney(200);
        acct2.saveMoney(100);
        
        acct1.withdrawMoney(50);
        acct2.withdrawMoney(40);
        
        System.out.printf("The total balance is $%d in %d accounts",
                Account.getTotalBalance(), Account.getNumOfAccounts());
        
    }
}
