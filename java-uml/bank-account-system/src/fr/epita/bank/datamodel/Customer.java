package fr.epita.bank.datamodel;

public class Customer {
    private String address;
    private String name;

    public Customer(String address, String name){
        this.name = name;
        this.address = address;
    }
    public Customer(){

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null){
            //do nothing or warning
            return;
        }
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
