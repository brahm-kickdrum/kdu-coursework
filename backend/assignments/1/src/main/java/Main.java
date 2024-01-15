
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.example.ExecuteTransaction.*;
import static org.example.TransactionReader.readTransactionsFromFile;

public class Main {

    private static final LoggerService log = new LoggerService();

    public static void main(String[] args) {

        String coinsCsvFile = "src/main/resources/coins.csv";

        String tradersCsvFile = "src/main/resources/traders.csv";

        TraderList traderArr = new TraderList();
        traderArr.makeTradersList(tradersCsvFile);

        CoinList coinArr = new CoinList(traderArr);
        coinArr.makeCoinList(coinsCsvFile);

        String targetCoinName = "Bitcoin";
        Coin targetCoin = coinArr.retrieveCoinDetails(targetCoinName);
        if (targetCoin != null) {
            log.logInfo("Coin found: " + targetCoin);
        } else {
            log.logInfo("Coin not found with name: " + targetCoinName);
        }


        String firstName = "Flo";
        String lastName = "Bookamer";
        Trader targetTrader = traderArr.retrieveTraderDetails(firstName, lastName);
        if (targetTrader != null) {
            log.logInfo("Trader found: " + targetTrader);
        } else {
            log.logInfo("Trader not found with name: " + firstName);
        }

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