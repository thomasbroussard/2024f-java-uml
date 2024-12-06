package fr.epita.bank.launcher;

import fr.epita.bank.datamodel.*;

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

        double balance = account.getBalance();
        double gain = balance * account.getInterestRate();
        account.setBalance(balance + gain);

        System.out.println(account);

        //the customer wants to buy :
        // - 5 (ounce) units of GOLD stock,
        // - 160 units of Apple actions.
        // they are respectively at 100€ and 6,7€.
        // The initial balance is set to 1000€

        InvestmentAccount investmentAccount = new InvestmentAccount();
        investmentAccount.setBalance(1000);

        Stock gold = new Stock("GOLD", 100);
        Stock apple = new Stock ("Apple", 6.7);

        StockOrder appleOrder = new StockOrder(investmentAccount, apple, 160);
        StockOrder goldOrder = new StockOrder(investmentAccount, gold, 5);

        double appleOrderCost = appleOrder.getQuantity() * appleOrder.getUnitPrice();
        double goldOrderCost = goldOrder.getQuantity() * goldOrder.getUnitPrice();

        System.out.println("total cost:"  + (appleOrderCost + goldOrderCost));


    }

}
