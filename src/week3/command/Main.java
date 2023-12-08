package week3.command;

public class Main {
    public static void main(String[] args) {
        Television television = new Television();
        Command commandOn = new CommandOn(television);
        RemoteControl remoteControl = new RemoteControl();

        remoteControl.addCommand(commandOn, "Televisie aan");
        remoteControl.start();
    }
}
