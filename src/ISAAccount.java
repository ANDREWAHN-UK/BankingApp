public class ISAAccount extends Account{

    public static String accountType = "ISA";
    private static int numberOfAccounts = 4000000;
    ISAAccount(double initialDeposit){
        super();
        this.setBalance(initialDeposit);
        this.setSortCode(445566);
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
