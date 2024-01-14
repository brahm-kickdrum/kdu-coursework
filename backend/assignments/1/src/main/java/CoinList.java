import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CoinList {
    private TraderList traderList;
    public CoinList(TraderList traderList) {
        this.traderList = traderList;
    }
    public static List<Coin> coinArray = new CopyOnWriteArrayList<>();
    private static final LoggerFile log = new LoggerFile();
    public static void readCoinCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Coin coin = createCoinFromData(data);
                coinArray.add(coin);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Coin createCoinFromData(String[] data) {
        Coin coin = new Coin();
        try {
            coin.setRank(Integer.parseInt(data[1]));
        } catch (NumberFormatException e) {
            coin.setRank(0);
        }

        coin.setName(data[2]);
        coin.setSymbol(data[3]);

        try {
            coin.setPrice(Double.parseDouble(data[4]));
        } catch (NumberFormatException e) {
            coin.setPrice(0.0);
        }

        try {
            coin.setSupply(Long.parseLong(data[5]));
        } catch (NumberFormatException e) {
            coin.setSupply(0);
        }

        return coin;
    }

    public void retrieveCoinDetailsByName(String s) {
        Coin c =  coinArray.stream()
                .filter(coin -> coin.getName().equals(s))
                .findFirst()
                .orElse(null);
        if(c==null){
            log.logError("Coin not found");
        }
        else{
            log.logInfo("\nName : " + c.getName() + "\nSymbol : " + c.getSymbol() + "\nPrice : " + c.getPrice() + "\nSupply : " +  c.getSupply());
        }
    }
    public Coin retrieveCoinDetailsBySymbol(String s) {
        return coinArray.stream()
                .filter(coin -> coin.getSymbol().equals(s))
                .findFirst()
                .orElse(null);
    }

    public void getTopNCoins(int n) {
        coinArray.stream()
                .sorted((c1, c2) -> Double.compare(c2.getPrice(), c1.getPrice()))
                .limit(n)
                .forEach(coin -> log.logInfo("\nName : " + coin.getName() + "\nSymbol : " + coin.getSymbol() + "\nPrice : " + coin.getPrice() + "\nSupply : " +  coin.getSupply()));
    }


    public synchronized void buyCoin(String coin, int quantity, String walletAddress){
        Coin c = retrieveCoinDetailsBySymbol(coin);
        if(c.getSupply()>=quantity){
            c.setSupply(c.getSupply()-quantity);
            c.setSupplyByWalletAddress(walletAddress,quantity);
        }
        else{
            log.logInfo("Can not buy coins due to insufficient supply");
        }
    }

    public synchronized void sellCoin(String coin, int quantity, String walletAddress){

        Coin c = retrieveCoinDetailsBySymbol(coin);
        if(c!=null){
            if(quantity <= c.getSupplyFromWalletAddress(walletAddress)){
                c.setSupply(c.getSupply() + quantity);
                c.setSupplyByWalletAddress(walletAddress, c.getSupplyFromWalletAddress(walletAddress) - quantity);
                log.logInfo("Successfully sold the coins");
            }
            else{
                log.logError("Not enough coins to sell");
            }
        }
        else{
            log.logError("No coins to sell as the coins are not bought");
        }
    }
    public synchronized void updatePrice(Coin coin, double price){

        coin.getCoinTraders().forEach((walletAddress, quantity) -> {

            Trader trader = traderList.retrieveTraderDetailsFromWalletAddress(walletAddress);
            if (trader != null) {
                double profit = calculateProfit(coin.getPrice(), price, quantity);
                trader.setProfit(profit);
            }
        });
        coin.setPrice(price);
    }

    public double calculateProfit(double newPrice, double oldPrice, long quantity){
        return (newPrice - oldPrice)*quantity;
    }

    public synchronized void addVolume(String coin, long volume){
        Coin c = retrieveCoinDetailsBySymbol(coin);
        c.setSupply(c.getSupply() + volume);
    }

}
