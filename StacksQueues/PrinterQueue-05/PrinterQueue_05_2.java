package StacksQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PrinterQueue_05_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Deque<String> printerQueue = new ArrayDeque<>(); // <- Ще съхранявам елементите, ако останат

        while (!input.equals("print")) {

            if (input.equals("cancel")) { // <- Ако е "cancel"

                String output = printerQueue.isEmpty() // <- Задавам стойност на output
                        ? "Printer is on standby"
                        : String.format("Canceled %s", printerQueue.poll());

                System.out.println(output);

            } else { // <- Ако не е "cancel"

                printerQueue.offer(input);

            }

            input = scanner.nextLine();

        }

        while (!printerQueue.isEmpty()) { // <- Принтирам, ако има останали

            System.out.println(printerQueue.poll());

        }

    }

}
