public class Customer {
    private final String firstName;
    private final Account account;
    private final String lastName;

    Customer(String firstName, String lastName, Account account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.account = account;
    }

    @Override
    public String toString(){
        return "\nCustomer Information:\n" +
                " First Name: " + firstName + "\n" +
                " Last Name: " + lastName + "\n" +
                account;
    }

    public String basicInfo(){
        return " First Name: " + firstName +
                " Last Name: " + lastName + " " + account +
                " Account Number: " + account.getAccountNumber();
    }

    Account getAccount(){
        return account;
    }
}
