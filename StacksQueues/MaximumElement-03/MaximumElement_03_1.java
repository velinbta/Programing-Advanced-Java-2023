package StacksQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MaximumElement_03_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine()); // <- Брой команди

        Deque<Integer> numStack = new ArrayDeque<>();

        for (int i = 0; i < numberOfCommands; i++) {

            String[] commandArr = scanner.nextLine().split("\\s+");

            int command = Integer.parseInt(commandArr[0]); // <- Извеждам командата

            switch (command) { // <- Търся, според командата

                case 1:

                    int numberToPush = Integer.parseInt(commandArr[1]);
                    numStack.push(numberToPush); // <- Слагам елемента на върха
                    break;

                case 2: // <- Махам елемента на върха

                    if (!numStack.isEmpty()) {
                        numStack.pop();
                    }
                    break;

                case 3: // <- Намирам най-голямото число в стека

                    int max = getMaxElementInStack(numStack);
                    System.out.println(max);
                    break;

            }

        }

    }

    private static int getMaxElementInStack(Deque<Integer> numStack) {
        // Намирам най-голямото число в стека
        int max = Integer.MIN_VALUE;

        for (int current : numStack) {

            if (current > max) {

                max = current;

            }

        }

        return max;

    }

}
