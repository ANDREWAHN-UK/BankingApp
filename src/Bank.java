import java.util.ArrayList;

public class Bank {

    static ArrayList<Customer> customers = new ArrayList<Customer>();
  static void addCustomer(Customer customer) {
        customers.add(customer);
    }

  static Customer getCustomer(double account) {
      return customers.get((int) account);
    }

    static ArrayList<Customer> getCustomers(){
      return customers;
    }

}
