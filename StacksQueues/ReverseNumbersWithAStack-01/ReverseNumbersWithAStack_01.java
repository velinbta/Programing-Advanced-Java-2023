package StacksQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class ReverseNumbersWithAStack_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String numbers = scanner.nextLine();

        Deque<Integer> numStack = new ArrayDeque<>();
        Arrays.stream(numbers.split("\\s+")) // <- Обръщам числата
                .map(e -> Integer.parseInt(e)).forEach(e -> numStack.push(e));

        while (!numStack.isEmpty()) {

            System.out.print(numStack.pop() + " "); // <- Изкарвам ги едно след друго

        }

    }

}

