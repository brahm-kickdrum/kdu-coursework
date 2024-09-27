package org.example;

public class UpdatePriceTransaction implements Transaction {
    private String type = "UPDATE_PRICE";
    private String coin;
    private double price;

    public UpdatePriceTransaction() {
    }

    public UpdatePriceTransaction(String coin, double price) {
        this.coin = coin;
        this.price = price;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
