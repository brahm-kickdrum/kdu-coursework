package org.example;

public class SellTransaction implements Transaction {
    private String type = "SELL";
    private String coin;
    private int quantity;
    private String walletAddress;

    public SellTransaction() {
    }

    public SellTransaction(String coin, int quantity, String walletAddress) {
        this.coin = coin;
        this.quantity = quantity;
        this.walletAddress = walletAddress;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }
}
