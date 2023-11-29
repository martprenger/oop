package week1.crypto;

public class CryptoConsole implements Observer{

    @Override
    public void update(Market market) {
        System.out.println("=========");
        for(int i=0; i<market.getNumberOfCoins(); i++) {
            System.out.println(market.getCoinName(i) + ": € " + market.getCoinPrice(i));
        }
    }
}
