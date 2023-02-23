package StacksQueues;

import java.util.*;

public class MaximumElement_03_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine()); // <- Брой команди
        Deque<Integer> intStack = new ArrayDeque<>();

        for (int i = 0; i < numberOfCommands; i++) {

            int[] commandArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(e -> Integer.parseInt(e)).toArray();

            int command = commandArr[0]; // <- Извеждам командата

            switch (command) { // <- Търся, според командата

                case 1:

                    int numberToPush = commandArr[1];
                    intStack.push(numberToPush); // <- Слагам елемента на върха

                    break;

                case 2: // <- Махам елемента на върха

                    if (!intStack.isEmpty()) {
                        intStack.pop();
                    }

                    break;

                case 3: // <- Намирам най-голямото число в стека

                    int max = intStack.stream().mapToInt(e -> e).max().orElse(-1);
                    System.out.println(max);

                    break;

            }

        }

    }

}
