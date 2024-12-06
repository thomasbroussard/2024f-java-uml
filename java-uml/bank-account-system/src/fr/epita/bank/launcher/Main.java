package fr.epita.bank.launcher;

import fr.epita.bank.datamodel.Customer;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, welcome to the application");

        Customer customer = new Customer();

        customer.name = "12343423";
        customer.setAddress(null);

    }

}
