package SetsMaps;

import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCards_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Set<String>> nameCardsMap = new LinkedHashMap<>(); // <- Играчи и уникални карти

        while (!input.equals("JOKER")) {

            int delimiterIndex = input.indexOf(":"); // <- Разделител имена на играчи/карти
            // Разделям играч/карти и правя списък от картите му
            String player = input.substring(0, delimiterIndex);
            String cards = input.substring(delimiterIndex + 2);

            List<String> cardsList = Arrays.stream(cards.split(",\\s+"))
                    .collect(Collectors.toList());

            nameCardsMap.putIfAbsent(player, new HashSet<>()); // <- Слагам играча ако липсва
            nameCardsMap.get(player).addAll(cardsList); // <- Уникални карти за конкретния играч

            input = scanner.nextLine();

        }

        Map<String, Integer> playerPointsMap = new LinkedHashMap<>(); // <- Играчи/крайни точки

        nameCardsMap.entrySet().forEach(player -> {
            // Изчислявам крайните му точки и ги добавям
            int points = calculatePlayerPointsInSet(player.getValue());
            playerPointsMap.put(player.getKey(), points);

        });

        playerPointsMap.entrySet().forEach(player ->
                System.out.printf("%s: %d\n", player.getKey(), player.getValue()));

    }

    private static int calculatePlayerPointsInSet(Set<String> cards) {
        // Изчислява точките на играча, като преминава през всяка уникална карта
        int totalPoints = 0;
        for (String card : cards) {

            int powerPoints = getPowerPoints(card);
            int typePoints = getTypePoints(card);
            totalPoints += powerPoints * typePoints; // <- За всяка карта се умножават

        }

        return totalPoints;
    }

    private static int getPowerPoints(String card) {
        // Изчислява "power points" от картата
        if (card.length() == 3) {
            return 10;
        } else {
            char power = card.charAt(0);
            switch (power) {
                case 'J':
                    return 11;
                case 'Q':
                    return 12;
                case 'K':
                    return 13;
                case 'A':
                    return 14;
                default:
                    return Character.getNumericValue(power);

            }

        }

    }

    private static int getTypePoints(String card) {
        // Изчислява "type points" при следващия символ от картата
        char type = card.length() == 3
                ? card.charAt(2) // <- При дължина 3
                : card.charAt(1); // <- При дължина 2

        switch (type) {

            case 'S':
                return 4;
            case 'H':
                return 3;
            case 'D':
                return 2;
            case 'C':
                return 1;
            default:
                return 1;

        }

    }

}
