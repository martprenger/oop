package week6.opgaveState1;

import week6.practicumState.ATM;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Order order = new Order();
        Scanner scanner = new Scanner(System.in);
        char command;
        do {
            System.out.println("0. Quit");
            System.out.println("1. Pay order");
            System.out.println("2. Send order");
            System.out.println("3. Return order");
            System.out.println("4. Refund order");
            System.out.print("Enter action (0..4): ");
            String s = scanner.nextLine().trim();
            System.out.println();
            command=(s.length()==1) ? s.charAt(0) : '\0';

            if (command=='1') {
                order.payOrder();
            }

            if (command=='2') {
                order.sendOrder();
            }

            if (command=='3') {
                order.returnOrder();
            }

            if (command=='4') {
                order.refundOrder();
            }

            System.out.println();
        } while (command!='0');
    }
}
