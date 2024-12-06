package fr.epita.bank.datamodel;

public class SavingsAccount extends CustomerAccount{

    double interestRate;
    Customer customer;

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "interestRate=" + interestRate +
                ", customer=" + customer +
                ", balance=" + balance +
                '}';
    }
}
