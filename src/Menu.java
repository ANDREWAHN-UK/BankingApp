import java.util.Scanner;

//this is the menu
public class Menu {

    Scanner Keyboard = new Scanner(System.in);

    Bank bank = new Bank();
    boolean exit;
    private void performAction(int choice) {

        switch (choice){
            case 0:
                System.out.println("Thank you for using out application.");
                System.exit(0);
                break;
            case 1:
                //log in as admin
                break;
            case 2:
                //log in as customer
                break;
            case 3:
                //make a deposit
                break;
            case 4:
                //make a withdrawal
                break;
            case 5:
                //check account balance
                break;
            case 6:
                //transfer funds
                break;
            case 7:
                //display menu again
                break;
            default:
                System.out.println("Unknown error has occurred. ");
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

            if (choice < 0 || choice > 7) {
                System.out.println("Choice not possible, please choose from 1 to 7.");
            }
        }
        while  (choice < 0 || choice > 7);
        return choice;
    }

    private void printMenu() {

        System.out.println("Please make a Selection: ");
        System.out.println("1. Log in as Admin");
        System.out.println("2. Log in as Customer");
        System.out.println("3. Make a deposit");
        System.out.println("4. Make a withdrawal");
        System.out.println("5. Check Account Balance");
        System.out.println("6. Transfer Funds");
        System.out.println("7. Display Menu Options again");
        System.out.println("0. Exit");
    }

    private void printHeader() {
        System.out.println("+-----------------------------------+");
        System.out.println("|           Welcome to the          |");
        System.out.println("|           Novus Bank App          |");
        System.out.println("+-----------------------------------+");
    }


    public static void main(String[] args) {

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
