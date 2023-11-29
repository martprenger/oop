package week1.crypto;

public class CryptoAlltimeHighNotification implements Observer{
    private String code; // afkorting van de munt
    private double highestPrice = 0;

    public CryptoAlltimeHighNotification(String code) {
        this.code = code;
    }

    @Override
    public void update(Market market) {
        double currentCoinPrice = market.getCoinPrice(code);
        if (highestPrice < currentCoinPrice){
            highestPrice = currentCoinPrice;
            System.out.println("Alltime high!! BTC Bitcoin € " + highestPrice);
        }
    }
}
