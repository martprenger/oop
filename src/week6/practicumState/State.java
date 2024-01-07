package week6.practicumState;

public interface State {

    void insertCard();
    void enterPincode(String pin);
    void enterAmount(int amount);
    void takeMoney();
    void cancel();

}
