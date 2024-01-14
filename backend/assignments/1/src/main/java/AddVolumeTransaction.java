public class AddVolumeTransaction implements Transaction {
    private String type = "ADD_VOLUME";
    private String coin;
    private long volume;

    public AddVolumeTransaction() {
    }

    public AddVolumeTransaction(String coin, long volume) {
        this.coin = coin;
        this.volume = volume;
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

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }
}
