package week6.practicumState;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        Scanner scanner = new Scanner(System.in);
        char command;
        do {
            System.out.println("0. Quit");
            System.out.println("1. Insert card");
            System.out.println("2. Enter pincode");
            System.out.println("3. Enter amount");
            System.out.println("4. Take money");
            System.out.println("5. Cancel");
            System.out.print("Enter action (0..5): ");
            String s = scanner.nextLine().trim();
            System.out.println();
            command=(s.length()==1) ? s.charAt(0) : '\0';

            if (command=='1') {
                atm.insertCard();
            }

            if (command=='2') {
                System.out.print("Enter pincode: ");
                String pincode=scanner.nextLine();
                atm.enterPincode(pincode);
            }

            if (command=='3') {
                System.out.print("Enter amount of money: ");
                try {
                    int amount = Integer.parseInt(scanner.nextLine());
                    atm.enterAmount(amount);
                } catch(NumberFormatException e) { }
            }

            if (command=='4') {
                atm.takeMoney();
            }

            if (command=='5') {
                atm.cancel();
            }

            System.out.println();
        } while (command!='0');
    }
}
