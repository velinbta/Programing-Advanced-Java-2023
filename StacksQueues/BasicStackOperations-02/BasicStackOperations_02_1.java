package StacksQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class BasicStackOperations_02_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] elementsArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        int[] lineOfNumbersArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        Deque<Integer> numStack = new ArrayDeque<>();

        int elementsToPush = elementsArr[0]; // <- Елементите, който да вкарам в стека
        int elementsToPop = elementsArr[1]; // <- Елементите, който да изкарам от стека
        int checkIfPresentElement = elementsArr[2]; // <- Елемента, който да проверя дали е в стека

        for (int i = 0; i < elementsToPush; i++) { // <- Вкарвам необходимия брой елементи в стека

            int currentElement = lineOfNumbersArr[i];
            numStack.push(currentElement);

        }

        int popElements = elementsToPop;

        while (popElements > 0) {

            if (!numStack.isEmpty()) { // <- Ако numStack не е празен, изкарвам елемента на върха
                numStack.pop();
            }

            popElements--;
        }

        if (numStack.isEmpty()) { // <- Ако е празен

            System.out.println(0);

        } else if (numStack.contains(checkIfPresentElement)) { // <- Ако се съдържа в стека

            System.out.println("true");

        } else { // <- Намирам най-малкото число в стека

            int smallest = findTheSmallestNumberInStack(numStack);
            System.out.println(smallest);

        }

    }

    private static int findTheSmallestNumberInStack(Deque<Integer> stack) {
        // Намирам най-малкото число в стека
        int smallest = Integer.MAX_VALUE;

        for (Integer number : stack) {

            if (number < smallest) {

                smallest = number;

            }

        }

        return smallest;

    }

}
