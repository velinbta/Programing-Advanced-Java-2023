package ExamsAdvanced;

import java.util.*;
import java.util.stream.Collectors;

public class RubberDuckDebuggers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> timeQueue = readQueue(scanner);
        Deque<Integer> taskStack = readStack(scanner);
        checkExceptions(timeQueue, taskStack); // <- Да няма негативни стойности и дали са с еднакъв размер

        Map<String, Integer> ducksMap = addDucksWithDefaultValues(); // <- Попълва патиците

        while (!timeQueue.isEmpty() || !taskStack.isEmpty()) {

            // Докато не са празни контейнерите, търси по резултата
            int result = timeQueue.peek() * taskStack.peek();

            if (result < 61) {

                incrementDuck("Darth Vader Ducky", ducksMap);
                removeTimeAndTask(timeQueue, taskStack);

            } else if (result < 121) {

                incrementDuck("Thor Ducky", ducksMap);
                removeTimeAndTask(timeQueue, taskStack);

            } else if (result < 181) {

                incrementDuck("Big Blue Rubber Ducky", ducksMap);
                removeTimeAndTask(timeQueue, taskStack);

            } else if (result < 241) {

                incrementDuck("Small Yellow Rubber Ducky", ducksMap);
                removeTimeAndTask(timeQueue, taskStack);

            } else if (result > 241) {

                taskStack.push(taskStack.pop() - 2); // <- Намаля стойността
                timeQueue.offer(timeQueue.poll()); // <- Премесва накрая

            }

        }

        String output = getOutput(ducksMap);
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

    private static void checkExceptions(Deque<Integer> timeQueue, Deque<Integer> taskStack) {
        // Проверява за негативни стойности в контейнерите и за техния размер
        // Хвърля изключения
        boolean containsNegativeValues = timeQueue.stream().anyMatch(n -> n < 1) ||
                taskStack.stream().anyMatch(n -> n < 1);

        if (timeQueue.size() != taskStack.size())
            throw new IllegalArgumentException("Time and task must have equal size!");
        else if (containsNegativeValues)
            throw new IllegalArgumentException("Time or task can't hold negative value!");

    }

    private static Map<String, Integer> addDucksWithDefaultValues() {
        // Попълва патиците
        Map<String, Integer> ducksMap = new LinkedHashMap<>();
        ducksMap.put("Darth Vader Ducky", 0);
        ducksMap.put("Thor Ducky", 0);
        ducksMap.put("Big Blue Rubber Ducky", 0);
        ducksMap.put("Small Yellow Rubber Ducky", 0);

        return ducksMap;
    }

    private static void incrementDuck(String duckName, Map<String, Integer> ducksMap) {
        // Увеличава броя на патицата
        ducksMap.put(duckName, ducksMap.get(duckName) + 1);
    }

    private static void removeTimeAndTask(Deque<Integer> timeQueue, Deque<Integer> taskStack) {
        // Премахва време и задача
        timeQueue.poll();
        taskStack.pop();
    }

    private static String getOutput(Map<String, Integer> ducksMap) {
        // Билдва изходните данни
        StringBuilder output = new StringBuilder();

        output.append("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        output.append(System.lineSeparator());

        ducksMap.forEach((key, value) -> {
            output.append(String.format("%s: %d", key, value));
            if (!key.equals("Small Yellow Rubber Ducky")) {
                output.append(System.lineSeparator());
            }
        });

        return output.toString();
    }

}
