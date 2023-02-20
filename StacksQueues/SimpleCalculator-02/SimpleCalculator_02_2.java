package StacksQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class SimpleCalculator_02_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();
        Deque<String> expressionQueue = new ArrayDeque<>();
        Arrays.stream(expression.split("\\s+")).forEach(e -> expressionQueue.offer(e)); // <- Целият израз

        Deque<Integer> resultQueue = new ArrayDeque<>(); // <- Крайния резултат

        while (!expressionQueue.isEmpty()) {

            if (expressionQueue.peek().matches("\\d+")) { // <- Намирам първото число и слагам в "resultQueue"

                Integer element = Integer.parseInt(expressionQueue.poll());
                resultQueue.offer(element);

            } else if (expressionQueue.peek().equals("+")) {

                expressionQueue.poll(); // <- Махам намерения оператор

                // Ако още не е празна опашката и следващото е число
                if (!expressionQueue.isEmpty() && expressionQueue.peek().matches("\\d+")) {

                    Integer element = Integer.parseInt(expressionQueue.poll());

                    // Събирам с първоначално намереното число и замествам
                    if (resultQueue.peek() != null) {
                        Integer result = resultQueue.poll() + element;
                        resultQueue.offer(result);
                    }

                }

            } else if (expressionQueue.peek().equals("-")) {

                expressionQueue.poll(); // <- Махам намерения оператор

                // Ако още не е празна опашката и следващото е число
                if (!expressionQueue.isEmpty() && expressionQueue.peek().matches("\\d+")) {

                    Integer element = Integer.parseInt(expressionQueue.poll());

                    // Изваждам и замествам
                    if (resultQueue.peek() != null) {
                        Integer result = resultQueue.poll() - element;
                        resultQueue.offer(result);
                    }

                }

            }

        }

        System.out.println(resultQueue.poll());

    }

}
