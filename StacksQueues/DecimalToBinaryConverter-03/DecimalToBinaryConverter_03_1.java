package StacksQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DecimalToBinaryConverter_03_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimalNumber = Integer.parseInt(scanner.nextLine());

        Deque<Integer> binaryStack = new ArrayDeque<>(); // <- Съхранявам бинарната репрезентация

        while (decimalNumber != 0) {

            boolean hasRemainder = decimalNumber % 2 != 0; // <- Ако има остатък

            if (hasRemainder) {

                binaryStack.push(1);

            } else { // <- Ако няма остатък

                binaryStack.push(0);

            }

            decimalNumber /= 2;

        }

        if (binaryStack.isEmpty()) { // <- Ако ми се подаде 0, като вход

            System.out.println("0");

        } else {

            binaryStack.forEach(e -> System.out.print(e));

        }

    }

}
