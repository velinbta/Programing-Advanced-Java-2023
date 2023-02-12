package StacksQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MatchingBrackets_04_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Deque<Integer> bracketsStack = new ArrayDeque<>(); // <- От тук ще взимам индекса на върха '('

        for (int index = 0; index < input.length(); index++) {

            char current = input.charAt(index); // <- Текущият символ от input

            if (current == '(') {

                bracketsStack.push(index); // <- Слагам на върха

            } else if (current == ')') {

                int startIndex = bracketsStack.pop(); // <- Взимам върха '(' за начален индекс

                String subString = input.substring(startIndex, index + 1); // substring от началния до текущият

                System.out.println(subString);

            }

        }

    }

}
