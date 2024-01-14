import java.util.List;

public class Main {

    private static final LoggerFile log = new LoggerFile();

    public static void main(String[] args) {

        String coinsCsvFile = "src/main/resources/coins.csv";

        String tradersCsvFile = "src/main/resources/traders.csv";

        TraderList traderArray = new TraderList();
        traderArray.readTraderCSV(tradersCsvFile);

        CoinList coinArr = new CoinList(traderArray);
        coinArr.readCoinCSV(coinsCsvFile);

        String targetCoinName = "Bitcoin";
        Coin targetCoin = coinArr.retrieveCoinDetailsBySymbol(targetCoinName);
        if (targetCoin != null) {
            log.logInfo("Coin found: " + targetCoin);
        } else {
            log.logInfo("Coin not found with name: " + targetCoinName);
        }

        String firstName = "Flo";
        String lastName = "Bookamer";
        traderArray.retrieveTraderDetails(firstName, lastName);

        coinArr.getTopNCoins(5);

        String filePath = "src/main/resources/small_transaction.json";
        List<Transaction> transactions = TransactionReader.readTransactionsFromFile(filePath);
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
    private static void handleBuyTransaction(BuyTransaction buyTransaction, CoinList coinArr) {
        coinArr.buyCoin(buyTransaction.getCoin(), buyTransaction.getQuantity(), buyTransaction.getWalletAddress());
    }
    private static void handleSellTransaction(SellTransaction sellTransaction, CoinList coinArr) {
        coinArr.sellCoin(sellTransaction.getCoin(), sellTransaction.getQuantity(), sellTransaction.getWalletAddress());
    }

    private static void handleAddVolumeTransaction(AddVolumeTransaction addVolumeTransaction, CoinList coinArr) {
        coinArr.addVolume(addVolumeTransaction.getCoin(), addVolumeTransaction.getVolume());
    }

    private static void handleUpdatePriceTransaction(UpdatePriceTransaction updatePriceTransaction, CoinList coinArr) {
        coinArr.updatePrice(coinArr.retrieveCoinDetailsBySymbol(updatePriceTransaction.getCoin()), updatePriceTransaction.getPrice());
    }

}