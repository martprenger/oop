package week3.command;

import java.util.ArrayList;
import java.util.Scanner;

public class RemoteControl {

    private ArrayList<Command> commands = new ArrayList<>();
    private ArrayList<String> labels  = new ArrayList<>();;

    public void addCommand(Command command, String label) {
        commands.add(command);
        labels.add(label);
    }

    public void start() {
        System.out.println("Remote control");
        System.out.println();
        System.out.println("Buttons:");
        for(int i=0; i<labels.size(); i++) {
            System.out.println(i+1+" - "+labels.get(i));
        }
        Scanner scanner = new Scanner(System.in);
        int key = 0;
        do {
            System.out.print("Enter key (0=quit): ");
            try {
                key = Integer.parseInt(scanner.nextLine());
            } catch(NumberFormatException e) {
                key = -1;
            }
            if (key>0 && key<=commands.size()) {
                Command command = commands.get(key-1);
                command.execute();
            }
        } while(key!=0);
    }

}