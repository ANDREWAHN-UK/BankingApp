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
    private void performAction(int choice) {

        switch (choice){
            case 0:
                System.out.println("Thank you for using out application.");
                System.exit(0);
                break;
            case 1:
                createAccount();
                break;
            case 2:
                makeDeposit();
                break;
            case 3:
                makeWithdrawal();
                break;
            case 4:
                checkBalance();
                break;

            default:
                System.out.println("Unknown error has occurred. ");
        }
    }

    private void checkBalance() {
    }

    private void makeWithdrawal() {
    }

    private void makeDeposit() {
    }

    private void createAccount() {
        String firstName, lastName, accountType="";
        double initialDeposit=0;

        boolean valid = false;
        while (!valid) {
            System.out.print("Please enter an account type: Current/Business/ISA");
            accountType = Keyboard.nextLine();
            if (accountType.equalsIgnoreCase("current") || accountType.equalsIgnoreCase("business") || accountType.equalsIgnoreCase("ISA")) {
                valid = true;
            } else{
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
                } else {
                    valid = true;
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

    }

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
        while  (choice < 0 || choice > 7);
        return choice;
    }

    private void printMenu() {

        System.out.println("Please make a Selection: ");
        System.out.println("1. Create a new account");
        System.out.println("2. Make a deposit");
        System.out.println("3. Make a withdrawal");
        System.out.println("4. Check Account Balance");
        System.out.println("0. Exit");
    }

    private void printHeader() {
        System.out.println("+-----------------------------------+");
        System.out.println("|           Welcome to the          |");
        System.out.println("|           Novus Bank App          |");
        System.out.println("+-----------------------------------+");
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
