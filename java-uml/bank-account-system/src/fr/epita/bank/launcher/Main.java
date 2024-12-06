package fr.epita.bank.launcher;

import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.datamodel.SavingsAccount;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, welcome to the application");

        Customer customer = new Customer();
        customer.setName("Thomas");
        customer.setAddress("Paris");

        //customer savings account creation
        SavingsAccount account = new SavingsAccount();
        account.setCustomer(customer);
        account.setInterestRate(0.025);
        account.setBalance(2000);
        //2000 euros on the account, what would be the gain for the customer?



    }

}
