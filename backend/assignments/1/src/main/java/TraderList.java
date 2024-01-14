import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TraderList {

    public static List<Trader> traderArray = new CopyOnWriteArrayList<>();

    private static final LoggerFile log = new LoggerFile();
    public void readTraderCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Trader trader = createTraderFromData(data);
                traderArray.add(trader);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Trader createTraderFromData(String[] data) {
        Trader trader = new Trader();

        trader.setFirstName(data[1]);
        trader.setLastName(data[2]);
        trader.setPhoneNumber(data[3]);
        trader.setWalletAddress(data[4]);

        return trader;
    }
    public static void retrieveTraderDetails(String firstName, String lastName) {

        Trader t =  traderArray.stream()
                .filter(trader -> trader.getFirstName().equals(firstName) && trader.getLastName().equals(lastName))
                .findFirst()
                .orElse(null);
        if(t==null){
            log.logError("Coin not found");
        }
        else{
            log.logInfo("\nFirst Name : " + t.getFirstName() + "\nLastName : " + t.getLastName() + "\nPhone number : " + t.getPhoneNumber() + "\nWallet Address : " +  t.getWalletAddress());
        }
    }
    public Trader retrieveTraderDetailsFromWalletAddress(String walletAddress) {

        return traderArray.stream()
                .filter(trader -> trader.getWalletAddress().equals(walletAddress) )
                .findFirst()
                .orElse(null);
    }

    public double retrieveProfitFromWalletAddress(String walletAddress){
        Trader t = retrieveTraderDetailsFromWalletAddress(walletAddress);
        return t.getProfit();
    }

    public void topAndBottomFiveTraders(){
        topFiveTraders();
        bottomFiveTraders();
    }

    public void bottomFiveTraders(){

        traderArray.stream()
                .sorted((t1,t2)-> Double.compare(t1.getProfit(), t2.getProfit()))
                .limit(5)
                .forEach(t -> logTrader(t));
    }
    public void topFiveTraders() {
        traderArray.stream()
                .sorted((t1, t2) -> Double.compare(t2.getProfit(), t1.getProfit()))
                .limit(5)
                .forEach(t -> logTrader(t));
    }

    public void logTrader(Trader t) {
        log.logInfo("\nFirst Name : " + t.getFirstName() + "\nLastName : " + t.getLastName() + "\nPhone number : " + t.getPhoneNumber() + "\nWallet Address : " +  t.getWalletAddress());
    }


    public static void main(String[] args) {
        String filePath = "src/main/resources/traders.csv";
        TraderList tr = new TraderList();
        tr.readTraderCSV(filePath);

        tr.retrieveTraderDetails("Mitsue","Tollner");
    }
}
