package StacksQueues;

import java.util.*;

public class MatchingBrackets_04_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Deque<Integer> bracketsIndexStack = new ArrayDeque<>(); // <- Съхранявам началния индекс '('
        List<String> expressionsList = new ArrayList<>(); // <- Съхранявам целия израз

        for (int index = 0; index < input.length(); index++) {

            char element = input.charAt(index); // <- Текущ елемент

            if (element == '(') {

                bracketsIndexStack.push(index); // <- Слагам на върха на стека

            } else if (element == ')') {

                int startIndex = bracketsIndexStack.pop(); // <- Взимам и премахвам от върха

                String subString = input.substring(startIndex, index + 1);

                expressionsList.add(subString); // <- Съхранявам целия израз

            }

        }

        expressionsList.forEach(e -> System.out.println(e));

    }

}
