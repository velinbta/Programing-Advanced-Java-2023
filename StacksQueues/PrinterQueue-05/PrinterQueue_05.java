package StacksQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PrinterQueue_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fileName = scanner.nextLine();

        Deque<String> queue = new ArrayDeque<>(); // <- Ще съхранявам елементите, ако останат

        while (!fileName.equals("print")) {

            if (!fileName.equals("cancel")) { // <- Ако не е "cancel"

                queue.offer(fileName);

            } else { // <- Ако е "cancel"

                if (queue.isEmpty()) {

                    System.out.println("Printer is on standby");

                } else {

                    System.out.printf("Canceled %s\n", queue.poll()); // <- Махам "опашката"

                }

            }

            fileName = scanner.nextLine();

        }

        queue.forEach(e -> System.out.println(e)); // <- Принтирам, ако има останали

    }

}
