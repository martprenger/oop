package week1.crypto;

public class Main {
    public static void main(String[] args) {
        Market market = new Market();
        market.addCoin(new Coin("BTC", "Bitcoin", 51000));
        market.addCoin(new Coin("LTC", "Litecoin", 183));
        market.addCoin(new Coin("XRP" ,"Ripple", 0.8684));

        CryptoConsole cryptoConsole = new CryptoConsole();
        CryptoAlltimeHighNotification BTCHighPrice = new CryptoAlltimeHighNotification("BTC");
        market.registerObserver(cryptoConsole);
        market.registerObserver(BTCHighPrice);
    }
}
