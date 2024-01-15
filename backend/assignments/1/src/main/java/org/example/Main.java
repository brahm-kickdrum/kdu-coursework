package org.example;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.example.ExecuteTransaction.*;
import static org.example.TransactionReader.readTransactionsFromFile;

public class Main {

    private static final LoggerFile log = new LoggerFile();

    public static void main(String[] args) {

        String coinsCsvFile = "src/main/resources/coins.csv";

        String tradersCsvFile = "src/main/resources/traders.csv";

        TraderList traderArr = new TraderList();
        traderArr.readTraderCSV(tradersCsvFile);

        CoinList coinArr = new CoinList(traderArr);
        coinArr.readCoinCSV(coinsCsvFile);


        coinArr.getTopNCoins(5);

        String filePath = "src/main/resources/small_transaction.json";
        List<Transaction> transactions = readTransactionsFromFile(filePath);


        CountDownLatch latch = new CountDownLatch(transactions.size());


        try {
            ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
            for (Transaction transaction : transactions)
                executorService.submit(new ExecuteTransaction(transactions, coinArr, latch));
            executorService.shutdown();
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }

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
}