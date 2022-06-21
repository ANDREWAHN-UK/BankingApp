public class CurrentAccount extends Account{

    public static String accountType = "Current";
    private static int numberOfAccounts = 3000000;

    CurrentAccount(double initialDeposit){
        super();
        this.setBalance(initialDeposit);
        this.setSortCode(112233);
        this.setAccountNumber(numberOfAccounts++);
        this.checkInterest(); //NB there will be no interest on anything but ISA accounts, this is just here for now because of the video
    }


    @Override
    public String toString(){
        return accountType + "Account\n" +
                "Account Number: " + this.getAccountNumber() + "\n" +
                "Balance: " + this.getBalance() + "\n" +
                "Interest Rate: " + this.getInterest() + "\n" ;
    }
}
