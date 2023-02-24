package StacksQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class BasicQueueOperations_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] elementsArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        int[] lineOfNumbersArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        Deque<Integer> numQueue = new ArrayDeque<>();

        int numbersToOffer = elementsArr[0]; // <- Елементите, които да вкарам в опашката
        int numbersToPoll = elementsArr[1]; // <- Елементите, които да изкарам от опашката
        int numberToCheckIfPresent = elementsArr[2]; // <- Елемент, който да проверя дали е в опашката

        for (int i = 0; i < numbersToOffer; i++) { // <- Вкарвам необходимия брой елементи в опашката

            int currentElement = lineOfNumbersArr[i];
            numQueue.offer(currentElement);

        }

        for (int i = 0; i < numbersToPoll; i++) {

            if (!numQueue.isEmpty()) { // <- Ако не е празна, изкарвам елементи
                numQueue.poll();
            }

        }

        if (numQueue.isEmpty()) { // <- Ако е празна

            System.out.println(0);

        } else if (numQueue.contains(numberToCheckIfPresent)) { // <- Ако се съдържа в опашката

            System.out.println("true");

        } else { // <- Иначе, намирам най-малкия елемент в опашката

            int smallestNumberInQueue = numQueue.stream().mapToInt(e -> e).min().orElse(-1);
            System.out.println(smallestNumberInQueue);

        }

    }

}
