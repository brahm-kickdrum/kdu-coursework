package org.example;

public class Trader {

    String firstName;
    String lastName;
    String phoneNumber;
    String walletAddress;
    double profit;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getWalletAddress() {
        return walletAddress;
    }
    public double getProfit() {
        return profit;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }
}
