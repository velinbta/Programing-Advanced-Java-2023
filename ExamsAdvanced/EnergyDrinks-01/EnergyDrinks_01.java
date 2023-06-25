package ExamsAdvanced;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EnergyDrinks_01 {
    private static int totalCaffeine = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> milligramsCaffeineStack = readStack(scanner);
        Deque<Integer> drinksQueue = readQueue(scanner);

        while (!milligramsCaffeineStack.isEmpty() && !drinksQueue.isEmpty()) { // <- Докато не са празни

            int currentDrinkCaffeine = milligramsCaffeineStack.peek() * drinksQueue.peek();

            if (canAcceptDrink(currentDrinkCaffeine)) { // <- До 300

                removeBothMilligramsAndDrink(milligramsCaffeineStack, drinksQueue);
                totalCaffeine += currentDrinkCaffeine;

            } else {

                milligramsCaffeineStack.pop();
                drinksQueue.offer(drinksQueue.poll());

                totalCaffeine = totalCaffeineIsAboveZero() // <- Ако не е под 0
                        ? totalCaffeine - 30
                        : 0;

            }

        }

        String output = getOutput(drinksQueue);
        System.out.println(output);

    }

    private static Deque<Integer> readStack(Scanner scanner) {
        // Прочита стек от терминала
        Deque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s*")).map(Integer::parseInt)
                .forEach(stack::push);

        return stack;
    }

    private static Deque<Integer> readQueue(Scanner scanner) {
        // Прочита опашка от терминала
        return Arrays.stream(scanner.nextLine().split(",\\s*")).map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
    }

    private static boolean totalCaffeineIsAboveZero() {
        return totalCaffeine - 30 > 0;
    }

    private static void removeBothMilligramsAndDrink(Deque<Integer> milligramsCaffeineStack, Deque<Integer> drinksQueue) {
        milligramsCaffeineStack.pop();
        drinksQueue.poll();
    }

    private static boolean canAcceptDrink(int currentDrinkCaffeine) {
        // До 300
        return currentDrinkCaffeine + totalCaffeine <= 300;
    }

    private static String getOutput(Deque<Integer> drinksQueue) {
        // Билдва изходните данни
        StringBuilder output = new StringBuilder();

        if (!drinksQueue.isEmpty()) {

            output.append("Drinks left: ");

            while (!drinksQueue.isEmpty()) {

                output.append(drinksQueue.poll());

                if (!drinksQueue.isEmpty())
                    output.append(", ");

            }

        } else {

            output.append("At least Stamat wasn't exceeding the maximum caffeine.");

        }

        output.append(System.lineSeparator());
        output.append(String.format("Stamat is going to sleep with %d mg caffeine.", totalCaffeine));

        return output.toString();
    }

}
