package fr.epita.bank.datamodel;

public class StockOrder {
    private InvestmentAccount account;
    private Stock stock;

    private double unitPrice;
    private int quantity;

    public StockOrder(InvestmentAccount account, Stock stock, int quantity) {
        this.account = account;
        this.stock = stock;
        this.unitPrice = stock.getUnitPrice();
        this.quantity = quantity;
    }

    public InvestmentAccount getAccount() {
        return account;
    }

    public void setAccount(InvestmentAccount account) {
        this.account = account;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
