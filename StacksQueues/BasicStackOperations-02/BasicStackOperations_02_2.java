package StacksQueues;

import java.util.*;

public class BasicStackOperations_02_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] elementsArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        int[] lineOfNumbersArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        int elementsToPush = elementsArr[0]; // <- Елементите, които да вкарам в стека
        int elementsToPop = elementsArr[1]; // <- Елементите, които да изкарам от стека
        int checkIfPresentElement = elementsArr[2]; // <- Елемент, който да проверя дали е в стека

        Deque<Integer> numStack = new ArrayDeque<>();

        for (int i = 0; i < elementsToPush; i++) { // <- Вкарвам необходимия брой елементи в стека

            int currentElement = lineOfNumbersArr[i];
            numStack.push(currentElement);

        }

        for (int i = 0; i < elementsToPop; i++) {

            if (!numStack.isEmpty()) { // <- Ако numStack не е празен, изкарвам елемента на върха
                numStack.pop();
            }

        }

        if (numStack.isEmpty()) { // <- Ако е празен

            System.out.println(0);

        } else if (numStack.contains(checkIfPresentElement)) { // <- Ако се съдържа в стека

            System.out.println(numStack.contains(checkIfPresentElement));

        } else { // <- Иначе, намирам най-малкия елемент в стека

            int min = numStack.stream().mapToInt(e -> e).min().orElse(-1);
            System.out.println(min);

        }

    }

}
