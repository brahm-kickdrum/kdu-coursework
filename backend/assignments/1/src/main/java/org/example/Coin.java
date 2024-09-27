package org.example;

import java.util.HashMap;
import java.util.Map;

public class Coin {
    int rank;
    String name;
    String symbol;
    double price;
    long supply;
    public static Map<String, Long> coinTraders = new HashMap<>();

    public int getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }

    public long getSupply() {
        return supply;
    }

    public long getSupplyFromWalletAddress(String walletAddress){
        return coinTraders.get(walletAddress);
    }

    public Map<String, Long> getCoinTraders() {
        return coinTraders;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSupply(long supply) {
        this.supply = supply;
    }

    public void setSupplyByWalletAddress(String walletAddress, long supply){
        if (coinTraders.containsKey(walletAddress)) {
            coinTraders.replace(walletAddress, supply);
        } else {
            coinTraders.put(walletAddress,supply);
        }
    }




}
