import java.util.ArrayList;
import java.util.Scanner;

//this is the menu
public class Menu {

    Scanner Keyboard = new Scanner(System.in);

    Bank bank = new Bank();
    boolean exit;

    public static void main(String[] args) {
        Menu menu = new Menu();

        menu.runMenu();
    }

    private void checkBalance() {
    }

    private void makeWithdrawal() {
        int account = selectAccount();
        if(account >=0 ) {
            System.out.println("How much would you like to withdraw? ");
            double amount;
            try{
                amount = Double.parseDouble(Keyboard.nextLine());
            } catch(NumberFormatException e){
                amount = 0;
            }
            Bank.getCustomer(account).getAccount().makeWithdrawal(amount);
        }
    }

    private void makeDeposit() {
        int account = selectAccount();
        if(account >=0 ) {
            System.out.println("How much would you like to deposit? ");
            double amount;
            try{
                amount = Double.parseDouble(Keyboard.nextLine());
            } catch(NumberFormatException e){
                amount = 0;
            }
            Bank.getCustomer(account).getAccount().makeDeposit(amount);
        }

    }
//gets run inside makeDeposit() and makeWithdrawal();
    private int selectAccount() {
        ArrayList<Customer> customers = bank.getCustomers();
        if(customers.size() <= 0){
            System.out.println("No customers at your bank.");
            return -1;
        }
        System.out.println("These are the available accounts: ");
        for(int i = 0; i< customers.size(); i++){
            System.out.println((i+1) + ")" + customers.get(i).toString());
        }
        double account = 0;
        System.out.print("Please choose one of the above accounts: ");
        try {
            account = Double.parseDouble(Keyboard.nextLine()) -1;
        }
        catch(NumberFormatException e){
            account = 0;
        }
        return (int) account;
    }

    private void createAccount() {
        boolean valid = false;
        String firstName, lastName, accountType="";
        double initialDeposit=0;


        while (!valid) {
            System.out.print("Please enter an account type: Current/Business/ISA");
            accountType = Keyboard.nextLine();
            if (accountType.equalsIgnoreCase("Current") || accountType.equalsIgnoreCase("Business") || accountType.equalsIgnoreCase("ISA")) {
                valid=true;
            } else {
                System.out.println("Invalid account type selected. Please enter Current/Business/ISA");
            }
        }
        System.out.print("Please enter your first name: ");
        firstName=Keyboard.nextLine();
        System.out.print("Please enter your last name: ");
        lastName=Keyboard.nextLine();

        valid = false;
        while(!valid){
            System.out.println("Please enter an initial deposit");
            try{
                initialDeposit = Double.parseDouble(Keyboard.nextLine());
            } catch (Exception e){
                System.out.println("Deposit must be a number.");
            }
            valid = true;

            if(accountType.equalsIgnoreCase("ISA")){
                if(initialDeposit < 100){
                    System.out.println("ISA accounts require a minimum of £100 to open");
                }
            }
        }

        Account account;
        if(accountType.equalsIgnoreCase("Current")){
            account = new CurrentAccount(initialDeposit);
        } else if(accountType.equalsIgnoreCase("Business")){
            account = new BusinessAccount(initialDeposit);
        } else{
            account = new ISAAccount(initialDeposit);
        }

        Customer customer = new Customer(firstName, lastName, account);
        Bank.addCustomer(customer);
    }


    //populate the initial menu
    private void printHeader() {
        System.out.println("+-----------------------------------+");
        System.out.println("|           Welcome to the          |");
        System.out.println("|           Novus Bank App          |");
        System.out.println("+-----------------------------------+");
    }

    //populate the initial menu
    private void printMenu() {

        System.out.println("Please make a Selection: ");
        System.out.println("1. Create a new account");
        System.out.println("2. Make a deposit");
        System.out.println("3. Make a withdrawal");
        System.out.println("4. Check Account Balance");
        System.out.println("0. Exit");
    }

    //populate the initial menu
    private void performAction(int choice) {

        switch (choice) {
            case 0 -> {
                System.out.println("Thank you for using our application.");
                System.exit(0);
            }
            case 1 -> createAccount();
            case 2 -> makeDeposit();
            case 3 -> makeWithdrawal();
            case 4 -> checkBalance();
            default -> System.out.println("Unknown error has occurred. ");
        }
    }
    //used in initial menu
    private int getInput() {

        int choice = -1;

        do {
            System.out.print("Enter your choice: ");
            try {
                choice = Keyboard.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid selection, numbers only please.");
            }

            if (choice < 0 || choice > 4) {
                System.out.println("Choice not possible, please choose from 1 to 4.");
            }
        }
        while  (choice < 0 || choice > 4);
        return choice;
    }

    public void runMenu(){
        printHeader();

        while(!exit){
            printMenu();
            int choice = getInput();
            performAction(choice);
        }
    }

}
