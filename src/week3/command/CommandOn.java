package week3.command;

public class CommandOn implements Command {

    Television television;

    public CommandOn(Television television) {
        this.television = television;
    }

    @Override
    public void execute() {
        television.turnOn();
    }
}