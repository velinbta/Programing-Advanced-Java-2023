package ExamsAdvanced;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TempleOfDoom_01 {
    @SuppressWarnings("ConstantConditions")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> toolsQueue = readQueue(scanner);
        Deque<Integer> substancesStack = readStack(scanner);
        Deque<Integer> challengesQueue = readQueue(scanner);

        while (!toolsQueue.isEmpty() && !substancesStack.isEmpty() && !challengesQueue.isEmpty()) {

            int result = toolsQueue.peek() * substancesStack.peek();

            if (challengeContainsResult(challengesQueue, result)) {

                // Премахва само един от резултатите, а не всички еднакви, съдържащи се вътре!!
                challengesQueue.remove(result);

                removeFromBothStackAndQueue(toolsQueue, substancesStack);

            } else {

                toolsQueue.offer(toolsQueue.poll() + 1); // + 1

                if (substancesStack.peek() - 1 < 1) { // <- Ако ще достигне 0, се премахва

                    substancesStack.pop();

                } else {

                    substancesStack.push(substancesStack.pop() - 1); // <- Намаля с 1

                }

            }

        }

        String output = getOutput(toolsQueue, substancesStack, challengesQueue);
        System.out.println(output);

    }

    private static Deque<Integer> readQueue(Scanner scanner) {
        // Прочита опашка
        return Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
    }

    private static Deque<Integer> readStack(Scanner scanner) {
        // Прочита стек
        Deque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .forEach(stack::push);

        return stack;
    }

    private static boolean challengeContainsResult(Deque<Integer> challengesQueue, int result) {
        return challengesQueue.contains(result);
    }

    private static void removeFromBothStackAndQueue(Deque<Integer> toolsQueue, Deque<Integer> substancesStack) {
        // Премахва от двата контейнера
        toolsQueue.poll();
        substancesStack.pop();
    }

    private static String getOutput(Deque<Integer> toolsQueue, Deque<Integer> substancesStack,
                                    Deque<Integer> challengesQueue) {

        // Билдва изходните данни
        StringBuilder output = new StringBuilder();

        if ((toolsQueue.isEmpty() || substancesStack.isEmpty()) && !challengesQueue.isEmpty())
            output.append("Harry is lost in the temple. Oblivion awaits him.");
        else if (challengesQueue.isEmpty())
            output.append("Harry found an ostracon, which is dated to the 6th century BCE.");

        if (!toolsQueue.isEmpty()) {

            output.append(System.lineSeparator());
            output.append("Tools: ");

            while (!toolsQueue.isEmpty()) {

                output.append(toolsQueue.poll());

                if (!toolsQueue.isEmpty())
                    output.append(", ");

            }

        }

        if (!substancesStack.isEmpty()) {

            output.append(System.lineSeparator());
            output.append("Substances: ");

            while (!substancesStack.isEmpty()) {

                output.append(substancesStack.pop());

                if (!substancesStack.isEmpty())
                    output.append(", ");

            }

        }

        if (!challengesQueue.isEmpty()) {

            output.append(System.lineSeparator());
            output.append("Challenges: ");

            while (!challengesQueue.isEmpty()) {

                output.append(challengesQueue.poll());

                if (!challengesQueue.isEmpty())
                    output.append(", ");

            }

        }

        return output.toString();
    }

}
