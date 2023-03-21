package SetsMaps;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class VoinaNumberGame_03_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Прочитам два Set с уникални стойности за всеки по отделно
        Set<Integer> firstPlayerSet = readLinkedHashSetFromConsole(scanner);
        Set<Integer> secondPlayerSet = readLinkedHashSetFromConsole(scanner);

        int rounds = 50; // <- 50 игри по условие или докато някой от играчите не му свършат картите
        while (rounds-- > 0 && !firstPlayerSet.isEmpty() && !secondPlayerSet.isEmpty()) {

            // На двамата играчи се взимат картите и се премахват от тестето
            int firstPlayerCard = firstPlayerSet.iterator().next();
            firstPlayerSet.remove(firstPlayerCard);
            int secondPlayerCard = secondPlayerSet.iterator().next();
            secondPlayerSet.remove(secondPlayerCard);

            // Ако са еднакви картите не се играят
            if (firstPlayerCard > secondPlayerCard) { // <- Първи играч взима двете и ги слага накрая

                firstPlayerSet.add(firstPlayerCard);
                firstPlayerSet.add(secondPlayerCard);

            } else if (secondPlayerCard > firstPlayerCard) { // <- Втори играч взима двете и ги слага накрая

                secondPlayerSet.add(firstPlayerCard);
                secondPlayerSet.add(secondPlayerCard);

            }

        }

        String output = getGameResult(firstPlayerSet, secondPlayerSet);
        System.out.println(output);

    }

    private static LinkedHashSet<Integer> readLinkedHashSetFromConsole(Scanner scanner) {
        // Прочита LinkedHashSet от конзолата
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(n -> Integer.parseInt(n)).collect(Collectors.toCollection(LinkedHashSet::new));

    }

    private static String getGameResult(Set<Integer> first, Set<Integer> second) {
        // Връща резултата от играта в String променлива
        if (first.size() > second.size())
            return "First player win!";
        else if (second.size() > first.size())
            return "Second player win!";
        else
            return "Draw!";

    }

}
