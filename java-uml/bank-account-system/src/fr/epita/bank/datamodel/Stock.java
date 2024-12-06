package fr.epita.bank.datamodel;

//adding a comment , will create conflict
public class Stock {
    private String stockName;
    private double unitPrice;

    public Stock(String stockName, double unitPrice) {
        this.stockName = stockName;
        this.unitPrice = unitPrice;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
