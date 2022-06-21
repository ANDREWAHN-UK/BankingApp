public class Account {

    private double balance;
    private double interest;
    private int accountNumber;

    private static int numberOfAccounts = 1000000;

    private double sortCode;

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = numberOfAccounts++;
    }

    public double getSortCode() {
        return sortCode;
    }

    public void setSortCode(double sortCode) {
        this.sortCode = sortCode;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void makeWithdrawal(double amount){
        if(amount>balance){
            System.out.println("You have insufficient funds");
        }
    }

    public void makeDeposit(double amount){

    }


}
