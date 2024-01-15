package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ExecuteTransaction implements Runnable {
    LoggerFile log = new LoggerFile();
    private CountDownLatch latch;
    private List<Transaction> transactions; // Declare transactions as an instance variable
    private CoinList coinArr;
    /**
     *
     * @param latch
     */
    public ExecuteTransaction(List<Transaction> transactions, CoinList coinArr, CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            processTransaction();
        } finally {
            latch.countDown();
        }
    }
    private void processTransaction() {
        for (Transaction transaction : transactions) {
            switch (transaction.getType()) {
                case "BUY":
                    handleBuyTransaction((BuyTransaction) transaction, coinArr);
                    break;
                case "SELL":
                    handleSellTransaction((SellTransaction) transaction, coinArr);
                    break;
                case "ADD_VOLUME":
                    handleAddVolumeTransaction((AddVolumeTransaction) transaction, coinArr);
                    break;
                case "UPDATE_PRICE":
                    handleUpdatePriceTransaction((UpdatePriceTransaction) transaction, coinArr);
                    break;
                default:
                    log.logInfo("Unknown transaction type: " + transaction.getType());
            }
        }

    }

    static void handleBuyTransaction(BuyTransaction buyTransaction, CoinList coinArr) {
        coinArr.buyCoin(buyTransaction.getCoin(), buyTransaction.getQuantity(), buyTransaction.getWalletAddress());
    }
    static void handleSellTransaction(SellTransaction sellTransaction, CoinList coinArr) {
        coinArr.sellCoin(sellTransaction.getCoin(), sellTransaction.getQuantity(), sellTransaction.getWalletAddress());
    }

    static void handleAddVolumeTransaction(AddVolumeTransaction addVolumeTransaction, CoinList coinArr) {
        coinArr.addVolume(addVolumeTransaction.getCoin(), addVolumeTransaction.getVolume());
    }

    static void handleUpdatePriceTransaction(UpdatePriceTransaction updatePriceTransaction, CoinList coinArr) {
        coinArr.updatePrice(coinArr.retrieveCoinDetailsBySymbol(updatePriceTransaction.getCoin()), updatePriceTransaction.getPrice());
    }

}