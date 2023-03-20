package SetsMaps;

import java.util.*;

public class VoinaNumberGame_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Прочитам два Set с уникални стойности за всеки по отделно
        Set<Integer> firstPlayerSet = readIntegerLinkedHashSet(scanner);
        Set<Integer> secondPlayerSet = readIntegerLinkedHashSet(scanner);

        // Прехвърлям ги в опашка
        Deque<Integer> firstPlayerQueue = moveIntegersFromSetToQueue(firstPlayerSet);
        Deque<Integer> secondPlayerQueue = moveIntegersFromSetToQueue(secondPlayerSet);

        int rounds = 0;
        // "50" игри по условие или докато някой от играчите не му свършат картите
        while (rounds <= 50 && !firstPlayerQueue.isEmpty() && !secondPlayerQueue.isEmpty()) {

            // Изтеглят се картите на двамата играчи от опашката
            int firstPlayerCard = firstPlayerQueue.poll();
            int secondPlayerCard = secondPlayerQueue.poll();

            // За да се зачете рунд, картите трябва да са различни
            if (firstPlayerCard != secondPlayerCard) {

                if (firstPlayerCard > secondPlayerCard) { // <- Първи играч взима двете и ги слага накрая

                    firstPlayerQueue.offer(firstPlayerCard);
                    firstPlayerQueue.offer(secondPlayerCard);

                } else { // <- Втори играч взима двете и ги слага накрая

                    secondPlayerQueue.offer(secondPlayerCard);
                    secondPlayerQueue.offer(firstPlayerCard);

                }

                rounds++;

            }

        }

        String output = getGameResult(firstPlayerQueue, secondPlayerQueue); // <- Резултат от играта
        System.out.println(output);

    }

    private static Set<Integer> readIntegerLinkedHashSet(Scanner scanner) {
        // Прочита Integer Set от конзолата
        Set<Integer> set = new LinkedHashSet<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(n -> Integer.parseInt(n))
                .forEach(n -> set.add(n));
        return set;
    }

    private static Deque<Integer> moveIntegersFromSetToQueue(Set<Integer> set) {
        // Прехвърля стойностите от Set в опашка
        Deque<Integer> integerDeque = new ArrayDeque<>();
        set.forEach(n -> integerDeque.offer(n));
        return integerDeque;
    }

    private static String getGameResult(Deque<Integer> first, Deque<Integer> second) {
        // Връща резултата от играта в String променлива
        if (first.size() == second.size())
            return "Draw!";
        else if (first.size() > second.size())
            return "First player win!";
        else
            return "Second player win!";

    }

}
