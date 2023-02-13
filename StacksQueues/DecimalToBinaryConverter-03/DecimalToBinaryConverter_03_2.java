package StacksQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DecimalToBinaryConverter_03_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimalNumber = Integer.parseInt(scanner.nextLine());

        Deque<Integer> binaryStack = new ArrayDeque<>(); // <- Тук държа бинарната репрезентация

        while (decimalNumber != 0) {

            binaryStack.push(decimalNumber % 2); // <- Именно резултата - остатъка

            decimalNumber /= 2;

        }

        if (binaryStack.isEmpty()) { // <- Ако получа нула като входни данни

            System.out.println("0");

        } else {

            binaryStack.forEach(e -> System.out.print(e));

        }

    }

}
