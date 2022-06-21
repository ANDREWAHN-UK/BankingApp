public class BusinessAccount extends Account {

    public static String accountType = "Business";
    private static int numberOfAccounts = 2000000;
   BusinessAccount(double initialDeposit){
        super();
        this.setBalance(initialDeposit);
        this.setSortCode(778899);

        this.setAccountNumber(numberOfAccounts++);
    }

    @Override
    public String toString(){
        return accountType + "Account\n" +
                "Account Number: " + this.getAccountNumber() + "\n" +
                "Balance: " + this.getBalance() + "\n" +
                "Interest Rate: " + this.getInterest();
    }
}
