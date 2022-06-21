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
            return;
        }
        balance -= amount;
        checkInterest();
        System.out.println("You have withdrawn " + amount + " pounds. Thank you for using us. ");
        System.out.println("Your balance is now " + balance + " pounds. ");
    }

    public void makeDeposit(double amount){

        if(amount <= 0){
            System.out.println("You cannot deposit a negative amount.");
            return;
        }
        checkInterest();
        amount = amount;
        balance+= amount;
        System.out.println("You have deposited " + amount + " pounds. Thank you for using us. ");
        System.out.println("You now have a balance of " + balance);
    }

    public void checkInterest(){
        if (balance > 100){
            interest=0.0;
        } else {
            interest = 0;
        }
    }


}
