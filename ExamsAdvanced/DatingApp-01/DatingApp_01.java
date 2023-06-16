package ExamsAdvanced;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class DatingApp_01 {

    private static int matches = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> malesStack = readAndFilterMales(scanner);
        Deque<Integer> femalesQueue = readAndFilterFemales(scanner);

        while (!femalesQueue.isEmpty() && !malesStack.isEmpty()) {

            if (malesStack.peek() < 1) {
                // Филтрирани са в началото, но после стойностите на мъжете се намаля с 2, ако няма съвпадение
                malesStack.pop();
                continue;
            }

            // Проверявам дали стойностите се делят на 25 без остатък и премахвам и следващия, ако има такъв
            if (nextIsDivisibleBy25WithoutRemainder(femalesQueue)) {
                removePersonAndNextIfPresent(femalesQueue);
                continue;
            } else if (nextIsDivisibleBy25WithoutRemainder(malesStack)) {
                removePersonAndNextIfPresent(malesStack);
                continue;
            }

            if (femalesQueue.peek().equals(malesStack.peek())) { // <- При съвпадение
                // Увеличава съвпаденията и премахва "мъж и жена"
                incrementMatches();
                femalesQueue.poll();
                malesStack.pop();

            } else {

                femalesQueue.poll();
                malesStack.push(malesStack.pop() - 2); // <- Намаля стойността с 2

            }

        }

        String output = getOutput(femalesQueue, malesStack);
        System.out.println(output);

    }

    private static Deque<Integer> readAndFilterMales(Scanner scanner) {
        // Прочита и филтрира мъжете от терминала > 0
        String males = scanner.nextLine();
        Deque<Integer> malesStack = new ArrayDeque<>();

        Arrays.stream(males.split("\\s+")).map(Integer::parseInt)
                .filter(male -> male > 0).forEach(malesStack::push);

        return malesStack;
    }

    private static Deque<Integer> readAndFilterFemales(Scanner scanner) {
        // Прочита и филтрира жените от терминала > 0
        String females = scanner.nextLine();
        Deque<Integer> femalesQueue = new ArrayDeque<>();

        Arrays.stream(females.split("\\s+")).map(Integer::parseInt)
                .filter(female -> female > 0).forEach(femalesQueue::offer);

        return femalesQueue;
    }

    private static void removePersonAndNextIfPresent(Deque<Integer> deque) {
        // Премахва текущия и следващия, ако има такъв
        deque.remove();
        if (!deque.isEmpty())
            deque.remove();
    }

    private static boolean nextIsDivisibleBy25WithoutRemainder(Deque<Integer> deque) {
        // Проверява дали се дели на 25 без остатък
        if (!deque.isEmpty())
            return deque.peek() % 25 == 0;

        return false;
    }

    private static void incrementMatches() {
        matches++;
    }

    private static int getMatches() {
        return matches;
    }

    private static String getOutput(Deque<Integer> femalesQueue, Deque<Integer> malesStack) {
        // Билдва изходните данни
        StringBuilder output = new StringBuilder();

        output.append(String.format("Matches: %d", getMatches()));
        output.append(System.lineSeparator());

        if (malesStack.isEmpty()) {

            output.append("Males left: none");
            output.append(System.lineSeparator());

        } else {

            output.append("Males left: ");

            while (!malesStack.isEmpty()) {
                output.append(malesStack.pop());

                if (!malesStack.isEmpty())
                    output.append(", ");

            }
            output.append(System.lineSeparator());

        }

        if (femalesQueue.isEmpty()) {

            output.append("Females left: none");

        } else {

            output.append("Females left: ");

            while (!femalesQueue.isEmpty()) {
                output.append(femalesQueue.poll());

                if (!femalesQueue.isEmpty())
                    output.append(", ");

            }

        }

        return output.toString();
    }

}
