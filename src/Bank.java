import java.util.ArrayList;

public class Bank {

    static ArrayList<Customer> customers = new ArrayList<Customer>();
  static void addCustomer(Customer customer) {
        customers.add(customer);
    }

  static Customer getCustomer(int account) {
      return customers.get(account);
    }

    ArrayList<Customer> getCustomers(){
      return customers;
    }

}
