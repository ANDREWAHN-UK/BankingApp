public class ISAAccount extends Account{

    public static String accountType = "ISA";
    private static int numberOfAccounts = 4000000;
    ISAAccount(double initialDeposit){
        super();
        this.setBalance(initialDeposit);
        this.setSortCode(445566);
        this.setAccountNumber(numberOfAccounts++);
        if(initialDeposit>100){
            this.setInterest(5);
        } else {
            this.setInterest(0);
        }
    }

    @Override
    public String toString(){
        return accountType + "Account\n" +
                "Account Number: " + this.getAccountNumber() + "\n" +
                "Balance: " + this.getBalance() + "\n" +
                "Interest Rate: " + this.getInterest();
    }
}
